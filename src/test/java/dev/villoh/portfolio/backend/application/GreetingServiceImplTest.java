package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.application.greeting.GreetingServiceImpl;
import dev.villoh.portfolio.backend.domain.model.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for GreetingServiceImpl.
 */
@ExtendWith({MockitoExtension.class})
class GreetingServiceImplTest {

    @InjectMocks
    private GreetingServiceImpl greetingService;

    @Test
    void getGreeting_shouldReturnGreetingWithCorrectIdAndMessage() {
        String name = "Mikel";
        Greeting greeting = greetingService.getGreeting(name);
        assertNotNull(greeting);
        assertEquals(name, greeting.getName());
        assertTrue(greeting.getMessage().contains("Hello, Mikel!"));
        assertTrue(greeting.getMessage().contains(name));
    }
}

