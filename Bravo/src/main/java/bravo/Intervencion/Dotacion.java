/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.Intervencion;

import java.util.Date;

/**
 *
 * @author Edgar
 */
public class Dotacion {
    private Date fechaHoraLlegada;
    private Date fechaHoraSalida;
    private float kmUnidadAlSalir;
    private float kmUnidadAlVolver;
    private UnidadMovil unidadMovil;

    public Dotacion(Date fechaHoraSalida, float kmUnidadAlSalir, UnidadMovil unidadMovil) {
        this.fechaHoraSalida = fechaHoraSalida;
        this.kmUnidadAlSalir = kmUnidadAlSalir;
        this.unidadMovil = unidadMovil;
    }

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public float getKmUnidadAlSalir() {
        return kmUnidadAlSalir;
    }

    public float getKmUnidadAlVolver() {
        return kmUnidadAlVolver;
    }

    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setKmUnidadAlSalir(float kmUnidadAlSalir) {
        this.kmUnidadAlSalir = kmUnidadAlSalir;
    }

    public void setKmUnidadAlVolver(float kmUnidadAlVolver) {
        this.kmUnidadAlVolver = kmUnidadAlVolver;
    }

    public UnidadMovil getUnidadMovil() {
        return unidadMovil;
    }

    public void setUnidadMovil(UnidadMovil unidadMovil) {
        this.unidadMovil = unidadMovil;
    }
    
    
    
}
