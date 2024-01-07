package be.helb.smakani.controller;

import be.helb.smakani.model.Flight;
import be.helb.smakani.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/createFlight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight){
        Flight newFlight = flightService.save(flight);

        return ResponseEntity.status(HttpStatus.CREATED).body(newFlight);
    }
}
