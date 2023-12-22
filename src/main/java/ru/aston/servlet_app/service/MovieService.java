package ru.aston.servlet_app.service;

import lombok.NoArgsConstructor;
import ru.aston.servlet_app.dao.MovieDao;
import ru.aston.servlet_app.dto.MovieDto;
import ru.aston.servlet_app.mapper.MovieMapper;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class MovieService {
    private static final MovieService INSTANCE = new MovieService();
    private final MovieMapper movieMapper = MovieMapper.getInstance();
    private final MovieDao movieDao = MovieDao.getInstance();

    public static MovieService getInstance() {
        return INSTANCE;
    }

    public List<MovieDto> findAllByDirectorId(Integer actorId) {
        return movieDao.findAllByDirectorId(actorId).stream()
                .map(movie -> new MovieDto(
                        movie.getId(),
                        movie.getDirector(),
                        movie.getName(),
                        movie.getYearOfProduction()
                ))
                .collect(Collectors.toList());
    }

    public List<MovieDto> findAll() {
        return movieDao.findAll().stream()
                .map(movie -> new MovieDto(
                        movie.getId(),
                        movie.getDirector(),
                        movie.getName(),
                        movie.getYearOfProduction()

                ))
                .collect(Collectors.toList());
    }
}
