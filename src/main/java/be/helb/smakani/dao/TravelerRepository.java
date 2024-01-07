package be.helb.smakani.dao;

import be.helb.smakani.model.Flight;
import be.helb.smakani.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler,Long> {

    Traveler findByFirstName(String firstName);
    Traveler findByLastName(String lastName);
    Traveler findByEmail(String email);

}
