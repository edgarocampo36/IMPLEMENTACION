/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.Sesion;

import java.util.Date;

/**
 *
 * @author Edgar
 */
public class Sesion {
    private Date dechaDesde;
    private Date fechaHasta;
    private Usuario usuario;

    public Sesion(Date dechaDesde, Usuario usuario) {
        this.dechaDesde = dechaDesde;
        this.usuario = usuario;
    }

    public Date getDechaDesde() {
        return dechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setDechaDesde(Date dechaDesde) {
        this.dechaDesde = dechaDesde;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean getUsuarioLogueado(Usuario usuario) {
       return usuario.getBombero();
    }
    
    
}
