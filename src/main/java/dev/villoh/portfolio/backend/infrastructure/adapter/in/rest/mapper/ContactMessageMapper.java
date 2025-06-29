package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper;

import dev.villoh.portfolio.backend.domain.model.ContactMessage;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.ContactMessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMessageMapper {
    ContactMessageDTO toDto(ContactMessage contactMessage);
    ContactMessage toEntity(ContactMessageDTO contactMessageDTO);
}

