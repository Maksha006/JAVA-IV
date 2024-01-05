package be.helb.smakani.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private LocalDateTime departureDate;
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "traveler_id")
    private Traveler travelerId;

    public Itinerary(Long id, LocalDateTime departureDate, LocalDateTime returnDate, Traveler travelerId, List<Flight> flights) {
        this.id = id;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.travelerId = travelerId;
        this.flights = flights;
    }

    @OneToMany(mappedBy = "itinerary")
    List<Flight> flights;


    public Itinerary() {
    }

}
