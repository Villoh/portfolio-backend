package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.domain.ContactMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Implementación de ContactMessageService.
 */
@Service
public class ContactMessageServiceImpl implements ContactMessageService {
    private static final Logger logger = LoggerFactory.getLogger(ContactMessageServiceImpl.class);

    private final JavaMailSender mailSender;

    @Autowired
    public ContactMessageServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendContactMessage(ContactMessage message) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo("your.email@domain.com"); // TODO: Reemplazar con tu email real o externalizar
            mail.setSubject("Mensaje de contacto del portfolio de " + message.getName());
            mail.setText("De: " + message.getEmail() + "\n\n" + message.getMessage());
            mailSender.send(mail);
            logger.info("Mensaje de contacto enviado: {}", message);
        } catch (MailException e) {
            logger.error("Error al enviar el mensaje de contacto: {}", message, e);
            throw new RuntimeException("Error al enviar el mensaje de contacto", e);
        }
    }
}
