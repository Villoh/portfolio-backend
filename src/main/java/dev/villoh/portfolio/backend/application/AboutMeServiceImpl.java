package dev.villoh.portfolio.backend.application;

import dev.villoh.portfolio.backend.domain.AboutMe;
import org.springframework.stereotype.Service;

/**
 * AboutMeServiceImpl es la implementación del servicio que proporciona
 */
@Service
public class AboutMeServiceImpl implements AboutMeService {
    @Override
    public AboutMe getAboutMe() {
        // Datos hardcodeados para el portfolio. En un caso real, vendrían de un repositorio.
        return new AboutMe("Miguel Villoh", "Senior Backend Engineer", "Apasionado por el diseño de arquitecturas limpias y escalables.", "miguel@villoh.dev");
    }
}

