package com.de.application.thekeyproxyservice.common.util.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Base Class for the adapter
 */
@Component
public abstract class AbstractAdapter {
    protected final RestTemplate restTemplate;
    protected final ObjectMapper mapper;

    /**
     * The constructor
     *
     * @param restTemplate {@link RestTemplate}
     * @param mapper       {@link ObjectMapper}
     */
    @Autowired
    protected AbstractAdapter(RestTemplate restTemplate, ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }
}