//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Song;
//import mk.finki.ukim.mk.lab.service.ArtistService;
//import mk.finki.ukim.mk.lab.service.SongService;
//import mk.finki.ukim.mk.lab.service.impl.SongServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@WebServlet(name = "SongListServlet", urlPatterns = "/listSongs")
//public class SongListServlet extends HttpServlet {
//
//    private final SongService songService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public SongListServlet(SongService songService, SpringTemplateEngine springTemplateEngine) {
//        this.songService = songService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//
//        context.setVariable("categories",songService.listByCategory(req.getParameter("category")));
//
//
//        List<Song> songs = songService.listSongs();
//        context.setVariable("songs",songs);
//        getServletContext().setAttribute("songs",songs);
//
//        springTemplateEngine.process("listSongs.html",context,resp.getWriter());
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String trackId = req.getParameter("trackId");
//        req.setAttribute("trackId", trackId);
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/artist");
//        dispatcher.forward(req,resp);
//
//    }
//}
