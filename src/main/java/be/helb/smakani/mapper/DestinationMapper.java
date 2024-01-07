package be.helb.smakani.mapper;

import be.helb.smakani.dto.DestinationDto;
import be.helb.smakani.model.Destination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "cityName", source = "cityName")
    @Mapping(target = "airportCode", source = "airportCode")
    DestinationDto destinationToDestinationDto(Destination destination);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cityName", source = "cityName")
    @Mapping(target = "airportCode", source = "airportCode")
    Destination destinationDtoToDestination(DestinationDto dto);
}
