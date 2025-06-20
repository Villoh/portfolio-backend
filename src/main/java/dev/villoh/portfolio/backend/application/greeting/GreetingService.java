package dev.villoh.portfolio.backend.application.greeting;

import dev.villoh.portfolio.backend.domain.Greeting;

/**
 * Interface for greeting services.
 */
public interface GreetingService {
    Greeting getGreeting(String name);
}

