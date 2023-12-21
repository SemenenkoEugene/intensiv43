package ru.aston.servlet_app.dao;

import ru.aston.servlet_app.entity.Actor;
import ru.aston.servlet_app.exception.DaoException;
import ru.aston.servlet_app.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDao implements Dao<Integer, Actor> {

    private static final ActorDao INSTANCE = new ActorDao();
    private static final String SAVE_SQL = """
            INSERT INTO actor
            (name, age) VALUES (?, ?)
            """;
    private static final String DELETE_SQL = """
            DELETE FROM actor
            WHERE actor_id = ?
            """;
    private static final String FIND_ALL_SQL = """
            SELECT *
            FROM actor
            """;
    private static final String UPDATE_SQL = """
            DELETE FROM actor
            WHERE actor_id = ?
                        """;

    private ActorDao() {
    }

    public static ActorDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Actor save(Actor actor) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, actor.getName());
            statement.setInt(2, actor.getAge());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                actor.setId(resultSet.getInt("actor_id"));
            }
            return actor;

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public List<Actor> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {
            List<Actor> actors = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                actors.add(buildActor(resultSet));
            }
            return actors;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private static Actor buildActor(ResultSet resultSet) throws SQLException {
        return new Actor(
                resultSet.getInt("actor_id"),
                resultSet.getString("name"),
                resultSet.getInt("age")
        );
    }

    @Override
    public boolean update(Actor actor) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, actor.getName());
            statement.setInt(2, actor.getAge());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
