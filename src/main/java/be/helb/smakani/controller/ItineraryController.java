package be.helb.smakani.controller;


import be.helb.smakani.model.Itinerary;
import be.helb.smakani.model.Traveler;
import be.helb.smakani.service.ItineraryService;
import be.helb.smakani.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItineraryController {

    private final ItineraryService itineraryService;

    @Autowired
    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @PostMapping("/addItinerary")
    public ResponseEntity<Itinerary> createDestination(@RequestBody Itinerary itinerary){
        Itinerary newItinerary = itineraryService.save(itinerary);

        return ResponseEntity.status(HttpStatus.CREATED).body(newItinerary);
    }
}
