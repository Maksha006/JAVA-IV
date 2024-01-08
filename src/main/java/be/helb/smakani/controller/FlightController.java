package be.helb.smakani.controller;

import be.helb.smakani.model.Flight;
import be.helb.smakani.model.Traveler;
import be.helb.smakani.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/allFlights")
    public List<Flight> findAllFlights() {
        return flightService.findAll();
    }

    @GetMapping("/flight/targetdestination/{id}")
    public List<Flight> findByTargetDestinationId(@PathVariable("id") Long destinationId) {
        return flightService.findByTargetDestinationId(destinationId);
    }

    @GetMapping("/flight/itineraryId/{id}")
    public List<Flight> findByItineraryId(@PathVariable("id") Long itineraryId) {
        return flightService.findByItineraryId(itineraryId);
    }

    @GetMapping("/flight/status")
    public List<Flight> findByStatus(@RequestParam String status) {
        return flightService.findByStatus(status);
    }

    @DeleteMapping("/flight/delete/{id}")
    public ResponseEntity<Flight> deleteTraveler(@PathVariable("id") Long id) {
        flightService.delete(id);
        return new ResponseEntity<Flight>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/flight/update/{id}")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) {
        Flight updatedFlight = flightService.save(flight);
        if (updatedFlight == null)
            return new ResponseEntity<Flight>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Flight>(updatedFlight, HttpStatus.OK);
    }

    @PostMapping("/createFlight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight){
        Flight newFlight = flightService.save(flight);

        return ResponseEntity.status(HttpStatus.CREATED).body(newFlight);
    }
}
