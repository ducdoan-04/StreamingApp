package org.ducdoan.client;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.*;
import javax.swing.SwingUtilities;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.ducdoan.client.UI.HomePanel;
import org.ducdoan.client.UI.MainPanel;
import org.ducdoan.client.UI.LiveStreamPanel;
import org.ducdoan.client.UI.LoginPanel;
import org.ducdoan.client.UI.RegistrationPanel;
import org.ducdoan.client.UI.RoomOwnerPanel;
import org.ducdoan.client.UI.RoomParticipantPanel;
import org.ducdoan.client.UI.components.Toaster.Toaster;
import org.ducdoan.client.backend.Backend;
import org.ducdoan.config.ClientConfig;

public class LivestreamClientJFrame extends JFrame {

private static HomePanel HomePanel;
private static MainPanel MainPanel;
private static LiveStreamPanel liveStreamPanel;
private static RoomOwnerPanel roomOwnerPanel;
private static RoomParticipantPanel roomParticipantPanel;
//private static JTabbedPane tapMain;
private static JFrame frame2;
private static String username;
private static String userId;
private static String currentRoom;
private static DefaultListModel<String> roomListModel = new DefaultListModel<>();
private static boolean checkRoomOwnerAfterUpdate = false;
private static Toaster toaster;
private static LivestreamClientJFrame MainFrame;

  public LivestreamClientJFrame() {
        initComponents();
//        this.setResizable(false);
//        MainFrame = new LivestreamClientJFrame(); // Assign MainFrame here
//        MainFrame.setTitle("Livestream Application");
//        MainFrame.setIconImage(new ImageIcon("/LOGO.png").getImage());
//        MainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        MainFrame.setSize(1100, 630); // 960, 552
//        MainFrame.setLocationRelativeTo(null);
//        MainFrame.setVisible(true);
//        new Thread(LivestreamClientJFrame::listenForBroadcastMessages).start();
//            if (HomePanel == null) {
//            HomePanel = new HomePanel();
//            tapMain.addTab("Main", null, HomePanel, "Main Panel");
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jbtHome = new javax.swing.JButton();
        jbtCreateRoom = new javax.swing.JButton();
        jbtFollowing = new javax.swing.JButton();
        jbtAccount = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlbInfor = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jbtSearch = new javax.swing.JButton();
        jbtLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tapMain = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(118, 204, 145));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo32.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(118, 204, 145));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-computer-100.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setMaximumSize(new java.awt.Dimension(38, 32));
        jLabel3.setPreferredSize(new java.awt.Dimension(38, 32));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Welcome,");

        jtfUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtfUsername.setForeground(new java.awt.Color(255, 255, 255));
        jtfUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtfUsername.setText("ducdoan00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(118, 204, 145));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtHome.setBackground(new java.awt.Color(138, 217, 163));
        jbtHome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtHome.setForeground(new java.awt.Color(255, 255, 255));
        jbtHome.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\ICON\\home2.png")); // NOI18N
        jbtHome.setText("Home");
        jbtHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtHomeActionPerformed(evt);
            }
        });

        jbtCreateRoom.setBackground(new java.awt.Color(138, 217, 163));
        jbtCreateRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtCreateRoom.setForeground(new java.awt.Color(255, 255, 255));
        jbtCreateRoom.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\ICON\\home2.png")); // NOI18N
        jbtCreateRoom.setText("Live now");
        jbtCreateRoom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtCreateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCreateRoomActionPerformed(evt);
            }
        });

        jbtFollowing.setBackground(new java.awt.Color(138, 217, 163));
        jbtFollowing.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtFollowing.setForeground(new java.awt.Color(255, 255, 255));
        jbtFollowing.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\ICON\\user32.png")); // NOI18N
        jbtFollowing.setText("Following");
        jbtFollowing.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jbtAccount.setBackground(new java.awt.Color(138, 217, 163));
        jbtAccount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jbtAccount.setForeground(new java.awt.Color(255, 255, 255));
        jbtAccount.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\ICON\\head.png")); // NOI18N
        jbtAccount.setText("Account");
        jbtAccount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\bg1.png")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtCreateRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtFollowing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCreateRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtFollowing, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(99, 178, 124));

        jlbInfor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbInfor.setForeground(new java.awt.Color(255, 255, 255));
        jlbInfor.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\ICON\\home2.png")); // NOI18N
        jlbInfor.setText("Home");

        jtfSearch.setBackground(new java.awt.Color(242, 242, 242));
        jtfSearch.setPreferredSize(new java.awt.Dimension(64, 30));
        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });

        jbtSearch.setBackground(new java.awt.Color(138, 217, 163));
        jbtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtSearch.setForeground(new java.awt.Color(255, 255, 255));
        jbtSearch.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\ICON\\search-icon-24.png")); // NOI18N
        jbtSearch.setText("Search");
        jbtSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtSearch.setPreferredSize(new java.awt.Dimension(75, 29));

        jbtLogout.setBackground(new java.awt.Color(138, 217, 163));
        jbtLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtLogout.setForeground(new java.awt.Color(255, 255, 255));
        jbtLogout.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\ICON\\Login-icon-16.png")); // NOI18N
        jbtLogout.setText("Logout");
        jbtLogout.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jbtLogout.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jbtLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jbtLogout)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbInfor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtLogout))
                .addContainerGap())
        );

        tapMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tapMain)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(tapMain, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jbtHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHomeActionPerformed
//        if(HomePanel == null){
//            HomePanel = new HomePanel();
//        String mockRoomList = "Room1|Alice|10,Room2|Bob|20,Room3|Charlie|30";
//         ImageIcon icon = new ImageIcon(getClass().getResource("/ICON/chat-16.png"));
//           tapMain.addTab("HOME", icon,HomePanel,"HOME");
//           HomePanel.updateRoomList(mockRoomList); 
//        }
//         tapMain.setSelectedComponent(HomePanel);
        if (HomePanel == null) {
                   HomePanel = new HomePanel();

                   // Lấy danh sách video từ backend
                   java.util.List<String> videoList = Backend.getVideoList();

                   // Chuyển đổi danh sách thành chuỗi và gọi updateRoomList
                   StringBuilder mockRoomList = new StringBuilder();
                   for (String room : videoList) {
                       mockRoomList.append(room).append(",");
                   }

                   // Thêm tab và gọi phương thức updateRoomList
                   ImageIcon icon = new ImageIcon(getClass().getResource("/ICON/chat-16.png"));
                   tapMain.addTab("HOME", icon, HomePanel);
                   HomePanel.updateRoomList(mockRoomList.toString());
               }
               tapMain.setSelectedComponent(HomePanel);
    }//GEN-LAST:event_jbtHomeActionPerformed

    private void jbtCreateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCreateRoomActionPerformed
        showRoomOwnerPanel();        
    }//GEN-LAST:event_jbtCreateRoomActionPerformed

    private void jbtLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLogoutActionPerformed
        MainFrame.dispose();
        showLoginPanel();
    }//GEN-LAST:event_jbtLogoutActionPerformed

    public static void main(String args[]) {
        frame2 = new JFrame("Livestream Application");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(800, 500);
        frame2.setLayout(new BorderLayout());
        showLoginPanel();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        new Thread(LivestreamClientJFrame::listenForBroadcastMessages).start();
   
    }
    public static void showLoginPanel() {
         frame2.dispose();
        frame2 = new JFrame("Livestream Application");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(800, 500);
        
        frame2.getContentPane().removeAll();
        frame2.add(new LoginPanel(), BorderLayout.CENTER);
        frame2.revalidate();
        frame2.repaint();
        
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
    public static void showRegistrationPanel() {

        frame2.getContentPane().removeAll();
        frame2.add(new RegistrationPanel(), BorderLayout.CENTER);
        frame2.revalidate();
        frame2.repaint();

    }

    public static void showMainPanel() {
        if (MainFrame == null) { 
            MainFrame = new LivestreamClientJFrame();
            MainFrame.setTitle("Livestream Application");
            MainFrame.setIconImage(new ImageIcon("/LOGO.png").getImage());
            MainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            MainFrame.setSize(1130, 630); // 960, 552
            MainFrame.setLocationRelativeTo(null);
            MainFrame.jtfUsername.setText(LivestreamClientJFrame.getUsername());
        }
        MainFrame.setVisible(true); 
        frame2.dispose(); 
        
    }
    public static void showLiveStreamPanel() {

    }
    public static void showRoomOwnerPanel() {
        if (roomOwnerPanel == null) {
            roomOwnerPanel = new RoomOwnerPanel();
            ImageIcon icon = new ImageIcon(MainFrame.getClass().getResource("/ICON/chat-16.png"));
            MainFrame.tapMain.addTab("Room Owner", icon, roomOwnerPanel, "Room Owner");
        }
        MainFrame.tapMain.setSelectedComponent(roomOwnerPanel);
    }

    public static void showRoomParticipantPanel() {
      if (roomParticipantPanel == null) {
            roomParticipantPanel = new RoomParticipantPanel();
            ImageIcon icon = new ImageIcon(MainFrame.getClass().getResource("/ICON/chat-16.png"));
            MainFrame.tapMain.addTab("Room Owner", icon, roomParticipantPanel, "Room Owner");
        }
        MainFrame.tapMain.setSelectedComponent(roomParticipantPanel);
    }
    
    public static boolean sendBroadcastMessage(String message) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress group = InetAddress.getByName(ClientConfig.BROADCAST_ADDRESS);
            String fullMessage = message + ":" + InetAddress.getLocalHost().getHostAddress();
            byte[] buffer = fullMessage.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, ClientConfig.BROADCAST_PORT);
            socket.send(packet);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        
    public static void listenForBroadcastMessages() {
        try (MulticastSocket socket = new MulticastSocket(ClientConfig.BROADCAST_PORT)) {
            InetAddress group = InetAddress.getByName(ClientConfig.BROADCAST_ADDRESS);
            socket.joinGroup(group);
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received broadcast message: " + message);
                if (message.startsWith("ROOM_LIST:")) {
                    updateRoomList(message.substring(10));
                } else if (message.startsWith("COMMENT:")) {
                    String[] parts = message.split(":");
                    if (parts.length == 5) {
                        String sender = parts[1];
                        String comment = parts[2];
                        boolean isOwner = sender.equals(getRoomOwner(currentRoom));
                        if (!sender.equals(username) && currentRoom != null && currentRoom.equals(parts[3])) {
                            comment = sender + ": " + comment;
                            if (liveStreamPanel != null) {
                                liveStreamPanel.addComment(comment, isOwner);
                            } else if (roomOwnerPanel != null) {
                                roomOwnerPanel.addComment(comment, isOwner);

                            } else if (roomParticipantPanel != null) {
                                roomParticipantPanel.addComment(comment, isOwner);
                            }
                        }
                    }
                } else if (message.startsWith("ROOM_CLOSED:")) {
                    String roomName = message.split(":")[1];
                    System.out.println("Received room closed message for room á hahaahhaha: " + roomName);
                    if (currentRoom != null && currentRoom.equals(roomName)) {
                        toaster.success("The room has been closed by the owner.");
                        JOptionPane.showMessageDialog(MainFrame, "The room has been closed by the owner.", "Room Closed",
                                JOptionPane.INFORMATION_MESSAGE);
                        leaveRoom();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String getRoomOwner(String roomName) {
        for (int i = 0; i < roomListModel.size(); i++) {
            String roomDetails = roomListModel.get(i);
            if (roomDetails.startsWith(roomName + " (Owner: ")) {
                int startIndex = roomDetails.indexOf("Owner: ") + 7;
                int endIndex = roomDetails.indexOf(", Participants:");
                if (startIndex != -1 && endIndex != -1) {
                    System.out.println("Room owner: " + roomDetails.substring(startIndex, endIndex));
                    return roomDetails.substring(startIndex, endIndex);
                }
            }
        }
        return null;
    }
    

    private static void updateRoomList(String roomList) {
        SwingUtilities.invokeLater(() -> {
            roomListModel.clear();
            String[] rooms = roomList.split(",");
            for (String room : rooms) {
                if (!room.isEmpty()) {
                    String[] roomDetails = room.split("\\|");
                    if (roomDetails.length == 4) {
                        String roomName = roomDetails[0];
                        String owner = roomDetails[1];
                        String participantCount = roomDetails[3];
                        roomListModel.addElement(
                                roomName + " (Owner: " + owner + ", Participants: " + participantCount + ")");

                        if (currentRoom != null && currentRoom.equals(roomName) && roomOwnerPanel != null) {
                            roomOwnerPanel.updateParticipantsCount(Integer.parseInt(participantCount));
                        } else if (currentRoom != null && currentRoom.equals(roomName)
                                && roomParticipantPanel != null) {
                            roomParticipantPanel.updateParticipantsCount(Integer.parseInt(participantCount));
                        }
                    } else {
                        System.err.println("Invalid room details: " + room);
                    }
                }
            }
            System.out.println("Updated room list: " + roomList);

            if (checkRoomOwnerAfterUpdate) {
                checkRoomOwnerAfterUpdate = false;
                if (isRoomOwner(currentRoom)) {
                    showRoomOwnerPanel();
                } else {
                    showRoomParticipantPanel();
                }
            }

            if (MainFrame.getContentPane().getComponent(0) instanceof MainPanel) {
                MainPanel mainPanel = (MainPanel) MainFrame.getContentPane().getComponent(0);
                mainPanel.updateRoomList(roomList);
            }
        });
    } 
    
        public static void joinRoom(String roomName) {
        currentRoom = roomName;
        System.out.println("Attempting to join room: " + roomName);
        sendBroadcastMessage("JOIN_ROOM:" + username + ":" + userId + ":" + roomName);
        checkRoomOwnerAfterUpdate = true;
    }

    public static void closeRoom() {
        if (currentRoom != null) {
            sendBroadcastMessage("CLOSE_ROOM:" + username + ":" + userId + ":" + currentRoom);
            currentRoom = null;
            showMainPanel();
            if (roomOwnerPanel != null) {
                roomOwnerPanel.stopAllStreams();
            }
        }
    }
    
    public static void leaveRoom() {
        if (currentRoom != null) {
            sendBroadcastMessage("LEAVE_ROOM:" + username + ":" + userId + ":" + currentRoom);
            currentRoom = null;
            showMainPanel();
        }
    }

    public static void createRoom(String roomName) {
        String message = "CREATE_ROOM:" + username + ":" + userId + ":" + roomName;
        if (sendBroadcastMessage(message)) {
            System.out.println("Create room request sent successfully for room: " + roomName);
            currentRoom = roomName;
            showRoomOwnerPanel();
        } else {
            toaster.error("Failed to send create room request.");
        }
    }
    
        
    public static void sendComment(String comment) {
        if (currentRoom != null) {
            String message = "COMMENT:" + username + ":" + userId + ":" + currentRoom + ":" + comment;
            sendBroadcastMessage(message);
        }
    }
    
        
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LivestreamClientJFrame.username = username;
    }

    public static void setUserId(String userId) {
        LivestreamClientJFrame.userId = userId;
    }

    public static DefaultListModel<String> getRoomListModel() {
        return roomListModel;
    }

    public static String getCurrentRoom() {
        return currentRoom;
    }
    
    private static boolean isRoomOwner(String roomName) {
        for (int i = 0; i < roomListModel.size(); i++) {
            String roomDetails = roomListModel.get(i);
            System.out.println("Checking room details: " + roomDetails);
            if (roomDetails.startsWith(roomName + " (Owner: " + username)) {
                System.out.println("User is the owner of the room: " + roomName);
                return true;
            }
        }
        System.out.println("User is not the owner of the room: " + roomName);
        return false;
    }
    
       
    public static String getRoomList() {
        // Fetch the room list from the server, or return a mocked list for now
        return "Room1|Owner1|10,Room2|Owner2|15,Room3|Owner3|20";
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jbtAccount;
    private javax.swing.JButton jbtCreateRoom;
    private javax.swing.JButton jbtFollowing;
    private javax.swing.JButton jbtHome;
    private javax.swing.JButton jbtLogout;
    private javax.swing.JButton jbtSearch;
    private javax.swing.JLabel jlbInfor;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JLabel jtfUsername;
    private javax.swing.JTabbedPane tapMain;
    // End of variables declaration//GEN-END:variables
}
