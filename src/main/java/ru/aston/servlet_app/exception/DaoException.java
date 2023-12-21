package ru.aston.servlet_app.exception;

public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}
