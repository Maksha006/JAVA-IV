package be.helb.smakani.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "traveler")
public class Traveler {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "traveler")
    List<CheckIn> checkIns;

    public Traveler(Long id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Traveler() {
    }
}
