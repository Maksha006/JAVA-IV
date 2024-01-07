package be.helb.smakani.service;

import be.helb.smakani.dao.DestinationRepository;
import be.helb.smakani.model.Destination;
import be.helb.smakani.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }


    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }
}
