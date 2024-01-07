package be.helb.smakani.Repository;

import be.helb.smakani.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler,Long> {

    Traveler findByFirstName(String firstName);
    Traveler findByLastName(String lastName);
    Traveler findByEmail(String email);

}
