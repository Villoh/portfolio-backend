package dev.villoh.portfolio.backend.infrastructure.adapter.in.sse;

import dev.villoh.portfolio.backend.application.metrics.MetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MetricsSseController {

    private static final long INTERVAL_MILLIS = 1000; // 5 seconds
    private final MetricsService metricsService;

    @GetMapping(path = "/api/metrics/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Map<String, Object>>> streamMetrics() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> {
                    Map<String, Object> metrics = metricsService.getLiveMetrics();
                    return ServerSentEvent.<Map<String, Object>>builder()
                            .id(UUID.randomUUID().toString())
                            .event("metrics")
                            .data(metrics)
                            .build();
                });
    }
}
