package dev.villoh.portfolio.backend.infrastructure.rest;

import dev.villoh.portfolio.backend.application.aboutme.AboutMeService;
import dev.villoh.portfolio.backend.infrastructure.rest.dto.AboutMeDTO;
import dev.villoh.portfolio.backend.infrastructure.rest.mapper.AboutMeMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para exponer la información de AboutMe.
 */
@RestController
@RequestMapping("/api/about-me")
public class AboutMeRestController {
    private final AboutMeService aboutMeService;
    private final AboutMeMapper aboutMeMapper;

    public AboutMeRestController(AboutMeService aboutMeService, AboutMeMapper aboutMeMapper) {
        this.aboutMeService = aboutMeService;
        this.aboutMeMapper = aboutMeMapper;
    }

    @Operation(summary = "Retrieve personal information", responses = {
            @ApiResponse(responseCode = "200", description = "Information retrieved successfully"),
    })
    @GetMapping
    public AboutMeDTO getAboutMe() {
        return aboutMeMapper.toDto(aboutMeService.getAboutMe());
    }
}

