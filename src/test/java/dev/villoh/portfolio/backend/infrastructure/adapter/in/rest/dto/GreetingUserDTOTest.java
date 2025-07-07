package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingUserDTOTest {
    @Test
    void constructorAndGetters() {
        GreetingUserDTO dto = new GreetingUserDTO("name", "message");
        assertEquals("name", dto.getName());
        assertEquals("message", dto.getMessage());
    }
}

