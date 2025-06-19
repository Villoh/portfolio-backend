package dev.villoh.portfolio.backend.infrastructure.rest;

import dev.villoh.portfolio.backend.application.ContactMessageService;
import dev.villoh.portfolio.backend.domain.ContactMessage;
import dev.villoh.portfolio.backend.infrastructure.rest.dto.ContactMessageDTO;
import dev.villoh.portfolio.backend.infrastructure.rest.mapper.ContactMessageMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para recibir mensajes de contacto.
 */
@RestController
@RequestMapping("/api/contact")
public class ContactMessageRestController {
    private final ContactMessageService contactMessageService;
    private final ContactMessageMapper contactMessageMapper;

    public ContactMessageRestController(ContactMessageService contactMessageService, ContactMessageMapper contactMessageMapper) {
        this.contactMessageService = contactMessageService;
        this.contactMessageMapper = contactMessageMapper;
    }

    @Operation(summary = "Send message", responses = {
            @ApiResponse(responseCode = "200", description = "Message sent successfully"),
    })
    @PostMapping
    public ResponseEntity<Void> sendContactMessage(@RequestBody ContactMessageDTO contactMessageDTO) {
        ContactMessage message = contactMessageMapper.toEntity(contactMessageDTO);
        contactMessageService.sendContactMessage(message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

