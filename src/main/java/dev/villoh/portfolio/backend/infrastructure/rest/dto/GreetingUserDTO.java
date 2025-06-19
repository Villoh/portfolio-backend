package dev.villoh.portfolio.backend.infrastructure.rest.dto;

import lombok.Data;

/**
 * DTO for greeting user information.
 */
@Data
public class GreetingUserDTO {
    private String name;
    private String message;

    public GreetingUserDTO() {}

    public GreetingUserDTO(String name, String message) {
        this.name = name;
        this.message = message;
    }
}

