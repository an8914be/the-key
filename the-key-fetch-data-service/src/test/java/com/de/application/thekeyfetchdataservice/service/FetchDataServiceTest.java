package com.de.application.thekeyfetchdataservice.service;

import com.de.application.thekeyfetchdataservice.core.FetchDataController;
import com.de.application.thekeyfetchdataservice.helper.HttpHelper;
import com.de.application.thekeyfetchdataservice.helper.TestDataGenerator;
import com.de.application.thekeyfetchdataservice.helper.TestUrls;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test for FetchDataService class
 */
@WebMvcTest(FetchDataService.class)
@AutoConfigureMockMvc
@Import(FetchDataService.class)
public class FetchDataServiceTest extends HttpHelper {
    @MockBean
    FetchDataController fetchDataController;

    @Test
    void testFetchDataFromBlog() throws Exception {
        // Arrange
        when(this.fetchDataController.fetchDataFromBlog()).thenReturn(TestDataGenerator.getExampleResponseObject());

        // Act
        final ResultActions resultActions = performGet(uriBuilder(TestUrls.fetchDataFromBlog()));

        // Assert
        resultActions
                .andExpect(status().isOk())
                .andExpect(result -> {
                    assertThat(result).isNotNull();
                    assertThat(result.getResponse().getContentAsString()).isEqualTo("Example Object");
                });
    }
}
