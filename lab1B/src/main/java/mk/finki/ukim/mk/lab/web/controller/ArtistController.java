package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @PostMapping()
    public String selectArtist(@RequestParam String trackId, Model model) {
        Song selectedSong = songService.findByTrackId(trackId);
        List<Artist> selectedSongArtists = selectedSong.getPerformers();
        model.addAttribute("trackId", trackId);


        List<Song> songs = songService.listSongs();
        model.addAttribute("songs", songs);


        List<Artist> artists = artistService.findAll().stream()
                .filter(artist -> !selectedSongArtists.contains(artist))
                .collect(Collectors.toList());


        model.addAttribute("artists", artists);
        return "artistList";
    }
    @PostMapping("/add")
    public String addArtist(@RequestBody Artist artist) {
        artistService.save(artist);
        return "artistList";
    }
}
