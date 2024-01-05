package ru.aston.spring.mvc.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.spring.mvc.entity.Actor;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ActorDaoImpl implements ActorDao {

    private final SessionFactory sessionFactory;

    @Override
    public Actor save(Actor actor) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    @Transactional
    public List<Actor> findAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Actor", Actor.class).getResultList();
    }

    @Override
    public boolean update(Actor actor) {
        return false;
    }
}
