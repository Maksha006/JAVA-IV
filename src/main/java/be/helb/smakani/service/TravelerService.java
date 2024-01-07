package be.helb.smakani.service;

import be.helb.smakani.dao.TravelerRepository;
import be.helb.smakani.model.Destination;
import be.helb.smakani.model.Traveler;
import org.springframework.stereotype.Service;

@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;

    public TravelerService(TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    public Traveler save(Traveler traveler) {
        return travelerRepository.save(traveler);
    }
}
