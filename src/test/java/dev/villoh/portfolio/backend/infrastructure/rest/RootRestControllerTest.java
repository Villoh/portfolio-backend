package dev.villoh.portfolio.backend.infrastructure.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RootRestController.class)
class RootRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnRunning() throws Exception {
        // Perform the request and verify the response
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("API Portfolio Backend is running"));
    }
}
