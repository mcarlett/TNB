package software.tnb.jira.client;

import com.atlassian.httpclient.api.HttpClient;
import com.atlassian.jira.rest.client.api.RestClientException;
import com.atlassian.jira.rest.client.api.SessionRestClient;
import com.atlassian.jira.rest.client.api.domain.Session;
import com.atlassian.jira.rest.client.internal.async.AbstractAsynchronousRestClient;
import com.atlassian.jira.rest.client.internal.json.SessionJsonParser;

import io.atlassian.util.concurrent.Promise;
import jakarta.ws.rs.core.UriBuilder;

import java.net.URI;

public class AsynchronousSessionRestClient extends AbstractAsynchronousRestClient implements SessionRestClient{

    private final SessionJsonParser sessionJsonParser = new SessionJsonParser();
    private final URI serverUri;

    public AsynchronousSessionRestClient(final URI serverUri, final HttpClient client) {
        super(client);
        this.serverUri = serverUri;
    }

    @Override
    public Promise<Session> getCurrentSession() throws RestClientException {
        return getAndParse(UriBuilder.fromUri(serverUri).path("rest/auth/latest/session").build(), sessionJsonParser);
    }
}
