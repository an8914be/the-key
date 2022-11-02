package com.de.application.thekeywordcountmapservice.service;

import com.de.application.thekeywordcountmapservice.core.WordCountMapController;
import com.de.application.thekeywordcountmapservice.helper.HttpHelper;
import com.de.application.thekeywordcountmapservice.helper.TestDataGenerator;
import com.de.application.thekeywordcountmapservice.helper.TestUrls;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test for WordCountMapService class
 */
@WebMvcTest(WordCountMapService.class)
@AutoConfigureMockMvc
@Import(WordCountMapService.class)
public class WordCountMapServiceTest extends HttpHelper {
    @MockBean
    WordCountMapController wordCountMapController;

    protected ObjectMapper jacksonMapper = new ObjectMapper();

    @Test
    void testCountWordsToMap() throws Exception {
        // Arrange
        when(this.wordCountMapController.countWords(any())).thenReturn(TestDataGenerator.normalSentenceMap());

        // Act
        final ResultActions resultActions = performPost(uriBuilder(TestUrls.countWordsToMap()),
                this.jacksonMapper.writeValueAsString(TestDataGenerator.normalSentenceWithSpecialCharacter()));

        // Assert
        resultActions
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assertThat(result).isNotNull();
                    assertThat(result.getResponse().getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
                });
    }
}