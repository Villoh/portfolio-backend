package dev.villoh.portfolio.backend_portfolio.domain;

/**
 * Entidad de dominio para saludos.
 */
public class Greeting {
    private final Long id;
    private final String message;

    public Greeting(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}

