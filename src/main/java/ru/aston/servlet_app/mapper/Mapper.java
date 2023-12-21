package ru.aston.servlet_app.mapper;

public interface Mapper<T, F> {
    T mapFrom(F f);
    F mapTo(T t);
}
