package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper;

import dev.villoh.portfolio.backend.domain.model.ContactMessage;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.ContactMessageDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactMessageMapperTest {
    private final ContactMessageMapper mapper = Mappers.getMapper(ContactMessageMapper.class);

    @Test
    void toDto_mapsContactMessageToDTO() {
        ContactMessage entity = new ContactMessage("name", "email", "message");
        ContactMessageDTO dto = mapper.toDto(entity);
        assertEquals("name", dto.getName());
        assertEquals("email", dto.getEmail());
        assertEquals("message", dto.getMessage());
    }

    @Test
    void toEntity_mapsDTOToContactMessage() {
        ContactMessageDTO dto = new ContactMessageDTO("name", "email", "message");
        ContactMessage entity = mapper.toEntity(dto);
        assertEquals("name", entity.getName());
        assertEquals("email", entity.getEmail());
        assertEquals("message", entity.getMessage());
    }
}

