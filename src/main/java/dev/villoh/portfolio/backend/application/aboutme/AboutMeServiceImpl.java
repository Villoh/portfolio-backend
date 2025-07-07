package dev.villoh.portfolio.backend.application.aboutme;

import dev.villoh.portfolio.backend.domain.model.AboutMe;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * AboutMeServiceImpl es la implementación del servicio que proporciona
 */
@Service
public class AboutMeServiceImpl implements AboutMeService {
    private final MessageSource messageSource;
    private static final String EMAIL = "";

    public AboutMeServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public AboutMe getAboutMe(String language) {
        Locale locale = language != null ? Locale.forLanguageTag(language) : LocaleContextHolder.getLocale();
        String name = messageSource.getMessage("aboutme.name", null, locale);
        String title = messageSource.getMessage("aboutme.title", null, locale);
        String summary = messageSource.getMessage("aboutme.summary", null, locale);
        return new AboutMe(name, title, summary, EMAIL);
    }
}
