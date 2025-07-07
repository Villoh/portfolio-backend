package dev.villoh.portfolio.backend.application.vote;

import dev.villoh.portfolio.backend.application.dto.VoteResult;
import dev.villoh.portfolio.backend.domain.model.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class VoteServiceImplTest {
    private VoteServiceImpl voteService;

    @BeforeEach
    void setUp() {
        voteService = new VoteServiceImpl();
    }

    @Test
    void vote_incrementsVoteCountAndEmitsResult() {
        Language lang = Language.JAVA;
        Mono<Void> result = voteService.vote(lang);
        assertNull(result.block());
        // Vote again to check increment
        voteService.vote(lang).block();
        // Stream should emit two results
        List<ServerSentEvent<VoteResult>> events = voteService.streamVotes().take(2).collectList().block();
        assertNotNull(events);
        assertEquals(2, events.size());
        assertEquals(lang, events.get(1).data().language());
        assertEquals(2, events.get(1).data().votes());
    }

    @Test
    void streamVotes_emitsServerSentEvents() {
        voteService.vote(Language.PYTHON).block();
        StepVerifier.create(voteService.streamVotes().take(1))
                .assertNext(event -> {
                    assertEquals(Language.PYTHON, event.data().language());
                    assertEquals(1, event.data().votes());
                    assertEquals("vote", event.event());
                    assertNotNull(event.id());
                })
                .verifyComplete();
    }
}

