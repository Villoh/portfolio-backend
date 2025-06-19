package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.domain.AboutMe;

/**
 * Service interface for retrieving personal information for the portfolio.
 */
public interface AboutMeService {
    AboutMe getAboutMe();
}

