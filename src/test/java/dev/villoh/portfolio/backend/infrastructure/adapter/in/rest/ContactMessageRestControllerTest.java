package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest;

import dev.villoh.portfolio.backend.application.contact.ContactMessageSender;
import dev.villoh.portfolio.backend.domain.model.ContactMessage;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.ContactMessageDTO;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper.ContactMessageMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactMessageRestControllerTest {
    @Mock
    ContactMessageSender contactMessageSender;
    @Mock
    ContactMessageMapper contactMessageMapper;
    @InjectMocks
    ContactMessageRestController controller;

    @Test
    void sendContactMessage_sendsMessageAndReturnsOk() {
        ContactMessageDTO dto = new ContactMessageDTO("name", "email", "msg");
        ContactMessage message = mock(ContactMessage.class);
        when(contactMessageMapper.toEntity(dto)).thenReturn(message);
        ResponseEntity<Void> response = controller.sendContactMessage(dto);
        verify(contactMessageSender).send(message);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}

