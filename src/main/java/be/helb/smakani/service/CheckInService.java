package be.helb.smakani.service;

import be.helb.smakani.Repository.CheckInRepository;
import be.helb.smakani.model.CheckIn;
import be.helb.smakani.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInService {

    private final CheckInRepository checkInRepository;

    @Autowired
    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    public List<CheckIn> findAll() {
        return checkInRepository.findAll();
    }

    List<CheckIn> findByTravelerId(Long TravelerId){
        return checkInRepository.findByTravelerId(TravelerId);
    }

    CheckIn findBytTicketNumber(String ticketNumber){
        return checkInRepository.findBytTicketNumber(ticketNumber);
    }

    public void delete(Long id) {
        checkInRepository.deleteById(id);
    }

    public CheckIn save(CheckIn checkIn){
        return checkInRepository.save(checkIn);
    }
}
