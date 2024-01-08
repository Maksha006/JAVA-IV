package be.helb.smakani.controller;


import be.helb.smakani.model.Flight;
import be.helb.smakani.model.Itinerary;
import be.helb.smakani.model.Traveler;
import be.helb.smakani.service.ItineraryService;
import be.helb.smakani.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ItineraryController {

    private final ItineraryService itineraryService;

    @Autowired
    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping("/allItineraries")
    public List<Itinerary> findAllItinerary() {
        return itineraryService.findAll();
    }

    @GetMapping("/itinerary/departureDate")
    public List<Itinerary> findByDepartureDate(@RequestParam LocalDate departureDate) {
        return itineraryService.findByDepartureDate(String.valueOf(departureDate));
    }

    @GetMapping("/itinerary/traveler/{id}")
    public List<Itinerary> findItinerariesByTravelerId(@PathVariable("id") Traveler travelerId) {
        return itineraryService.findItinerariesByTravelerId(travelerId);
    }

    @DeleteMapping("/itinerary/delete/{id}")
    public ResponseEntity<Itinerary> deleteTraveler(@PathVariable("id") Long id) {
        itineraryService.delete(id);
        return new ResponseEntity<Itinerary>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/itinerary/update/{id}")
    public ResponseEntity<Itinerary> updateItinerary(@RequestBody Itinerary itinerary) {
        Itinerary updatedItinerary = itineraryService.save(itinerary);
        if (updatedItinerary == null)
            return new ResponseEntity<Itinerary>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Itinerary>(updatedItinerary, HttpStatus.OK);
    }

    @PostMapping("/addItinerary")
    public ResponseEntity<Itinerary> createDestination(@RequestBody Itinerary itinerary){
        Itinerary newItinerary = itineraryService.save(itinerary);

        return ResponseEntity.status(HttpStatus.CREATED).body(newItinerary);
    }
}
