package dev.villoh.portfolio.backend.shared.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(OpenApiInfoProperties openApiInfoProperties) {
        return new OpenAPI()
                .info(new Info()
                        .title(openApiInfoProperties.getTitle())
                        .description(openApiInfoProperties.getDescription())
                        .version(openApiInfoProperties.getVersion())
                );
    }
}

