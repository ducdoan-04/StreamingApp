package org.ducdoan.dao;

import org.ducdoan.server.model.Room;
import org.ducdoan.utils.DatabaseUtils;

import java.sql.*;

public class RoomDAO {
    public Room createRoom(Room room) throws SQLException {
        String query = "INSERT INTO rooms (name, owner_id, start_time, title_stream) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, room.getRoomName());
            statement.setInt(2, room.getOwnerId());
            statement.setTimestamp(3, room.getStartTime());
            statement.setString(4, room.getTitleStream());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                room.setId(generatedKeys.getInt(1));
                return room;
            }
        }
        return null;
    }

    public Room getRoomByName(String roomName) throws SQLException {
        String query = "SELECT * FROM rooms WHERE name = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roomName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Room room = new Room();
                room.setId(resultSet.getInt("id"));
                room.setRoomName(resultSet.getString("name"));
                room.setOwnerId(resultSet.getInt("owner_id"));
                room.setStartTime(resultSet.getTimestamp("start_time"));
                room.setEndTime(resultSet.getTimestamp("end_time"));
                room.setTitleStream(resultSet.getString("title_stream"));
                return room;
            }
        }
        return null;
    }

    public void updateRoomEndTime(int roomId, Timestamp endTime) throws SQLException {
        String query = "UPDATE rooms SET end_time = ? WHERE id = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setTimestamp(1, endTime);
            statement.setInt(2, roomId);
            statement.executeUpdate();
        }
    }
}