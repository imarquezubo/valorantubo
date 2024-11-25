/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package valorant_app;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author isaia
 */
public class panelMapa extends javax.swing.JPanel {
    String nombreMapa;
    int partidas;
    int partidasGanadas;
    int partidasPerdidas;
    float winrate;
    int index;
    
    
    public panelMapa() {
        initComponents();
    }

    public void llenarDatos(String nombreMapa, int partidas, int partidasGanadas, int partidasPerdidas, float winrate, int index) {
        
        this.nombreMapa = nombreMapa;
        this.partidas = partidas;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.winrate = winrate;
        this.index = index;
    }
    
    public void llenarPanel() {
        lblMapa.setText(String.valueOf(nombreMapa));
        lblVictorias.setText(String.valueOf(partidasGanadas));
        lblPartidas.setText(String.valueOf(partidas));
        lblDerrotas.setText(String.valueOf(partidasPerdidas));
        lblWinrate.setText(String.valueOf(winrate));
        
        lblMapaImage.setText("");
        
        switch(nombreMapa) {
            case "Ascent" -> {
                lblMapaImage.setIcon(new ImageIcon(getClass().getResource("/mapas/Ascent.png")));
            }
            case "Bind" -> {
                lblMapaImage.setIcon(new ImageIcon(getClass().getResource("/mapas/Bind.png")));
            }
            case "Haven" -> {
                lblMapaImage.setIcon(new ImageIcon(getClass().getResource("/mapas/Haven.png")));
            }
            case "Split" -> {
                lblMapaImage.setIcon(new ImageIcon(getClass().getResource("/mapas/Split.png")));
            }
            case "Breeze" -> {
                lblMapaImage.setIcon(new ImageIcon(getClass().getResource("/mapas/Breeze.png")));
            }
            case "Fracture" -> {
                lblMapaImage.setIcon(new ImageIcon(getClass().getResource("/mapas/Fracture.png")));
            }
            case "Pearl" -> {
                lblMapaImage.setIcon(new ImageIcon(getClass().getResource("/mapas/Pearl.png")));
            }
        }
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMapaImage = new javax.swing.JLabel();
        lblPartidas = new javax.swing.JLabel();
        lblWinrate = new javax.swing.JLabel();
        lblMapa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblVictorias = new javax.swing.JLabel();
        lblDerrotas = new javax.swing.JLabel();
        Nombre_Mapa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 44, 54));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(830, 150));
        setPreferredSize(new java.awt.Dimension(800, 150));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMapaImage.setForeground(new java.awt.Color(255, 255, 255));
        lblMapaImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMapaImage.setText("[n/n]");
        add(lblMapaImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 150));

        lblPartidas.setForeground(new java.awt.Color(255, 255, 255));
        lblPartidas.setText("[n/n]");
        add(lblPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 107, 29));

        lblWinrate.setForeground(new java.awt.Color(255, 255, 255));
        lblWinrate.setText("[n/n]");
        add(lblWinrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 70, 30));

        lblMapa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMapa.setForeground(new java.awt.Color(255, 255, 255));
        lblMapa.setText("[n/n]");
        add(lblMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 107, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Partidas:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 29));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Victorias:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 70, 29));

        lblVictorias.setForeground(new java.awt.Color(255, 255, 255));
        lblVictorias.setText("[n/n]");
        add(lblVictorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 60, 29));

        lblDerrotas.setForeground(new java.awt.Color(255, 255, 255));
        lblDerrotas.setText("[n/n]");
        add(lblDerrotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 80, 29));

        Nombre_Mapa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nombre_Mapa.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_Mapa.setText("Derrotas:");
        add(Nombre_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 112, 29));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Winrate:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 104, 30));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre_Mapa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblDerrotas;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblMapaImage;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JLabel lblVictorias;
    private javax.swing.JLabel lblWinrate;
    // End of variables declaration//GEN-END:variables
}
