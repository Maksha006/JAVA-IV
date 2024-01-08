package be.helb.smakani.service;

import be.helb.smakani.Repository.FlightRepository;
import be.helb.smakani.model.Flight;
import be.helb.smakani.model.Traveler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public List<Flight> findByTargetDestinationId(Long destinationId){
        return flightRepository.findByTargetDestinationId(destinationId);
    }
    public List<Flight> findByItineraryId(Long itineraryId){
        return flightRepository.findByItineraryId(itineraryId);
    }

    public List<Flight> findByStatus(String status){
        return flightRepository.findByStatus(status);
    }

    public void delete(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }
}
