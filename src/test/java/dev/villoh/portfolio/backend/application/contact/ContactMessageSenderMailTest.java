package dev.villoh.portfolio.backend.application.contact;

import dev.villoh.portfolio.backend.domain.model.ContactMessage;
import dev.villoh.portfolio.backend.domain.port.RendererPort;
import dev.villoh.portfolio.backend.shared.exception.InternalServerErrorException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ContactMessageSenderMailTest {
    private JavaMailSender mailSender;
    private RendererPort renderer;
    private ContactMessageSenderMail sender;

    @BeforeEach
    void setUp() {
        mailSender = mock(JavaMailSender.class);
        renderer = mock(RendererPort.class);
        sender = new ContactMessageSenderMail(mailSender, renderer);
        // Set the recipientEmail field via reflection since @Value is not processed in unit tests
        try {
            var field = ContactMessageSenderMail.class.getDeclaredField("recipientEmail");
            field.setAccessible(true);
            field.set(sender, "test@recipient.com");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void send_sendsEmailSuccessfully() {
        ContactMessage message = new ContactMessage("John", "john@email.com", "Hello!");
        when(renderer.render(anyString(), any(Map.class))).thenReturn("<html>content</html>");
        MimeMessage mimeMessage = mock(MimeMessage.class);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        doNothing().when(mailSender).send(any(MimeMessage.class));

        assertDoesNotThrow(() -> sender.send(message));
        verify(mailSender).send(mimeMessage);
    }

    @Test
    void send_throwsInternalServerErrorException_onFailure() {
        ContactMessage message = new ContactMessage("John", "john@email.com", "Hello!");
        when(renderer.render(anyString(), any(Map.class))).thenThrow(new RuntimeException("fail"));
        Exception ex = assertThrows(InternalServerErrorException.class, () -> sender.send(message));
        assertTrue(ex.getMessage().contains("Error sending contact message"));
    }
}

