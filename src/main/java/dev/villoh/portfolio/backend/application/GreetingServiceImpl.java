package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.domain.Greeting;
import dev.villoh.portfolio.backend.infrastructure.rest.mapper.GreetingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of the GreetingService interface.
 */
@Service
@RequiredArgsConstructor
public class GreetingServiceImpl implements GreetingService {

    private final GreetingMapper greetingMapper;

    @Override
    public Greeting getGreeting(String name) {
        // Example implementation, in a real case a repository would be queried
        Greeting greeting = new Greeting(0L, name, "Hello, " + name + "!");
        // Convert the Greeting to a GreetingUserDTO
        return greeting;
    }
}

