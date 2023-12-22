package ru.aston.servlet_app.dao;

import ru.aston.servlet_app.entity.Movie;
import ru.aston.servlet_app.exception.DaoException;
import ru.aston.servlet_app.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDao implements Dao<Integer, Movie> {

    private static final MovieDao INSTANCE = new MovieDao();

    private static final String FIND_ALL_SQL = """
            SELECT movie_id, director_id, name, year_of_production
            FROM movie
            """;
    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE movie_id = ?
            """;

    private static final String FIND_FILM_BY_ACTOR_SQL = """
            SELECT actor.name, movie.name, movie.year_of_production FROM actor JOIN Actor_Movie AM
                ON actor.actor_id = AM.actor_id JOIN movie ON AM.movie_id = Movie.movie_id;
            """;

    private MovieDao() {
    }

    public static MovieDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Movie> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {
            List<Movie> moviesByActor = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                moviesByActor.add(buildMovie(resultSet));
            }

            return moviesByActor;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    public List<Movie> findFilmByActor(Integer id) {
        List<Movie> moviesByActor = new ArrayList<>();

        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(FIND_FILM_BY_ACTOR_SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setName(resultSet.getString("name"));
                movie.setYearOfProduction(resultSet.getInt("year_of_production"));
                moviesByActor.add(movie);
            }

            return moviesByActor;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }


    @Override
    public boolean update(Movie movie) {
        return false;
    }

    public Optional<Movie> findAllByDirectorId(Integer id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            Movie movie = null;
            if (resultSet.next()) {
                movie = buildMovie(resultSet);
            }
            return Optional.ofNullable(movie);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private Movie buildMovie(ResultSet resultSet) throws SQLException {
        return new Movie(
                resultSet.getInt("movie_id"),
                resultSet.getInt("director_id"),
                resultSet.getString("name"),
                resultSet.getInt("year_of_production")
        );
    }
}
