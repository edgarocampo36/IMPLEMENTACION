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
public class Cancelada extends Estado{

    public Cancelada() {
        super.setNombre("Cancelada");
        super.setAmbito("Intervencion");
        super.setDescripcion("La intervencion fue cancelada");
    }
    
    
}
