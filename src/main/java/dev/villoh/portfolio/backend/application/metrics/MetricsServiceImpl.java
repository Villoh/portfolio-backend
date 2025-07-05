package dev.villoh.portfolio.backend.application.metrics;

import dev.villoh.portfolio.backend.domain.port.MetricsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MetricsServiceImpl implements MetricsService{

    private final MetricsPort metricsPort;

    public Map<String, Object> getLiveMetrics() {
        return metricsPort.collectMetrics();
    }
}

