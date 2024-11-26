/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package valorant_app;

import java.awt.Color;
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
public class panelPartida extends javax.swing.JPanel {
    int idMapa;
    String nombreMapa;
    String tipoPartida;
    String agenteJugado;
    String fechaPartida;
    String rolEquipo;
    int rondasGanadas;
    int index;
    
    
    public panelPartida() {
        initComponents();
    }

    public void llenarDatos(int idMapa, String nombreMapa, String tipoPartida, String agenteJugado, String fechaPartida, String rolEquipo, int rondasGanadas, int index) {
        
        this.idMapa = idMapa;
        this.nombreMapa = nombreMapa;
        this.tipoPartida = tipoPartida;
        this.agenteJugado = agenteJugado;
        this.fechaPartida = fechaPartida;
        this.rolEquipo = rolEquipo;
        this.rondasGanadas = rondasGanadas;
        this.index = index;
    }
    
    public void llenarPanel() {
        //lblMapaId.setText(String.valueOf(idMapa));
        //lblNombreMapa.setText(nombreMapa);
        lblModoJuego.setText(tipoPartida);
        lblAgenteJugado.setText(agenteJugado);
        lblFecha.setText(fechaPartida);
        //lblRolEquipo.setText(rolEquipo);
        lblRondasGanadas.setText(String.valueOf(rondasGanadas));
        
        if(rondasGanadas>=13){
            this.setBackground(new Color(192, 255 ,211));
        } else {
            this.setBackground(new Color(255, 197, 197));
        }
        
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
        
        
        lblAgentImage.setText("");
        switch(agenteJugado){
            case "Jett" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Jett.png")));
            }
            case "Phoenix" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Phoenix.png")));
            }
            case "Sova" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Sova.png")));
            }
            case "Cypher" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Cypher.png")));
            }
            case "Viper" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Viper.png")));
            }
            case "Sage" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Sage.png")));
            }
            case "Brimstone" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Brimstone.png")));
            }
            case "Raze" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Raze.png")));
            }
            case "Killjoy" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Killjoy.png")));
            }
            case "Omen" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Omen.png")));
            }
            case "Skye" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Skye.png")));
            }
            case "Yoru" -> {
                lblAgentImage.setIcon(new ImageIcon(getClass().getResource("/agentes/Yoru.png")));
            }
            
        }
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAgentImage = new javax.swing.JLabel();
        lblMapaImage = new javax.swing.JLabel();
        lblModoJuego = new javax.swing.JLabel();
        lblAgenteJugado = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblRondasGanadas = new javax.swing.JLabel();
        btnMas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(830, 150));
        setPreferredSize(new java.awt.Dimension(830, 150));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgentImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAgentImage.setForeground(new java.awt.Color(255, 255, 255));
        lblAgentImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgentImage.setText("[agent_image]");
        add(lblAgentImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 100, 100));

        lblMapaImage.setForeground(new java.awt.Color(255, 255, 255));
        lblMapaImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMapaImage.setText("[n/n]");
        add(lblMapaImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 200, 150));

        lblModoJuego.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblModoJuego.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblModoJuego.setText("[game_mode]");
        add(lblModoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 130, 29));

        lblAgenteJugado.setText("[n/n]");
        add(lblAgenteJugado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 107, 29));

        lblFecha.setBackground(new java.awt.Color(0, 0, 0));
        lblFecha.setText("[date]");
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 130, 29));

        lblRondasGanadas.setText("[win_rounds]");
        add(lblRondasGanadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 30, 20));

        btnMas.setBackground(new java.awt.Color(255, 51, 51));
        btnMas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMas.setForeground(new java.awt.Color(255, 255, 255));
        btnMas.setText("Ver más");
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });
        add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 110, 30));

        jLabel1.setText("Rondas Ganadas:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        
        String idPartida = String.valueOf(idMapa);
        System.out.println("ID de partida seleccionado: " + idPartida);

        Query query = new Query();
        JTable tablaDetalles = new JTable();
        tablaDetalles.setOpaque(true);
        ((DefaultTableCellRenderer) tablaDetalles.getDefaultRenderer(Object.class)).setOpaque(true);

        query.obtenerDetallesPartida(idPartida, tablaDetalles);

        JFrame detallesFrame = new JFrame("Detalles de la Partida");
        detallesFrame.setSize(1000, 600);
        detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel() {
            private Image backgroundImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/valoranttracker.jpg"));

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        // Ajustar tamaño y posición del JTable para centrarlo
        JScrollPane scrollPane = new JScrollPane(tablaDetalles);
        int scrollPaneWidth = 800;
        int scrollPaneHeight = 190;
        int panelWidth = detallesFrame.getWidth();
        int panelHeight = detallesFrame.getHeight();

        // Calcular la posición para centrar el JTable en el JFrame
        int xPosition = (panelWidth - scrollPaneWidth) / 2 - 10; // Ajuste fino de -10
        int yPosition = (panelHeight - scrollPaneHeight) / 2 - 30; // Ajuste fino de -30

        scrollPane.setBounds(xPosition, yPosition, scrollPaneWidth, scrollPaneHeight);

        panel.add(scrollPane);
        detallesFrame.add(panel);
        detallesFrame.setVisible(true);
    }//GEN-LAST:event_btnMasActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        String idPartida = String.valueOf(idMapa);
        System.out.println("ID de partida seleccionado: " + idPartida);

        Query query = new Query();
        JTable tablaDetalles = new JTable();
        tablaDetalles.setOpaque(true);
        ((DefaultTableCellRenderer) tablaDetalles.getDefaultRenderer(Object.class)).setOpaque(true);

        query.obtenerDetallesPartida(idPartida, tablaDetalles);

        JFrame detallesFrame = new JFrame("Detalles de la Partida");
        detallesFrame.setSize(1000, 600);
        detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel() {
            private Image backgroundImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/valoranttracker.jpg"));

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        // Ajustar tamaño y posición del JTable para centrarlo
        JScrollPane scrollPane = new JScrollPane(tablaDetalles);
        int scrollPaneWidth = 800;
        int scrollPaneHeight = 190;
        int panelWidth = detallesFrame.getWidth();
        int panelHeight = detallesFrame.getHeight();

        // Calcular la posición para centrar el JTable en el JFrame
        int xPosition = (panelWidth - scrollPaneWidth) / 2 - 10; // Ajuste fino de -10
        int yPosition = (panelHeight - scrollPaneHeight) / 2 - 30; // Ajuste fino de -30

        scrollPane.setBounds(xPosition, yPosition, scrollPaneWidth, scrollPaneHeight);

        panel.add(scrollPane);
        detallesFrame.add(panel);
        detallesFrame.setVisible(true);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAgentImage;
    private javax.swing.JLabel lblAgenteJugado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMapaImage;
    private javax.swing.JLabel lblModoJuego;
    private javax.swing.JLabel lblRondasGanadas;
    // End of variables declaration//GEN-END:variables
}
