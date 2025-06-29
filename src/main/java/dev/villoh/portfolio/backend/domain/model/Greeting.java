package dev.villoh.portfolio.backend.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Entidad de dominio para saludos.
 */
@Data
@RequiredArgsConstructor
public class Greeting {
    private final String name;
    private final String message;
}

