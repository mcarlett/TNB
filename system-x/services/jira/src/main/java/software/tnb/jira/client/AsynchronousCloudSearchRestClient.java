package software.tnb.jira.client;

import static com.atlassian.jira.rest.client.api.IssueRestClient.Expandos.NAMES;
import static com.atlassian.jira.rest.client.api.IssueRestClient.Expandos.SCHEMA;

import jakarta.ws.rs.core.UriBuilder;

import org.apache.commons.lang3.StringUtils;

import com.atlassian.jira.rest.client.api.RestClientException;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.api.domain.TotalCount;
import com.atlassian.jira.rest.client.internal.async.DisposableHttpClient;
import com.atlassian.jira.rest.client.internal.json.EnhancedSearchResultJsonParser;
import com.atlassian.jira.rest.client.internal.json.TotalCountJsonParser;

import java.net.URI;
import java.util.Set;

import io.atlassian.util.concurrent.Promise;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AsynchronousCloudSearchRestClient extends AsynchronousSearchRestClient {

    private static final String SEARCH_URI_PREFIX = "search/jql";
    private static final String APPROXIMATE_COUNT_URI_PREFIX = "search/approximate-count";
    private static final String NEXT_PAGE_TOKEN_ATTRIBUTE = "nextPageToken";
    private static final String RECONCILE_ISSUES_ATTRIBUTE = "reconcileIssues";
    private static final String EXPAND = String.join(",", SCHEMA.getValue(), NAMES.getValue());
    private static final Set<String> DEFAULT_FIELDS = Set.of("*navigable");
    private final EnhancedSearchResultJsonParser searchResultJsonParser = new EnhancedSearchResultJsonParser();
    private final TotalCountJsonParser totalCountJsonParser = new TotalCountJsonParser();
    private final URI searchUri,totalCountUri;

    public AsynchronousCloudSearchRestClient(URI baseUri, DisposableHttpClient httpClient) {
        super(baseUri, httpClient);
        this.totalCountUri = UriBuilder.fromUri(baseUri).path(APPROXIMATE_COUNT_URI_PREFIX).build();
        this.searchUri = UriBuilder.fromUri(baseUri).path(SEARCH_URI_PREFIX).build();
    }

    @Override
    public Promise<SearchResult> searchJql(String jql) {
        return searchJql(jql, null, null, DEFAULT_FIELDS);
    }

    @Override
    public Promise<SearchResult> searchJql(String jql, Integer maxResults, Integer startAt, Set<String> fields) {
        if(startAt==null || startAt==0){
            return enhancedSearchJql(jql, maxResults, null, fields, null);
        }
        throw new UnsupportedOperationException("This search API is not supported anymore. Please use this enhancedSearchJql");}

    @Override
    public Promise<SearchResult> enhancedSearchJql(String jql) {
        return enhancedSearchJql(jql, null, null, DEFAULT_FIELDS,null);
    }

    @Override
    public Promise<SearchResult> enhancedSearchJql(String jql, Integer maxResults, String nextPageToken,
        Set<String> fields, Set<Integer> reconcileIssues) {
        final String notNullJql = StringUtils.defaultString(jql);
        if (notNullJql.length() > MAX_JQL_LENGTH_FOR_HTTP_GET) {
            return enhancedSearchJqlImplPost(jql, maxResults, nextPageToken, fields, reconcileIssues);
        } else {
            return enhancedSearchJqlImplGet(jql, maxResults, nextPageToken, fields, reconcileIssues);
        }
    }

    @Override
    public Promise<TotalCount> totalCount(String jql) {
        final JSONObject postEntity = new JSONObject();
        try {
            postEntity.put(JQL_ATTRIBUTE, jql);
        } catch (JSONException e) {
            throw new RestClientException(e);
        }
        return postAndParse(totalCountUri, postEntity, totalCountJsonParser);
    }

    private Promise<SearchResult> enhancedSearchJqlImplGet(String jql, Integer maxResults, String nextPageToken, Set<String> fields, Set<Integer> reconcileIssues) {
        final UriBuilder uriBuilder = UriBuilder.fromUri(searchUri)
            .queryParam(JQL_ATTRIBUTE, jql)
            .queryParam(EXPAND_ATTRIBUTE, EXPAND);
        if (fields != null) {
            uriBuilder.queryParam(FIELDS_ATTRIBUTE, String.join(",", fields));
        }
        if (reconcileIssues != null) {
            uriBuilder.queryParam(RECONCILE_ISSUES_ATTRIBUTE, String.join(",", reconcileIssues.toString()));
        }
        addOptionalQueryParam(uriBuilder, NEXT_PAGE_TOKEN_ATTRIBUTE, nextPageToken);
        addOptionalQueryParam(uriBuilder, MAX_RESULTS_ATTRIBUTE, maxResults);
        return getAndParse(uriBuilder.build(), searchResultJsonParser);
    }

    private Promise<SearchResult> enhancedSearchJqlImplPost(String jql, Integer maxResults, String nextPageToken,
        Set<String> fields, Set<Integer> reconcileIssues) {
        final JSONObject postEntity = new JSONObject();
        try {
            postEntity.put(JQL_ATTRIBUTE, jql)
                .put(EXPAND_ATTRIBUTE, EXPAND)
                .putOpt(MAX_RESULTS_ATTRIBUTE, maxResults)
                .putOpt(NEXT_PAGE_TOKEN_ATTRIBUTE, nextPageToken);
            if (fields != null) {
                postEntity.put(FIELDS_ATTRIBUTE, fields); // putOpt doesn't work with collections
            }
            if (reconcileIssues != null) {
                postEntity.put(RECONCILE_ISSUES_ATTRIBUTE, reconcileIssues); // putOpt doesn't work with collections
            }
        } catch (JSONException e) {
            throw new RestClientException(e);
        }
        return postAndParse(searchUri, postEntity, searchResultJsonParser);
    }
}
