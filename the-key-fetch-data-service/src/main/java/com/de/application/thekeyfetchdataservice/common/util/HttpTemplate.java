package com.de.application.thekeyfetchdataservice.common.util;

import com.de.application.thekeyfetchdataservice.common.config.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Helper class to fetch the key academy blog-posts
 */
@Component
public class HttpTemplate {
    private final RestTemplate restTemplate;

    @Autowired
    public HttpTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetch data from the key academy log
     *
     * @return responseEntity {@link ResponseEntity}
     * @throws RestClientException restClientException {@link RestClientException}
     */
    public ResponseEntity<Object> fetchDataFromTheKeyAcademyBlog() throws RestClientException {
        return this.restTemplate.getForEntity(Routes.URL_BLOG_THE_KEY_ACADEMY, Object.class);
    }
}
