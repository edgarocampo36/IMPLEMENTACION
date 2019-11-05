/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.EstadoIntervencion;

/**
 *
 * @author Edgar
 */
public class Abortada extends Estado {

    public Abortada() {
        super.setNombre("Abortada");
        super.setAmbito("Intervencion");
        super.setDescripcion("La intervencion se encuentra fue abortada");
    }
    
    
    
}
