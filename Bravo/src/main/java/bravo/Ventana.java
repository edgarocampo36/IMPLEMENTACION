/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo;

import Interfaz.TablaIntervenciones;
import Intervencion.Intervencion;
import Sesion.Sesion;
import Sesion.Usuario;
import java.util.ArrayList;
import java.util.Date;
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
        
        String user = "bombero";
        String contrasenia = "123456";
        Date fechaActual = new Date();
        Usuario usuarioActual = new Usuario(contrasenia, fechaActual, user);
        Sesion sesionActual = new Sesion(fechaActual, usuarioActual);
        
        //Se cargan las intervenciones en memoria
        GeneradorBase generador = new GeneradorBase();
        ArrayList<Intervencion> intervenciones = generador.getIntervenciones();
        
        GestorFinalizarIntervencion gestor = new GestorFinalizarIntervencion(sesionActual, usuarioActual);
        
        //TablaIntervenciones t1 = new TablaIntervenciones(intervenciones);
        
    }
    
    //metodo 28
    public void mostrarDatosObtenidosDotacion(String matrizDotacion[][]){
        int i = 0;
        int j = 0;
        while(matrizDotacion[i][j] != null){
            System.out.println("Dotacion "+(i+1)+":");
            while(matrizDotacion[i][j] != null){
                System.out.println(matrizDotacion[i][j]);
                j++;
            }
            i++;
        }
    }
    
    //medoto 29
    public void solicitarFechaHoraLLegadaYKilometraje(){
        
    }
    
    //metodo 30
    public void tomarFechaHoraLlegadaYKilometraje(){
        
    }
    
    //metodo 34
    public void solicitarConfirmacionFinalizacion(){
        
    }
    
    //metodo 35
    public void confirmarFinalizacion(){
        
    }
    
}


