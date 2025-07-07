package dev.villoh.portfolio.backend.application.greeting;

import dev.villoh.portfolio.backend.domain.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of the GreetingService interface.
 */
@Service
@RequiredArgsConstructor
public class GreetingServiceImpl implements GreetingService {

    @Override
    public Greeting getGreeting(String name) {
        // Example implementation, in a real case a repository would be queried
        return new Greeting(name, "Hello, " + name + "!");
    }
}

