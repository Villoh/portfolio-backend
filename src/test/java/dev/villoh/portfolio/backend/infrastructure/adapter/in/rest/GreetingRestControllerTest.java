package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest;

import dev.villoh.portfolio.backend.application.greeting.GreetingService;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.GreetingUserDTO;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper.GreetingMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingRestControllerTest {
    @Mock
    GreetingService greetingService;
    @Mock
    GreetingMapper greetingMapper;
    @InjectMocks
    GreetingRestController controller;

    @Test
    void getGreeting_returnsGreetingMessage() {
        String name = "Mikel";
        var greeting = new dev.villoh.portfolio.backend.domain.model.Greeting(name, "Hello, Mikel!");
        var dto = new GreetingUserDTO(name, "Hello, Mikel!");
        when(greetingService.getGreeting(name)).thenReturn(greeting);
        when(greetingMapper.toDTO(greeting)).thenReturn(dto);
        String result = controller.getGreeting(name);
        assertEquals("Hello, Mikel!", result);
    }
}

