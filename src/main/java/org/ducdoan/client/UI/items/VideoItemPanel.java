package org.ducdoan.client.UI.items;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class VideoItemPanel extends JPanel {


//    public VideoItemPanel() {
//        initComponents();
//    }

//    public VideoItemPanel(String status, String username, ImageIcon coverImage, ImageIcon userImage) {
//        initComponents();
//        setStatus(status);
//        setUsername(username);
//        jlbPhotoCover.setIcon(coverImage);
//        jlbImageUser.setIcon(userImage);
//        setPreferredSize(new Dimension(200, 150));
//    }
    public VideoItemPanel(String status, String username, ImageIcon coverImage, ImageIcon userImage) {
        initComponents();
        setStatus(status);
        setUsername(username);
        jlbPhotoCover.setIcon(coverImage);
        jlbImageUser.setIcon(userImage);
        setPreferredSize(new Dimension(200, 150));//185, 144
    }
    
    public void setStatus(String status) {
        jlbStatus.setText(status);
    }

    public void setUsername(String username) {
        jlbUsername.setText(username);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbPhotoCover = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlbImageUser = new javax.swing.JLabel();
        jlbStatus = new javax.swing.JLabel();
        jlbUsername = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlbPhotoCover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbPhotoCover.setIcon(new javax.swing.ImageIcon("D:\\HOC TAP\\HK1 2024 - 2025\\DO AN CO SO 4\\Projects\\StreamingApp\\src\\main\\resources\\ICON\\ok-icon.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbPhotoCover, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbPhotoCover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbImageUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbImageUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/user32.png"))); // NOI18N
        jlbImageUser.setToolTipText("");
        jlbImageUser.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jlbImageUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlbImageUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jlbStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlbStatus.setText("'status'");

        jlbUsername.setText("'username");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlbImageUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbImageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlbStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlbImageUser;
    private javax.swing.JLabel jlbPhotoCover;
    private javax.swing.JLabel jlbStatus;
    private javax.swing.JLabel jlbUsername;
    // End of variables declaration//GEN-END:variables
}