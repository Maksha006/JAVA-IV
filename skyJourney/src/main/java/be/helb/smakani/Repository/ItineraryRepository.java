package be.helb.smakani.Repository;

import be.helb.smakani.model.Itinerary;
import be.helb.smakani.model.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary,Long> {

    List<Itinerary> findByDepartureDate(LocalDate departureDate);

    List<Itinerary> findItinerariesByTravelerId(Traveler travelerId);
}
