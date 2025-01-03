package org.ducdoan.client.UI;

import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.VideoInputFrameGrabber;
import org.ducdoan.client.LivestreamClient;
import org.ducdoan.client.UI.components.UIUtils;
import org.ducdoan.config.ServerConfig;
import org.ducdoan.utils.Constants;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Objects;

public class RoomOwnerPanel extends JPanel {
    private JTextPane commentPane;
    private JTextField commentField;
    private StyledDocument doc;
    private JPanel videoPanel;
    private JPanel screenSharePanel;
    private JPanel controlPanel;
    private FrameGrabber grabber;
    private Java2DFrameConverter converter;
    private BufferedImage currentImage;
    private BufferedImage screenImage;
    private WebSocketClient client;
    private JLabel participantsLabel;
    private boolean isCameraOn = true;
    private boolean isMicOn = true;
    private boolean isScreenSharing = false;
    private TargetDataLine microphone;
    private AudioFormat audioFormat;
    private boolean running = true;
    private JLayeredPane layeredPane;

    public RoomOwnerPanel() {
        setLayout(new BorderLayout());
        setBackground(UIUtils.COLOR_BACKGROUND);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 600));
        add(layeredPane, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Room Owner - Live Stream");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(UIUtils.FONT_GENERAL_UI.deriveFont(Font.BOLD, 24));
        titleLabel.setForeground(UIUtils.OFFWHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titleLabel.setBounds(0, 0, 800, 60);
        layeredPane.add(titleLabel, JLayeredPane.DEFAULT_LAYER);

        videoPanel = new JPanel(new BorderLayout()) {
            {
                setDoubleBuffered(true);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentImage != null) {
                    g.drawImage(currentImage, 0, 0, getWidth(), getHeight(), null);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        videoPanel.setPreferredSize(new Dimension(800, 480));
        videoPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        videoPanel.setBounds(0, 60, 800, 480);
        layeredPane.add(videoPanel, JLayeredPane.DEFAULT_LAYER);

        controlPanel = new JPanel();
        controlPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        ImageIcon cameraOnIcon = resizeIcon(
                new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("video-camera-alt.png"))),
                20, 20);
        ImageIcon cameraOffIcon = resizeIcon(
                new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("video-slash.png"))), 20,
                20);
        ImageIcon micOnIcon = resizeIcon(
                new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("mic.png"))), 20, 20);
        ImageIcon micOffIcon = resizeIcon(
                new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("mute.png"))), 20, 20);
        ImageIcon shareScreenIcon = resizeIcon(
                new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("monitor.png"))), 20, 20);

        JButton toggleCameraButton = new JButton(cameraOnIcon);
        styleButton(toggleCameraButton);
        toggleCameraButton.addActionListener(e -> {
            isCameraOn = !isCameraOn;
            toggleCameraButton.setIcon(isCameraOn ? cameraOnIcon : cameraOffIcon);
            toggleCamera(isCameraOn);
        });
        controlPanel.add(toggleCameraButton);

        JButton toggleMicButton = new JButton(micOnIcon);
        styleButton(toggleMicButton);
        toggleMicButton.addActionListener(e -> {
            isMicOn = !isMicOn;
            toggleMicButton.setIcon(isMicOn ? micOnIcon : micOffIcon);
            toggleMic(isMicOn);
        });
        controlPanel.add(toggleMicButton);

        JButton shareScreenButton = new JButton(shareScreenIcon);
        styleButton(shareScreenButton);
        shareScreenButton.addActionListener(e -> shareScreen());
        controlPanel.add(shareScreenButton);

        videoPanel.add(controlPanel, BorderLayout.SOUTH);

        commentPane = new JTextPane();
        commentPane.setEditable(false);
        commentPane.setBackground(UIUtils.COLOR_BACKGROUND);
        commentPane.setForeground(UIUtils.OFFWHITE);
        commentPane.setFont(UIUtils.FONT_GENERAL_UI);
        doc = commentPane.getStyledDocument();
        JScrollPane commentScrollPane = new JScrollPane(commentPane);
        commentScrollPane.setBounds(0, 540, 800, 200);
        layeredPane.add(commentScrollPane, JLayeredPane.DEFAULT_LAYER);

        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        commentField = new JTextField();
        commentField.setBackground(UIUtils.COLOR_BACKGROUND);
        commentField.setForeground(UIUtils.OFFWHITE);
        commentField.setFont(UIUtils.FONT_GENERAL_UI);
        commentPanel.add(commentField, BorderLayout.CENTER);

        JButton sendButton = new JButton("Send");
        styleButton(sendButton);
        sendButton.addActionListener(new SendCommentActionListener());
        commentPanel.add(sendButton, BorderLayout.EAST);
        commentPanel.setBounds(0, 740, 800, 40);
        layeredPane.add(commentPanel, JLayeredPane.DEFAULT_LAYER);

        JButton closeRoomButton = new JButton("Close Room");
        styleButton(closeRoomButton);
        closeRoomButton.addActionListener(new CloseRoomActionListener());
        closeRoomButton.setBounds(0, 0, 150, 40);
        layeredPane.add(closeRoomButton, JLayeredPane.DEFAULT_LAYER);

        connectWebSocket();
        startVideoStream();
    }

    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    private void toggleCamera(boolean isOn) {
        isCameraOn = isOn;
        if (isCameraOn) {
            try {
                if (grabber == null) {
                    grabber = new VideoInputFrameGrabber(1);
                    grabber.start();
                } else {
                    grabber.restart();
                }
                System.out.println("Camera turned on");
            } catch (FrameGrabber.Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (grabber != null) {
                    grabber.stop();
                    grabber.release();
                    grabber = null;
                }
                currentImage = null;
                videoPanel.repaint();
                System.out.println("Camera turned off");
            } catch (FrameGrabber.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void toggleMic(boolean isOn) {
        isMicOn = isOn;
        if (isMicOn) {
            try {
                if (microphone == null) {
                    audioFormat = new AudioFormat(44100, 16, 2, true, true);
                    DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
                    microphone = (TargetDataLine) AudioSystem.getLine(info);
                    microphone.open(audioFormat);
                    microphone.start();
                    new Thread(() -> {
                        byte[] buffer = new byte[4096];
                        while (isMicOn && running) {
                            int bytesRead = microphone.read(buffer, 0, buffer.length);
                            if (bytesRead > 0 && client != null && client.isOpen()) {
                                String encodedAudio = Base64.getEncoder().encodeToString(buffer);
                                client.send("AUDIO:" + encodedAudio);
                            }
                        }
                    }).start();
                }
                System.out.println("Microphone turned on");
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
        } else {
            if (microphone != null) {
                microphone.stop();
                microphone.close();
                microphone = null;
            }
            System.out.println("Microphone turned off");
        }
    }

    private void shareScreen() {
        // Implement screen sharing functionality here
    }

    private void connectWebSocket() {
        try {
            client = new WebSocketClient(
                    new URI("ws://" + Constants.SERVER_ADDRESS + ":" + ServerConfig.SIGNALING_PORT)) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    System.out.println("Connected to server");
                }

                @Override
                public void onMessage(String message) {
                    System.out.println("Received: " + message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("Connection closed");
                }

                @Override
                public void onError(Exception ex) {
                    ex.printStackTrace();
                }
            };
            client.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void startVideoStream() {
        new Thread(() -> {
            try {
                grabber = new VideoInputFrameGrabber(1);
                grabber.start();
                converter = new Java2DFrameConverter();
                while (running) {
                    if (isCameraOn && grabber != null) {
                        try {
                            Frame frame = grabber.grab();
                            if (frame != null) {
                                currentImage = converter.convert(frame);
                                videoPanel.repaint();

                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                ImageIO.write(currentImage, "jpg", baos);
                                byte[] imageBytes = baos.toByteArray();
                                String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
                                if (client != null && client.isOpen()) {
                                    client.send(encodedImage);
                                } else {
                                    System.out.println("room||WebSocket connection is not open.");
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FrameGrabber.Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private class SendCommentActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comment = commentField.getText();
            if (!comment.trim().isEmpty()) {
                LivestreamClient.sendComment(comment);
                addComment("You: " + comment, true);
                commentField.setText("");
            }
        }
    }

    private class CloseRoomActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LivestreamClient.closeRoom();
            if (client != null) {
                client.close();
            }
        }
    }

    public void addComment(String comment, boolean isOwner) {
        try {
            Style style = doc.addStyle("Style", null);
            StyleConstants.setForeground(style, isOwner ? Color.RED : Color.WHITE);
            doc.insertString(doc.getLength(), comment + "\n", style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void styleButton(JButton button) {
        button.setBackground(UIUtils.COLOR_INTERACTIVE);
        button.setForeground(Color.white);
        button.setFont(UIUtils.FONT_GENERAL_UI);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(UIUtils.COLOR_INTERACTIVE);
            }
        });
    }
}
