package be.helb.smakani.controller;

import be.helb.smakani.model.CheckIn;
import be.helb.smakani.model.Destination;
import be.helb.smakani.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckInController {

    private final CheckInService checkInService;

    @Autowired
    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @PostMapping("/createCheckIn")
    public ResponseEntity<CheckIn> createDestination(@RequestBody CheckIn checkIn){
        CheckIn newCheckIn = checkInService.save(checkIn);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCheckIn);
    }
}
