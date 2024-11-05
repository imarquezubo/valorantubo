/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valorant_app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author isaia
 */
public class Query extends Conexion {

    public Query() {
    }

    Boolean comprobarExisteNombre(String nombre){
        Boolean comprobacion = false;
        conectar();
        try {
            String query = "SELECT COUNT(*) FROM jugador WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombre);
            resultado = ps.executeQuery();
            
            if (resultado.next() && resultado.getInt(1) > 0) {
                comprobacion = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return comprobacion;
    }
    
    Boolean comprobarExisteCorreo(String correo){
        Boolean comprobacion = false;
        conectar();
        try {
            String query = "SELECT COUNT(*) FROM jugador WHERE correo = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, correo);
            resultado = ps.executeQuery();
            
            if (resultado.next() && resultado.getInt(1) > 0) {
                comprobacion = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        //JOptionPane.showMessageDialog(null, "RsultSet(correo): "+res);
        
        return comprobacion;
    }
    
    String getNombre(String nombre){
        conectar();
        try {
            String query = "SELECT nombre FROM jugador WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombre);
            resultado = ps.executeQuery();
            
            if (resultado.next()) {
                nombre = resultado.getString(1);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
                nombre = "";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return nombre;
    }
    
    
    
    String getPassword(String nombre){
        String password = null;
        conectar();
        try {
            String query = "SELECT contrasena FROM jugador WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombre);
            resultado = ps.executeQuery();
            
            if (resultado.next()) {
                password = resultado.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return password;
    }
    
    public void insertUsuario(String nombre, String correo, String password) {
    conectar();
    try {
        // Establecer el id_rango para "Unranked" a 9
        int idRangoUnranked = 9; // Cambia esto a 9 para que corresponda con "Unranked"
        String query = "INSERT INTO jugador(nombre, correo, contrasena, nivel, id_rango) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, nombre);
        ps.setString(2, correo);
        ps.setString(3, password);
        ps.setInt(4, 1); // Nivel 1
        ps.setInt(5, idRangoUnranked); // ID del rango "Unranked"
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "¡Usuario creado con éxito!");
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos, vuelva a intentarlo");
    } finally {
        cerrarConexion();
    }
}

    String getCorreo(String nombreUsuario) {
       String correo = "";
        conectar();
        try {
            String query = "SELECT correo FROM jugador WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombreUsuario);
            resultado = ps.executeQuery();
            
            if (resultado.next()) {
                correo = resultado.getString("correo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return correo;
    }
    // Método nuevo para obtener datos del usuario
    public String[] getUserData(String nombreUsuario) {
        String[] userData = new String[4]; // Ahora almacenamos nombre, correo, nivel y rango
    conectar();
    try {
        // Asegúrate de que tu tabla 'jugador' tiene una columna para el nivel y un rango asociado
        String query = "SELECT j.nombre, j.correo, j.nivel, r.nombre AS rango " +
                       "FROM jugador j INNER JOIN rango r ON j.id_rango = r.id_rango " +
                       "WHERE j.nombre = ?";
        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, nombreUsuario);
        resultado = ps.executeQuery();

        if (resultado.next()) {
            userData[0] = resultado.getString("nombre"); // Nombre de usuario
            userData[1] = resultado.getString("correo"); // Correo electrónico
            userData[2] = resultado.getString("nivel"); // Nivel del jugador
            userData[3] = resultado.getString("rango"); // Rango del jugador
        } else {
            // Usuario no encontrado
            userData = null;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        cerrarConexion();
    }
    return userData; // Retorna el array con los datos
    }
    public void llenarHistorial(JTable historial, String idJugador) {
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new String[]{"ID", "Mapa", "Modo", "Agente", "Fecha", "Rol del Equipo", "Rondas Ganadas", "Resultado", "Acción"});
    historial.setModel(model);

    conectar();
    try {
        String query = "SELECT " +
                       "jugador.id_jugador, " +
                       "mapa.nombre AS mapa, " +
                       "tipo_partida.descripcion AS modo, " +
                       "agente.nombre AS agente, " +
                       "partida.fecha, " +
                       "equipo.rol_equipo, " +
                       "equipo.rondas_ganadas " +
                       "FROM " +
                       "partida_jugador " +
                       "INNER JOIN jugador ON jugador.id_jugador = partida_jugador.id_jugador " +
                       "INNER JOIN partida ON partida.id_partida = partida_jugador.id_partida " +
                       "INNER JOIN mapa ON mapa.id_mapa = partida.id_mapa " +
                       "INNER JOIN tipo_partida ON tipo_partida.id_tipo_partida = partida.id_tipo_partida " +
                       "INNER JOIN estadistica ON estadistica.id_estadistica = partida_jugador.id_estadistica " +
                       "INNER JOIN agente ON agente.id_agente = estadistica.id_agente " +
                       "INNER JOIN equipo ON equipo.id_equipo = partida_jugador.id_equipo " +
                       "WHERE jugador.id_jugador = ?";

        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, idJugador);
        resultado = ps.executeQuery();

        while (resultado.next()) {
            String id = resultado.getString("id_jugador");
            String mapa = resultado.getString("mapa");
            String modo = resultado.getString("modo");
            String agente = resultado.getString("agente");
            String fecha = resultado.getString("fecha");
            String rolEquipo = resultado.getString("rol_equipo");
            int rondasGanadas = resultado.getInt("rondas_ganadas");
            String resultadoPartida = (rolEquipo.equals("Atacante") && rondasGanadas >= 13) || 
                                      (rolEquipo.equals("Defensor") && rondasGanadas >= 13) ? "Victoria" : "Derrota";

            // Agrega una fila con un botón
            model.addRow(new Object[]{id, mapa, modo, agente, fecha, rolEquipo, rondasGanadas, resultadoPartida, "Ver Detalles"});
        }
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        cerrarConexion();
    }
    

    // Agrega un TableCellRenderer y TableCellEditor para la columna de botones
    historial.getColumn("Acción").setCellRenderer(new ButtonRenderer());
    historial.getColumn("Acción").setCellEditor(new ButtonEditor(new JCheckBox(), historial));
}
public void obtenerDetallesPartida(String idPartida, JTable tablaDetalles) {
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new String[]{"Nombre Jugador", "Equipo", "Agente", "Asesinatos", "Muertes", "Asistencias", "ACS", "Puntaje Eco", "Primeros Asesinatos", "Plants", "Defusals"});
    tablaDetalles.setModel(model);

    conectar();
    try {
        String query = "SELECT j.nombre AS nombre_jugador, " +
                       "e.rol_equipo AS equipo, " +
                       "a.nombre AS agente, " +
                       "estadistica.asesinatos, " +
                       "estadistica.muertes, " +  // Asegúrate de que este nombre sea correcto
                       "estadistica.asistencias, " +
                       "estadistica.acs, " +
                       "estadistica.Puntaje_Eco, " +  // Verifica que sea 'Puntaje_Eco'
                       "estadistica.primeros_asesinatos, " +
                       "estadistica.plants, " +
                       "estadistica.Defuse " +  // Cambia 'defuses' por 'Defuse'
                       "FROM partida_jugador pj " +
                       "INNER JOIN jugador j ON pj.id_jugador = j.id_jugador " +
                       "INNER JOIN equipo e ON pj.id_equipo = e.id_equipo " +
                       "INNER JOIN estadistica ON pj.id_estadistica = estadistica.id_estadistica " +
                       "INNER JOIN agente a ON estadistica.id_agente = a.id_agente " +
                       "WHERE pj.id_partida = ?";

        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, idPartida); // Asegúrate de que aquí estés usando el ID correcto
        resultado = ps.executeQuery();

        while (resultado.next()) {
            String nombreJugador = resultado.getString("nombre_jugador");
            String equipo = resultado.getString("equipo");
            String agente = resultado.getString("agente");
            int asesinatos = resultado.getInt("asesinatos");
            int muertes = resultado.getInt("muertes");
            int asistencias = resultado.getInt("asistencias");
            int acs = resultado.getInt("acs");
            int puntajeEco = resultado.getInt("Puntaje_Eco");
            int primerosAsesinatos = resultado.getInt("primeros_asesinatos");
            int plants = resultado.getInt("plants");
            int defuses = resultado.getInt("Defuse");

            model.addRow(new Object[]{nombreJugador, equipo, agente, asesinatos, muertes, asistencias, acs, puntajeEco, primerosAsesinatos, plants, defuses});
        }
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        cerrarConexion();
    }
}
    class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "Ver Detalles" : value.toString());
        return this;
    }
}
class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private boolean clicked;
    private JTable table;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        this.table = table;
        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    // Asegúrate de que la columna 0 tenga el ID de la partida
                    String idPartida = table.getValueAt(filaSeleccionada, 0).toString();
                    System.out.println("ID de partida seleccionado: " + idPartida); // Agregar depuración

                    Query query = new Query();
                    JTable tablaDetalles = new JTable();
                    query.obtenerDetallesPartida(idPartida, tablaDetalles);

                    JFrame detallesFrame = new JFrame("Detalles de la Partida");
                    detallesFrame.setSize(800, 240);
                    detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    JPanel panel = new JPanel() {
                        private Image backgroundImage = Toolkit.getDefaultToolkit().getImage("imagenes/valooo3.png");

                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                        }
                    };
                    panel.setLayout(new BorderLayout());
                    
                    JScrollPane scrollPane = new JScrollPane(tablaDetalles);
                    panel.add(scrollPane, BorderLayout.CENTER);

                    detallesFrame.add(panel);
                    detallesFrame.setVisible(true);
                }
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "Ver Detalles" : value.toString();
        button.setText(label);
        clicked = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (clicked) {
            // Aquí puedes manejar acciones adicionales si es necesario
            clicked = false;
        }
        return label;
    }

    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}


    
    
    private void cerrarConexion() {
        try {
        if (resultado != null) resultado.close();
        if (instruccion != null) instruccion.close();
        if (conexion != null) conexion.close();
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    String obtenerIdJugador(String nombre) {
        String idJugador = "";
        conectar();
        try {
            String query = "SELECT id_jugador FROM jugador WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombre);
            resultado = ps.executeQuery();

            if (resultado.next()) {
                idJugador = resultado.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return idJugador;
    }
    
}
    
      
