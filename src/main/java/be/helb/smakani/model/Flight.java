package be.helb.smakani.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String flightNumber;
    private String airline;
    private LocalDateTime departureTime;
    private LocalDateTime  arrivalTime;
    private String status;

    public Flight(Long id, String flightNumber, String airline, LocalDateTime  departureTimes, LocalDateTime arrivalTimes, String status) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureTime = departureTimes;
        this.arrivalTime = arrivalTimes;
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "itinerary_id")
    private Itinerary itinerary;

    @ManyToOne
    @JoinColumn(name = "origin_destination_id")
    private Destination originDestination;

    @ManyToOne
    @JoinColumn(name = "target_destination_id")
    private Destination targetDestination;

}
