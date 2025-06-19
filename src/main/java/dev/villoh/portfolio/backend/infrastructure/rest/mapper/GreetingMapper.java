package dev.villoh.portfolio.backend.infrastructure.rest.mapper;

import dev.villoh.portfolio.backend.domain.Greeting;
import dev.villoh.portfolio.backend.infrastructure.rest.dto.GreetingUserDTO;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir entre Greeting y GreetingDTO.
 */
@Mapper(componentModel = "spring")
public interface GreetingMapper {
    GreetingUserDTO toDTO(Greeting greeting);
}

