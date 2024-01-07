package be.helb.smakani.Repository;

import be.helb.smakani.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckInRepository extends JpaRepository<CheckIn,Long> {

    List<CheckIn> findByTravelerId(Long TravelerId);

    CheckIn findBytTicketNumber(String ticketNumber);
}
