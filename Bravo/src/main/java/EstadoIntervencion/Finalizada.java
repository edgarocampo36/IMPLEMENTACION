/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoIntervencion;

import EstadoIntervencion.Estado;

/**
 *
 * @author Edgar
 */
public class Finalizada extends Estado{

    public Finalizada() {
        super.setNombre("Finalizada");
        super.setAmbito("Intervencion");
        super.setDescripcion("La intervencion se encuentra finalizada");
    }
    
}
