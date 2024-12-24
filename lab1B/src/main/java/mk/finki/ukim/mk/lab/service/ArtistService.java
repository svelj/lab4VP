package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;

public interface ArtistService {


    List<Artist> findAll();
    Artist save(Artist artist);
    Artist findById(Long id);

}
