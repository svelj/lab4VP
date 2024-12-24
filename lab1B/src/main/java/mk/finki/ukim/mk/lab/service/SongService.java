package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
//    List<Song> listByCategory(String name);
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);

    List<Song> findAllByAlbum_Id(Long albumId);
    Song save(Song song);
    void delete(String title);
    void deleteById(Long id);
    void deleteByTrackId(String trackId);
    public Song findById(Long id);

}
