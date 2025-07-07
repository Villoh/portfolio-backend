package dev.villoh.portfolio.backend.infrastructure.adapter.in.sse;

import dev.villoh.portfolio.backend.application.metrics.MetricsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MetricsSseControllerTest {
    @Mock
    MetricsService metricsService;
    @InjectMocks
    MetricsSseController controller;

    @Test
    void streamMetrics_emitsServerSentEvents() {
        when(metricsService.getLiveMetrics()).thenReturn(Map.of("key", 123));
        Flux<ServerSentEvent<Map<String, Object>>> flux = controller.streamMetrics();
        ServerSentEvent<Map<String, Object>> event = flux.blockFirst();
        assertNotNull(event);
        assertEquals("metrics", event.event());
        assertEquals(Map.of("key", 123), event.data());
        assertNotNull(event.id());
    }
}

