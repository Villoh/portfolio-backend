package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.domain.ContactMessage;

/**
 * Servicio de aplicación para procesar mensajes de contacto.
 */
public interface ContactMessageService {
    void sendContactMessage(ContactMessage message);
}

