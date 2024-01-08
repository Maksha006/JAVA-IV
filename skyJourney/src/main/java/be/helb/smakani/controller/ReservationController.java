package be.helb.smakani.controller;

import be.helb.smakani.model.Flight;
import be.helb.smakani.model.Reservation;
import be.helb.smakani.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/allReservation")
    public List<Reservation> findAllReservation() {
        return reservationService.findAll();
    }

    @GetMapping("/reservation/targetdestination/{id}")
    public Optional<Reservation> findById(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @DeleteMapping("/reservation/delete/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Long id) {
        reservationService.delete(id);
        return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/reservation/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        Reservation updateReservation = reservationService.save(reservation);
        if (updateReservation == null)
            return new ResponseEntity<Reservation>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<Reservation>(updateReservation, HttpStatus.OK);
    }

    @PostMapping("/addReservation")
    public ResponseEntity<Reservation> createDestination(@RequestBody Reservation reservation){
        Reservation newReservation = reservationService.save(reservation);

        return ResponseEntity.status(HttpStatus.CREATED).body(newReservation);
    }
}
