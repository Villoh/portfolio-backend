package dev.villoh.portfolio.backend.infrastructure.adapter.out.metrics;

import dev.villoh.portfolio.backend.domain.port.MetricsPort;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.HashMap;
import java.util.Map;

@Component
public class MetricsAdapter implements MetricsPort {
    @Override
    public Map<String, Object> collectMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        Runtime runtime = Runtime.getRuntime();
        long uptimeMillis = runtimeBean.getUptime();
        long uptimeSeconds = uptimeMillis / 1000;
        long uptimeMinutes = uptimeSeconds / 60;
        long uptimeHours = uptimeMinutes / 60;
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        double usedMemoryMB = usedMemory / (1024.0 * 1024.0);
        double totalMemoryMB = runtime.totalMemory() / (1024.0 * 1024.0);
        double maxMemoryMB = runtime.maxMemory() / (1024.0 * 1024.0);
        double freeMemoryMB = runtime.freeMemory() / (1024.0 * 1024.0);

        metrics.put("systemLoadAverage", String.format("%.2f", osBean.getSystemLoadAverage()));
        metrics.put("availableProcessors", osBean.getAvailableProcessors());
        metrics.put("uptime", String.format("%dh %dm %ds", uptimeHours, uptimeMinutes % 60, uptimeSeconds % 60));
        metrics.put("usedMemoryMB", String.format("%.2f MB", usedMemoryMB));
        metrics.put("freeMemoryMB", String.format("%.2f MB", freeMemoryMB));
        metrics.put("totalMemoryMB", String.format("%.2f MB", totalMemoryMB));
        metrics.put("maxMemoryMB", String.format("%.2f MB", maxMemoryMB));
        metrics.put("startTime", new java.util.Date(runtimeBean.getStartTime()).toString());
        metrics.put("osName", System.getProperty("os.name"));
        metrics.put("osVersion", System.getProperty("os.version"));
        metrics.put("javaVersion", System.getProperty("java.version"));
        metrics.put("user", System.getProperty("user.name"));
        return metrics;
    }
}
