package org.ducdoan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
//    private static final String URL = "jdbc:mysql://localhost:3306/streaming";
     private static final String URL = "jdbc:mysql://192.168.1.3:3306/streaming";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}