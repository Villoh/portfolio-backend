package dev.villoh.portfolio.backend.domain;

import lombok.Data;

/**
 * Domain entity representing a contact message.
 */
@Data
public class ContactMessage {
    private final String name;
    private final String email;
    private final String message;
}

