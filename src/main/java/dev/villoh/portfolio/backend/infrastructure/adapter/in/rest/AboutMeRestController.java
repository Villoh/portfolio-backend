package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest;

import dev.villoh.portfolio.backend.application.aboutme.AboutMeService;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.AboutMeDTO;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper.AboutMeMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Operation(summary = "Retrieve personal information",
        description = "Returns personal information localized to the requested language. Available languages: en (English), es (Spanish). Use the 'lang' query parameter to select the language.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Information retrieved successfully"),
    })
    @GetMapping
    public AboutMeDTO getAboutMe(@RequestParam(value = "lang", required = false) String language) {
        return aboutMeMapper.toDto(aboutMeService.getAboutMe(language));
    }
}
