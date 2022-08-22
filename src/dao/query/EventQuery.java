/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.query;

import config.Database;
import dao.EventDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Event;

/**
 *
 * @author fkrfd
 */
public class EventQuery implements EventDAO {

    @Override
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();

        String query = "SELECT * FROM events";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet;

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Event event = new Event();

                event.setId(resultSet.getInt(1));
                event.setName(resultSet.getString(2));
                event.setLocation(resultSet.getString(3));
                event.setStartedAt(resultSet.getString(4));
                event.setFinishedAt(resultSet.getString(5));

                events.add(event);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return events;
    }

    @Override
    public Event getEvent(int id) {
        Event event = new Event();

        String query = "SELECT * FROM events WHERE id = ?";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet;

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                event.setId(resultSet.getInt(1));
                event.setName(resultSet.getString(2));
                event.setLocation(resultSet.getString(3));
                event.setStartedAt(resultSet.getString(4));
                event.setFinishedAt(resultSet.getString(5));
            }

            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return event;
    }

    @Override
    public boolean insertEvent(String name, String location, String startedAt, String finishedAt) {
        String query = "INSERT INTO events (name, location, started_at, finished_at) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, location);
            statement.setString(3, startedAt);
            statement.setString(4, finishedAt);

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean updateEvent(Event event) {
        String query = "UPDATE events SET name = ?, location = ?, started_at = ?, finished_at = ? WHERE id = ?";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, event.getName());
            statement.setString(2, event.getLocation());
            statement.setString(3, event.getStartedAt());
            statement.setString(4, event.getFinishedAt());
            statement.setInt(5, event.getId());

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean deleteEvent(int id) {
        String query = "DELETE FROM events WHERE id = ?";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }
}
