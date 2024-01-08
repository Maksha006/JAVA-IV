package helb.smakani.service;

import be.helb.smakani.dto.DestinationDto;
import be.helb.smakani.mapper.DestinationMapper;
import be.helb.smakani.model.Destination;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DestinationMapperTest {

    private DestinationMapper mapper = Mappers.getMapper(DestinationMapper.class);

    @Test
    public void testDestinationToDestinationDto() {
        Destination destination = new Destination();
        destination.setId(1L);
        destination.setCityName("Rome");
        destination.setAirportCode("FCO");

        DestinationDto destinationDto = mapper.destinationToDestinationDto(destination);

        assertEquals(destination.getId(), destinationDto.getId());
        assertEquals(destination.getCityName(), destinationDto.getCityName());
        assertEquals(destination.getAirportCode(), destinationDto.getAirportCode());
    }

    @Test
    public void testDestinationDtoToDestination() {
        DestinationDto destinationDto = new DestinationDto();
        destinationDto.setId(1L);
        destinationDto.setCityName("Rome");
        destinationDto.setAirportCode("FCO");

        Destination destination = mapper.destinationDtoToDestination(destinationDto);

        assertEquals(destinationDto.getId(), destination.getId());
        assertEquals(destinationDto.getCityName(), destination.getCityName());
        assertEquals(destinationDto.getAirportCode(), destination.getAirportCode());
    }
}
