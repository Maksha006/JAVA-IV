package be.helb.smakani.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "destination")
public class Destination {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //@JsonProperty("city_name")
    private String cityName;

    //@JsonProperty("airport_code")
    private String airportCode;

    public Destination(Long id, String cityName, String airportCode) {
        this.id = id;
        this.cityName = cityName;
        this.airportCode = airportCode;
    }

    public Destination() {
    }
}
