package dev.villoh.portfolio.backend.domain.port.render;

import java.util.Map;

public interface TemplateRendererPort {
    String render(String templatePath, Map<String, String> placeholders);
}
