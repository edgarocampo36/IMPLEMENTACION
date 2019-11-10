/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion;

/**
 *
 * @author Edgar
 */
public class Bombero {
    private boolean activo;
    private String nombre;
    private String apellido;
    private Usuario usuario;
    private Rol rol;

    public Bombero(boolean activo, String nombre, String apellido) {
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean getRol() {
        return rol.esEncargadoDeGuardia();
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
 
}
