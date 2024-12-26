package org.ducdoan.server.manager;

import org.ducdoan.server.video.VideoStreamManager;
import org.ducdoan.dao.ParticipantDAO;
import org.ducdoan.dao.RoomDAO;
import org.ducdoan.server.model.Participant;
import org.ducdoan.server.model.Room;
import org.ducdoan.server.video.VideoStreamManager;
import org.ducdoan.server.video.VideoStreamTask;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class RoomManager {
    private Map<String, Room> rooms;
    private VideoStreamManager videoStreamManager;
    private RoomDAO roomDAO;
    private ParticipantDAO participantDAO;

    public RoomManager() {
        this.rooms = new HashMap<>();
        this.videoStreamManager = new VideoStreamManager();
        this.roomDAO = new RoomDAO();
        this.participantDAO = new ParticipantDAO();
    }

    public synchronized void createRoom(String roomName, String owner, int ownerId, String multicastAddress, int multicastPort,  String titleStream) {
        if (roomName != null && !roomName.trim().isEmpty() && !rooms.containsKey(roomName)) {
            Room room = new Room(roomName, ownerId, multicastAddress, multicastPort, titleStream);
            try {
                room = roomDAO.createRoom(room);
                participantDAO.addParticipant(room.getId(), ownerId, titleStream);
                room.addParticipant(new Participant(room.getId(), ownerId));
                rooms.put(roomName, room);
                videoStreamManager.startStream(roomName, new VideoStreamTask(roomName));
                System.out.println("Room created: " + roomName + " by " + owner);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to create room: " + roomName);
            }
        } else {
            System.out.println("Failed to create room: " + roomName);
        }
    }

    public synchronized void closeRoom(String roomName) {
        if (rooms.containsKey(roomName)) {
            Room room = rooms.get(roomName);
            try {
                roomDAO.updateRoomEndTime(room.getId(), new Timestamp(System.currentTimeMillis()));
                rooms.remove(roomName);
                videoStreamManager.stopStream(roomName);
                System.out.println("Room closed: " + roomName);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to close room: " + roomName);
            }
        }
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public Room getRoomByName(String roomName) {
        return rooms.get(roomName);
    }
}