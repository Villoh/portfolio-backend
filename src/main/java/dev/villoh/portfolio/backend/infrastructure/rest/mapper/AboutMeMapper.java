package dev.villoh.portfolio.backend.infrastructure.rest.mapper;

import dev.villoh.portfolio.backend.domain.AboutMe;
import dev.villoh.portfolio.backend.infrastructure.rest.dto.AboutMeDTO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE
)
public interface AboutMeMapper {
    AboutMeDTO toDto(AboutMe aboutMe);
    AboutMe toEntity(AboutMeDTO aboutMeDTO);
}

