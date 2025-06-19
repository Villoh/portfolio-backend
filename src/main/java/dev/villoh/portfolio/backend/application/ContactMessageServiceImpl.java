package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.domain.ContactMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementación de ContactMessageService.
 */
@Service
public class ContactMessageServiceImpl implements ContactMessageService {
    private static final Logger logger = LoggerFactory.getLogger(ContactMessageServiceImpl.class);

    @Override
    public void sendContactMessage(ContactMessage message) {
        // Simulación de envío de email (stub). En un caso real, integrar con un servicio de email.
        logger.info("Mensaje de contacto recibido: {}", message);
    }
}

