package dev.villoh.portfolio.backend.domain.port;

import java.util.Map;

public interface MetricsPort {
    Map<String, Object> collectMetrics();
}

