package com.de.application.thekeywordcountmapservice.core;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the core functionality
 */
@Component
public class WordCountMapControllerImpl implements WordCountMapController {
    private static final Integer INITIAL_COUNT = 1;

    @Override
    public Map<String, Integer> countWords(String content) {
        Map<String, Integer> wordMap = new HashMap<>();

        if (!content.isEmpty()) {
            String[] words = content.split("\\W+");
            for (String word : words) {
                if (!wordMap.containsKey(word)) {
                    wordMap.put(word, INITIAL_COUNT);
                } else {
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }

        return wordMap;
    }
}
