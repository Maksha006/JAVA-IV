package be.helb.smakani.Repository;

import be.helb.smakani.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination,Long> {

    Destination findByAirportCode(String airportCode);
    Destination findByCityName(String cityName);
}
