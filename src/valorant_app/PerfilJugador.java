/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package valorant_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adolf
 */
public class PerfilJugador extends javax.swing.JFrame {
    Query query = new Query();
    String nombreUsuario;
    String idUsuario;

    /**
     * Creates new form PerfilJugador
     */
    public PerfilJugador() {
        initComponents();
    }
    public PerfilJugador(String nombreUsuario, String idUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        lblNombre.setText(nombreUsuario);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        agentes = new javax.swing.JScrollPane();
        agentesPanel = new javax.swing.JPanel();
        roles = new javax.swing.JScrollPane();
        rolesPanel = new javax.swing.JPanel();
        mapas = new javax.swing.JScrollPane();
        mapasPanel = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agentesPanel.setLayout(new javax.swing.BoxLayout(agentesPanel, javax.swing.BoxLayout.PAGE_AXIS));
        agentes.setViewportView(agentesPanel);

        jTabbedPane1.addTab("Agentes", agentes);

        rolesPanel.setLayout(new javax.swing.BoxLayout(rolesPanel, javax.swing.BoxLayout.PAGE_AXIS));
        roles.setViewportView(rolesPanel);

        jTabbedPane1.addTab("Roles", roles);

        mapasPanel.setLayout(new javax.swing.BoxLayout(mapasPanel, javax.swing.BoxLayout.PAGE_AXIS));
        mapas.setViewportView(mapasPanel);

        jTabbedPane1.addTab("Mapas", mapas);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("[name]");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerfilJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane agentes;
    private javax.swing.JPanel agentesPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JScrollPane mapas;
    private javax.swing.JPanel mapasPanel;
    private javax.swing.JScrollPane roles;
    private javax.swing.JPanel rolesPanel;
    // End of variables declaration//GEN-END:variables
}
