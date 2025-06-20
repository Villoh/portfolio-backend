package dev.villoh.portfolio.backend.application.render;

import java.util.Map;

public interface IRendererService {
        /**
     * Renders a template with the provided placeholders.
     *
     * @param templatePath  The path to the template file.
     * @param placeholders  A map of placeholders to be replaced in the template.
     * @return The rendered template as a string.
     */
    String render(String templatePath, Map<String, String> placeholders);
}
