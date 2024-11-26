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
public class panelAg extends javax.swing.JPanel {
    String nombreAgente;
    int partidas;
    int partidasGanadas;
    int partidasPerdidas;
    float winrate;
    int index;
    
    
    public panelAg() {
        initComponents();
    }

    public void llenarDatos(String nombreAgente, int partidas, int partidasGanadas, int partidasPerdidas, float winrate, int index) {
        
        this.nombreAgente = nombreAgente;
        this.partidas = partidas;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.winrate = winrate;
        this.index = index;
    }
    
    public void llenarPanel() {
        lblAgenteNombre.setText(String.valueOf(nombreAgente));
        lblVictorias.setText(String.valueOf(partidasGanadas));
        lblPartidas.setText(String.valueOf(partidas));
        lblDerrotas.setText(String.valueOf(partidasPerdidas));
        lblWinrate.setText(String.valueOf(winrate));
        
        lblAgenteIcon.setText("");
        switch(nombreAgente){
            case "Jett" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Jett.png")));
            }
            case "Phoenix" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Phoenix.png")));
            }
            case "Sova" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Sova.png")));
            }
            case "Cypher" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Cypher.png")));
            }
            case "Viper" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Viper.png")));
            }
            case "Sage" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Sage.png")));
            }
            case "Brimstone" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Brimstone.png")));
            }
            case "Raze" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Raze.png")));
            }
            case "Killjoy" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Killjoy.png")));
            }
            case "Omen" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Omen.png")));
            }
            case "Skye" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Skye.png")));
            }
            case "Yoru" -> {
                lblAgenteIcon.setIcon(new ImageIcon(getClass().getResource("/agentes/Yoru.png")));
            }
            
        }
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombre_Mapa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAgenteIcon = new javax.swing.JLabel();
        lblVictorias = new javax.swing.JLabel();
        lblAgenteNombre = new javax.swing.JLabel();
        lblDerrotas = new javax.swing.JLabel();
        lblWinrate = new javax.swing.JLabel();
        lblPartidas = new javax.swing.JLabel();

        setBackground(new java.awt.Color(21, 44, 54));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(830, 150));
        setPreferredSize(new java.awt.Dimension(830, 150));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre_Mapa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nombre_Mapa.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_Mapa.setText("Derrotas:");
        add(Nombre_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 70, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Partidas:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Victorias:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 70, 29));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Winrate:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 70, 30));

        lblAgenteIcon.setForeground(new java.awt.Color(255, 255, 255));
        lblAgenteIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgenteIcon.setText("[n/n]");
        add(lblAgenteIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 100));

        lblVictorias.setForeground(new java.awt.Color(255, 255, 255));
        lblVictorias.setText("[n/n]");
        add(lblVictorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 107, 29));

        lblAgenteNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAgenteNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblAgenteNombre.setText("[n/n]");
        add(lblAgenteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 107, 29));

        lblDerrotas.setForeground(new java.awt.Color(255, 255, 255));
        lblDerrotas.setText("[n/n]");
        add(lblDerrotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 107, 29));

        lblWinrate.setForeground(new java.awt.Color(255, 255, 255));
        lblWinrate.setText("[n/n]");
        add(lblWinrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 60, 30));

        lblPartidas.setForeground(new java.awt.Color(255, 255, 255));
        lblPartidas.setText("[n/n]");
        add(lblPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 50, 20));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre_Mapa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAgenteIcon;
    private javax.swing.JLabel lblAgenteNombre;
    private javax.swing.JLabel lblDerrotas;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JLabel lblVictorias;
    private javax.swing.JLabel lblWinrate;
    // End of variables declaration//GEN-END:variables
}
