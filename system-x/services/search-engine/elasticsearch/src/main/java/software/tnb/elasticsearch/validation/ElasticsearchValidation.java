package software.tnb.elasticsearch.validation;

import static org.junit.jupiter.api.Assertions.fail;

import software.tnb.searchengine.common.validation.SearchValidation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;

public class ElasticsearchValidation implements SearchValidation {
    private static final Logger LOG = LoggerFactory.getLogger(ElasticsearchValidation.class);

    private final ElasticsearchClient client;

    public ElasticsearchValidation(ElasticsearchClient client) {
        this.client = client;
    }

    @Override
    public void createIndex(String index) {
        try {
            client.indices().create(new CreateIndexRequest.Builder().index(index).build());
        } catch (IOException e) {
            fail("Exception while creating Elastic search index: ", e);
        }
    }

    @Override
    public void deleteIndex(String index) {
        try {
            if (indexExists(index)) {
                LOG.debug("Deleting index {}", index);
                client.indices().delete(new DeleteIndexRequest.Builder().index(index).build());
            }
        } catch (IOException e) {
            LOG.error("Error while cleaning up index {}: {}", index, e.getMessage(), e);
        }
    }

    @Override
    public <T> HitsMetadata<T> getData(String index, Class<T> documentClass) {
        SearchRequest searchRequest = new SearchRequest.Builder().index(index).build();
        return getData(searchRequest, documentClass);
    }

    public <T> HitsMetadata<T> getData(SearchRequest searchRequest, Class<T> documentClass) {
        try {
            SearchResponse<T> response = client.search(searchRequest, documentClass);
            return response.hits();
        } catch (Exception e) {
            LOG.trace("Error while getting elasticsearch data: {}", e.getMessage());
            return new HitsMetadata.Builder<T>().hits(Collections.emptyList()).build();
        }
    }

    @Override
    public IndexResponse insert(String index, Object content) {
        try {
            return client.index(new IndexRequest.Builder<Object>().index(index).document(content).build());
        } catch (IOException e) {
            fail("Unable to create record: ", e);
        }
        return null;
    }

    @Override
    public List<String> getIndices() {
        try {
            return client.cat().indices().valueBody().stream().map(i -> i.index()).collect(Collectors.toList());
        } catch (ElasticsearchException ese) {
            if (ese.getMessage().contains("index_not_found_exception")) {
                return new ArrayList<>();
            } else {
                throw ese;
            }
        } catch (IOException e) {
            fail("Unable to list indices: ", e);
        }
        return new ArrayList<>();
    }

    @Override
    public boolean indexExists(String index) {
        try {
            return client.indices().exists(new ExistsRequest.Builder().index(index).build()).value();
        } catch (IOException e) {
            fail("Unable to check if index exists: ", e);
            return false;
        }
    }
}
