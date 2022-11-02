package com.de.application.thekeyfetchdataservice.core;

import org.springframework.http.ResponseEntity;

/**
 * Interface for the core functionality for fetching data from the key academy blog
 */
public interface FetchDataController {
    /**
     * Fetch the data from the key academy blog
     *
     * @return responseEntity {@link ResponseEntity}
     */
    ResponseEntity<Object> fetchDataFromBlog();
}
