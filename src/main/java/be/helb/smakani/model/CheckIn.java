package be.helb.smakani.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "check_in")
public class CheckIn {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String ticketNumber;

    @ManyToOne
    @JoinColumn(name = "traveler_id")
    private Traveler traveler;

    public CheckIn(Long id, String ticketNumber, Traveler traveler, Flight flight) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.traveler = traveler;
        this.flight = flight;
    }

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
