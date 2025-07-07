package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RootRestControllerTest {
    private final RootRestController controller = new RootRestController();

    @Test
    void index_returnsApiStatus() {
        String result = controller.index();
        assertEquals("API Portfolio Backend is running", result);
    }
}

