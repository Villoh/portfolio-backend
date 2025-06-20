package dev.villoh.portfolio.backend.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for contact messages.
 */
@Data
@AllArgsConstructor
public class ContactMessageDTO {
    private final String name;
    private final String email;
    private final String message;
    // Getters, setters, constructor
    // ...
}


