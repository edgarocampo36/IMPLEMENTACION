/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion;

import java.util.Date;

/**
 *
 * @author Edgar
 */
public class Usuario {
    
    private String contrasenia;
    private Date fechaAlta;
    private String nombre;
    private Bombero bombero;

    public Usuario(String contrasenia, Date fechaAlta, String nombre) {
        this.contrasenia = contrasenia;
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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
    
    public boolean validarNombre(String nom){
        return nom.equals(nombre);
    }
    
    public boolean validarContrasenia(String contra){
        return contra.equals(contrasenia);
    }
    
}
