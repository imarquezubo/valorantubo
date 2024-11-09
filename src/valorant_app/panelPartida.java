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
        lblMapaId.setText(String.valueOf(idMapa));
        lblNombreMapa.setText(nombreMapa);
        lblModoJuego.setText(tipoPartida);
        lblAgenteJugado.setText(agenteJugado);
        lblFecha.setText(fechaPartida);
        lblRolEquipo.setText(rolEquipo);
        lblRondasGanadas.setText(String.valueOf(rondasGanadas));
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Nombre_Mapa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblMapaId = new javax.swing.JLabel();
        lblNombreMapa = new javax.swing.JLabel();
        lblModoJuego = new javax.swing.JLabel();
        lblAgenteJugado = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblRolEquipo = new javax.swing.JLabel();
        lblRondasGanadas = new javax.swing.JLabel();
        btnMas = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(830, 150));
        setPreferredSize(new java.awt.Dimension(830, 150));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Id_mapa:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 26, 112, 29));

        Nombre_Mapa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nombre_Mapa.setText("Nombre_mapa:");
        add(Nombre_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 80, 112, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Modo de Juego:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 26, -1, 29));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Agente Jugado:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 80, 99, 29));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Rol Equipo:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 80, 80, 29));

        Fecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Fecha.setText("Fecha:");
        add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 80, 29));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Rondas Gandas:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 104, 20));

        lblMapaId.setText("[n/n]");
        add(lblMapaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 27, 107, 29));

        lblNombreMapa.setText("[n/n]");
        add(lblNombreMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 81, 107, 29));

        lblModoJuego.setText("[n/n]");
        add(lblModoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 27, 107, 29));

        lblAgenteJugado.setText("[n/n]");
        add(lblAgenteJugado, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 81, 107, 29));

        lblFecha.setText("[n/n]");
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 140, 29));

        lblRolEquipo.setText("[n/n]");
        add(lblRolEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 81, 77, 29));

        lblRondasGanadas.setText("[n/n]");
        add(lblRondasGanadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 30, 20));

        btnMas.setText("Leer más");
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });
        add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 98, 110, -1));
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
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Nombre_Mapa;
    private javax.swing.JButton btnMas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAgenteJugado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMapaId;
    private javax.swing.JLabel lblModoJuego;
    private javax.swing.JLabel lblNombreMapa;
    private javax.swing.JLabel lblRolEquipo;
    private javax.swing.JLabel lblRondasGanadas;
    // End of variables declaration//GEN-END:variables
}
