/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author MOON
 */
public class Inscripcion {
    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;
    private LocalDate fechaInscripcion;

    public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota, LocalDate fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Inscripcion(Alumno alumno, Materia materia, double nota, LocalDate fechaInscripcion) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Inscripcion() {
    }

    public Inscripcion(double nota) {
        this.nota = nota;
    }
    

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + ", fechaInscripcion=" + fechaInscripcion + '}';
    }
    
    

    
}
