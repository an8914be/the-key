package com.de.application.thekeyfetchdataservice.core;

import com.de.application.thekeyfetchdataservice.common.util.HttpTemplate;
import com.de.application.thekeyfetchdataservice.helper.TestDataGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Test for FetchDataControllerImpl class
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FetchDataControllerImpl.class})
class FetchDataControllerImplTest {
    @MockBean
    private HttpTemplate httpTemplate;

    private final FetchDataControllerImpl fetchData;

    @Autowired
    FetchDataControllerImplTest(FetchDataControllerImpl fetchData) {
        this.fetchData = fetchData;
    }

    @Test
    void testFetchDataFromBlog() throws JsonProcessingException, URISyntaxException {
        // Arrange
        when(this.httpTemplate.fetchDataFromTheKeyAcademyBlog()).thenReturn(TestDataGenerator.getExampleResponseObject());

        // Act
        ResponseEntity<Object> result = this.fetchData.fetchDataFromBlog();

        // Assert
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
