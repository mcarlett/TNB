package software.tnb.jira.client;

import com.atlassian.httpclient.api.HttpClient;
import com.atlassian.jira.rest.client.api.ProjectRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.Project;
import com.atlassian.jira.rest.client.internal.async.AbstractAsynchronousRestClient;
import com.atlassian.jira.rest.client.internal.json.BasicProjectsJsonParser;
import com.atlassian.jira.rest.client.internal.json.ProjectJsonParser;

import io.atlassian.util.concurrent.Promise;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;

public class AsynchronousProjectRestClient extends AbstractAsynchronousRestClient implements ProjectRestClient {

    private static final String PROJECT_URI_PREFIX = "project";
    private final ProjectJsonParser projectJsonParser = new ProjectJsonParser();
    private final BasicProjectsJsonParser basicProjectsJsonParser = new BasicProjectsJsonParser();

    private final URI baseUri;

    public AsynchronousProjectRestClient(final URI baseUri, final HttpClient client) {
        super(client);
        this.baseUri = baseUri;
    }

    @Override
    public Promise<Project> getProject(final String key) {
        final URI uri = UriBuilder.fromUri(baseUri).path(PROJECT_URI_PREFIX).path(key).build();
        return getAndParse(uri, projectJsonParser);
    }

    @Override
    public Promise<Project> getProject(final URI projectUri) {
        return getAndParse(projectUri, projectJsonParser);
    }

    @Override
    public Promise<Iterable<BasicProject>> getAllProjects() {
        final URI uri = UriBuilder.fromUri(baseUri).path(PROJECT_URI_PREFIX).build();
        return getAndParse(uri, basicProjectsJsonParser);
    }
}
