/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intervencion;

/**
 *
 * @author Edgar
 */
public class UnidadMovil {
    private String dominio;
    private boolean habilitada;
    private float kilometraje;
    private float kilometrajeInicial;

    public UnidadMovil(String dominio, boolean habilitada, float kilometraje, float kilometrajeInicial) {
        this.dominio = dominio;
        this.habilitada = habilitada;
        this.kilometraje = kilometraje;
        this.kilometrajeInicial = kilometrajeInicial;
    }
    
    //metodo 27
    public String getDominio() {
        return dominio;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public float getKilometraje() {
        return kilometraje;
    }

    public float getKilometrajeInicial() {
        return kilometrajeInicial;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public void setKilometraje(float kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setKilometrajeInicial(float kilometrajeInicial) {
        this.kilometrajeInicial = kilometrajeInicial;
    }
    
}
