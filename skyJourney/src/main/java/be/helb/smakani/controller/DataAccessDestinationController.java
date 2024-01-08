package be.helb.smakani.controller;

import be.helb.smakani.dto.DestinationDto;
import be.helb.smakani.service.DataDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations") // Le chemin de base pour toutes les routes de ce contrôleur
public class DataAccessDestinationController {

    private final DataDestinationService dataDestinationService;

    @Autowired
    public DataAccessDestinationController(DataDestinationService dataDestinationService) {
        this.dataDestinationService = dataDestinationService;
    }

    @GetMapping
    public ResponseEntity<List<DestinationDto>> getAllDestinations() {
        List<DestinationDto> destinations = dataDestinationService.getDestinations();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DestinationDto> createDestination(@RequestBody DestinationDto destinationDto) {
        DestinationDto createdDestination = dataDestinationService.createDestination(destinationDto);
        return new ResponseEntity<>(createdDestination, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        dataDestinationService.deleteDestination(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
