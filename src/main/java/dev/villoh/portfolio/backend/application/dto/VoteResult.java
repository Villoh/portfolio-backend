package dev.villoh.portfolio.backend.application.dto;

import dev.villoh.portfolio.backend.domain.model.Language;

public record VoteResult(Language language, long votes) {}
