package be.helb.smakani.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {

    public Reservation(Long id, String bookingNumber, Itinerary itinerary) {
        this.id = id;
        this.bookingNumber = bookingNumber;
        this.itinerary = itinerary;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String bookingNumber;

    @OneToOne
    @JoinColumn(name = "itinerary_id")
    private Itinerary itinerary;


}
