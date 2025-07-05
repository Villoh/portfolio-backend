package dev.villoh.portfolio.backend.shared.config;

import dev.villoh.portfolio.backend.infrastructure.adapter.in.websocket.GreetingWebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Simple WebSocket configuration for /ws/greeting endpoint (no STOMP).
 */
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final GreetingWebSocketHandler greetingWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(greetingWebSocketHandler, "/ws/greeting").setAllowedOriginPatterns("*");
    }
}
