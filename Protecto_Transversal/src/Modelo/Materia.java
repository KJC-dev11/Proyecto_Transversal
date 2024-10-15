/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author MOON
 */
public class Materia {
    private int idMateria;
    private String nombre;
    private int añoMateria;
    private boolean activo;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int añoMateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.añoMateria = añoMateria;
        this.activo = activo;
    }

    public Materia(String nombre, int añoMateria, boolean activo) {
        this.nombre = nombre;
        this.añoMateria = añoMateria;
        this.activo = activo;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoMateria() {
        return añoMateria;
    }

    public void setAñoMateria(int añoMateria) {
        this.añoMateria = añoMateria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Materia: " + nombre + " (Año: " + añoMateria + ")";
    }
    
    
            
    
}
