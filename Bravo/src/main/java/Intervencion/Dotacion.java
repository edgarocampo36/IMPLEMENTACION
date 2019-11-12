/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intervencion;

import Intervencion.UnidadMovil;
import java.util.Date;

/**
 *
 * @author Edgar
 */
public class Dotacion {
    private Date fechaHoraSalida;
    private float kmUnidadAlSalir;
    private Date fechaHoraLlegada;
    private float kmUnidadAlVolver;
    private UnidadMovil unidadMovil;

    public Dotacion(Date fechaHoraSalida, UnidadMovil unidadMovil) {
        this.fechaHoraSalida = fechaHoraSalida;
        this.kmUnidadAlSalir = unidadMovil.getKilometraje();
        this.unidadMovil = unidadMovil;
    }

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }
    
    //metodo 25
    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    //metodo 24
    public float getKmUnidadAlSalir() {
        return kmUnidadAlSalir;
    }

    public float getKmUnidadAlVolver() {
        return kmUnidadAlVolver;
    }

    //metodo 39
    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setKmUnidadAlSalir(float kmUnidadAlSalir) {
        this.kmUnidadAlSalir = kmUnidadAlSalir;
    }

    //metodo 39
    public void setKmUnidadAlVolver(float kmUnidadAlVolver) {
        this.kmUnidadAlVolver = kmUnidadAlVolver;
        this.actualizarKmUnidadMovil(kmUnidadAlVolver);
    }
    
    //metodo 39
    public void actualizarKmUnidadMovil(float kilometraje){
        unidadMovil.setKilometraje(kilometraje);
    }

    public UnidadMovil getUnidadMovil() {
        return unidadMovil;
    }

    public void setUnidadMovil(UnidadMovil unidadMovil) {
        this.unidadMovil = unidadMovil;
    }
    
    //metodo 26
    public String conocerUnidadMovil(){
        return unidadMovil.getDominio();
    }
        
    //metodo 32
    public boolean validarKilometrajeUnidad(float kilometraje){
        return kilometraje>kmUnidadAlSalir;
    }
    
    //metodo 33
    public boolean validarFechaHoraLlegada(Date fechaHora){
        return fechaHora.after(fechaHoraSalida);
    }
    
}
