package dev.villoh.portfolio.backend.infrastructure.adapter.out.render;

import dev.villoh.portfolio.backend.domain.port.RendererPort;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class RendererAdapter implements RendererPort {

    @Override
    @SneakyThrows
    public String render(String templatePath, Map<String, String> placeholders) {
        ClassPathResource resource = new ClassPathResource(templatePath);
        try (InputStream input = resource.getInputStream()) {
            String template = new String(input.readAllBytes(), StandardCharsets.UTF_8);
            for (var entry : placeholders.entrySet()) {
                template = template.replace("{{" + entry.getKey() + "}}", entry.getValue());
            }
            return template;
        }
    }
}
