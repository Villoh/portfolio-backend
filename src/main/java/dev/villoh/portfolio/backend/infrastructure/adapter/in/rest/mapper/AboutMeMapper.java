package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper;

import dev.villoh.portfolio.backend.domain.model.AboutMe;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.AboutMeDTO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE
)
public interface AboutMeMapper {
    AboutMeDTO toDto(AboutMe aboutMe);
    AboutMe toEntity(AboutMeDTO aboutMeDTO);
}

