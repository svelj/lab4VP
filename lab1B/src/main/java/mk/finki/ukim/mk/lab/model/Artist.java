package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    public Artist() {
    }
    public Artist(String firstName,String lastName,String bio){
        this.firstName=firstName;
        this.lastName=lastName;
        this.bio=bio;
    }
}
