package ru.aston.spring.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aston.spring.mvc.dao.ActorDao;
import ru.aston.spring.mvc.entity.Actor;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ActorController {

    private final ActorDao actorDao;

    @RequestMapping("/")
    public String showAllActors(Model model) {
        List<Actor> actors = actorDao.findAll();
        model.addAttribute("allActors", actors);
        return "all-actors";
    }
}
