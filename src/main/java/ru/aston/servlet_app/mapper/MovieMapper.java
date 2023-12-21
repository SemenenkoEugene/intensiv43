package ru.aston.servlet_app.mapper;

import lombok.NoArgsConstructor;
import ru.aston.servlet_app.dto.MovieDto;
import ru.aston.servlet_app.entity.Movie;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class MovieMapper implements Mapper<Movie, MovieDto> {
    private static final MovieMapper INSTANCE = new MovieMapper();

    public static MovieMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Movie mapFrom(MovieDto movieDto) {
        return Movie.builder()
                .director(movieDto.getDirectorId())
                .name(movieDto.getName())
                .yearOfProduction(movieDto.getYearOfProduction())
                .build();
    }

    @Override
    public MovieDto mapTo(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getDirector(),
                movie.getName(),
                movie.getYearOfProduction()
        );
    }
}
