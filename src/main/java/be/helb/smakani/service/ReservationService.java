package be.helb.smakani.service;

import be.helb.smakani.dao.CheckInRepository;
import be.helb.smakani.dao.ReservationRepository;
import be.helb.smakani.model.CheckIn;
import be.helb.smakani.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }
}
