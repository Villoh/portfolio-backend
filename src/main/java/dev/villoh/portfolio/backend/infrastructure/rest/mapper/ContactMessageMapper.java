package dev.villoh.portfolio.backend.infrastructure.rest.mapper;

import dev.villoh.portfolio.backend.domain.ContactMessage;
import dev.villoh.portfolio.backend.infrastructure.rest.dto.ContactMessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMessageMapper {
    ContactMessageDTO toDto(ContactMessage contactMessage);
    ContactMessage toEntity(ContactMessageDTO contactMessageDTO);
}

