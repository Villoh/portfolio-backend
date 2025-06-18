package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.application.dto.GreetingUserDTO;
import dev.villoh.portfolio.backend.application.mapper.GreetingMapper;
import dev.villoh.portfolio.backend.domain.Greeting;
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
    public GreetingUserDTO getGreeting(String name) {
        // Example implementation, in a real case a repository would be queried
        Greeting greeting = new Greeting(0L, name, "Hello, " + name + "!");
        // Convert the Greeting to a GreetingUserDTO
        return greetingMapper.toDTO(greeting);
    }
}

