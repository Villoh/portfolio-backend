package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper;

import dev.villoh.portfolio.backend.domain.model.AboutMe;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.AboutMeDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AboutMeMapperTest {
    private final AboutMeMapper mapper = Mappers.getMapper(AboutMeMapper.class);

    @Test
    void toDto_mapsAboutMeToDTO() {
        AboutMe aboutMe = new AboutMe("name", "title", "summary", "email");
        AboutMeDTO dto = mapper.toDto(aboutMe);
        assertEquals("name", dto.getName());
        assertEquals("title", dto.getTitle());
        assertEquals("summary", dto.getSummary());
    }

    @Test
    void toEntity_mapsDTOToAboutMe() {
        AboutMeDTO dto = new AboutMeDTO("name", "title", "summary");
        AboutMe aboutMe = mapper.toEntity(dto);
        assertEquals("name", aboutMe.getName());
        assertEquals("title", aboutMe.getTitle());
        assertEquals("summary", aboutMe.getSummary());
    }
}

