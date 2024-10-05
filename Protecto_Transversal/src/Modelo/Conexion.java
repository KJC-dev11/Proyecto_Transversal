/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author MOON
 */
public class Conexion {
    private static final String url ="jdbc:mysql://localhost:3306/gestion_alumnos";
    private static final String usuario ="root";
    private static final String password ="";
    
    private static Connection conexion;
    
    private Conexion(){
        
    }
    
    public static Connection getConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(url, usuario, password);
                System.out.println("Conexión exitosa");
            } catch (SQLException e) {
                System.out.println("Error en la conexión: " + e.getMessage());
            }
        }
        return conexion;
    }
}
