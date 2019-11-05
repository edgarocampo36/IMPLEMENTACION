/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.Sesion;

import java.util.Date;

/**
 *
 * @author Edgar
 */
public class Usuario {
    
    private String contraseña;
    private Date fechaAlta;
    private String nombre;
    private Bombero bombero;

    public Usuario(String contraseña, Date fechaAlta, String nombre) {
        this.contraseña = contraseña;
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getBombero() {
        return bombero.getRol();
    }
    
    
}
