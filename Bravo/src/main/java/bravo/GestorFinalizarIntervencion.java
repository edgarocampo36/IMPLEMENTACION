/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo;

import Intervencion.Dotacion;
import Intervencion.Intervencion;
import Sesion.Sesion;
import Sesion.Usuario;
import java.util.ArrayList;
import java.util.Date;


public class GestorFinalizarIntervencion {
    
    private VistaPrincipal ventana;
    private Sesion sesionActual;
    private Usuario usuarioLogueado;
    private ArrayList<Intervencion> listaIntervenciones;
    private ArrayList<Intervencion> intervencionesEnCursoOrdenadas;
    private Intervencion intervencionSeleccionada;
    private Date fechaHoraLlegada[];
    private float kilometrajeLlegada[];
    

    public GestorFinalizarIntervencion(Sesion sesionActual, Usuario usuarioLogueado, ArrayList<Intervencion> listIntervenciones) {
        this.sesionActual = sesionActual;
        this.usuarioLogueado = usuarioLogueado;
        this.listaIntervenciones = listIntervenciones;
    }

    public void setVentana(VistaPrincipal ventana) {
        this.ventana = ventana;
    }

    public ArrayList<Intervencion> getIntervencionesEnCursoOrdenadas() {
        return intervencionesEnCursoOrdenadas;
    }
    
    
    
    //metodo 3
    public ArrayList<Intervencion> opcionFinalizarIntervencion(Sesion sesion, Usuario usuario){
        //metodo 4
        if(validarUsuarioLogueado(sesion, usuario)){
            //metodo 9
            ArrayList<Intervencion> intervencionesEnCurso = buscarIntervencionesEnCurso(listaIntervenciones);

            //metodo 17
            intervencionesEnCursoOrdenadas = ordenarIntervencionesXFecha(intervencionesEnCurso);
            return intervencionesEnCursoOrdenadas;
        }
        return null;
    }
    
    //metodo 4
    public boolean validarUsuarioLogueado(Sesion sesion, Usuario usuario){
        return sesion.getUsuarioLogueado(usuario);
    }
    
    //metodo 9
    public ArrayList<Intervencion> buscarIntervencionesEnCurso(ArrayList<Intervencion> intervenciones){
        ArrayList<Intervencion> intervencionesEnCurso = new ArrayList<>();
        for (Intervencion i : intervenciones){
            //metodo 10
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
    public String[][] tomarSeleccionIntervencion(Intervencion intervencion){
        intervencionSeleccionada = intervencion;
        return buscarDotacionesAsociadasAIntervencion(intervencionSeleccionada);
    }
    
    //metodo 22
    public String[][] buscarDotacionesAsociadasAIntervencion(Intervencion intervencion){
        return intervencion.conocerDotacion();
    }
    
    //metodo 31
    public boolean tomarFechaHoraLlegadaYKilometraje(String fechaHora[], String kilometraje[]){
        int n = intervencionSeleccionada.getDotacion().size();
        fechaHoraLlegada = new Date[n];
        kilometrajeLlegada = new float[n];
        ConversorFecha conversor = new ConversorFecha();
        for (int i=0; i<n; i++){
            fechaHoraLlegada[i] = conversor.stringADate(fechaHora[i]);
            kilometrajeLlegada[i] = Float.valueOf(kilometraje[i]);
            ArrayList<Dotacion> dotaciones = intervencionSeleccionada.getDotacion();
            Dotacion dot = dotaciones.get(i);
            if(validarKilometrajeUnidad(dot, kilometrajeLlegada[i])){ //completar si ingresa mal datos
                if(validarFechaHoraLlegada(dot, fechaHoraLlegada[i])){
                }
            }
        }
        return true;
    }
    
    
    
    //metodo 32
    public boolean validarKilometrajeUnidad(Dotacion dotacion, float kilometraje){
         return dotacion.validarKilometrajeUnidad(kilometraje);
    }
    
    //metodo 33
    public boolean validarFechaHoraLlegada(Dotacion dotacion, Date fechaHora){
        return dotacion.validarFechaHoraLlegada(fechaHora);
    }
    
    //metodo 36
    public void confirmarFinalizacion(){
        Date fechaHoraActual = this.getFechaHoraActual();
        this.actualizarEstadoIntervencion(fechaHoraActual);
    }
    
    //metodo 37
    public Date getFechaHoraActual(){
        Date fechaActual = new Date(); //obtiene la fecha actual
        ConversorFecha conversor = new ConversorFecha();
        return conversor.formatoDate(fechaActual);
    }
    
    //metodo 39
    public void actualizarEstadoIntervencion(Date fechaHoraActual){
        intervencionSeleccionada.finalizar(fechaHoraActual, fechaHoraLlegada, kilometrajeLlegada);
    }
}
