package dev.villoh.portfolio.backend.infrastructure.grpc;

import dev.villoh.portfolio.backend.application.greeting.GreetingService;
import dev.villoh.portfolio.backend.domain.Greeting;
import dev.villoh.portfolio.backend.proto.GreetRequest;
import dev.villoh.portfolio.backend.proto.GreetResponse;
import dev.villoh.portfolio.backend.proto.GreetingServiceGrpc;
import dev.villoh.portfolio.backend.shared.exception.BadRequestException;
import dev.villoh.portfolio.backend.shared.exception.InternalServerErrorException;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * gRPC adapter for the GreetingService application logic.
 * Delegates business logic to the application service and maps to gRPC messages.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class GreetingGrpcService extends GreetingServiceGrpc.GreetingServiceImplBase {

    private final GreetingService greetingService;

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        log.info("Hello {}", request.getName());
        if (request.getName().startsWith("error")) {
            throw new BadRequestException("Bad name: " + request.getName());
        }
        if (request.getName().startsWith("internal")) {
            throw new InternalServerErrorException("Internal error for name: " + request.getName());
        }
        Greeting greeting = greetingService.getGreeting(request.getName());
        GreetResponse response = GreetResponse.newBuilder()
                .setMessage(greeting.getMessage())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
