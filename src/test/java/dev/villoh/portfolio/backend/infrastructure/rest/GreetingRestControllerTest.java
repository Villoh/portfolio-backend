package dev.villoh.portfolio.backend.infrastructure.rest;

import dev.villoh.portfolio.backend.application.greeting.GreetingService;
import dev.villoh.portfolio.backend.domain.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingRestController.class)
class GreetingRestControllerTest {

    @MockitoBean
    private GreetingService greetingService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnGreeting() throws Exception {
        // Mock the service response
        String expectedGreeting = "Hello from backend!";
        when(greetingService.getGreeting("Mikel"))
                .thenReturn(new Greeting(0L, "Mikel", expectedGreeting));

        // Perform the request and verify the response
        mockMvc.perform(get("/api/greetings/{name}", "Mikel"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedGreeting));
    }
}
