package dev.villoh.portfolio.backend.infrastructure.adapter.out.render;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RendererAdapterTest {
    @Test
    void render_replacesPlaceholdersInHtmlTemplate() {
        RendererAdapter adapter = new RendererAdapter();
        String result = adapter.render("templates/contact-message-template.html", Map.of(
                "name", "Test User",
                "email", "test@example.com",
                "message", "Hello from the test!"
        ));
        assertTrue(result.contains("Test User"));
        assertTrue(result.contains("test@example.com"));
        assertTrue(result.contains("Hello from the test!"));
        assertTrue(result.contains("<html"));
        assertTrue(result.contains("New Contact Message"));
    }
}
