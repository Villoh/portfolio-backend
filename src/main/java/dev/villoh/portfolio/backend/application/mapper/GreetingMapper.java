package dev.villoh.portfolio.backend.application.mapper;

import dev.villoh.portfolio.backend.application.dto.GreetingUserDTO;
import dev.villoh.portfolio.backend.domain.Greeting;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir entre Greeting y GreetingDTO.
 */
@Mapper(componentModel = "spring")
public interface GreetingMapper {
    GreetingUserDTO toDTO(Greeting greeting);
}

