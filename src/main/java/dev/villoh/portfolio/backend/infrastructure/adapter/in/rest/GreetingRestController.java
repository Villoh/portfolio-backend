package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest;

import dev.villoh.portfolio.backend.application.greeting.GreetingService;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper.GreetingMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
        summary = "Get a personalized greeting by name",
        description = "Returns a greeting message for the specified name. The name is provided as a path variable.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Greeting found", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Invalid name parameter", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        }
    )
    @GetMapping("/{name}")
    public String getGreeting(@PathVariable String name) {
        return greetingMapper.toDTO(greetingService.getGreeting(name)).getMessage();
    }
}
