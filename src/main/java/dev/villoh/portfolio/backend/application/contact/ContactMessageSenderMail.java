package dev.villoh.portfolio.backend.application.contact;

import dev.villoh.portfolio.backend.domain.model.ContactMessage;
import dev.villoh.portfolio.backend.domain.port.RendererPort;
import dev.villoh.portfolio.backend.shared.exception.InternalServerErrorException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Implementation of ContactMessageSender that sends messages via email.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ContactMessageSenderMail implements ContactMessageSender {
    private final JavaMailSender mailSender;
    private final RendererPort renderer;

    @Value("${mail.username}")
    private String recipientEmail; // Email address to send contact messages to

    @Override
    public void send(ContactMessage message) {
        try {
            // Load HTML template
            String htmlContent = renderer.render("templates/contact-message-template.html", Map.of(
                "name", message.getName(),
                "email", message.getEmail(),
                "message", message.getMessage()
            ));

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setTo(recipientEmail);
            helper.setSubject("Mensaje de contacto del portfolio de " + message.getName());
            helper.setText(htmlContent, true); // true = isHtml
            mailSender.send(mimeMessage);
            log.info("Mensaje de contacto enviado: {}", message);
        } catch (Exception e) {
            throw new InternalServerErrorException("Error sending contact message: " + e.getMessage(), e);
        }
    }
}
