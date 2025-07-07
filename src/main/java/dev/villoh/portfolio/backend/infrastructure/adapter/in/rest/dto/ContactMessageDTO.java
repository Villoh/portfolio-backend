package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for contact messages.
 */
@Data
@AllArgsConstructor
public class ContactMessageDTO {
    private String name;
    private String email;
    private String message;
}
