package be.helb.smakani.service;

import be.helb.smakani.dao.CheckInRepository;
import be.helb.smakani.model.CheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInService {

    private final CheckInRepository checkInRepository;

    @Autowired
    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    public CheckIn save(CheckIn checkIn){
        return checkInRepository.save(checkIn);
    }
}
