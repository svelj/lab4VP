//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Artist;
//import mk.finki.ukim.mk.lab.model.Song;
//import mk.finki.ukim.mk.lab.service.ArtistService;
//import mk.finki.ukim.mk.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@WebServlet(name="ArtistServlet", urlPatterns = "/artist")
//public class ArtistServlet extends HttpServlet {
//
//    private final ArtistService artistService;
//    private final SongService songService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//
//    public ArtistServlet(ArtistService artistService, SongService songService, SpringTemplateEngine springTemplateEngine) {
//        this.artistService = artistService;
//        this.songService = songService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req,resp);
//
//        WebContext context =  new WebContext(webExchange);
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req,resp);
//
//        WebContext context =  new WebContext(webExchange);
//
//        String trackId = (String) req.getAttribute("trackId");
//        context.setVariable("trackId", trackId);
//        getServletContext().setAttribute("trackId",trackId);
//
//        Song selectedSong = songService.findByTrackId(trackId);
//        List<Artist> selectedSongArtists = selectedSong.getPerformers();
//
//        List<Song> songs = songService.listSongs();
//        context.setVariable("songs",songs);
//
//        List<Artist> artists = artistService.listArtists().stream()
//                .filter(artist -> !selectedSongArtists.contains(artist))
//                .collect(Collectors.toList());
//
//
//        context.setVariable("artists", artists);
//
//
//
////         Long artistId = Long.valueOf(req.getParameter("artistId"));
////         context.setVariable("artistId",artistId);
////
////          songService.addArtistToSong(artistService.findById(artistId),selectedSong);
//
//        springTemplateEngine.process("artistList.html",context,resp.getWriter());
//
//    }
//}
