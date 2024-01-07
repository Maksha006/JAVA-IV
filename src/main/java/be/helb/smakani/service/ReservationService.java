package be.helb.smakani.service;

import be.helb.smakani.Repository.ReservationRepository;
import be.helb.smakani.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }
}
