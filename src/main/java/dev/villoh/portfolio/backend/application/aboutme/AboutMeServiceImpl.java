package dev.villoh.portfolio.backend.application.aboutme;

import dev.villoh.portfolio.backend.domain.AboutMe;
import org.springframework.stereotype.Service;

/**
 * AboutMeServiceImpl es la implementación del servicio que proporciona
 */
@Service
public class AboutMeServiceImpl implements AboutMeService {
    private static final String NAME = "Miguel Villoh";
    private static final String TITLE = "Senior Backend Engineer";
    private static final String DESCRIPTION = "Apasionado por el diseño de arquitecturas limpias y escalables.";
    private static final String EMAIL = "miguel@villoh.dev";

    @Override
    public AboutMe getAboutMe() {
        // Use constants for the about me data
        return new AboutMe(NAME, TITLE, DESCRIPTION, EMAIL);
    }
}
