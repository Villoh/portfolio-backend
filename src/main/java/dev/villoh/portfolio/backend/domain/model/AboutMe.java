package dev.villoh.portfolio.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Domain entity representing personal information for the portfolio.
 */
@Data
@AllArgsConstructor
public class AboutMe {
    private final String name;
    private final String title;
    private final String summary;
    private final String email;
}