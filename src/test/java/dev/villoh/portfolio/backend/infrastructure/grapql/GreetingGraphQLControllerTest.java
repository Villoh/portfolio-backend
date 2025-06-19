package dev.villoh.portfolio.backend.infrastructure.grapql;

import dev.villoh.portfolio.backend.application.GreetingService;
import dev.villoh.portfolio.backend.application.GreetingServiceImpl;
import dev.villoh.portfolio.backend.domain.Greeting;
import dev.villoh.portfolio.backend.infrastructure.rest.mapper.GreetingMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest
@ExtendWith(MockitoExtension.class)
class GreetingGraphQLControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Mock
    private GreetingService greetingService;

    @Mock
    private GreetingMapper greetingMapper;

    @BeforeEach
    void setUp() {
        greetingService = new GreetingServiceImpl(greetingMapper);
    }

    @Test
    void greetingQuery_returnsGreetingMessage() {
        // Arrange
        Mockito.when(greetingService.getGreeting("Mikel"))
                .thenReturn(new Greeting(0L, "Mikel", "Hello, Mikel!"));
        // Act & Assert
        graphQlTester.document("query { greeting(name: \"Mikel\") }")
                .execute()
                .path("greeting").hasValue()
                .path("greeting").entity(String.class).isEqualTo("Hello, Mikel!");
    }
}
