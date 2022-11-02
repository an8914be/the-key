package com.de.application.thekeyproxyservice.common.util.adapter;

import com.de.application.thekeyproxyservice.common.config.other.Routes;
import com.de.application.thekeyproxyservice.common.util.datatypes.Blogpost;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Helper class to fetch the data from the fetch-data-service
 */
@Component
public class FetchDataFromBlogAdapter extends AbstractAdapter {
    /**
     * The constructor
     *
     * @param restTemplate {@link RestTemplate}
     * @param mapper       {@link ObjectMapper}
     */
    @Autowired
    protected FetchDataFromBlogAdapter(RestTemplate restTemplate, ObjectMapper mapper) {
        super(restTemplate, mapper);
    }

    /**
     * Fetch data from fetch-data-service
     *
     * @return {@link List} of {@link Blogpost}
     * @throws RestClientException restClientException {@link RestClientException}
     */
    public List<Blogpost> fetchData() throws RestClientException {
        return this.mapper.convertValue(
                this.restTemplate.getForEntity(Routes.FETCH_DATA_SERVICE_URL, Object.class).getBody(),
                new TypeReference<List<Blogpost>>() {
                });
    }
}