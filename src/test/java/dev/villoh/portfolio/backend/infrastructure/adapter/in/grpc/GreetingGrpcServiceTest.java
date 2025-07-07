package dev.villoh.portfolio.backend.infrastructure.adapter.in.grpc;

import dev.villoh.portfolio.backend.application.greeting.GreetingService;
import dev.villoh.portfolio.backend.domain.model.Greeting;
import dev.villoh.portfolio.backend.proto.GreetRequest;
import dev.villoh.portfolio.backend.proto.GreetResponse;
import dev.villoh.portfolio.backend.shared.exception.BadRequestException;
import dev.villoh.portfolio.backend.shared.exception.InternalServerErrorException;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GreetingGrpcServiceTest {
    @Mock
    GreetingService greetingService;
    @Mock
    StreamObserver<GreetResponse> responseObserver;
    @InjectMocks
    GreetingGrpcService grpcService;

    @Test
    void greet_sendsGreetingResponse() {
        GreetRequest request = GreetRequest.newBuilder().setName("Mikel").build();
        Greeting greeting = new Greeting("Mikel", "Hello, Mikel!");
        when(greetingService.getGreeting("Mikel")).thenReturn(greeting);
        grpcService.greet(request, responseObserver);
        verify(responseObserver).onNext(GreetResponse.newBuilder().setMessage("Hello, Mikel!").build());
        verify(responseObserver).onCompleted();
    }

    @Test
    void greet_throwsBadRequestException() {
        GreetRequest request = GreetRequest.newBuilder().setName("errorName").build();
        try {
            grpcService.greet(request, responseObserver);
            fail("Expected BadRequestException");
        } catch (BadRequestException ex) {
            assertTrue(ex.getMessage().contains("Bad name"));
        }
    }

    @Test
    void greet_throwsInternalServerErrorException() {
        GreetRequest request = GreetRequest.newBuilder().setName("internalName").build();
        try {
            grpcService.greet(request, responseObserver);
            fail("Expected InternalServerErrorException");
        } catch (InternalServerErrorException ex) {
            assertTrue(ex.getMessage().contains("Internal error"));
        }
    }
}

