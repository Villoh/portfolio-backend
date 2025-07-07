package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest;

import dev.villoh.portfolio.backend.application.aboutme.AboutMeService;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.AboutMeDTO;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper.AboutMeMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Operation(
        summary = "Get localized personal information",
        description = "Returns personal information for the portfolio, localized to the requested language. Use the 'lang' query parameter to select the language (e.g., 'en' for English, 'es' for Spanish).",
        responses = {
            @ApiResponse(responseCode = "200", description = "Information retrieved successfully", content = @Content(schema = @Schema(implementation = AboutMeDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid language parameter", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        }
    )
    @GetMapping
    public AboutMeDTO getAboutMe(@RequestParam(value = "lang", required = false) String language) {
        return aboutMeMapper.toDto(aboutMeService.getAboutMe(language));
    }
}
