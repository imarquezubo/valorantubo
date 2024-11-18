/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valorant_app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
 public boolean cambiarContrasena(String correo, String contrasenaActual, String nuevaContrasena) {
    boolean exito = false;
    
    try {
        // Establecer la conexión
        Connection con = getConnection();

        // Verificar que la contraseña actual sea correcta
        String verificarQuery = "SELECT * FROM jugador WHERE correo = ? AND contrasena = ?";  // Cambié 'jugadores' por 'jugador'
        PreparedStatement stmtVerificar = con.prepareStatement(verificarQuery);
        stmtVerificar.setString(1, correo);
        stmtVerificar.setString(2, contrasenaActual);
        
        ResultSet rs = stmtVerificar.executeQuery();

        if (rs.next()) {
            // Contraseña actual es correcta, ahora actualizar
            String actualizarQuery = "UPDATE jugador SET contrasena = ? WHERE correo = ?";  // Cambié 'jugadores' por 'jugador'
            PreparedStatement stmtActualizar = con.prepareStatement(actualizarQuery);
            stmtActualizar.setString(1, nuevaContrasena);
            stmtActualizar.setString(2, correo);
            int filasActualizadas = stmtActualizar.executeUpdate();

            if (filasActualizadas > 0) {
                exito = true;
            }
        }
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return exito;
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
    
    public int getNivel(String nombreUsuario){
        int nivel=0;
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT jugador.nivel FROM jugador WHERE jugador.nombre = '"+nombreUsuario+"';");
            resultado.next();
            nivel = Integer.parseInt(resultado.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return nivel;
    }
    
    public int getAsistenciasTotales(String nombreUsuario){
        int asistenciasTotales=0;
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT SUM(estadistica.Asistencias) FROM partida_jugador " +
                "INNER JOIN jugador ON jugador.id_jugador = partida_jugador.id_jugador " +
                "INNER JOIN partida ON partida.id_partida = partida_jugador.id_partida " +
                "INNER JOIN estadistica ON estadistica.id_estadistica = partida_jugador.id_estadistica " +
                "WHERE jugador.nombre = '"+nombreUsuario+"';");
            resultado.next();
            asistenciasTotales = Integer.parseInt(resultado.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return asistenciasTotales;
    }
    
    public int getKillsTotales(String nombreUsuario){
        int killsTotales=0;
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT SUM(estadistica.asesinatos) FROM partida_jugador " +
                "INNER JOIN jugador ON jugador.id_jugador = partida_jugador.id_jugador " +
                "INNER JOIN partida ON partida.id_partida = partida_jugador.id_partida " +
                "INNER JOIN estadistica ON estadistica.id_estadistica = partida_jugador.id_estadistica " +
                "WHERE jugador.nombre = '"+nombreUsuario+"';");
            resultado.next();
            killsTotales = Integer.parseInt(resultado.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return killsTotales;
    }
    
    public int getMuertesTotales(String nombreUsuario){
        int muertesTotales=0;
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT SUM(estadistica.Muertes) FROM partida_jugador " +
                "INNER JOIN jugador ON jugador.id_jugador = partida_jugador.id_jugador " +
                "INNER JOIN partida ON partida.id_partida = partida_jugador.id_partida " +
                "INNER JOIN estadistica ON estadistica.id_estadistica = partida_jugador.id_estadistica " +
                "WHERE jugador.nombre = '"+nombreUsuario+"';");
            resultado.next();
            muertesTotales = Integer.parseInt(resultado.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return muertesTotales;
    }
    
    public float getACSPromedio(String nombreUsuario){
        float acs=0;
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT AVG(estadistica.ACS) FROM partida_jugador " +
                "INNER JOIN jugador ON jugador.id_jugador = partida_jugador.id_jugador " +
                "INNER JOIN partida ON partida.id_partida = partida_jugador.id_partida " +
                "INNER JOIN estadistica ON estadistica.id_estadistica = partida_jugador.id_estadistica " +
                "WHERE jugador.nombre = '"+nombreUsuario+"';");
            resultado.next();
            acs = Float.parseFloat(resultado.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        return acs;
    }
    
    public int getWinrateTotal(String nombreUsuario){
        int winRate = 0;
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT ROUND(SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) / COUNT(*) *100,0)  as Winrate " +
                "FROM partida_jugador " +
                "INNER JOIN jugador ON jugador.id_jugador = partida_jugador.id_jugador " +
                "INNER JOIN partida ON partida.id_partida = partida_jugador.id_partida " +
                "INNER JOIN equipo ON equipo.id_equipo = partida_jugador.id_equipo " +
                "WHERE jugador.nombre = '"+nombreUsuario+"';");
            resultado.next();
            winRate = Integer.parseInt(resultado.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return winRate;
    }
    
    public String getRango(String nombreUsuario) {
        String rango="";
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT rango.nombre FROM jugador " +
                    "INNER JOIN rango ON rango.id_rango = jugador.id_rango " +
                    "WHERE jugador.nombre = 'PlayerOne';");
            resultado.next();
            rango = resultado.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return rango;
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
    
    
public void obtenerDetallesPartida(String idPartida, JTable tablaDetalles) {
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new String[]{"Nombre Jugador", "Equipo", "Agente", "Asesinatos", "Muertes", "Asistencias", "K/D", "ACS", "Puntaje Eco", "Primeros Asesinatos", "Plants", "Defusals"});
    tablaDetalles.setModel(model);

    // Aplicar el renderer personalizado a cada columna
    tablaDetalles.setDefaultRenderer(Object.class, new EquipoCellRenderer());

    conectar();
    try {
        String query = "SELECT j.nombre AS nombre_jugador, " +
                       "e.rol_equipo AS equipo, " +
                       "a.nombre AS agente, " +
                       "estadistica.asesinatos, " +
                       "estadistica.muertes, " +  
                       "estadistica.asistencias, " +
                       "estadistica.acs, " +
                       "estadistica.Puntaje_Eco, " +  
                       "estadistica.primeros_asesinatos, " +
                       "estadistica.plants, " +
                       "estadistica.Defuse " +  
                       "FROM partida_jugador pj " +
                       "INNER JOIN jugador j ON pj.id_jugador = j.id_jugador " +
                       "INNER JOIN equipo e ON pj.id_equipo = e.id_equipo " +
                       "INNER JOIN estadistica ON pj.id_estadistica = estadistica.id_estadistica " +
                       "INNER JOIN agente a ON estadistica.id_agente = a.id_agente " +
                       "WHERE pj.id_partida = ? " +
                       "ORDER BY e.rol_equipo";

        PreparedStatement ps = conexion.prepareStatement(query);
        ps.setString(1, idPartida);
        resultado = ps.executeQuery();

        while (resultado.next()) {
            String nombreJugador = resultado.getString("nombre_jugador");
            String equipo = resultado.getString("equipo");
            String agente = resultado.getString("agente");
            int asesinatos = resultado.getInt("asesinatos");
            int muertes = resultado.getInt("muertes");
            int asistencias = resultado.getInt("asistencias");
            double kdRatio = muertes != 0 ? (double) asesinatos / muertes : 0;  // Manejo de división por cero
            kdRatio = Math.round(kdRatio * 10) / 10.0;  // Redondeo a un decimal
            int acs = resultado.getInt("acs");
            int puntajeEco = resultado.getInt("Puntaje_Eco");
            int primerosAsesinatos = resultado.getInt("primeros_asesinatos");
            int plants = resultado.getInt("plants");
            int defuses = resultado.getInt("Defuse");

            model.addRow(new Object[]{nombreJugador, equipo, agente, asesinatos, muertes, asistencias, kdRatio, acs, puntajeEco, primerosAsesinatos, plants, defuses});
        }
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        cerrarConexion();
    }
}



// Define la clase EquipoCellRenderer fuera de obtenerDetallesPartida
class EquipoCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Obtener el valor de la columna 'Equipo' para la fila actual
        String equipo = table.getValueAt(row, 1).toString();
        
        // Cambiar color de fondo según el rol del equipo
        if (equipo.equalsIgnoreCase("Atacante")) {
            cell.setBackground(new Color(173, 216, 230)); // Celeste claro para atacantes
        } else if (equipo.equalsIgnoreCase("Defensor")) {
            cell.setBackground(new Color(255, 182, 193)); // Rojo claro para defensores
        } else {
            cell.setBackground(Color.WHITE); // Color blanco si el equipo no coincide con Atacante o Defensor
        }

        // Ajustar el color del texto para que sea visible
        cell.setForeground(Color.BLACK);
        
        return cell;
    }
}

    /*
    private void cerrarConexion() {
        try {
        if (resultado != null) resultado.close();
        if (instruccion != null) instruccion.close();
        if (conexion != null) conexion.close();
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }

    }*/
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
    
    
    public int numeroDePartidasDeUnUsuario(String nombreUsuario) {
        int numeroPartidas=0;
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT COUNT(*) FROM jugador " +
                    " INNER JOIN partida_jugador ON partida_jugador.id_jugador = jugador.id_jugador " +
                    " INNER JOIN partida ON partida.id_partida = partida_jugador.id_partida " +
                    " WHERE jugador.nombre = '"+nombreUsuario+"';");
            resultado.next();
            numeroPartidas = Integer.parseInt(resultado.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return numeroPartidas;
    }
    public int cantidadDeAgentesUsadosPorUsuario(String nombreUsuario) {
    int cantidadAgentes = 0;
    conectar();
    try {
        resultado = instruccion.executeQuery(
            "SELECT COUNT(DISTINCT agente.id_agente) " +
            "FROM jugador " +
            "INNER JOIN partida_jugador ON partida_jugador.id_jugador = jugador.id_jugador " +
            "INNER JOIN estadistica ON partida_jugador.id_estadistica = estadistica.id_estadistica " + // Se agrega la tabla estadistica
            "INNER JOIN agente ON estadistica.id_agente = agente.id_agente " + // Se usa la tabla estadistica para obtener el agente
            "WHERE jugador.nombre = '" + nombreUsuario + "';"
        );
        resultado.next();
        cantidadAgentes = Integer.parseInt(resultado.getString(1));
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }

    return cantidadAgentes;
}
    
    
    
    
    public ResultSet datosPartida(String nombreUsuario, int index){
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT mapa.id_mapa, mapa.nombre, tipo_partida.descripcion, agente.nombre, partida.fecha, equipo.rol_equipo, equipo.rondas_ganadas  FROM jugador " +
                " INNER JOIN partida_jugador ON partida_jugador.id_jugador = jugador.id_jugador " +
                " INNER JOIN partida ON partida.id_partida = partida_jugador.id_partida " +
                " INNER JOIN mapa ON mapa.id_mapa = partida.id_mapa " +
                " INNER JOIN tipo_partida ON tipo_partida.id_tipo_partida = partida.id_tipo_partida " +
                " INNER JOIN estadistica ON estadistica.id_estadistica = partida_jugador.id_estadistica " +
                " INNER JOIN agente ON agente.id_agente = estadistica.id_agente " +
                " INNER JOIN equipo ON equipo.id_equipo = partida_jugador.id_equipo " +
                " WHERE jugador.nombre = '"+nombreUsuario+"';");
            int x=1;
            while(x<=index){
                resultado.next();
                x++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
   public ResultSet agentesEst(String nombreUsuario, int index) {
    conectar();
    try {
        resultado = instruccion.executeQuery(
            "SELECT " +
                "agente.nombre AS Agente, " +
                "COUNT(partida_jugador.id_partida_jugador) AS Partidas, " +
                "SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) AS Victorias, " +
                "SUM(CASE WHEN equipo.rondas_ganadas < 13 THEN 1 ELSE 0 END) AS Derrotas, " +
                "ROUND(100 * SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) / COUNT(partida_jugador.id_partida_jugador), 2) AS Winrate " +
            "FROM " +
                "partida_jugador " +
            "INNER JOIN jugador ON partida_jugador.id_jugador = jugador.id_jugador " +
            "INNER JOIN estadistica ON partida_jugador.id_estadistica = estadistica.id_estadistica " +
            "INNER JOIN agente ON estadistica.id_agente = agente.id_agente " +
            "INNER JOIN equipo ON partida_jugador.id_equipo = equipo.id_equipo " +
            "WHERE " +
                "jugador.nombre = '" + nombreUsuario + "' " +
            "GROUP BY " +
                "agente.nombre " +
            "ORDER BY " +
                "Partidas DESC;"
        );

        int x = 1;
        while (x <= index) {
            resultado.next();
            x++;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }

    return resultado;
    }
   public ResultSet rolesEst(String nombreUsuario, int index) {
    conectar();
    try {
        resultado = instruccion.executeQuery(
            "SELECT " +
                "clase.nombre AS Rol, " +
                "COUNT(partida_jugador.id_partida_jugador) AS Partidas, " +
                "SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) AS Victorias, " +
                "SUM(CASE WHEN equipo.rondas_ganadas < 13 THEN 1 ELSE 0 END) AS Derrotas, " +
                "ROUND(100 * SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) / COUNT(partida_jugador.id_partida_jugador), 2) AS Winrate " +
            "FROM " +
                "partida_jugador " +
            "INNER JOIN jugador ON partida_jugador.id_jugador = jugador.id_jugador " +
            "INNER JOIN estadistica ON partida_jugador.id_estadistica = estadistica.id_estadistica " +
            "INNER JOIN agente ON estadistica.id_agente = agente.id_agente " +
            "INNER JOIN clase ON agente.id_clase = clase.id_clase " +
            "INNER JOIN equipo ON partida_jugador.id_equipo = equipo.id_equipo " +
            "WHERE " +
                "jugador.nombre = '" + nombreUsuario + "' " +
            "GROUP BY " +
                "clase.nombre " +
            "ORDER BY " +
                "Partidas DESC;"
        );

        int x = 1;
        while (x <= index) {
            resultado.next();
            x++;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }

    return resultado;
}
   
   public int cantidadDeRolesUsadosPorUsuario(String nombreUsuario) {
    int cantidadRoles = 0;
    conectar();
    try {
        resultado = instruccion.executeQuery(
            "SELECT COUNT(DISTINCT clase.id_clase) " +
            "FROM jugador " +
            "INNER JOIN partida_jugador ON partida_jugador.id_jugador = jugador.id_jugador " +
            "INNER JOIN estadistica ON partida_jugador.id_estadistica = estadistica.id_estadistica " +
            "INNER JOIN agente ON estadistica.id_agente = agente.id_agente " +
            "INNER JOIN clase ON agente.id_clase = clase.id_clase " + // Se usa la tabla clase para obtener el rol
            "WHERE jugador.nombre = '" + nombreUsuario + "';"
        );
        resultado.next();
        cantidadRoles = Integer.parseInt(resultado.getString(1));
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }

    return cantidadRoles;
}
   
   public ResultSet mapasEst(String nombreUsuario, int index) {
    conectar();
    try {
        resultado = instruccion.executeQuery(
            "SELECT " +
                "mapa.nombre AS Mapa, " +
                "COUNT(partida_jugador.id_partida_jugador) AS Partidas, " +
                "SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) AS Victorias, " +
                "SUM(CASE WHEN equipo.rondas_ganadas < 13 THEN 1 ELSE 0 END) AS Derrotas, " +
                "ROUND(100 * SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) / COUNT(partida_jugador.id_partida_jugador), 2) AS Winrate " +
            "FROM " +
                "partida_jugador " +
            "JOIN partida ON partida_jugador.id_partida = partida.id_partida " +
            "JOIN mapa ON partida.id_mapa = mapa.id_mapa " +
            "JOIN equipo ON partida_jugador.id_equipo = equipo.id_equipo " +
            "JOIN jugador ON partida_jugador.id_jugador = jugador.id_jugador " +
            "WHERE " +
                "jugador.nombre = '" + nombreUsuario + "' " +
            "GROUP BY " +
                "mapa.nombre " +
            "ORDER BY " +
                "Partidas DESC;"
        );

        int x = 1;
        while (x <= index) {
            resultado.next();
            x++;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }

    return resultado;
}

   public int cantidadDeMapasJugadosPorUsuario(String nombreUsuario) {
    int cantidadMapas = 0;
    conectar();
    try {
        resultado = instruccion.executeQuery(
            "SELECT COUNT(DISTINCT mapa.id_mapa) " +
            "FROM jugador " +
            "INNER JOIN partida_jugador ON partida_jugador.id_jugador = jugador.id_jugador " +
            "INNER JOIN partida ON partida_jugador.id_partida = partida.id_partida " +
            "INNER JOIN mapa ON partida.id_mapa = mapa.id_mapa " + // Se usa la tabla mapa para obtener los mapas
            "WHERE jugador.nombre = '" + nombreUsuario + "';"
        );
        resultado.next();
        cantidadMapas = Integer.parseInt(resultado.getString(1));
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }

    return cantidadMapas;
}
public ResultSet mejoresJugadores(int index) {
    conectar();
    try {
        resultado = instruccion.executeQuery(
            "SELECT " +
                "ROW_NUMBER() OVER (ORDER BY rango.id_rango DESC, " +
                "ROUND(100 * SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) / COUNT(partida_jugador.id_partida_jugador), 2) DESC) AS Posicion, " +
                "jugador.nombre AS Nombre, " +
                "COUNT(partida_jugador.id_partida_jugador) AS Partidas, " +
                "rango.nombre AS Rango, " +
                "ROUND(100 * SUM(CASE WHEN equipo.rondas_ganadas = 13 THEN 1 ELSE 0 END) / COUNT(partida_jugador.id_partida_jugador), 2) AS Winrate " +
            "FROM " +
                "jugador " +
            "JOIN " +
                "partida_jugador ON jugador.id_jugador = partida_jugador.id_jugador " +
            "JOIN " +
                "equipo ON partida_jugador.id_equipo = equipo.id_equipo " +
            "JOIN " +
                "rango ON jugador.id_rango = rango.id_rango " +
            "WHERE " +
                "rango.nombre <> 'Unranked' " + // Excluir jugadores unranked
            "GROUP BY " +
                "jugador.nombre, rango.nombre, rango.id_rango " +
            "ORDER BY " +
                "rango.id_rango DESC, Winrate DESC " +
            "LIMIT 10;"
        );
        int x = 1;
        while (x <= index) {
            resultado.next();
            x++;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
    }

    return resultado;
}

   /*
   
   public void llenarHistorial(JTable historial, String idJugador) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Mapa", "Modo", "Agente", "Fecha", "Rol del Equipo", "Rondas Ganadas", "Resultado", "Acción"});
        historial.setModel(model);

        conectar();
        try {
            String query = "SELECT " +
                           "partida.id_partida, " +
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
                String id = resultado.getString("id_partida");
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
            String idPartida = table.getValueAt(filaSeleccionada, 0).toString();
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


   */
   
}

    
      
