package mk.finki.ukim.mk.lab.web.controller;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.service.AlbumService;
import org.springframework.ui.Model;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller()
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
//    private final ArtistService artistService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }


    @GetMapping
    public String getSongsPage(@RequestParam(required = false) Long albumId,@RequestParam(required = false) String error, Model model){
    List<Song> songs;
        if (albumId != null) {
            songs = songService.findAllByAlbum_Id(albumId);
        } else {
            songs = songService.listSongs();
        }

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("songs",songs);
        model.addAttribute("albums", albumService.findAll());
    return "listSongs";
    };

    @GetMapping("/add")
    public String showAddSongForm(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "addSong";
    }
    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId){
        Album album = albumService.findById(albumId);
        Song song = new Song(title,trackId,genre,releaseYear,album,new ArrayList<>());
        songService.save(song);
        return"redirect:/songs";
    }
    @PostMapping("/delete/{songId}")
    public String deleteSong(@PathVariable Long songId){
        songService.deleteById(songId);

        return"redirect:/songs";
    }

    @PostMapping("/edit/{songId}")
     public String editSong(@PathVariable Long songId,
                            @RequestParam String title,
                            @RequestParam String trackId,
                            @RequestParam String genre,
                            @RequestParam int releaseYear,
                            @RequestParam Long albumId){
        Song song = songService.findByTrackId(trackId);
        if(song == null){
            return "redirect:/songs";
        }
        song.setTitle(title);
        song.setTrackId(trackId);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);

        Album album = albumService.findById(albumId);
        if(album!=null){
            song.setAlbum(album);
        }
        songService.save(song);
        return"redirect:/songs";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id,Model model){
        Song song = songService.findById(id);

        if(song == null){
            return "redirect:/songs?error=SongNotFound";
        }

        List<Album> albums = albumService.findAll();
        model.addAttribute("song", song);
        model.addAttribute("albums", albums);

        return "addSong";
    }
//
//    @GetMapping("/review/{id}")
//    public String getReviewSongForm(@PathVariable Long id,Model model){
//        Song song = songService.findById(id);
//        model.addAttribute("song", song);
//        return "add-review";
//    }

//    @PostMapping("/review/{id}")
//    public String addReview(@PathVariable Long id
//                            ,@RequestParam String comment
//                            ,@RequestParam int rating
//                            ,Model model){
//
//        Review review = new Review(comment, rating);
//        songService.addReviewSong(id,review);
//        return "redirect:/songs";
//    }

}
