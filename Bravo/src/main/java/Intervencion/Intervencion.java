/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intervencion;

import Intervencion.Dotacion;
import EstadoIntervencion.Estado;
import EstadoIntervencion.HistorialIntervencion;
import Sesion.Bombero;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Edgar
 */
public class Intervencion {
    private String domicilioReportado;
    private String resumenSiniestroInformante;
    private ArrayList<Dotacion> dotacion = new ArrayList<>(); 
    private ArrayList<HistorialIntervencion> historial = new ArrayList<>();
    private Bombero encargado;
    private Estado estado;

    public Intervencion(String domicilioReportado, String resumenSiniestroInformante, Estado estado) {
        this.domicilioReportado = domicilioReportado;
        this.resumenSiniestroInformante = resumenSiniestroInformante;
        this.estado = estado;
    }


    

    public void setDomicilioReportado(String domicilioReportado) {
        this.domicilioReportado = domicilioReportado;
    }

    public void setResumenSiniestroInformante(String resumenSiniestroInformante) {
        this.resumenSiniestroInformante = resumenSiniestroInformante;
    }

    public String getDomicilioReportado() {
        return domicilioReportado;
    }

    public String getResumenSiniestroInformante() {
        return resumenSiniestroInformante;
    }

    public ArrayList<Dotacion> getDotacion() {
        return dotacion;
    }

    public ArrayList<HistorialIntervencion> getHistorial() {
        return historial;
    }

    public Bombero getEncargado() {
        return encargado;
    }

    public void setDotacion(ArrayList<Dotacion> dotacion) {
        this.dotacion = dotacion;
    }

    public void setHistorial(ArrayList<HistorialIntervencion> historial) {
        this.historial = historial;
    }

    public void setEncargado(Bombero encargado) {
        this.encargado = encargado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
    
    public void agregarHistorialIntervencion(HistorialIntervencion nuevoHistorial){
        this.historial.add(nuevoHistorial);
    }
    
    public boolean estaEnCurso(){
        return estado.estaEnCurso();
    }
    
    //
    public boolean esNueva(){
        return estado.esNueva();
    }
    
    //
    public Date getFechaHoraSolicitud(){
        Date fechaCreacion = new Date();
        for(HistorialIntervencion h : historial){
            if(!h.esNueva()){
                fechaCreacion = h.getFechaHoraDesde();
            }
        }
        return fechaCreacion;
    }
    
    //metodo 23
    public String[][] conocerDotacion(){
        int n = dotacion.size();
        String matrizDotacion[][] = new String[n][3];
        int i = 0;
        for (Dotacion dot : dotacion){
            matrizDotacion[i][0] = Float.toString(dot.getKmUnidadAlSalir());
            String fechaHoraSalida = dot.getFechaHoraSalida().toString();
            matrizDotacion[i][1] = fechaHoraSalida;
            matrizDotacion[i][2] = dot.conocerUnidadMovil();
            i++;
        }
        return matrizDotacion;
    }
    
    //metodo 39
    public void finalizar(Date fechaHoraActual, Date fechaHoraLlegada[], float kilometrajeLlegada[]){
        estado.finalizar(fechaHoraActual, fechaHoraLlegada, kilometrajeLlegada, this);
        
    }
}
