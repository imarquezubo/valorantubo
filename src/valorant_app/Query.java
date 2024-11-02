/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valorant_app;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author isaia
 */
public class Query extends Conexion {

    public Query() {
    }

    Boolean comprobarExisteNombre(String nombre){
        Boolean comprobacion;
        conectar();
        String resultadoQuery="nulo";
        try {
            resultado = instruccion.executeQuery("SELECT nombre FROM jugador WHERE id_jugador = (SELECT id_jugador FROM jugador WHERE nombre='"+nombre+"');");
            resultado.next();
            resultadoQuery = resultado.getString(1);
        } catch (SQLException ex) {
            //Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(resultadoQuery.equals(nombre)){
            comprobacion=true;
        } else {
            comprobacion =false;
        }
        
        //JOptionPane.showMessageDialog(null, "ResultSet: "+res);
        return comprobacion;
    }
    
    Boolean comprobarExisteCorreo(String correo){
        Boolean comprobacion;
        conectar();
        String resultadoQuery = "nulo";
        try {
            resultado = instruccion.executeQuery("SELECT correo FROM jugador where id_jugador = (SELECT id_jugador FROM jugador WHERE correo = '"+correo+"');");
            resultado.next();
            resultadoQuery = resultado.getString(1);
        } catch (SQLException ex) {
            //Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null, "RsultSet(correo): "+res);
        if(resultadoQuery.equals(correo)){
            comprobacion=true;
        } else {
            comprobacion=false;
        }
        return comprobacion;
    }
    
    String getNombre(String nombre){
        conectar();
        try {
            resultado = instruccion.executeQuery("SELECT nombre FROM jugador" +
                " WHERE id_jugador = (" +
                " SELECT id_jugador FROM jugador" +
                " WHERE nombre = '"+nombre+"');");
            resultado.next();
            nombre = resultado.getString(1);
        } catch (SQLException ex) {
            //Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No existe el usuario");
            nombre = "";
        }
        
        return nombre;
    }
    
    
    
    String getPassword(String nombre){
        String password = null;
        try {
            conectar();
            resultado = instruccion.executeQuery("SELECT contrasena FROM jugador WHERE id_jugador = ( SELECT id_jugador FROM jugador WHERE nombre = '"+nombre+"');");
            resultado.next();
            password = resultado.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password;
    }
    
    void insertUsuario(String nombre, String correo, String password){
        conectar();
        try {
            instruccion.executeUpdate("INSERT INTO jugador(nombre,correo,contrasena) VALUES('"+nombre+"','"+correo+"','"+password+"');");
            JOptionPane.showMessageDialog(null, "¡Usuario creado con éxito!");
        } catch (SQLException ex) {
            //Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los datos, vuelva a intentarlo");
        }
        
    }
}
