package com.de.application.thekeyfetchdataservice.helper;

import org.springframework.http.ResponseEntity;

/**
 * Test-Data-Generator for the Tests
 */
public class TestDataGenerator {
    private TestDataGenerator() {
    }

    public static ResponseEntity<Object> getExampleResponseObject() {
        return ResponseEntity.ok().body("Example Object");
    }

    public static String getExampleObject() {
        return "Example Object";
    }
}
