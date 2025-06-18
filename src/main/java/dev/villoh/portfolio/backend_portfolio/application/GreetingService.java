package dev.villoh.portfolio.backend_portfolio.application;

import dev.villoh.portfolio.backend_portfolio.domain.Greeting;

/**
 * Interfaz de caso de uso para saludos.
 */
public interface GreetingService {
    Greeting getGreeting(Long id);
}

