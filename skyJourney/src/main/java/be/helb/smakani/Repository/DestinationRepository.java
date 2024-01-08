package be.helb.smakani.Repository;

import be.helb.smakani.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {

    Destination findByAirportCode(String airportCode);
    Destination findByCityName(String cityName);
}
