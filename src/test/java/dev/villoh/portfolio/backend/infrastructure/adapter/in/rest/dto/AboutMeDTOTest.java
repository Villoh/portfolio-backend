package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AboutMeDTOTest {
    @Test
    void constructorAndGetters() {
        AboutMeDTO dto = new AboutMeDTO("name", "title", "summary");
        assertEquals("name", dto.getName());
        assertEquals("title", dto.getTitle());
        assertEquals("summary", dto.getSummary());
    }
}

