package ru.aston.servlet_app.servlet;

import ru.aston.servlet_app.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/movies-actor")
public class MovieActorServlet extends HttpServlet {

    private final MovieService movieService = MovieService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer actorId = Integer.valueOf(req.getParameter("actorId"));
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Список фильмов, в которых снялся актер:</h1>");
            writer.write("<ul>");
            movieService.findFilmByActorId(actorId).forEach(movieDto ->
                    writer.write("""
                            <li>
                            <a> Название фильма: %s, год выпуска: %d</a>
                            </li>""".formatted(movieDto.getName(), movieDto.getYearOfProduction())));

            writer.write("</ul>");
        }
    }
}
