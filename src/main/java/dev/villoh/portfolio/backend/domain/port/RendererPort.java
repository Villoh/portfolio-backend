package dev.villoh.portfolio.backend.domain.port;

import java.util.Map;

public interface RendererPort {
    String render(String templatePath, Map<String, String> placeholders);
}
