package dev.villoh.portfolio.backend.application.vote;

import dev.villoh.portfolio.backend.application.dto.VoteResult;
import dev.villoh.portfolio.backend.domain.model.Language;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class VoteServiceImpl implements VoteService {

    private final Map<Language, Long> voteMap = new ConcurrentHashMap<>();
    private final Sinks.Many<VoteResult> sink = Sinks.many().multicast().onBackpressureBuffer();

    public Mono<Void> vote(Language language) {
        voteMap.merge(language, 1L, Long::sum);
        VoteResult result = new VoteResult(language, voteMap.get(language));
        sink.tryEmitNext(result);
        return Mono.empty();
    }

    public Flux<ServerSentEvent<VoteResult>> streamVotes() {
        return sink.asFlux()
                   .map(result -> ServerSentEvent.builder(result)
                           .id(UUID.randomUUID().toString())     // unique ID for reconnection
                           .event("vote")                        // named event type
                           .data(result)
                           .build());
    }
}
