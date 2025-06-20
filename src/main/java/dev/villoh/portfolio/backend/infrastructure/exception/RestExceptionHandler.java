package dev.villoh.portfolio.backend.infrastructure.exception;

import dev.villoh.portfolio.backend.shared.exception.BadRequestException;
import dev.villoh.portfolio.backend.shared.exception.CustomHttpResponse;
import dev.villoh.portfolio.backend.shared.exception.InternalServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling exceptions in the application.
 * This class handles specific types of exceptions and returns appropriate HTTP responses.
 */
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * Handles BadRequestException and returns a 400 HTTP response.
     *
     * @param ex the BadRequestException to be handled
     * @return a CustomHttpResponse with success status set to false and error message
     */
    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody CustomHttpResponse handleBadRequestException(BadRequestException ex) {
        return new CustomHttpResponse(ex.getMessage());
    }

    /**
     * Handles InternalServerErrorException and returns a 500 HTTP response.
     *
     * @param ex the InternalServerErrorException to be handled
     * @return a CustomHttpResponse with success status set to false and error message
     */
    @ExceptionHandler(value = InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody CustomHttpResponse handleInternalServerErrorException(InternalServerErrorException ex) {
    	return new CustomHttpResponse(ex.getMessage());
    }
}
