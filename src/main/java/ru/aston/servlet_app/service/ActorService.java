package ru.aston.servlet_app.service;

import lombok.NoArgsConstructor;
import ru.aston.servlet_app.dao.ActorDao;
import ru.aston.servlet_app.dto.ActorDto;
import ru.aston.servlet_app.entity.Actor;
import ru.aston.servlet_app.mapper.ActorMapper;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ActorService {

    private static final ActorService INSTANCE = new ActorService();
    private final ActorMapper actorMapper = ActorMapper.getInstance();

    private final ActorDao actorDao = ActorDao.getInstance();

    public static ActorService getInstance() {
        return INSTANCE;
    }

    public List<ActorDto> findAll() {
        return actorDao.findAll().stream()
                .map(actor -> new ActorDto(
                        actor.getId(),
                        actor.getName(),
                        actor.getAge()
                ))
                .collect(Collectors.toList());
    }


}
