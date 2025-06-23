package dev.villoh.portfolio.backend.application.aboutme;

import dev.villoh.portfolio.backend.domain.AboutMe;

/**
 * Service interface for retrieving personal information for the portfolio.
 */
public interface AboutMeService {
    /**
     * Retrieves personal information localized to the specified language.
     * @param language the language code (e.g., "en", "es")
     * @return AboutMe entity with localized fields
     */
    AboutMe getAboutMe(String language);
}
