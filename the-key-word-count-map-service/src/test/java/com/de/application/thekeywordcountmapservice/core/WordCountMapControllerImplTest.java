package com.de.application.thekeywordcountmapservice.core;

import com.de.application.thekeywordcountmapservice.helper.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for WordCountMapControllerImpl class
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WordCountMapControllerImpl.class})
class WordCountMapControllerImplTest {

    private final WordCountMapControllerImpl wordCountMapController;

    @Autowired
    WordCountMapControllerImplTest(WordCountMapControllerImpl wordCountMapController) {
        this.wordCountMapController = wordCountMapController;
    }

    @Test
    void testCountWordsEmptyString() {
        // Act
        Map<String, Integer> result = this.wordCountMapController.countWords("");

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    void testCountWordsNormalSentence() {
        // Arrange
        Map<String, Integer> expected = TestDataGenerator.normalSentenceMap();

        // Act
        Map<String, Integer> result = this.wordCountMapController.countWords(TestDataGenerator.normalSentence());

        // Assert
        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get("is")).isEqualTo(expected.get("is"));
        assertThat(result.get("a")).isEqualTo(expected.get("a"));
    }

    @Test
    void testCountWordsNormalSentenceWithSpecialCharacter() {
        // Arrange
        Map<String, Integer> expected = TestDataGenerator.normalSentenceMap();

        // Act
        Map<String, Integer> result = this.wordCountMapController.countWords(TestDataGenerator.normalSentenceWithSpecialCharacter());

        // Assert
        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get("is")).isEqualTo(expected.get("is"));
        assertThat(result.get("a")).isEqualTo(expected.get("a"));
    }
}
