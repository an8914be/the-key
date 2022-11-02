package com.de.application.thekeywordcountmapservice.core;

import java.util.Map;

/**
 * Interface for the core functionality for counting words from a string
 */
public interface WordCountMapController {
    Map<String, Integer> countWords(String content);
}