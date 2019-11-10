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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class GestorFinalizarIntervencion {
    
    private Sesion sesionActual;
    private Usuario usuarioLogueado;
    private Intervencion intervencionSeleccionada;
    private Date fechaHoraLlegada[];
    private float kilometrajeLlegada[];

    public GestorFinalizarIntervencion(Sesion sesionActual, Usuario usuarioLogueado) {
        this.sesionActual = sesionActual;
        this.usuarioLogueado = usuarioLogueado;
    }
    
    //metodo 3
    public ArrayList<Intervencion> opcionFinalizarIntervencion(Sesion sesion, Usuario usuario, ArrayList<Intervencion> intervenciones){
        if(validarUsuarioLogueado()){
            ArrayList<Intervencion> intervencionesEnCurso = buscarIntervencionesEnCurso(intervenciones);
            ArrayList<Intervencion> intervencionesOrdenadas = ordenarIntervencionesXFecha(intervencionesEnCurso);
            return intervencionesOrdenadas;
        }
        return  null;
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
        for (int i=0; i<n; i++){
            fechaHoraLlegada[i] = parseFecha(fechaHora[i]);
            kilometrajeLlegada[i] = Float.valueOf(kilometraje[i]);
            ArrayList<Dotacion> dotaciones = intervencionSeleccionada.getDotacion();
            Dotacion dot = dotaciones.get(i);
            //dot.tomarFechaHoraLlegadaYKilometraje(fechaHoraLlegada,kilometrajeLlegada); REVISAR
            if(validarKilometrajeUnidad(dot, kilometrajeLlegada[i])){
                if(validarFechaHoraLlegada(dot, fechaHoraLlegada[i])){
                    continue;
                }
            }
        }
        return true;
    }
    
    public static Date parseFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
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
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy"); //Formateador de fecha
        String fechaString = formato.format(fechaActual); //formatea la fecha actual y devuelve un string
        try {
            fechaActual = formato.parse(fechaString); //convierte la fecha en string a un Date
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaActual;
    }
    
    //metodo 39
    public void actualizarEstadoIntervencion(Date fechaHoraActual){
        intervencionSeleccionada.finalizar(fechaHoraActual, fechaHoraLlegada, kilometrajeLlegada);
    }
}
