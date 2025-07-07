package dev.villoh.portfolio.backend.infrastructure.adapter.in.exception;

import dev.villoh.portfolio.backend.shared.exception.BadRequestException;
import dev.villoh.portfolio.backend.shared.exception.CustomHttpResponse;
import dev.villoh.portfolio.backend.shared.exception.InternalServerErrorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RestExceptionHandlerTest {
    private final RestExceptionHandler handler = new RestExceptionHandler();

    @Test
    void handleBadRequestException_returnsCustomHttpResponse() {
        BadRequestException ex = new BadRequestException("bad request");
        CustomHttpResponse response = handler.handleBadRequestException(ex);
        assertNotNull(response);
        assertEquals("bad request", response.message());
    }

    @Test
    void handleInternalServerErrorException_returnsCustomHttpResponse() {
        InternalServerErrorException ex = new InternalServerErrorException("internal error");
        CustomHttpResponse response = handler.handleInternalServerErrorException(ex);
        assertNotNull(response);
        assertEquals("internal error", response.message());
    }
}

