/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package valorant_app;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author adolf
 */
public class PerfilJugador extends javax.swing.JFrame {
    //RoundedPanel RoundedPanel = new RoundedPanel(20, new Color(21,44,54));
    Query query = new Query();
    String nombreUsuario;
    String idUsuario;

    /**
     * Creates new form PerfilJugador
     */
    public PerfilJugador() {
        super();
        initComponents(); // Inicializa los componentes
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); // Evita que el usuario redimensione
        setVisible(true); // Muestra el JFrame
        
        
    }
    
    public PerfilJugador(String nombreUsuario, String idUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        lblNombre.setText(nombreUsuario);
        lblCorreo.setText(String.valueOf(query.getCorreo(nombreUsuario)));
        lblNivel.setText(String.valueOf(query.getNivel(nombreUsuario)));
        lblAsistencias.setText(String.valueOf(query.getAsistenciasTotales(nombreUsuario)));
        lblKills.setText(String.valueOf(query.getKillsTotales(nombreUsuario)));
        lblMuertes.setText(String.valueOf(query.getMuertesTotales(nombreUsuario)));
        lblACS.setText(String.valueOf(Math.round(query.getACSPromedio(nombreUsuario))));
        lblWinrate.setText(String.valueOf(query.getWinrateTotal(nombreUsuario)) + "%");
        lblRango.setText(query.getRango(nombreUsuario));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/valoLogo.png")));
        this.setTitle("Valorant Tracker");
        llenarIconoRango();
    }
    
    public void llenarIconoRango(){
        String rango = query.getRango(nombreUsuario);
        lblRankIcon.setText("");
        
        switch(rango){
            case "Hierro" -> {
                
                lblRankIcon.setIcon(new ImageIcon(getClass().getResource("/rank_icons/hierro3.png")));
            }
            case "Bronce" -> {
                lblRankIcon.setIcon(new ImageIcon(getClass().getResource("/rank_icons/bronce3.png")));
            }
            case "Plata" -> {
                lblRankIcon.setIcon(new ImageIcon(getClass().getResource("/rank_icons/plata3.png")));
            }
            case "Oro" -> {
                lblRankIcon.setIcon(new ImageIcon(getClass().getResource("/rank_icons/oro3.png")));
            }
            case "Platino" -> {
                lblRankIcon.setIcon(new ImageIcon(getClass().getResource("/rank_icons/platino3.png")));
            }
            case "Diamante" -> {
                lblRankIcon.setIcon(new ImageIcon(getClass().getResource("/rank_icons/diamante3.png")));
            }
            case "Inmortal" -> {
                lblRankIcon.setIcon(new ImageIcon(getClass().getResource("/rank_icons/inmortal3.png")));
            }
            case "Radiante" -> {
                lblRankIcon.setIcon(new ImageIcon(getClass().getResource("/rank_icons/radiante.png")));
            }
            case "unranked" -> {
                lblRango.setText("Sin Rango");
            }
        }
    }
    
    public void llenarAgentes() {
        for(int x=1 ; x<=query.cantidadDeAgentesUsadosPorUsuario(nombreUsuario) ; x++){
            ResultSet rs;
            rs = query.agentesEst(nombreUsuario, x);
            try {
                panelAg agentespanel = new panelAg ();
                agentespanel.llenarDatos(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(4)),Float.parseFloat(rs.getString(5)), x);
                agentespanel.llenarPanel();
                agentesPanel.add(agentespanel);
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(listaPartidas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void llenarRoles() {
        for(int x=1 ; x<=query.cantidadDeRolesUsadosPorUsuario(nombreUsuario) ; x++){
            ResultSet rs;
            rs = query.rolesEst(nombreUsuario, x);
            try {
                panelRol panelrol = new panelRol ();
                panelrol.llenarDatos(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(4)),Float.parseFloat(rs.getString(5)), x);
                panelrol.llenarPanel();
                rolesPanel.add(panelrol);
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(listaPartidas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void llenarMapas() {
        for(int x=1 ; x<=query.cantidadDeMapasJugadosPorUsuario(nombreUsuario) ; x++){
            ResultSet rs;
            rs = query.mapasEst(nombreUsuario, x);
            try {
                panelMapa panelmapa = new panelMapa ();
                panelmapa.llenarDatos(rs.getString(1),Integer.parseInt(rs.getString(2)),Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString(4)),Float.parseFloat(rs.getString(5)), x);
                panelmapa.llenarPanel();
                mapasPanel.add(panelmapa);
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(listaPartidas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleBar = new javax.swing.JPanel();
        btnX = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cerrarbt = new javax.swing.JToggleButton();
        historialbt = new javax.swing.JToggleButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        mapas = new javax.swing.JScrollPane();
        mapasPanel = new javax.swing.JPanel();
        roles = new javax.swing.JScrollPane();
        rolesPanel = new javax.swing.JPanel();
        agentes = new javax.swing.JScrollPane();
        agentesPanel = new javax.swing.JPanel();
        seccionPerfil = new RoundedPanel(20, new Color(21,44,54));
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblKills = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblACS = new javax.swing.JLabel();
        lblMuertes = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblAsistencias = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblRango = new javax.swing.JLabel();
        lblWinrate = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblRankIcon = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        historialbt1 = new javax.swing.JToggleButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleBar.setBackground(new java.awt.Color(21, 44, 54));
        titleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnX.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnX.setForeground(new java.awt.Color(255, 255, 255));
        btnX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnX.setText("X");
        btnX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXMouseExited(evt);
            }
        });
        titleBar.add(btnX, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 20, 30));

        btnMinimize.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnMinimize.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setText("-");
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        titleBar.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 20, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Valorant Tracker");
        titleBar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        getContentPane().add(titleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cerrarbt.setBackground(new java.awt.Color(255, 68, 87));
        cerrarbt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cerrarbt.setForeground(new java.awt.Color(255, 255, 255));
        cerrarbt.setText("Cerrar Sesión");
        cerrarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarbtActionPerformed(evt);
            }
        });
        jPanel1.add(cerrarbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 470, 190, 50));

        historialbt.setBackground(new java.awt.Color(255, 68, 87));
        historialbt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        historialbt.setForeground(new java.awt.Color(255, 255, 255));
        historialbt.setText("Historial");
        historialbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialbtActionPerformed(evt);
            }
        });
        jPanel1.add(historialbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, 190, 50));

        mapasPanel.setLayout(new javax.swing.BoxLayout(mapasPanel, javax.swing.BoxLayout.PAGE_AXIS));
        mapas.setViewportView(mapasPanel);

        jTabbedPane1.addTab("Mapas", mapas);

        rolesPanel.setLayout(new javax.swing.BoxLayout(rolesPanel, javax.swing.BoxLayout.PAGE_AXIS));
        roles.setViewportView(rolesPanel);

        jTabbedPane1.addTab("Roles", roles);

        agentesPanel.setLayout(new javax.swing.BoxLayout(agentesPanel, javax.swing.BoxLayout.PAGE_AXIS));
        agentes.setViewportView(agentesPanel);

        jTabbedPane1.addTab("Agentes", agentes);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 800, 430));

        seccionPerfil.setBackground(new java.awt.Color(21, 44, 54));
        seccionPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        seccionPerfil.setPreferredSize(new java.awt.Dimension(969, 160));
        seccionPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setBackground(new java.awt.Color(228, 228, 228));
        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(228, 228, 228));
        lblNombre.setText("[name]");
        seccionPerfil.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 8, 270, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/userProfileIcon.png"))); // NOI18N
        seccionPerfil.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 21, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(228, 228, 228));
        lblCorreo.setText("[email]");
        seccionPerfil.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 53, 270, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(228, 228, 228));
        jLabel3.setText("Nivel");
        seccionPerfil.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        lblNivel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(228, 228, 228));
        lblNivel.setText("[N]");
        seccionPerfil.add(lblNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(228, 228, 228));
        jLabel5.setText("Kills");
        seccionPerfil.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 70, -1));

        lblKills.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblKills.setForeground(new java.awt.Color(255, 255, 255));
        lblKills.setText("[N]");
        seccionPerfil.add(lblKills, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 70, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(228, 228, 228));
        jLabel7.setText("ACS");
        seccionPerfil.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 70, -1));

        lblACS.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblACS.setForeground(new java.awt.Color(255, 255, 255));
        lblACS.setText("[N]");
        seccionPerfil.add(lblACS, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 70, -1));

        lblMuertes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblMuertes.setForeground(new java.awt.Color(255, 255, 255));
        lblMuertes.setText("[N]");
        seccionPerfil.add(lblMuertes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 64, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(228, 228, 228));
        jLabel10.setText("Muertes");
        seccionPerfil.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jPanel4.setPreferredSize(new java.awt.Dimension(2, 40));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        seccionPerfil.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 50));

        lblAsistencias.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblAsistencias.setForeground(new java.awt.Color(255, 255, 255));
        lblAsistencias.setText("[N]");
        seccionPerfil.add(lblAsistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 90, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(228, 228, 228));
        jLabel12.setText("Asistencias");
        seccionPerfil.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 100, -1));

        lblRango.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblRango.setForeground(new java.awt.Color(228, 228, 228));
        lblRango.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRango.setText("[rank]");
        seccionPerfil.add(lblRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 110, -1));

        lblWinrate.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblWinrate.setForeground(new java.awt.Color(255, 255, 255));
        lblWinrate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWinrate.setText("[%]");
        seccionPerfil.add(lblWinrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 110, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(228, 228, 228));
        jLabel15.setText("Winrate");
        seccionPerfil.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 100, -1));

        lblRankIcon.setForeground(new java.awt.Color(255, 255, 255));
        lblRankIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRankIcon.setText("[RankIcon]");
        lblRankIcon.setPreferredSize(new java.awt.Dimension(68, 68));
        seccionPerfil.add(lblRankIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, -1, -1));

        jPanel6.setPreferredSize(new java.awt.Dimension(2, 40));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        seccionPerfil.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, 50));

        jPanel7.setPreferredSize(new java.awt.Dimension(2, 40));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        seccionPerfil.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, 50));

        jPanel8.setPreferredSize(new java.awt.Dimension(2, 40));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        seccionPerfil.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, 50));

        historialbt1.setBackground(new java.awt.Color(255, 68, 87));
        historialbt1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        historialbt1.setForeground(new java.awt.Color(255, 255, 255));
        historialbt1.setText("Ver Perfil");
        historialbt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialbt1ActionPerformed(evt);
            }
        });
        seccionPerfil.add(historialbt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 110, 30));

        jPanel1.add(seccionPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1030, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_main.jpg"))); // NOI18N
        background.setText("jLabel2");
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarbtActionPerformed

                this.setVisible(false);
        new login().setVisible(true);
    }//GEN-LAST:event_cerrarbtActionPerformed

    private void historialbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialbt1ActionPerformed
             // TODO add your handling code here:
        String[] userData = query.getUserData(nombreUsuario); // Obtener los datos del usuario

    if (userData != null) {
        String nombre = userData[0]; // Nombre de usuario
        String correoElectronico = userData[1]; // Correo electrónico

        DatosPerfil perfil = new DatosPerfil(nombre, correoElectronico);
        perfil.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Error al cargar los datos del perfil.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_historialbt1ActionPerformed

    private void historialbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialbtActionPerformed
      listaPartidas listapartidas = new listaPartidas(nombreUsuario, idUsuario, this); // Pasa "this"
    listapartidas.llenarLista();
    listapartidas.setVisible(true);
    this.setVisible(false); // Oculta el JFrame actual temporalmente
    }//GEN-LAST:event_historialbtActionPerformed

    private void btnXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnXMouseClicked

    private void btnXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXMouseEntered
        // TODO add your handling code here:
        btnX.setForeground(new Color(255, 68, 87));
    }//GEN-LAST:event_btnXMouseEntered

    private void btnXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXMouseExited
        // TODO add your handling code here:
        btnX.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnXMouseExited

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseEntered
        // TODO add your handling code here:
        btnMinimize.setForeground(new Color(255, 68, 87));
    }//GEN-LAST:event_btnMinimizeMouseEntered

    private void btnMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseExited
        // TODO add your handling code here:
        btnMinimize.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnMinimizeMouseExited

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  try {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception ex) {
    ex.printStackTrace();
}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane agentes;
    private javax.swing.JPanel agentesPanel;
    private javax.swing.JLabel background;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnX;
    private javax.swing.JToggleButton cerrarbt;
    private javax.swing.JToggleButton historialbt;
    private javax.swing.JToggleButton historialbt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblACS;
    private javax.swing.JLabel lblAsistencias;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblKills;
    private javax.swing.JLabel lblMuertes;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRango;
    private javax.swing.JLabel lblRankIcon;
    private javax.swing.JLabel lblWinrate;
    private javax.swing.JScrollPane mapas;
    private javax.swing.JPanel mapasPanel;
    private javax.swing.JScrollPane roles;
    private javax.swing.JPanel rolesPanel;
    private javax.swing.JPanel seccionPerfil;
    private javax.swing.JPanel titleBar;
    // End of variables declaration//GEN-END:variables
}
