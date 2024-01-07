package be.helb.smakani.service;

import be.helb.smakani.dao.CheckInRepository;
import be.helb.smakani.dao.ItineraryRepository;
import be.helb.smakani.model.CheckIn;
import be.helb.smakani.model.Itinerary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public Itinerary save(Itinerary itinerary){
        return itineraryRepository.save(itinerary);
    }
}
