package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.ArtistRepository;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;

        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        List<Song> songs = songRepository.findAll();
        List<Artist> artists = artistRepository.findAll();
        Song song1 = songs.stream().filter(c->c.getId().equals(song.getId()))
                .findFirst()
                .orElse(null);

        song1.getPerformers().add(artist);

        songRepository.save(song1);

        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void delete(String title) {
        songRepository.deleteByTitle(title);
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }

    @Override
    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }
    @Override
    public Song findById(Long id){
        return songRepository.findById(id)
                .orElse(null);
    }
    @Override
    public void deleteByTrackId(String trackId) {
        songRepository.deleteByTrackId(trackId);
    }

}
