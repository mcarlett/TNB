package software.tnb.jira.client;

import com.atlassian.jira.rest.client.api.AuditRestClient;
import com.atlassian.jira.rest.client.api.ComponentRestClient;
import com.atlassian.jira.rest.client.api.GroupRestClient;
import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.MetadataRestClient;
import com.atlassian.jira.rest.client.api.MyPermissionsRestClient;
import com.atlassian.jira.rest.client.api.ProjectRestClient;
import com.atlassian.jira.rest.client.api.ProjectRolesRestClient;
import com.atlassian.jira.rest.client.api.SearchRestClient;
import com.atlassian.jira.rest.client.api.SessionRestClient;
import com.atlassian.jira.rest.client.api.UserRestClient;
import com.atlassian.jira.rest.client.api.VersionRestClient;
import com.atlassian.jira.rest.client.api.domain.util.UriUtil;
import com.atlassian.jira.rest.client.internal.async.DisposableHttpClient;

import java.io.IOException;
import java.net.URI;

import jakarta.ws.rs.core.UriBuilder;

public class AsynchronousJiraRestClient implements JiraRestClient {

    private final IssueRestClient issueRestClient;
    private final ProjectRestClient projectRestClient;
    private final SessionRestClient sessionRestClient;
    private final MetadataRestClient metadataRestClient;
    private final SearchRestClient searchRestClient;
    private final DisposableHttpClient httpClient;

    public AsynchronousJiraRestClient(URI serverUri, DisposableHttpClient httpClient) {
        boolean isCloudVersion = UriUtil.isURICloud(serverUri);
        final URI baseUri = UriBuilder.fromUri(serverUri).path("/rest/api/latest").build();

        this.httpClient = httpClient;
        metadataRestClient = new AsynchronousMetadataRestClient(baseUri, httpClient);
        sessionRestClient = new AsynchronousSessionRestClient(serverUri, httpClient);
        issueRestClient = new AsynchronousIssueRestClient(baseUri, httpClient, sessionRestClient, metadataRestClient);
        projectRestClient = new AsynchronousProjectRestClient(baseUri, httpClient);
        searchRestClient = isCloudVersion? new AsynchronousCloudSearchRestClient(baseUri, httpClient):new AsynchronousSearchRestClient(baseUri, httpClient);
    }

    @Override
    public IssueRestClient getIssueClient() {
        return issueRestClient;
    }

    @Override
    public SessionRestClient getSessionClient() {
        return sessionRestClient;
    }

    @Override
    public UserRestClient getUserClient() {
        throw new UnsupportedOperationException("need to be implemented");
    }

    @Override
    public GroupRestClient getGroupClient() {
        throw new UnsupportedOperationException("need to be implemented");
    }

    @Override
    public ProjectRestClient getProjectClient() {
        return projectRestClient;
    }

    @Override
    public ComponentRestClient getComponentClient() {
        throw new UnsupportedOperationException("need to be implemented");
    }

    @Override
    public MetadataRestClient getMetadataClient() {
        return metadataRestClient;
    }

    @Override
    public SearchRestClient getSearchClient() {
        return searchRestClient;
    }

    @Override
    public VersionRestClient getVersionRestClient() {
        throw new UnsupportedOperationException("need to be implemented");
    }

    @Override
    public ProjectRolesRestClient getProjectRolesRestClient() {
        throw new UnsupportedOperationException("need to be implemented");
    }

    @Override
    public MyPermissionsRestClient getMyPermissionsRestClient() {
        throw new UnsupportedOperationException("need to be implemented");
    }

    @Override
    public AuditRestClient getAuditRestClient() {
        throw new UnsupportedOperationException("need to be implemented");
    }

    @Override
    public void close() throws IOException {
        try {
            httpClient.destroy();
        } catch (Exception e) {
            throw (e instanceof IOException) ? ((IOException) e) : new IOException(e);
        }
    }
}
