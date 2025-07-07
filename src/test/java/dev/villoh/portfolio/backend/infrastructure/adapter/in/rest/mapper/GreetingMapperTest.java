package dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.mapper;

import dev.villoh.portfolio.backend.domain.model.Greeting;
import dev.villoh.portfolio.backend.infrastructure.adapter.in.rest.dto.GreetingUserDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingMapperTest {
    private final GreetingMapper mapper = Mappers.getMapper(GreetingMapper.class);

    @Test
    void toDTO_mapsGreetingToDTO() {
        Greeting greeting = new Greeting("Mikel", "Hello, Mikel!");
        GreetingUserDTO dto = mapper.toDTO(greeting);
        assertEquals("Mikel", dto.getName());
        assertEquals("Hello, Mikel!", dto.getMessage());
    }
}

