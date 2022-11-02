package com.de.application.thekeywordcountmapservice.service;

import com.de.application.thekeywordcountmapservice.core.WordCountMapController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The rest service for counting words from a string
 */
@RestController
@RequestMapping("/rest/word-count-map/v1")
public class WordCountMapService {
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final WordCountMapController wordCountMapController;

    /**
     * The constructor
     *
     * @param wordCountMapController {@link WordCountMapController}
     */
    public WordCountMapService(WordCountMapController wordCountMapController) {
        this.wordCountMapController = wordCountMapController;
    }

    /**
     * REST-Endpoint with listener on '/count'
     * Call the core layer to count the words from a string
     *
     * @param content {@link String}
     * @return wordCountMap {@link Map}
     */
    @PostMapping("/count")
    public Map<String, Integer> countWordsToMap(@RequestBody String content) {
        logger.log(Level.INFO, "Count words output successfully by countWordsToMap method");
        return this.wordCountMapController.countWords(content);
    }
}
