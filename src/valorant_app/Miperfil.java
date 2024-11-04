/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package valorant_app;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ramir
 */
public class Miperfil extends javax.swing.JFrame {
private String nombreUsuario;

    /**
     * Creates new form Miperfil
     */
    public Miperfil(String nombreUsuario) {
        FondoPanel fondo = new FondoPanel(); // Llama al constructor sin parámetros
    this.setContentPane(fondo);  // Configura el fondo del JFrame
    initComponents();            // Llama a initComponents para inicializar los componentes de la interfaz
    this.nombreUsuario = nombreUsuario;
    loadUserData();              // Cargar los datos del usuario
    this.setVisible(true);       // Asegúrate de que el JFrame es visible
    }
     private void loadUserData() {
        // Aquí puedes agregar la lógica para cargar los datos del usuario
        // Por ejemplo, mostrando el nombre de usuario en un JLabel
        jLabelNombreUsuario.setText("Bienvenido, " + nombreUsuario); // Asegúrate de que jLabelNombreUsuario no sea nulo
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        VerPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNombreUsuario.setForeground(new java.awt.Color(255, 0, 51));
        jLabelNombreUsuario.setText("Nombre de Usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Acceder a Mis Datos");

        VerPerfil.setText("Ver Mi Perfil");
        VerPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(VerPerfil))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(VerPerfil)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPerfilActionPerformed
        // Suponiendo que tienes un campo de texto para el nombre de usuario
        Miperfil miPerfil = new Miperfil(nombreUsuario);
        miPerfil.setVisible(true);
        this.dispose(); // Cerrar la ventana de inicio de sesión

        Query query = new Query(); // Crear una instancia de la clase Query
        String[] userData = query.getUserData(nombreUsuario); // Obtener los datos del usuario

        if (userData != null) {
            String nombre = userData[0]; // Nombre de usuario
            String correoElectronico = userData[1]; // Correo electrónico

            DatosPerfil perfil = new DatosPerfil(nombre, correoElectronico);
            perfil.setVisible(true);
            this.dispose(); // Cerrar la ventana actual si es necesario
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos del perfil.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_VerPerfilActionPerformed

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
            java.util.logging.Logger.getLogger(Miperfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Miperfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Miperfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Miperfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Miperfil("NombreUsuarioEjemplo").setVisible(true); // Cambiar por el nombre de usuario real
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VerPerfil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {
    private Image imagen;

    public FondoPanel() {
        // Cambia la ruta de acuerdo a la ubicación real de tu imagen en el paquete
        imagen = new ImageIcon(getClass().getResource("/imagenes/valorant1.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método de la superclase
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen ajustada al tamaño del panel
        setOpaque(false); // Configura el panel como transparente para mostrar la imagen
    }
}

}  //listo