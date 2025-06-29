package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for transferring personal information about the portfolio owner.
 */
@Data
@AllArgsConstructor
public class AboutMeDTO {
    private final String name;
    private final String title;
    private final String summary;
    // Getters, setters, constructor
    // ...
}

