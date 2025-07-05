package dev.villoh.portfolio.backend.shared.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class MailConfig {

    private final MailProperties props;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(props.getHost());
        sender.setPort(props.getPort());
        sender.setUsername(props.getUsername());
        sender.setPassword(props.getPassword());

        Properties javaProps = sender.getJavaMailProperties();
        javaProps.put("mail.transport.protocol", "smtp");
        javaProps.put("mail.smtp.auth", props.isAuth());
        javaProps.put("mail.smtp.starttls.enable", props.isStarttls());
        javaProps.put("mail.debug", "false");

        return sender;
    }
}
