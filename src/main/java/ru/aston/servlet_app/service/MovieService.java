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

    public List<MovieDto> findAllByActorId(Integer actorId) {
        return movieDao.findAllByActorId(actorId).stream()
                .map(movie -> new MovieDto(
                        movie.getId(),
                        movie.getDirector(),
                        movie.getName(),
                        movie.getYearOfProduction()
                ))
                .collect(Collectors.toList());
    }
}
