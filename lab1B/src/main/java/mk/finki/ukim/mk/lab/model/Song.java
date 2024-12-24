package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackId;
    private String title;
    private String genre;
//    private String category;
    private int releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Album album;
//    private List<Review> reviews;

    public Song(String title,String trackId,String genre,int releaseYear,Album album,List<Artist> performers){
        this.title = title;
        this.trackId = trackId;
        this.genre = genre;
//        this.category=category;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
//        this.reviews=reviews;
    }

    public Song() {

    }
}
