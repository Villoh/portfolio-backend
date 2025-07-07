package dev.villoh.portfolio.backend.infrastructure.adapter.out.metrics;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MetricsAdapterTest {
    @Test
    void collectMetrics_returnsAllExpectedKeys() {
        MetricsAdapter adapter = new MetricsAdapter();
        Map<String, Object> metrics = adapter.collectMetrics();
        assertNotNull(metrics.get("systemLoadAverage"));
        assertNotNull(metrics.get("availableProcessors"));
        assertNotNull(metrics.get("uptime"));
        assertNotNull(metrics.get("usedMemoryMB"));
        assertNotNull(metrics.get("freeMemoryMB"));
        assertNotNull(metrics.get("totalMemoryMB"));
        assertNotNull(metrics.get("maxMemoryMB"));
        assertNotNull(metrics.get("startTime"));
        assertNotNull(metrics.get("osName"));
        assertNotNull(metrics.get("osVersion"));
        assertNotNull(metrics.get("javaVersion"));
        assertNotNull(metrics.get("user"));
        assertEquals(12, metrics.size());
    }
}
