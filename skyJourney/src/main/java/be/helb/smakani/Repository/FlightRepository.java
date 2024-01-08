package be.helb.smakani.Repository;

import be.helb.smakani.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    List<Flight> findByTargetDestinationId(Long destinationId);
    List<Flight> findByItineraryId(Long itineraryId);
    List<Flight> findByStatus(String status);


}
