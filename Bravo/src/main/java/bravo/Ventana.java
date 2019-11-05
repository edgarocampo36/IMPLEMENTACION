/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo;

import Interfaz.TablaIntervenciones;
import bravo.Intervencion.Intervencion;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Edgar
 */
public class Ventana extends JFrame{
    
    public Ventana() {

        super("Bravo - Finalizar Intervencion");
        
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//-- METODO MAIN
    public static void main(String[] ARGS) {
        
        GestorFinalizarIntervencion gestor = new GestorFinalizarIntervencion();
        ArrayList<Intervencion> intervenciones = new ArrayList<>();
        TablaIntervenciones t1 = new TablaIntervenciones(intervenciones);
    }
}


