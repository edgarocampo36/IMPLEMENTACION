/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoIntervencion;

import Intervencion.Dotacion;
import Intervencion.Intervencion;
import java.util.ArrayList;
import java.util.Date;

public class EnCurso extends Estado{

    public EnCurso() {
        super.setNombre("En Curso");
        super.setAmbito("Intervencion");
        super.setDescripcion("La intervencion se encuentra en curso");
    }
    
    
    @Override
    public void finalizar(Date fechaHoraActual, Date fechaHoraLlegada[], float kilometrajeLlegada[], Intervencion intervencion){
        ArrayList<Dotacion> dotaciones = intervencion.getDotacion();
        ArrayList<HistorialIntervencion> historial = intervencion.getHistorial();
        this.buscarHistorialActual(historial, fechaHoraActual); //finaliza el historialIntervencion actual
        for(int i=0; i<dotaciones.size(); i++){ //actualiza la fecha y hora y kilometraje de cada dotacion de la intervencion
            dotaciones.get(i).setFechaHoraLlegada(fechaHoraLlegada[i]);
            dotaciones.get(i).setKmUnidadAlVolver(kilometrajeLlegada[i]);
        }
        Estado nuevoEstado = crearProximoEstado();
        HistorialIntervencion nuevoHistorialIntervencion = crearNuevoHistorial(fechaHoraActual, nuevoEstado);
        intervencion.agregarHistorialIntervencion(nuevoHistorialIntervencion);
        intervencion.setEstado(nuevoEstado);
        
    }
        
    public void buscarHistorialActual(ArrayList<HistorialIntervencion> historial, Date fechaHoraActual){
        for(HistorialIntervencion h : historial){
            if(h.esActual()){
                h.setFechaHoraHasta(fechaHoraActual);
                break;
            }
        }
    }
        
    public Estado crearProximoEstado(){
        return new Finalizada();
    }
    
    public HistorialIntervencion crearNuevoHistorial(Date fechaHora, Estado estado){
        return new HistorialIntervencion(fechaHora, estado);
    }
}
