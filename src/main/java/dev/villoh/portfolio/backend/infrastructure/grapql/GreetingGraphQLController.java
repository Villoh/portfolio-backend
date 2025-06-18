package dev.villoh.portfolio.backend.infrastructure.grapql;

import dev.villoh.portfolio.backend.application.GreetingService;
import dev.villoh.portfolio.backend.application.mapper.GreetingMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * GraphQL controller for greetings.
 */
@Controller
public class GreetingGraphQLController {
    private final GreetingService greetingService;

    public GreetingGraphQLController(GreetingService greetingService, GreetingMapper greetingMapper) {
        this.greetingService = greetingService;
    }

    /**
     * GraphQL query to get a greeting by id.
     * @param name the name to greet
     * @return GreetingDTO
     */
    @QueryMapping
    public String greeting(@Argument String name) {
        return greetingService.getGreeting(name).getMessage();
    }
}

