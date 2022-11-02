package com.de.application.thekeyproxyservice.service;

import com.de.application.thekeyproxyservice.common.config.other.Routes;
import com.de.application.thekeyproxyservice.config.ScheduledConfig;
import com.de.application.thekeyproxyservice.core.blogpost.BlogPostController;
import com.de.application.thekeyproxyservice.helper.TestDataGenerator;
import com.de.application.thekeyproxyservice.service.websocket.WebsocketService;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(WebsocketService.class)
@AutoConfigureMockMvc
@Import(WebsocketService.class)
@SpringJUnitConfig(ScheduledConfig.class)
class WebsocketServiceTest {
    @Autowired
    WebsocketService websocketService;

    @MockBean
    SimpMessagingTemplate simpMessagingTemplate;

    @MockBean
    BlogPostController blogPostController;

    @Test
    void testSendCountedWords() {
        await().atMost(Duration.TWO_SECONDS).untilAsserted(() -> {
            // Arrange
            when(blogPostController.prepareDataFromBlog()).thenReturn(TestDataGenerator.createWordCountMap());
            // Assert
            verify(this.simpMessagingTemplate).convertAndSend(eq(Routes.DESTINATION_ENDPOINT), (Object) any());
        });
    }
}