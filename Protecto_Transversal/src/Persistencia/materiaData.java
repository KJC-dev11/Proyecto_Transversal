/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Conexion;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author MOON
 */
public class materiaData {
    
    private Connection con = null;
    
    public materiaData (){
        con = Conexion.getConexion();
    }
    
    
    public void guardarMateria(Materia materia) throws SQLException{
        String sql = "INSERT INTO materia (nombre, estado) VALUES (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setBoolean(2, materia.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada con exito");
            }
            ps.close();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia: " + ex.getMessage());
        }
    }
    
    public Materia buscarMateria(int id){
        Materia materia = null;
                String sql = "SELECT nombre from materia where idMateria = ? AND activo = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe la materia");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia: " + ex.getMessage());
        }
        return materia;
    }
    
    public List<Materia> listarMaterias(){
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = 1";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setActivo(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia: "+ ex.getMessage());
        }
        return materias;
    }
    
    public void modificarMateria(Materia materia){
        String sql = "UPDATE materia SET nombre = ? WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getIdMateria());
            
            int exito = ps.executeUpdate();
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
            ps.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia: "+ ex.getMessage());
        }
    }
    
    public void eliminarMateria(int id){
        String sql = "UPDATE materia SET activo = 0 WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            
            if(fila ==1){
                JOptionPane.showMessageDialog(null, "Se elimino la materia");
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia: "+ ex.getMessage());
        }
    }
}
