package com.de.application.thekeywordcountmapservice.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Test-Data-Generator for the Tests
 */
public class TestDataGenerator {
    private TestDataGenerator() {
    }

    public static String normalSentence(){
        return "This is a normal sentence is is is a";
    }

    public static Map<String, Integer> normalSentenceMap(){
        Map<String, Integer> result = new HashMap<>();
        result.put("a", 2);
        result.put("is", 4);
        result.put("normal", 1);
        result.put("This", 1);
        result.put("sentence", 1);
        return result;
    }

    public static String normalSentenceWithSpecialCharacter(){
        return "This is a normal. sentence is is is a.";
    }
}
