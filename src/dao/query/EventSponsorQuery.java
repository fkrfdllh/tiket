/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.query;

import config.Database;
import dao.EventDAO;
import dao.EventSponsorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EventSponsor;

/**
 *
 * @author fkrfd
 */
public class EventSponsorQuery implements EventSponsorDAO {

    private final Connection conn = Database.getConnection();

    private final EventDAO eventDao = new EventQuery();

    private String query;

    @Override
    public List<EventSponsor> getEventSponsors() {
        List<EventSponsor> sponsors = new ArrayList<>();

        query = "SELECT * FROM event_sponsors";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EventSponsor sponsor = new EventSponsor();
                sponsor.setId(rs.getInt(1));
                sponsor.setEvent(eventDao.getEvent(rs.getInt(2)));
                sponsor.setName(rs.getString(3));
                sponsor.setTier(rs.getInt(4));

                sponsors.add(sponsor);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return sponsors;
    }

    @Override
    public EventSponsor getEventSponsor(int id) {
        EventSponsor sponsor = new EventSponsor();

        query = "SELECT * FROM event_sponsors WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sponsor.setId(rs.getInt(1));
                sponsor.setEvent(eventDao.getEvent(rs.getInt(2)));
                sponsor.setName(rs.getString(3));
                sponsor.setTier(rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return sponsor;
    }

    @Override
    public boolean insertEventSponsor(int eventId, String name, int tier) {
        query = "INSERT INTO event_sponsors (event_id, name, tier) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventId);
            stmt.setString(2, name);
            stmt.setInt(3, tier);

            int row = stmt.executeUpdate();

            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return false;
    }

    @Override
    public boolean updateEventSponsor(EventSponsor sponsor) {
        query = "UPDATE event_sponsors SET event_id = ?, name = ?, tier = ? WHERE id = ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, sponsor.getEvent().getId());
            stmt.setString(2, sponsor.getName());
            stmt.setInt(3, sponsor.getTier());
            stmt.setInt(4, sponsor.getId());

            int row = stmt.executeUpdate();

            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return false;
    }

    @Override
    public boolean deleteEventSponsor(int id) {
        query = "DELETE FROM event_sponsors WHERE id = ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int row = stmt.executeUpdate();

            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return false;
    }

}
