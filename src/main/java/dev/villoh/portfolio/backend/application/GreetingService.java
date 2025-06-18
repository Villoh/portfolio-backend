package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.application.dto.GreetingUserDTO;

/**
 * Interface for greeting services.
 */
public interface GreetingService {
    GreetingUserDTO getGreeting(String name);
}

