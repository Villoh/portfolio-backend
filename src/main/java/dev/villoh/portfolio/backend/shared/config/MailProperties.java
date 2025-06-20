package dev.villoh.portfolio.backend.shared.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mail")
@Configuration
public class MailProperties {
    private String host;
    private int port;
    private String username;
    private String password;
    private boolean auth;
    private boolean starttls;
}
