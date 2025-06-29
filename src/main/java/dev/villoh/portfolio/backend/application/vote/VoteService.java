package dev.villoh.portfolio.backend.application.vote;

import dev.villoh.portfolio.backend.application.dto.VoteResult;
import dev.villoh.portfolio.backend.domain.model.Language;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VoteService {

    /**
     * Registers a vote for the specified language.
     *
     * @param language the language to vote for
     * @return a Mono that completes when the vote is registered
     */
    Mono<Void> vote(Language language);

    /**
     * Streams the current vote results as Server-Sent Events.
     *
     * @return a Flux of ServerSentEvent containing VoteResult
     */
    Flux<ServerSentEvent<VoteResult>> streamVotes();
}
