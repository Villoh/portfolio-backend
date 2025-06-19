package dev.villoh.portfolio.backend.infrastructure.rest;

import dev.villoh.portfolio.backend.application.GreetingService;
import dev.villoh.portfolio.backend.infrastructure.rest.mapper.GreetingMapper;
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
     * Get a greeting by name.
     * @param name name of the person to greet
     * @return GreetingDTO
     */
    @Operation(summary = "Get a greeting by name", description = "Returns a greeting message for the specified name.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Greeting found")
    })
    @GetMapping("/{name}")
    public String getGreeting(@PathVariable String name) {
        return greetingMapper.toDTO(greetingService.getGreeting(name)).getMessage();
    }
}

