package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest;

import dev.villoh.portfolio.backend.application.contact.ContactMessageSender;
import dev.villoh.portfolio.backend.domain.model.ContactMessage;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.ContactMessageDTO;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper.ContactMessageMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para recibir mensajes de contacto.
 */
@RestController
@RequestMapping("/api/contact")
public class ContactMessageRestController {
    private final ContactMessageSender contactMessageSender;
    private final ContactMessageMapper contactMessageMapper;

    public ContactMessageRestController(ContactMessageSender contactMessageSender, ContactMessageMapper contactMessageMapper) {
        this.contactMessageSender = contactMessageSender;
        this.contactMessageMapper = contactMessageMapper;
    }

    @Operation(
        summary = "Send a contact message",
        description = "Receives a contact message and sends it via email. The request body must include the sender's name, email, and message.",
        requestBody = @RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = ContactMessageDTO.class),
                mediaType = "application/json"
            )
        ),
        responses = {
            @ApiResponse(responseCode = "200", description = "Message sent successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        }
    )
    @PostMapping
    public ResponseEntity<Void> sendContactMessage(@RequestBody ContactMessageDTO contactMessageDTO) {
        ContactMessage message = contactMessageMapper.toEntity(contactMessageDTO);
        contactMessageSender.send(message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
