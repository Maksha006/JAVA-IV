package be.helb.smakani.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "destination")
public class Destination {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String cityName;
    private String airportCode;

    public Destination(Long id, String cityName, String airportCode) {
        this.id = id;
        this.cityName = cityName;
        this.airportCode = airportCode;
    }

    public Destination() {
    }
}
