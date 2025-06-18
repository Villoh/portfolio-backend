package dev.villoh.portfolio.backend_portfolio.infrastructure.rest;

import dev.villoh.portfolio.backend_portfolio.application.GreetingService;
import dev.villoh.portfolio.backend_portfolio.application.dto.GreetingDTO;
import dev.villoh.portfolio.backend_portfolio.application.mapper.GreetingMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Adaptador REST para saludos.
 */
@RestController
@RequestMapping("/api/greetings")
@RequiredArgsConstructor
public class GreetingRestController {
    private final GreetingService greetingService;
    private final GreetingMapper greetingMapper;

    /**
     * Obtiene un saludo por ID.
     * @param id identificador del saludo
     * @return GreetingDTO
     */
    @Operation(summary = "Obtener saludo por ID", description = "Devuelve un saludo de ejemplo.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Saludo encontrado"),
        @ApiResponse(responseCode = "404", description = "Saludo no encontrado")
    })
    @GetMapping("/{id}")
    public GreetingDTO getGreeting(@PathVariable Long id) {
        return greetingMapper.toDTO(greetingService.getGreeting(id));
    }
}

