package dev.villoh.portfolio.backend_portfolio.application.dto;

/**
 * DTO para exponer saludos.
 */
public class GreetingDTO {
    private Long id;
    private String message;

    public GreetingDTO() {}

    public GreetingDTO(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

