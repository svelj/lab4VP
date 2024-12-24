package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.AlbumRepository;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Song> songs = null;
    public static List<Artist> artists = null;

    public static List<Artist> artistToSong = null;
//    public static List<Category> categories = null;

    public static List<Album> albums = null;

    public static List<Album> reviews = null;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public DataHolder(AlbumRepository albumRepository, ArtistRepository artistRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @PostConstruct
    public void init() {
//        categories = new ArrayList<>();
//        categories.add(new Category("Category1"));
//        categories.add(new Category("Category2"));
//        categories.add(new Category("Category3"));
//        categories.add(new Category("Category4"));

        albums = new ArrayList<>();
        if (this.albumRepository.count() == 0) {
            albums.add(new Album("Thriller", "Pop", "1982", new ArrayList<>()));
            albums.add(new Album("The Dark Side of the Moon", "Progressive Rock", "1973", new ArrayList<>()));
            albums.add(new Album("Back in Black", "Hard Rock", "1980", new ArrayList<>()));
            albums.add(new Album("Rumours", "Soft Rock", "1977", new ArrayList<>()));
            albums.add(new Album("Abbey  Road", "Rock", "1969", new ArrayList<>()));
            this.albumRepository.saveAll(albums);
        }

        artists = new ArrayList<>();
        if(this.artistRepository.count()==0) {
            artists.add(new Artist("Michael", "Smith", "A renowned country singer known for heartfelt lyrics and soulful melodies."));
            artists.add(new Artist("Jessica", "Johnson", "A pop artist with chart-topping hits and a vibrant stage presence."));
            artists.add(new Artist("David", "Brown", "An acclaimed rock guitarist known for his electrifying performances."));
            artists.add(new Artist("Emily", "Davis", "An indie folk singer-songwriter with a knack for storytelling."));
            artists.add(new Artist("Joshua", "Wilson", "A talented hip-hop artist recognized for his insightful lyrics and beats."));
            this.artistRepository.saveAll(artists);
        }
    }
}
