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
public class Nueva extends Estado{

    public Nueva() {
        super.setNombre("Nueva");
        super.setAmbito("Intervencion");
        super.setDescripcion("La intervencion se encuentra creada");
    }

    @Override
    public boolean esNueva(){
        return true;
    }
    
}
