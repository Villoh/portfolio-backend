package dev.villoh.portfolio.backend.application.contact;

import dev.villoh.portfolio.backend.domain.ContactMessage;

/**
 * Application service for handling contact messages.
 */
public interface ContactMessageSender {
    void send(ContactMessage message);
}

