/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.Intervencion;

import bravo.EstadoIntervencion.Estado;
import bravo.EstadoIntervencion.HistorialIntervencion;
import bravo.Sesion.Bombero;
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
    private ArrayList<Bombero> encargado = new ArrayList<>();
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

    public ArrayList<Bombero> getEncargado() {
        return encargado;
    }

    public void setDotacion(ArrayList<Dotacion> dotacion) {
        this.dotacion = dotacion;
    }

    public void setHistorial(ArrayList<HistorialIntervencion> historial) {
        this.historial = historial;
    }

    public void setEncargado(ArrayList<Bombero> encargado) {
        this.encargado = encargado;
    }
    
    public boolean estaEnCurso(){
        return estado.estaEnCurso();
    }
    
    public boolean esNueva(){
        return estado.esNueva();
    }
    public Date getFechaHoraSolicitud(){
        Date fechaCreacion = new Date();
        for(HistorialIntervencion h : historial){
            if(!h.esNueva()){
                fechaCreacion = h.getFechaHoraDesde();
            }
        }
        return fechaCreacion;
    }
    
    
    
}
