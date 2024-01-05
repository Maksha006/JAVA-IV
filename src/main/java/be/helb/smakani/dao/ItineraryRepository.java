package be.helb.smakani.dao;

import be.helb.smakani.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary,Long> {
}
