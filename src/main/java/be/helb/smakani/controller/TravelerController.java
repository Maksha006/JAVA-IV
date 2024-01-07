package be.helb.smakani.controller;

import be.helb.smakani.model.Destination;
import be.helb.smakani.model.Traveler;
import be.helb.smakani.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TravelerController {
    private final TravelerService travelerService;

    @Autowired
    public TravelerController(TravelerService travelerService) {
        this.travelerService = travelerService;
    }

    @GetMapping("/allTraveler")
    public List<Traveler> findAllTraveler() {

        return travelerService.findAll();
    }

    @GetMapping("/traveler")
    public Traveler findTravelerByFirstName(@RequestParam String firstname) {

        return travelerService.findByFirstName(firstname);
    }

    @GetMapping("/traveler")
    public Traveler findTravelerByLastName(@RequestParam String lastname) {

        return travelerService.findByLastName(lastname);
    }

    @PostMapping("/createTraveler")
    public ResponseEntity<Traveler> createTraveler(@RequestBody Traveler traveler){
        Traveler newTraveler = travelerService.save(traveler);

        return ResponseEntity.status(HttpStatus.CREATED).body(newTraveler);
    }

    @PutMapping("/traveler/update/{id}")
    public ResponseEntity<Traveler> updateTraveler(@RequestBody Traveler traveler) {
        Traveler updatedTraveler = travelerService.save(traveler);
        if (updatedTraveler == null)
            return new ResponseEntity<Traveler>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Traveler>(updatedTraveler, HttpStatus.OK);
    }

    @DeleteMapping("/traveler/delete/{id}")
    public ResponseEntity<Traveler> deleteTraveler(@PathVariable("id") Long id) {
        travelerService.delete(id);
        return new ResponseEntity<Traveler>(HttpStatus.NO_CONTENT);
    }
}
