package be.helb.smakani.Repository;

import be.helb.smakani.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn,Long> {

    List<CheckIn> findByTravelerId(Long TravelerId);

    CheckIn findByTicketNumber(String ticketNumber);
}
