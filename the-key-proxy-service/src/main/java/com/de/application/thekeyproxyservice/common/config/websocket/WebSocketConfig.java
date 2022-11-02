package com.de.application.thekeyproxyservice.common.config.websocket;

import com.de.application.thekeyproxyservice.common.config.other.Routes;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Websocket configuration
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker(Routes.DESTINATION);
        config.setApplicationDestinationPrefixes(Routes.DESTINATION_PREFIX);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(Routes.WEBSOCKET_ENDPOINT).setAllowedOrigins(Routes.GUI_URL).withSockJS();
        //registry.addEndpoint(Routes.WEBSOCKET_ENDPOINT).setAllowedOrigins(Routes.PROXY_URL).withSockJS();
    }
}