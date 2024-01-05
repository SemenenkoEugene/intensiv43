package ru.aston.spring.mvc.dao;

import ru.aston.spring.mvc.entity.Actor;

import java.util.List;

public interface ActorDao extends Dao<Integer, Actor> {
    Actor save(Actor actor);

    boolean delete(Integer id);

    List<Actor> findAll();

    boolean update(Actor actor);
}
