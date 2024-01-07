package be.helb.smakani.Repository;

import be.helb.smakani.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary,Long> {

    Itinerary findByDepartureDate(String departureDate);

    Itinerary findItinerariesByTravelerId(Long travelerId);
}
