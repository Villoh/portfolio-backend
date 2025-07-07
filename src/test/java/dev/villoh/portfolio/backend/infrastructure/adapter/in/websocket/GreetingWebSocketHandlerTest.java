package dev.villoh.portfolio.backend.infrastructure.adapter.in.websocket;

import dev.villoh.portfolio.backend.application.greeting.GreetingService;
import dev.villoh.portfolio.backend.domain.model.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingWebSocketHandlerTest {
    @Mock
    GreetingService greetingService;
    @InjectMocks
    GreetingWebSocketHandler handler;

    @Test
    void handleTextMessage_sendsGreeting() throws Exception {
        WebSocketSession session = mock(WebSocketSession.class);
        TextMessage message = new TextMessage("Mikel");
        Greeting greeting = new Greeting("Mikel", "Hello, Mikel!");
        when(greetingService.getGreeting("Mikel")).thenReturn(greeting);
        handler.handleTextMessage(session, message);
        verify(session).sendMessage(new TextMessage("Hello, Mikel!"));
    }
}

