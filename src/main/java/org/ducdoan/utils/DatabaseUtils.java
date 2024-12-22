package org.ducdoan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
//    private static final String URL = "jdbc:mysql://localhost:3306/streaming";
     private static final String URL = "jdbc:mysql://192.168.1.8:3306/streaming";
    private static final String USER = "TestUser";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
//GRANT ALL PRIVILEGES ON *.* TO 'TestUser'@'%' IDENTIFIED BY '123456';
//FLUSH PRIVILEGES;
//Room created: 4 by ducdoan04
//Room created: 4 title: Xin chao mn by ducdoan04
//Streaming video for room: 4
//Sent room list to broadcast address: ROOM_LIST:4|ducdoan04|1|1|225.32.242.172|5452|Xin chao mn,
//Streaming video for room: 4
