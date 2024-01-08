package be.helb.smakani.controller;

import be.helb.smakani.model.CheckIn;
import be.helb.smakani.model.Flight;
import be.helb.smakani.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckInController {

    private final CheckInService checkInService;

    @Autowired
    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @GetMapping("/allcheckins")
    public List<CheckIn> findAllCheckIns() {
        return checkInService.findAll();
    }

    @GetMapping("/checkin/traveler/{id}")
    List<CheckIn> findByTravelerId(@PathVariable("id") Long travelerId) {
        return checkInService.findByTravelerId(travelerId);
    }

    @GetMapping("/checkin/ticketNumber/{ticketNumber}")
    public CheckIn findByTicketNumber(@PathVariable("ticketNumber") String ticketNumber) {
        return checkInService.findByTicketNumber(ticketNumber);
    }

    @DeleteMapping("/checkin/delete/{id}")
    public ResponseEntity<CheckIn> deleteCheckIn(@PathVariable("id") Long id) {
        checkInService.delete(id);
        return new ResponseEntity<CheckIn>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/checkin/update/{id}")
    public ResponseEntity<CheckIn> updateFlight(@RequestBody CheckIn checkIn) {
        CheckIn updatedCheckIn = checkInService.save(checkIn);
        if (updatedCheckIn == null)
            return new ResponseEntity<CheckIn>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<CheckIn>(updatedCheckIn, HttpStatus.OK);
    }

    @PostMapping("/createCheckIn")
    public ResponseEntity<CheckIn> createDestination(@RequestBody CheckIn checkIn){
        CheckIn newCheckIn = checkInService.save(checkIn);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCheckIn);
    }
}
