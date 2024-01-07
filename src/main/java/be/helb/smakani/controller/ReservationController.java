package be.helb.smakani.controller;

import be.helb.smakani.model.Itinerary;
import be.helb.smakani.model.Reservation;
import be.helb.smakani.service.ItineraryService;
import be.helb.smakani.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/addReservation")
    public ResponseEntity<Reservation> createDestination(@RequestBody Reservation reservation){
        Reservation newReservation = reservationService.save(reservation);

        return ResponseEntity.status(HttpStatus.CREATED).body(newReservation);
    }
}
