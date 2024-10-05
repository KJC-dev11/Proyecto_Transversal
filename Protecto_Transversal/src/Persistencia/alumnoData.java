/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Conexion;
import java.sql.Connection;

/**
 *
 * @author MOON
 */
public class alumnoData {
    
    private Connection con=null;
    
    public alumnoData(){
        
        con = Conexion.getConexion();
    }
}
