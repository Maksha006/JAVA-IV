package be.helb.smakani.controller;

import be.helb.smakani.model.Destination;
import be.helb.smakani.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }
    @PostMapping("/createDestination")
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination){
        Destination newDestination = destinationService.save(destination);

        return ResponseEntity.status(HttpStatus.CREATED).body(newDestination);
    }

    @GetMapping("/destination/cityname")
    public Destination findByCityName(@RequestParam String cityName) {

        return destinationService.findByCityName(cityName);
    }

    @GetMapping("/allDestinations")
    public List<Destination> findAllDestination() {

        return destinationService.findAll();
    }

    @DeleteMapping("/destination/delete/{id}")
    public ResponseEntity<Destination> deleteDestination(@PathVariable("id") Long id) {
        destinationService.delete(id);
        return new ResponseEntity<Destination>(HttpStatus.NO_CONTENT);
    }
}
