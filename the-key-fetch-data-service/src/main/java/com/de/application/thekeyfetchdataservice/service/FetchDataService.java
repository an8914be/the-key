package com.de.application.thekeyfetchdataservice.service;

import com.de.application.thekeyfetchdataservice.core.FetchDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The rest service for fetching the data from the key academy blog
 */
@RestController
@RequestMapping("/rest/data/v1")
public class FetchDataService {
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final FetchDataController fetchDataController;

    /**
     * The constructor
     *
     * @param fetchDataController {@link FetchDataController}
     */
    @Autowired
    public FetchDataService(FetchDataController fetchDataController) {
        this.fetchDataController = fetchDataController;
    }

    /**
     * REST-Endpoint with listener on '/fetch/blog'
     * Call the core layer to fetch data from the key academy blog
     *
     * @return responseEntity {@link ResponseEntity}
     */
    @GetMapping(value = "/fetch/blog")
    public ResponseEntity<Object> fetchDataFromBlog() {
        logger.log(Level.INFO, "Blog-data output successfully by fetchDataFromBlog method");
        return this.fetchDataController.fetchDataFromBlog();
    }
}