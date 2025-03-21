package software.tnb.jira.service;

import com.atlassian.jira.rest.client.api.JiraRestClient;

import software.tnb.common.service.Service;
import software.tnb.jira.account.JiraAccount;
import software.tnb.jira.client.AsynchronousJiraRestClient;
import software.tnb.jira.validation.JiraValidation;

import org.junit.jupiter.api.extension.ExtensionContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.jira.rest.client.auth.BasicHttpAuthenticationHandler;
import com.atlassian.jira.rest.client.internal.async.AsynchronousHttpClientFactory;
import com.atlassian.jira.rest.client.internal.async.DisposableHttpClient;
import com.google.auto.service.AutoService;

import java.net.URI;

@AutoService(Jira.class)
public class Jira extends Service<JiraAccount, JiraRestClient, JiraValidation> {
    private static final Logger LOG = LoggerFactory.getLogger(Jira.class);

    @Override
    protected JiraRestClient client() {
        if (client == null) {
            LOG.debug("Creating new JiraRest client");
            final DisposableHttpClient httpClient = new AsynchronousHttpClientFactory()
                .createClient(URI.create(account().getJiraUrl())
                    , new BasicHttpAuthenticationHandler(account().getUsername(), account().getPassword()));
            client = new AsynchronousJiraRestClient(URI.create(account().getJiraUrl()), httpClient);
        }
        return client;
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        LOG.debug("Creating new Jira validation");
        validation = new JiraValidation(client());
    }
}
