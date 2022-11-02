package com.de.application.thekeyproxyservice.common.util;

import com.de.application.thekeyproxyservice.common.config.other.Routes;
import com.de.application.thekeyproxyservice.common.util.adapter.FetchDataFromBlogAdapter;
import com.de.application.thekeyproxyservice.common.util.datatypes.Blogpost;
import com.de.application.thekeyproxyservice.helper.TestDataGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;


/**
 * Test for FetchDataFromBlogAdapter class
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FetchDataFromBlogAdapter.class, RestTemplate.class, ObjectMapper.class})
class FetchDataFromBlogAdapterTest {
    private final RestTemplate restTemplate;
    private final FetchDataFromBlogAdapter fetchDataFromBlogAdapter;
    private final ObjectMapper mapper;

    private MockRestServiceServer mockServer;

    @Autowired
    FetchDataFromBlogAdapterTest(FetchDataFromBlogAdapter fetchDataFromBlogAdapter, RestTemplate restTemplate, ObjectMapper mapper) {
        this.restTemplate = restTemplate;
        this.fetchDataFromBlogAdapter = fetchDataFromBlogAdapter;
        this.mapper = mapper;
    }

    @BeforeEach
    public void init() {
        this.mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void testFetchData() throws JsonProcessingException, URISyntaxException {
        // Arrange
        this.mockServer.expect(ExpectedCount.once(),
                requestTo(new URI(Routes.FETCH_DATA_SERVICE_URL)))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.mapper.writeValueAsString(TestDataGenerator.createListOfBlogPosts()))
                );

        // Act
        List<Blogpost> result = this.fetchDataFromBlogAdapter.fetchData();

        // Assert
        assertThat(result.size()).isEqualTo(3);
    }
}