package dev.villoh.portfolio.backend_portfolio.application.mapper;

import dev.villoh.portfolio.backend_portfolio.application.dto.GreetingDTO;
import dev.villoh.portfolio.backend_portfolio.domain.Greeting;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir entre Greeting y GreetingDTO.
 */
@Mapper(componentModel = "spring")
public interface GreetingMapper {
    GreetingDTO toDTO(Greeting greeting);
    Greeting toEntity(GreetingDTO dto);
}

