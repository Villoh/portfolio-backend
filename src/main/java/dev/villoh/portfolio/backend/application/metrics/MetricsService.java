package dev.villoh.portfolio.backend.application.metrics;

import java.util.Map;

public interface MetricsService {
    /**
     * Collects and returns live metrics.
     *
     * @return a map containing the collected metrics.
     */
    Map<String, Object> getLiveMetrics();
}
