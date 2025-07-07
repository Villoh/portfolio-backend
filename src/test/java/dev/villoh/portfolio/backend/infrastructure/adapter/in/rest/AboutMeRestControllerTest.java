package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest;

import dev.villoh.portfolio.backend.application.aboutme.AboutMeService;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.AboutMeDTO;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper.AboutMeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AboutMeRestControllerTest {
    @Mock
    AboutMeService aboutMeService;
    @Mock
    AboutMeMapper aboutMeMapper;
    @InjectMocks
    AboutMeRestController controller;

    @Test
    void getAboutMe_returnsAboutMeDTO() {
        var aboutMe = mock(dev.villoh.portfolio.backend.domain.model.AboutMe.class);
        var dto = new AboutMeDTO("name", "title", "summary");
        when(aboutMeService.getAboutMe("en")).thenReturn(aboutMe);
        when(aboutMeMapper.toDto(aboutMe)).thenReturn(dto);
        AboutMeDTO result = controller.getAboutMe("en");
        assertEquals(dto, result);
    }
}

