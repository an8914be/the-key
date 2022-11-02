package com.de.application.thekeyproxyservice.common.util.adapter;

import com.de.application.thekeyproxyservice.common.config.other.Routes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Helper class to fetch the data from the word-count-map-service
 */
@Component
public class WordCountAdapter extends AbstractAdapter {
    /**
     * The constructor
     *
     * @param restTemplate {@link RestTemplate}
     * @param mapper       {@link ObjectMapper}
     */
    @Autowired
    protected WordCountAdapter(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    /**
     * Fetch data from word-count-map-service
     *
     * @return {@link Map} of {@link String}
     * @throws RestClientException restClientException {@link RestClientException}
     */
    public Map<String, Integer> countWordsToMap(String content) throws RestClientException {
        return this.mapper.convertValue(
                this.restTemplate.postForEntity(Routes.WORD_COUNT_MAP_SERVICE_URL, new HttpEntity<>(content), Map.class).getBody(),
                new TypeReference<Map<String, Integer>>() {
                });
    }
}