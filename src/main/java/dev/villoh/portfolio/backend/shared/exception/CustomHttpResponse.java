package dev.villoh.portfolio.backend.shared.exception;

/**
 * Custom exception class for handling custom response status.
 * This exception is used to return custom HTTP status codes and messages.
 */
public record CustomHttpResponse(String message) { }