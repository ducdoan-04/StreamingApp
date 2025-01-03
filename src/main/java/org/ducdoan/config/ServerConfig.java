package org.ducdoan.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerConfig {
    public static final String BROADCAST_ADDRESS;
    public static final int BROADCAST_PORT;
    public static final int SIGNALING_PORT;

    static {
        Properties properties = new Properties();
        try (InputStream input = ServerConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        BROADCAST_ADDRESS = properties.getProperty("udp.server.address", "192.168.45.84"); //ip server || 230.0.0.1 ||255.255.255.255
        BROADCAST_PORT = Integer.parseInt(properties.getProperty("udp.server.port", "9877"));
        SIGNALING_PORT = Integer.parseInt(properties.getProperty("websocket.server.port", "8080"));
    }
}