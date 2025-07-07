package dev.villoh.portfolio.backend.infrastructure.adapter.in.sse;

import dev.villoh.portfolio.backend.application.dto.VoteResult;
import dev.villoh.portfolio.backend.application.vote.VoteService;
import dev.villoh.portfolio.backend.domain.model.Language;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VoteControllerTest {
    @Mock
    VoteService voteService;
    @InjectMocks
    VoteController controller;

    @Test
    void vote_returnsAcceptedResponse() {
        when(voteService.vote(Language.JAVA)).thenReturn(Mono.empty());
        Mono<ResponseEntity<Void>> response = controller.vote(Language.JAVA);
        assertEquals(HttpStatus.ACCEPTED, response.block().getStatusCode());
        verify(voteService).vote(Language.JAVA);
    }

    @Test
    void streamVotes_returnsFluxFromService() {
        VoteResult result = new VoteResult(Language.JAVA, 1L);
        Flux<ServerSentEvent<VoteResult>> flux = Flux.just(ServerSentEvent.builder(result).event("vote").build());
        when(voteService.streamVotes()).thenReturn(flux);
        Flux<ServerSentEvent<VoteResult>> response = controller.streamVotes();
        ServerSentEvent<VoteResult> event = response.blockFirst();
        assertNotNull(event);
        assertEquals("vote", event.event());
        assertEquals(result, event.data());
    }
}

