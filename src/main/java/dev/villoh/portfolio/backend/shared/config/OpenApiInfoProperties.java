package dev.villoh.portfolio.backend.shared.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "springdoc.info")
public class OpenApiInfoProperties {
    private String title;
    private String description;
    private String version;
}

