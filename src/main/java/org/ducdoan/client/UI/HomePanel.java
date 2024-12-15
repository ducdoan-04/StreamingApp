package org.ducdoan.client.UI;

import javax.swing.*;
import java.awt.*;
import org.ducdoan.client.LivestreamClientJFrame;
import org.ducdoan.client.UI.items.VideoItemPanel;

public class HomePanel extends JPanel {
    private LivestreamClientJFrame parentForm;

    public HomePanel() {
        initComponents();
    }

    private void initComponents() {
        JScrollPane jScrollPaneHome = new JScrollPane();
        JPanel videoListPanel = new JPanel();

        // Sử dụng FlowLayout thay vì GridLayout để dễ dàng kiểm soát chiều cao
        videoListPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));  // Thêm khoảng cách giữa các video items

        // Giới hạn chiều cao của videoListPanel để tránh kéo dài
        videoListPanel.setPreferredSize(new Dimension(800, 500));  // Chiều cao cố định

        // Thêm các VideoItemPanel vào videoListPanel
        for (int i = 1; i <= 10; i++) {
            VideoItemPanel videoItem = new VideoItemPanel(
                "Status " + i,
                "User " + i,
                new ImageIcon(getClass().getResource("/PhotoCover/1.png")),
                new ImageIcon(getClass().getResource("/ICON/gear.png"))
            );
            videoListPanel.add(videoItem);
        }

        // Thiết lập layout của HomePanel và thêm JScrollPane
        setLayout(new BorderLayout());
        jScrollPaneHome.setViewportView(videoListPanel);  // Gắn videoListPanel vào JScrollPane
        add(jScrollPaneHome, BorderLayout.CENTER);  // Thêm JScrollPane vào HomePanel
    }

    public void updateRoomList(String mockRoomList) {
        String[] rooms = mockRoomList.split(",");
        JPanel videoListPanel = new JPanel();
        videoListPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));  // Sử dụng FlowLayout

        // Giới hạn chiều cao của videoListPanel
        videoListPanel.setPreferredSize(new Dimension(800, 500));  // Chiều cao cố định

        // Thêm các VideoItemPanel vào videoListPanel
        for (String room : rooms) {
            String[] roomDetails = room.split("\\|");
            if (roomDetails.length == 3) {
                String roomName = roomDetails[0];
                String owner = roomDetails[1];
                String participants = roomDetails[2];

                VideoItemPanel videoItem = new VideoItemPanel(
                    roomName,
                    owner,
                    new ImageIcon(getClass().getResource("/PhotoCover/1.png")),
                    new ImageIcon(getClass().getResource("/ICON/gear.png"))
                );

                videoListPanel.add(videoItem);
            }
        }

        JScrollPane jScrollPaneHome = new JScrollPane(videoListPanel);
        setLayout(new BorderLayout());
        add(jScrollPaneHome, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
