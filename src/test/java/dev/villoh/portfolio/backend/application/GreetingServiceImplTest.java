package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.application.greeting.GreetingServiceImpl;
import dev.villoh.portfolio.backend.domain.model.Greeting;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper.GreetingMapper;
import dev.villoh.portfolio.backend.infrastructure.rest.mapper.GreetingMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for GreetingServiceImpl.
 */
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@ContextConfiguration(
        classes = {
                GreetingMapperImpl.class
        }
)
class GreetingServiceImplTest {

    @Autowired
    private GreetingMapper greetingMapper;

    private GreetingServiceImpl greetingService;

    @BeforeEach
    void setUp() {
        greetingService = new GreetingServiceImpl(greetingMapper);
    }
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

