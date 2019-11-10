/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoIntervencion;

/**
 *
 * @author Edgar
 */
public class Firmada extends Estado{

    public Firmada() {
        super.setNombre("Firmada");
        super.setAmbito("Intervencion");
        super.setDescripcion("La intervencion se encuentra firmada");
    }
    
    
}
