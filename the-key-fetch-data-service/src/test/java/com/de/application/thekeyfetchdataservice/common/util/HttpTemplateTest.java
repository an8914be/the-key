package com.de.application.thekeyfetchdataservice.common.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import com.de.application.thekeyfetchdataservice.common.config.Routes;
import com.de.application.thekeyfetchdataservice.helper.TestDataGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Test for HttpTemplate class
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HttpTemplate.class, RestTemplate.class, ObjectMapper.class})
class HttpTemplateTest {
    private final HttpTemplate httpTemplate;
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private MockRestServiceServer mockServer;

    @Autowired
    HttpTemplateTest(HttpTemplate httpTemplate,  RestTemplate restTemplate, ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.httpTemplate = httpTemplate;
    }

    @BeforeEach
    public void init() {
        this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
    }

    @Test
    void testFetchDataFromTheKeyAcademyBlog() throws URISyntaxException, JsonProcessingException {
        // Arrange
        this.mockServer.expect(ExpectedCount.once(),
                requestTo(new URI(Routes.URL_BLOG_THE_KEY_ACADEMY)))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.mapper.writeValueAsString(TestDataGenerator.getExampleObject()))
                );

        // Act
        ResponseEntity<Object> result = this.httpTemplate.fetchDataFromTheKeyAcademyBlog();

        // Assert
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
