package be.helb.smakani.controller;

import be.helb.smakani.dto.DestinationDto;
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

    @GetMapping("/allDestinations")
    public List<DestinationDto> findAllDestination() {

        return destinationService.findAll();
    }

    @GetMapping("/destination/airportcode")
    public DestinationDto findByAirportCode(@RequestParam String airportCode) {

        return destinationService.findByAirportCode(airportCode);
    }

    @GetMapping("/destination/cityname")
    public DestinationDto findByCityName(@RequestParam String cityName) {

        return destinationService.findByCityName(cityName);
    }

    @PutMapping("/destination/update/{id}")
    public ResponseEntity<DestinationDto> updateDestination(@RequestBody DestinationDto destinationDto) {
        DestinationDto updatedDestination = destinationService.save(destinationDto);
        if (updatedDestination == null)
            return new ResponseEntity<DestinationDto>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<DestinationDto>(updatedDestination, HttpStatus.OK);
    }

    @DeleteMapping("/destination/delete/{id}")
    public ResponseEntity<Destination> deleteDestination(@PathVariable("id") Long id) {
        destinationService.delete(id);
        return new ResponseEntity<Destination>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/createDestination")
    public ResponseEntity<DestinationDto> createDestination(@RequestBody DestinationDto destinationDto){
        DestinationDto savedDestinationDto = destinationService.save(destinationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDestinationDto);
    }
}
