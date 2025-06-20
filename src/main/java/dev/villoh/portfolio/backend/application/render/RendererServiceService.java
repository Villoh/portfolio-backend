package dev.villoh.portfolio.backend.application.render;

import dev.villoh.portfolio.backend.domain.port.render.TemplateRendererPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Renderer class for handling rendering operations.
 * This class is currently a placeholder and can be extended in the future.
 */
@Component
@RequiredArgsConstructor
public class RendererServiceService implements IRendererService {

    private final TemplateRendererPort templateRendererPort;

    /**
     * Renders a template with the provided placeholders.
     *
     * @param templatePath  The path to the template file.
     * @param placeholders  A map of placeholders to be replaced in the template.
     * @return The rendered template as a string.
     */
    @Override
    public String render(String templatePath, Map<String, String> placeholders) {
        return templateRendererPort.render(templatePath, placeholders);
    }
}
