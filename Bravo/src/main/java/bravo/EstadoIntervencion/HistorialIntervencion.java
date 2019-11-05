/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.EstadoIntervencion;

import java.util.Date;

/**
 *
 * @author Edgar
 */
public class HistorialIntervencion {
    
    private Date fechaHoraDesde;
    private Date fechaHoraHasta;
    private Estado estado;
    
    
    public HistorialIntervencion(Date fechaHora, Estado est) {
        fechaHoraDesde = fechaHora;
        estado = est;
    }

    public void setFechaHoraDesde(Date fechaHoraDesde) {
        this.fechaHoraDesde = fechaHoraDesde;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setFechaHoraHasta(Date fechaHoraHasta) {
        this.fechaHoraHasta = fechaHoraHasta;
    }

    public boolean esNueva() {
        return estado.esNueva();
    }

    public Date getFechaHoraDesde() {
        return fechaHoraDesde;
    }

    public Date getFechaHoraHasta() {
        return fechaHoraHasta;
    }

    public Estado getEstado() {
        return estado;
    }
    
}
