/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo;

import bravo.Intervencion.Intervencion;
import bravo.Sesion.Sesion;
import bravo.Sesion.Usuario;
import java.util.ArrayList;


public class GestorFinalizarIntervencion {
    
    private Sesion sesionActual;
    private Usuario usuarioLogueado;

    public GestorFinalizarIntervencion(Sesion sesionActual, Usuario usuarioLogueado) {
        this.sesionActual = sesionActual;
        this.usuarioLogueado = usuarioLogueado;
    }
    
    //metodo 3
    public void opcionFinalizarIntervencion(Sesion sesion, Usuario usuario){

    }
    
    //metodo 4
    public boolean validarUsuarioLogueado(){
        return sesionActual.getUsuarioLogueado(usuarioLogueado);
    }
    
    //metodo 9
    public ArrayList<Intervencion> buscarIntervencionesEnCurso(ArrayList<Intervencion> intervenciones){
        ArrayList<Intervencion> intervencionesEnCurso = new ArrayList<>();
        for (Intervencion i : intervenciones){
            if(i.estaEnCurso()){
                intervencionesEnCurso.add(i);
            } 
        } 
        return intervencionesEnCurso;
    }
    
    //metodo 17
    public ArrayList<Intervencion> ordenarIntervencionesXFecha(ArrayList<Intervencion> intervenciones){
        for (int i = 0; i<intervenciones.size()-1; i++){
            Intervencion in1 = intervenciones.get(i);
            for(int j = 1; j<intervenciones.size(); j++){
                Intervencion in2 = intervenciones.get(j);
                if(in1.getFechaHoraSolicitud().compareTo(in2.getFechaHoraSolicitud()) > 0){ //si in1 es mayor que in2 se ordenan
                    intervenciones.set(i, in2);
                    intervenciones.set(j, in1);
                    in1 = in2;
                }
            }
        }
        return intervenciones;
    }
    
    //metodo 21
    public void tomarSeleccionIntervencion(){
        
    }
    
    //metodo 22
    
}
