/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Alumno;
import Modelo.Conexion;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author MOON
 */
public class inscripcionData {
    private Connection con = null;
    private final materiaData matData;
    private final alumnoData aluData;
    
    public inscripcionData(){
        con = Conexion.getConexion();
        matData = new materiaData();
        aluData = new alumnoData(); 
    }
      public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO Inscripcion (idAlumno, idMateria, nota, fechaInscripcion) VALUES (?, ?, ?, ?);";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.setDate(4, java.sql.Date.valueOf(insc.getFechaInscripcion()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inscripción guardada correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la inscripción: " + e.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
  List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
                insc.setMateria(matData.buscarMateria(rs.getInt("idMateria")));
                insc.setFechaInscripcion(rs.getDate("fechaInscripcion").toLocalDate());
                insc.setNota(rs.getDouble("nota"));
                inscripciones.add(insc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + e.getMessage());
        }
        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT m.* FROM materia m JOIN inscripcion i ON m.idMateria = i.idMateria WHERE i.idAlumno = ? AND i.nota IS NOT NULL";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Materia materia = new Materia(rs.getInt("idMateria"), rs.getString("nombre"), rs.getInt("añoMateria"), rs.getBoolean("activo"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias cursadas: " + e.getMessage());
        }
        return materias;
    }

    public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Materia materia = new Materia(rs.getInt("idMateria"), rs.getString("nombre"), rs.getInt("añoMateria"), rs.getBoolean("activo"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias no cursadas: " + e.getMessage());
        }
        return materias;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la inscripción a eliminar");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la inscripción: " + e.getMessage());
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la inscripción a actualizar");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + e.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT a.* FROM alumno a JOIN inscripcion i ON a.idAlumno = i.idAlumno WHERE i.idMateria = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMateria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Alumno alumno = new Alumno(rs.getInt("idAlumno"), rs.getInt("dni"), rs.getString("apellido"), rs.getString("nombre"), rs.getDate("fechaNacimiento").toLocalDate(), rs.getBoolean("estado"));
                    alumnos.add(alumno);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumnos por materia: " + e.getMessage());
        }
        return alumnos;
    }
}
