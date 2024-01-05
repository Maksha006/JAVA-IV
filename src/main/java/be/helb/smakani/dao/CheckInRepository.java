package be.helb.smakani.dao;

import be.helb.smakani.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn,Long> {
}
