//package mk.finki.ukim.mk.lab.web;
//
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
//import javax.swing.*;
//import java.io.IOException;
//
//@WebServlet(name = "SongDetails", urlPatterns = "/songDetails")
//public class SongDetails extends HttpServlet {
//    private final ArtistService artistService;
//    private final SongService songService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public SongDetails(ArtistService artistService, SongService songService, SpringTemplateEngine springTemplateEngine) {
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
//        String trackId = (String) context.getVariable("trackId");
//
//        Song song = songService.findByTrackId(trackId);
//
//        context.setVariable("song",song);
//
//        springTemplateEngine.process("songDetails.html",context,resp.getWriter());
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//        String trackId = (String) getServletContext().getAttribute("trackId");
//        Song song = songService.findByTrackId(trackId);
//
//        Long artistId = Long.valueOf(req.getParameter("artistId"));
//        Artist artist = artistService.findById(artistId);
//
//        songService.addArtistToSong(artist,song);
//
//        context.setVariable("song",song);
//
//        springTemplateEngine.process("songDetails.html",context,resp.getWriter());
//    }
//}
