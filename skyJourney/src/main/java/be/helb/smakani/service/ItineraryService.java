package be.helb.smakani.service;

import be.helb.smakani.Repository.ItineraryRepository;
import be.helb.smakani.model.Itinerary;
import be.helb.smakani.model.Traveler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Itinerary> findByDepartureDate(String departureDate){
        return itineraryRepository.findByDepartureDate(LocalDate.parse(departureDate));
    }

    public List<Itinerary> findItinerariesByTravelerId(Traveler travelerId){
        return itineraryRepository.findItinerariesByTravelerId(travelerId);
    }

    public void delete(Long id) {
        itineraryRepository.deleteById(id);
    }


    public Itinerary save(Itinerary itinerary){
        return itineraryRepository.save(itinerary);
    }
}
