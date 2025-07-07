package dev.villoh.portfolio.backend.application.dto;

import dev.villoh.portfolio.backend.domain.model.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VoteResultTest {
    @Test
    void record_accessorsWorkCorrectly() {
        VoteResult result = new VoteResult(Language.JAVA, 42L);
        assertEquals(Language.JAVA, result.language());
        assertEquals(42L, result.votes());
    }
}

