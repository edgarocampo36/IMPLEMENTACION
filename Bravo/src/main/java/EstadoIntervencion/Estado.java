/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoIntervencion;

import Intervencion.Intervencion;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Edgar
 */
public abstract class Estado {
    private String ambito;
    private String descripcion;
    private String nombre;
   
    public void abortar(){
        
    }
    
    public void cancelar(){
        
    }
    
    public void finalizar(){
        
    }
    
    public void firmar(){
        
    }
    
    public void iniciar(){
        
    }
    
    public void notificar(){
        
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmbito() {
        return ambito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    //metodo 11
    public boolean estaEnCurso(){
        return false;
    }
    
    public boolean esNueva(){
        return false;
    }

    public void finalizar(Date fechaActual, Date[] fechaHoraLlegada, float[] kilometrajeLlegada, Intervencion aThis) {
        throw new UnsupportedOperationException("Funcion no soportada"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
