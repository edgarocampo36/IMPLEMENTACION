/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.EstadoIntervencion;

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
    
}
