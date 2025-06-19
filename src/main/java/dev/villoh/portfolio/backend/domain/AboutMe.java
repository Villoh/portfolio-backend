package dev.villoh.portfolio.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Entidad de dominio que representa la información personal para el portfolio.
 */
@Data
@AllArgsConstructor
public class AboutMe {
    private final String name;
    private final String title;
    private final String summary;
    private final String email;
}