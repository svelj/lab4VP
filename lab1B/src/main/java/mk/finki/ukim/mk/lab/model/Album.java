package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    public Album() {

    }
    public Album(String name,String genre,String releaseYear,List<Song>songs){
        this.name = name;
        this.genre=genre;
        this.releaseYear = releaseYear;
        this.songs = songs;
    }
}
