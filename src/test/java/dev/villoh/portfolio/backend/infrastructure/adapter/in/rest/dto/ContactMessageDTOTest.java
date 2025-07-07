package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactMessageDTOTest {
    @Test
    void constructorAndGetters() {
        ContactMessageDTO dto = new ContactMessageDTO("name", "email", "message");
        assertEquals("name", dto.getName());
        assertEquals("email", dto.getEmail());
        assertEquals("message", dto.getMessage());
    }
}

