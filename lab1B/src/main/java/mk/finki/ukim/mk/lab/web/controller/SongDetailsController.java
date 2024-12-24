package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/details")
public class SongDetailsController {
    private final SongService songService;
    private final ArtistService artistService;


    public SongDetailsController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping()
    public String songDetails(@RequestParam String trackId,@RequestParam Long artistId ,Model model){

        Song song = songService.findByTrackId(trackId);
        model.addAttribute("song",song);
        songService.addArtistToSong(artistService.findById(artistId),song);

        return "songDetails";
    }
}
