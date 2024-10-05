/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Modelo.Alumno;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MOON
 */
public class Protecto_Transversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Connection con;
        con = Conexion.getConexion();
        
        Alumno franco = new Alumno(43953801, "Aguero", "Franco", new Date(2001, 12, 18), true);
        Alumno romeo = new Alumno(46408652, "Caruso", "Romeo", new Date(2005, 05, 27), true);        
        Alumno kevin = new Alumno(43123698, "Jofre", "Kevin", new Date(2000, 11, 11), true);
        
        try {
            
            String sql = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado) "
                    + "VALUES (43953801,'Aguero','Franco','2001-12-18',1)";
            
            String sql1 = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado) "
                    + "VALUES (46408652,'Caruso','Romeo','2005-05-27',1)";
            
            String sql2 = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado) "
                    + "VALUES (43123698,'Jofre','Kevin','2000-11-11',1)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL"+e.getMessage());
        }
        
        
            
                
    }
    
}