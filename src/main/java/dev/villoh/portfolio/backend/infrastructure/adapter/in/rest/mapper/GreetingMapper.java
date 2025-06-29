package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper;

import dev.villoh.portfolio.backend.domain.model.Greeting;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.GreetingUserDTO;
import org.mapstruct.Mapper;

/**
 * Mapper para convertir entre Greeting y GreetingDTO.
 */
@Mapper(componentModel = "spring")
public interface GreetingMapper {
    GreetingUserDTO toDTO(Greeting greeting);
}

