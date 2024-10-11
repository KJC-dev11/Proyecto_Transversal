/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author MOON
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String DB="gestion_alumnos";
    private static final String USUARIO ="root";
    private static final String PASSWORD ="";
    
    private static Connection conexion;
    
    private Conexion(){
        
    }
    
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL + DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC", USUARIO, PASSWORD);
                JOptionPane.showMessageDialog(null, "Conexión exitosa a la base de datos");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers: " + ex.getMessage());
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Error al conectarse a la BD: " + ex.getMessage());
            }
        }
        return conexion;
    }
}
