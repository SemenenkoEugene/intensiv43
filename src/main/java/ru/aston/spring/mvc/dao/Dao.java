package ru.aston.spring.mvc.dao;

import java.util.List;

public interface Dao<K, E> {
    E save(E e);

    boolean delete(K id);

    List<E> findAll();

    boolean update(E e);
}
