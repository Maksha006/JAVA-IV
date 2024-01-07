package be.helb.smakani.service;

import be.helb.smakani.dao.TravelerRepository;
import be.helb.smakani.model.Traveler;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;

    public TravelerService(TravelerRepository travelerRepository) {
        this.travelerRepository = travelerRepository;
    }

    public List<Traveler> findAll() {
        return travelerRepository.findAll();
    }

    public  Traveler findByFirstName(String firstName){return travelerRepository.findByFirstName(firstName);}
    public  Traveler findByLastName(String lastName){return travelerRepository.findByLastName(lastName);}
    public  Traveler findByEmail(String email){return travelerRepository.findByEmail(email);}

    public void delete(Long id) {
        travelerRepository.deleteById(id);
    }



    public Traveler save(Traveler traveler) {
        return travelerRepository.save(traveler);
    }
}
