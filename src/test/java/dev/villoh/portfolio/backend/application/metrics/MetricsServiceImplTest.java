package dev.villoh.portfolio.backend.application.metrics;

import dev.villoh.portfolio.backend.domain.port.MetricsPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MetricsServiceImplTest {
    private MetricsPort metricsPort;
    private MetricsServiceImpl metricsService;

    @BeforeEach
    void setUp() {
        metricsPort = mock(MetricsPort.class);
        metricsService = new MetricsServiceImpl(metricsPort);
    }

    @Test
    void getLiveMetrics_returnsMetricsFromPort() {
        Map<String, Object> expected = Map.of("key", 123);
        when(metricsPort.collectMetrics()).thenReturn(expected);
        Map<String, Object> result = metricsService.getLiveMetrics();
        assertEquals(expected, result);
        verify(metricsPort).collectMetrics();
    }
}

