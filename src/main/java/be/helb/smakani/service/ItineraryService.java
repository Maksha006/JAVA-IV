package be.helb.smakani.service;

import be.helb.smakani.Repository.ItineraryRepository;
import be.helb.smakani.model.Itinerary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public List<Itinerary> findAll() {
        return itineraryRepository.findAll();
    }

    Itinerary findByDepartureDate(String departureDate){
        return itineraryRepository.findByDepartureDate(departureDate);
    }

    Itinerary findItinerariesByTravelerId(Long travelerId){
        return itineraryRepository.findItinerariesByTravelerId(travelerId);
    }

    public void delete(Long id) {
        itineraryRepository.deleteById(id);
    }


    public Itinerary save(Itinerary itinerary){
        return itineraryRepository.save(itinerary);
    }
}
