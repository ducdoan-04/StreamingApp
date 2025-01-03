package org.ducdoan.dao;

import org.ducdoan.server.model.Participant;
import org.ducdoan.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    public void addParticipant(int roomId, int userId, String titleStream) throws SQLException {
        String query = "INSERT INTO participants (room_id, user_id,title_stream) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roomId);
            statement.setInt(2, userId);
            statement.setString(3, titleStream);
            statement.executeUpdate();
        }
    }

    public void removeParticipant(int roomId, int userId) throws SQLException {
        String query = "DELETE FROM participants WHERE room_id = ? AND user_id = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roomId);
            statement.setInt(2, userId);
            statement.executeUpdate();
        }
    }

    public List<Participant> getParticipantsByRoomId(int roomId) throws SQLException {
        String query = "SELECT * FROM participants WHERE room_id = ?";
        List<Participant> participants = new ArrayList<>();
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, roomId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Participant participant = new Participant();
                participant.setId(resultSet.getInt("id"));
                participant.setRoomId(resultSet.getInt("room_id"));
                participant.setUserId(resultSet.getInt("user_id"));
                participant.setTitleStream(resultSet.getString("title_stream"));
                participants.add(participant);
            }
        }
        return participants;
    }
}