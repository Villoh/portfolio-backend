package dev.villoh.portfolio.backend.infrastructure.adapter.in.sse;

import dev.villoh.portfolio.backend.application.dto.VoteResult;
import dev.villoh.portfolio.backend.application.vote.VoteService;
import dev.villoh.portfolio.backend.domain.model.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/vote")
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/{language}")
    public Mono<ResponseEntity<Void>> vote(@PathVariable Language language) {
        return voteService.vote(language)
                          .thenReturn(ResponseEntity.accepted().build());
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<VoteResult>> streamVotes() {
        return voteService.streamVotes();
    }
}
