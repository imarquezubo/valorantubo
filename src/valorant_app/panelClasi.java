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
public class panelClasi extends javax.swing.JPanel {
    int posicion;
    String jugador;
    int partidas;
    String rango;
    float winrate;
    int index;
    
    
    public panelClasi() {
        initComponents();
    }

    public void llenarDatos(int posicion, String jugador, int partidas, String rango, float winrate, int index) {
        
        this.posicion = posicion;
        this.jugador = jugador;
        this.partidas = partidas;
        this.rango = rango;
        this.winrate = winrate;
        this.index = index;
    }
    
    public void llenarPanel() {
        lblPosicion.setText(String.valueOf(posicion));
        lblPlayer.setText(String.valueOf(jugador));
        lblPartidas.setText(String.valueOf(partidas));
        lblRango.setText(String.valueOf(rango));
        lblWinrate.setText(String.valueOf(winrate));
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lblRango = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPlayer = new javax.swing.JLabel();
        lblVictorias = new javax.swing.JLabel();
        lblPartidas = new javax.swing.JLabel();
        lblWinrate = new javax.swing.JLabel();
        lblPosicion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(830, 150));
        setPreferredSize(new java.awt.Dimension(830, 150));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Partidas:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, 29));

        lblRango.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRango.setText("Rango:");
        add(lblRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 99, 29));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Winrate:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 104, 30));

        lblPlayer.setText("[n/n]");
        add(lblPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 29));

        lblVictorias.setText("[n/n]");
        add(lblVictorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 107, 29));

        lblPartidas.setText("[n/n]");
        add(lblPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 107, 29));

        lblWinrate.setText("[n/n]");
        add(lblWinrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 80, 30));

        lblPosicion.setText("[n/n]");
        add(lblPosicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 29));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JLabel lblPlayer;
    private javax.swing.JLabel lblPosicion;
    private javax.swing.JLabel lblRango;
    private javax.swing.JLabel lblVictorias;
    private javax.swing.JLabel lblWinrate;
    // End of variables declaration//GEN-END:variables
}
