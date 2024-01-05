package be.helb.smakani.dao;

import be.helb.smakani.model.Flight;
import be.helb.smakani.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepository extends JpaRepository<Traveler,Long> {
}
