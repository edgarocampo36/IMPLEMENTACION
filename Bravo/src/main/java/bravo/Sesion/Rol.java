/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.Sesion;

/**
 *
 * @author Edgar
 */
public class Rol {
    private String nombre;

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean esEncargadoDeGuardia(){
        return "Encargado de guardia".equals(nombre);     
    }
    
}
