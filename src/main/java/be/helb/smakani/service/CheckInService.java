package be.helb.smakani.service;

import be.helb.smakani.Repository.CheckInRepository;
import be.helb.smakani.model.CheckIn;
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

    public List<CheckIn> findByTravelerId(Long TravelerId){
        return checkInRepository.findByTravelerId(TravelerId);
    }

    public CheckIn findByTicketNumber(String ticketNumber){
        return checkInRepository.findBytTicketNumber(ticketNumber);
    }

    public void delete(Long id) {
        checkInRepository.deleteById(id);
    }

    public CheckIn save(CheckIn checkIn){
        return checkInRepository.save(checkIn);
    }
}
