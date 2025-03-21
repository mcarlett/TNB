package software.tnb.jira.validation;

import com.atlassian.jira.rest.client.api.domain.IssueType;

import software.tnb.common.validation.Validation;
import software.tnb.jira.validation.model.Issue;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicIssue;
import com.atlassian.jira.rest.client.api.domain.Comment;
import com.atlassian.jira.rest.client.api.domain.Project;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.api.domain.input.TransitionInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

public class JiraValidation implements Validation {
    private static final Logger LOG = LoggerFactory.getLogger(JiraValidation.class);

    private final JiraRestClient client;

    public JiraValidation(JiraRestClient client) {
        this.client = client;
    }

    /**
     * Create issue in given project.
     *
     * @param projectKey key of project where issue will be created
     * @param issueSummary name of issue to be created
     * @return id of created issue
     */
    public String createIssue(String projectKey, String issueSummary) {
        try {
            final AtomicReference<Map<String, Object>> fields = new AtomicReference<>();
            final Project project = this.client.getProjectClient().getProject(projectKey).get();
            project.getIssueTypes().forEach(issueType -> {
                if ("Bug".equals(issueType.getName())) {
                    fields.set(Map.of(
                        "issuetype", issueType
                    ));
                }
            });

            BasicIssue iss = null;
            if (fields.get() != null) {
                IssueInput newIssue = new IssueInputBuilder()
                    .setSummary(issueSummary)
                    .setIssueType((IssueType) fields.get().get("issuetype"))
                    .setProjectKey(projectKey)
                    .build();
                iss = this.client.getIssueClient().createIssue(newIssue).get();
                LOG.debug("Issue created " + iss.getKey());
            }
            return Optional.ofNullable(iss).map(BasicIssue::getKey).orElse(null);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteIssue(String issueKey) {
        LOG.debug("Deleting issue " + issueKey);
        this.client.getIssueClient().deleteIssue(issueKey, true);
    }

    public List<String> getComments(String issueKey) {
        LOG.debug("Getting comments of " + issueKey);
        final List<String> comments = new ArrayList<>();
        try {
            this.client.getIssueClient().getIssue(issueKey).get().getComments().forEach(comment -> comments.add(comment.getBody()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get comments for " + issueKey, e);
        }
        return comments;
    }

    /**
     * Deprecated.
     * @param issueKey jira issue key
     * @param message message
     * @deprecated use getComments and assert on it
     * @return true/false
     */
    @Deprecated
    public boolean findInComments(String issueKey, String message) {
        return getComments(issueKey).contains(message);
    }

    public Issue getIssue(String issueKey) {
        try {
            return convertIssueBeanToIssue(this.client.getIssueClient().getIssue(issueKey).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void addComment(String issueKey, String content) {
        LOG.debug("Adding comment on issue " + issueKey);
        try {
            Map<String, Object> body = new JSONObject()
                .put("type", "doc")
                .put("version", 1)
                .put("content", new JSONArray().put(
                    new JSONObject().put("type", "paragraph").put("content",
                        new JSONArray().put(
                            new JSONObject().put("type", "text").put("text", content)
                        )
                    )
                )
                ).toMap();
            this.client.getIssueClient().addComment(this.client.getIssueClient().getIssue(issueKey).get().getCommentsUri()
                , Comment.valueOf(content));
        } catch (Exception e) {
            throw new RuntimeException("Failed to add comment on issue " + issueKey, e);
        }
    }

    public List<Issue> getIssues(String project) {
        return getIssues(project, "");
    }

    public List<Issue> getIssues(String project, String customJQL) {
        assert StringUtils.isNotEmpty(project);
        final List<Issue> issues = new ArrayList<>();
        try {
            String jql = String.format("project = \"%s\"", project) + (StringUtils.isNotEmpty(customJQL) ? " AND " + customJQL : "");
            this.client.getSearchClient().searchJql(jql).get().getIssues()
                .forEach(issue -> issues.add(convertIssueBeanToIssue(issue)));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return issues;
    }

    public void setTransition(String issueKey, int transitionId) {
        LOG.debug("Transit issue " + issueKey + " - transition id: " + transitionId);
        try {
            this.client.getIssueClient().transition(this.client.getIssueClient().getIssue(issueKey).get()
                , new TransitionInput(transitionId));
        } catch (Exception e) {
            throw new RuntimeException("Failed to transit issue " + issueKey, e);
        }
    }

    private Issue convertIssueBeanToIssue(com.atlassian.jira.rest.client.api.domain.Issue sourceIssue) {
        Issue result = new Issue();
        result.setKey(sourceIssue.getKey());
        result.setSummary(sourceIssue.getSummary());
        result.setDescription(sourceIssue.getDescription());
        result.setType(sourceIssue.getIssueType().getName());
        result.setStatus(sourceIssue.getStatus().getName());
        result.setProjectKey(sourceIssue.getProject().getKey());
        final List<String> attachmentIds = new ArrayList<>();
        sourceIssue.getAttachments().forEach(attachment -> attachmentIds.add(attachment.getContentUri().toString()));
        result.setAttachmentsIds(attachmentIds);
        sourceIssue.getFields().forEach(issueField -> {
            if ("priority".equals(issueField.getName())) {
                result.setPriority(String.valueOf(issueField.getValue()));
            }
        });
        return result;
    }
}
