package be.helb.smakani.service;

import be.helb.smakani.Repository.DestinationRepository;
import be.helb.smakani.dto.DestinationDto;
import be.helb.smakani.mapper.DestinationMapper;
import be.helb.smakani.model.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    private final DestinationMapper destinationMapper = DestinationMapper.INSTANCE;;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<DestinationDto> findAll() {
        return destinationRepository.findAll()
                .stream()
                .map(destinationMapper::destinationToDestinationDto)
                .collect(Collectors.toList());
    }

    public DestinationDto findByAirportCode(String airportCode) {
        Destination destination = destinationRepository.findByAirportCode(airportCode);
        return destinationMapper.destinationToDestinationDto(destination);
    }
    public DestinationDto findByCityName(String cityName) {
        Destination destination = destinationRepository.findByCityName(cityName);
        return destinationMapper.destinationToDestinationDto(destination);
    }

    public void delete(Long id) {
        destinationRepository.deleteById(id);
    }

    public DestinationDto save(DestinationDto destinationDto) {
        Destination destination = destinationMapper.destinationDtoToDestination(destinationDto);
        Destination savedDestination = destinationRepository.save(destination);
        return destinationMapper.destinationToDestinationDto(savedDestination);
    }
}
