/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valorant_app;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author isaia
 */
public class Conexion {
    String user;
    String pass;
    String url;
    Connection conexion;
    Statement instruccion;
    ResultSet resultado;

    public Conexion() {
        this.user = "root";
        this.pass = "";
        this.url = "jdbc:mysql://localhost:3306/valorant_tracker";
    }
    
    void conectar(){
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            instruccion = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    void comprobarConexion(){
        try {
            conexion = DriverManager.getConnection(url,user,pass);
            JOptionPane.showMessageDialog(null,"Conexión a la base de datos con éxito");
        } catch (SQLException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
        }
    }
    
    
}
