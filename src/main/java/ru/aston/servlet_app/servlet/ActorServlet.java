package ru.aston.servlet_app.servlet;

import ru.aston.servlet_app.service.ActorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/actors")
public class ActorServlet extends HttpServlet {

    private final ActorService actorService = ActorService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Список актеров:</h1>");
            writer.write("<ul>");
            actorService.findAll().forEach(actorDto ->
                    writer.write("""
                            <li>
                            <a>%s</a>
                            </li>""".formatted(actorDto.getName())));
            writer.write("</ul>");
        }
    }


}
