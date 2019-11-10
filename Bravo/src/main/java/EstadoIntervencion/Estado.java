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
    
    public boolean estaEnCurso(){
        return "En curso".equals(nombre);
    }
    
    public boolean esNueva(){
        return "Nueva".equals(nombre);
    }

    public void finalizar(Date fechaActual, Date[] fechaHoraLlegada, float[] kilometrajeLlegada, Intervencion aThis) {
        throw new UnsupportedOperationException("Funcion no soportada"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
