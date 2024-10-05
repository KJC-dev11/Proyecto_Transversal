package Persistencia;

import Modelo.Alumno;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class alumnoData {
    
    private Connection con = null;

    public alumnoData() {
        con = Conexion.getConexion(); // Llamamos a la conexión
    }

    // Método para guardar un alumno en la BD
    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, new Date(alumno.getFechaNacimiento().getTime())); // java.util.Date a java.sql.Date
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                System.out.println("Alumno añadido con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla Alumno: " + ex.getMessage());
        }
    }

    // Método para listar todos los alumnos activos
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumno WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getInt("idAlumno"),
                        rs.getInt("dni"),
                        rs.getString("apellido"),
                        rs.getString("nombre"),
                        rs.getDate("fechaNacimiento"),
                        rs.getBoolean("estado")
                );
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla Alumno: " + ex.getMessage());
        }
        return alumnos;
    }

    // Método para buscar un alumno por ID
    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumno WHERE idAlumno = ? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno(
                        rs.getInt("idAlumno"),
                        rs.getInt("dni"),
                        rs.getString("apellido"),
                        rs.getString("nombre"),
                        rs.getDate("fechaNacimiento"),
                        rs.getBoolean("estado")
                );
            } else {
                System.out.println("No existe el alumno con ID: " + id);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla Alumno: " + ex.getMessage());
        }
        return alumno;
    }

}
