package dev.villoh.portfolio.backend_portfolio.application;

import dev.villoh.portfolio.backend_portfolio.domain.Greeting;
import org.springframework.stereotype.Service;

/**
 * Implementación simple de GreetingService.
 */
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public Greeting getGreeting(Long id) {
        // Implementación de ejemplo, en un caso real se consultaría un repositorio
        return new Greeting(id, "Hello from backend! (id=" + id + ")");
    }
}

