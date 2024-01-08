package be.helb.smakani.dao;

import be.helb.smakani.model.Destination;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DestinationDao extends JpaRepository<Destination,Long> {

    Destination findByCityName(String cityName);
}
