package dev.villoh.portfolio.backend.application.aboutme;

import dev.villoh.portfolio.backend.domain.model.AboutMe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class AboutMeServiceImplTest {
    private MessageSource messageSource;
    private AboutMeServiceImpl aboutMeService;

    @BeforeEach
    void setUp() {
        messageSource = Mockito.mock(MessageSource.class);
        aboutMeService = new AboutMeServiceImpl(messageSource);
    }

    @Test
    void getAboutMe_returnsLocalizedAboutMe() {
        Mockito.when(messageSource.getMessage(eq("aboutme.name"), any(), any(Locale.class))).thenReturn("Test Name");
        Mockito.when(messageSource.getMessage(eq("aboutme.title"), any(), any(Locale.class))).thenReturn("Test Title");
        Mockito.when(messageSource.getMessage(eq("aboutme.summary"), any(), any(Locale.class))).thenReturn("Test Summary");

        AboutMe aboutMe = aboutMeService.getAboutMe("en");
        assertEquals("Test Name", aboutMe.getName());
        assertEquals("Test Title", aboutMe.getTitle());
        assertEquals("Test Summary", aboutMe.getSummary());
    }
}

