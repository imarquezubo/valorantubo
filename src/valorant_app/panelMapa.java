/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package valorant_app;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombre_Mapa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblMapa = new javax.swing.JLabel();
        lblVictorias = new javax.swing.JLabel();
        lblPartidas = new javax.swing.JLabel();
        lblDerrotas = new javax.swing.JLabel();
        lblWinrate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(830, 150));
        setPreferredSize(new java.awt.Dimension(830, 150));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre_Mapa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nombre_Mapa.setText("Derrotas:");
        add(Nombre_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 112, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Partidas:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 29));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Victorias:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 99, 29));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Winrate:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 104, 30));

        lblMapa.setText("[n/n]");
        add(lblMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 107, 29));

        lblVictorias.setText("[n/n]");
        add(lblVictorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 107, 29));

        lblPartidas.setText("[n/n]");
        add(lblPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 107, 29));

        lblDerrotas.setText("[n/n]");
        add(lblDerrotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 107, 29));

        lblWinrate.setText("[n/n]");
        add(lblWinrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 30, 30));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre_Mapa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblDerrotas;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JLabel lblVictorias;
    private javax.swing.JLabel lblWinrate;
    // End of variables declaration//GEN-END:variables
}
