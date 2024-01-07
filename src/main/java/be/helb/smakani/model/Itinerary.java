package be.helb.smakani.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private LocalDate departureDate;
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "traveler_id")
    private Traveler travelerId;

    public Itinerary(Long id, LocalDate departureDate, LocalDate returnDate, Traveler travelerId, List<Flight> flights) {
        this.id = id;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.travelerId = travelerId;
        this.flights = flights;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "itinerary")
    List<Flight> flights;


    public Itinerary() {
    }

}
