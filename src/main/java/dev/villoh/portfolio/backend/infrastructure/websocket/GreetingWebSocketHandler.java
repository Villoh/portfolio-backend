package dev.villoh.portfolio.backend.infrastructure.websocket;

import dev.villoh.portfolio.backend.application.greeting.GreetingService;
import dev.villoh.portfolio.backend.domain.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Simple WebSocket handler for greeting messages (no STOMP).
 */
@Component
@RequiredArgsConstructor
public class GreetingWebSocketHandler extends TextWebSocketHandler {
    private final GreetingService greetingService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String name = message.getPayload();
        Greeting greeting = greetingService.getGreeting(name);
        session.sendMessage(new TextMessage(greeting.getMessage()));
    }
}

