package com.de.application.thekeyfetchdataservice.core;

import com.de.application.thekeyfetchdataservice.common.util.HttpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of the core functionality
 */
@Component
public class FetchDataControllerImpl implements FetchDataController {
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final HttpTemplate httpTemplate;

    /**
     * The constructor
     *
     * @param httpTemplate {@link HttpTemplate}
     */
    @Autowired
    public FetchDataControllerImpl(HttpTemplate httpTemplate) {
        this.httpTemplate = httpTemplate;
    }

    @Override
    public ResponseEntity<Object> fetchDataFromBlog() {
        try {
            return this.httpTemplate.fetchDataFromTheKeyAcademyBlog();
        } catch (RestClientException exception) {
            logger.log(Level.WARNING, exception.toString());
            exception.printStackTrace();
        }
        return null;
    }
}
