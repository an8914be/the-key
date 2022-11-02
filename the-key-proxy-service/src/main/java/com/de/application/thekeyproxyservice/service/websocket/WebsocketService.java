package com.de.application.thekeyproxyservice.service.websocket;

import com.de.application.thekeyproxyservice.common.config.other.Routes;
import com.de.application.thekeyproxyservice.core.blogpost.BlogPostController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The websocket service that sends data to the gui
 */
@Service
@EnableScheduling
public class WebsocketService {
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final BlogPostController blogPostController;
    private final SimpMessagingTemplate simpMessagingTemplate;

    /**
     * The constructor
     *
     * @param blogPostController    {@link BlogPostController}
     * @param simpMessagingTemplate {@link SimpMessagingTemplate}
     */
    @Autowired
    WebsocketService(BlogPostController blogPostController, SimpMessagingTemplate simpMessagingTemplate) {
        this.blogPostController = blogPostController;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    /**
     * Websocket sender method, that sends the counted words from the key academy blog
     * every two seconds to the client
     */
    @Scheduled(fixedRate = 2000)
    public void sendCountedWords() {
        logger.log(Level.INFO, "Transfer data per websocket successfully");
        Map<String, Integer> wordCountMap = this.blogPostController.prepareDataFromBlog();
        this.simpMessagingTemplate.convertAndSend(Routes.DESTINATION_ENDPOINT, wordCountMap);
    }
}