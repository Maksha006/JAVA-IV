package be.helb.smakani.controller;

import be.helb.smakani.model.Destination;
import be.helb.smakani.model.Traveler;
import be.helb.smakani.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelerController {
    private final TravelerService travelerService;

    @Autowired
    public TravelerController(TravelerService travelerService) {
        this.travelerService = travelerService;
    }

    @PostMapping("/createTraveler")
    public ResponseEntity<Traveler> createDestination(@RequestBody Traveler traveler){
        Traveler newTraveler = travelerService.save(traveler);

        return ResponseEntity.status(HttpStatus.CREATED).body(newTraveler);
    }
}
