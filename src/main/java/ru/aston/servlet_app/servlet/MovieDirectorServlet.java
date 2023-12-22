package ru.aston.servlet_app.servlet;

import ru.aston.servlet_app.service.MovieService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/movies-director")
public class MovieDirectorServlet extends HttpServlet {
    private final MovieService movieService = MovieService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer directorId = Integer.valueOf(req.getParameter("directorId"));
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Список фильмов, которые снял этот режиссер:</h1>");
            writer.write("<ul>");
            movieService.findAllByDirectorId(directorId).forEach(movieDto ->
                    writer.write("""
                            <li>
                            <a> Название фильма: %s, год выпуска: %d</a>
                            </li>""".formatted(movieDto.getName(), movieDto.getYearOfProduction())));
            writer.write("</ul>");
        }

    }


}
