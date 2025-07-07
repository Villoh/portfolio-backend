package dev.villoh.portfolio.backend.infrastructure.adapter.in.grapql;

import dev.villoh.portfolio.backend.application.greeting.GreetingService;
import dev.villoh.portfolio.backend.domain.model.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingGraphQLControllerTest {
    @Mock
    GreetingService greetingService;
    @InjectMocks
    GreetingGraphQLController controller;

    @Test
    void greeting_returnsGreetingMessage() {
        Greeting greeting = new Greeting("Mikel", "Hello, Mikel!");
        when(greetingService.getGreeting("Mikel")).thenReturn(greeting);
        String result = controller.greeting("Mikel");
        assertEquals("Hello, Mikel!", result);
    }
}

