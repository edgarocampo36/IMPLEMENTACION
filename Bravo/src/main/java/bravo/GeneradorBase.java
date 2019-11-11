package bravo;


import EstadoIntervencion.Abortada;
import EstadoIntervencion.Cancelada;
import EstadoIntervencion.Convocada;
import EstadoIntervencion.EnCurso;
import EstadoIntervencion.Estado;
import EstadoIntervencion.Finalizada;
import EstadoIntervencion.Firmada;
import EstadoIntervencion.HistorialIntervencion;
import EstadoIntervencion.Nueva;
import Intervencion.Dotacion;
import Intervencion.Intervencion;
import Intervencion.UnidadMovil;
import Sesion.Bombero;
import bravo.ConversorFecha;
import bravo.GestorFinalizarIntervencion;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class GeneradorBase {
    private ArrayList<Intervencion> intervenciones = new ArrayList<>();
    private ArrayList<Dotacion> dotaciones = new ArrayList<>();
    private ArrayList<UnidadMovil> unidadesMoviles = new ArrayList<>();
    private ArrayList<HistorialIntervencion> historial = new ArrayList<>(); 
    
    
    public GeneradorBase(){
        this.generarIntervenciones();
    }
    
    public void generarIntervenciones(){
        Date fechaHora = new Date();
        ConversorFecha conversor = new ConversorFecha();
        fechaHora = conversor.formatoDate(fechaHora);
        
        Estado estadoNueva = new Nueva();
        Estado estadoConvocada = new Convocada();
        Estado estadoEnCurso = new EnCurso();
        
        Date fechaHoraHasta = new Date();
        fechaHoraHasta = conversor.formatoDate(fechaHora);
        
        HistorialIntervencion historialNueva = new HistorialIntervencion(fechaHora, estadoNueva);
        historialNueva.setFechaHoraHasta(fechaHoraHasta);
        
        HistorialIntervencion historialConvocada = new HistorialIntervencion(fechaHora, estadoConvocada);
        historialConvocada.setFechaHoraHasta(fechaHoraHasta);
        
        HistorialIntervencion historialEnCurso = new HistorialIntervencion(fechaHora, estadoEnCurso);
        
        historial.add(historialNueva);
        historial.add(historialConvocada);
        historial.add(historialEnCurso);
        
        Bombero encargado = new Bombero(true, "Carlos", "Perez");
        Bombero encargado2 = new Bombero(true, "Pedro", "Gonzalez");
        
        //Generacion de las unidades moviles
        UnidadMovil unidad1 = new UnidadMovil("001", true, 100, 0);
        UnidadMovil unidad2 = new UnidadMovil("002", true, 10000, 1000);
        UnidadMovil unidad3 = new UnidadMovil("003", true, 8000, 8000);
        
        unidadesMoviles.add(unidad1);
        unidadesMoviles.add(unidad2);
        unidadesMoviles.add(unidad3);
        
        //Generacion de las dotaciones
        Dotacion dot1 = new Dotacion(fechaHora, unidadesMoviles.get(0));
        Dotacion dot2 = new Dotacion(fechaHora, unidadesMoviles.get(1));
        Dotacion dot3 = new Dotacion(fechaHora, unidadesMoviles.get(2));
        
        dotaciones.add(dot1);
        dotaciones.add(dot2);
        dotaciones.add(dot3);
        
        //Generacion de intervenciones
        Intervencion intervencion = new Intervencion("Colon 3008", "Incendio de Edificio", estadoEnCurso);
        intervencion.setHistorial(historial);
        intervencion.setEncargado(encargado);
        intervencion.setDotacion(dotaciones);
        
        Intervencion intervencion2 = new Intervencion("General Paz 3008", "Incendio de Edificio", estadoEnCurso);
        intervencion2.setHistorial(historial);
        intervencion2.setEncargado(encargado2);
        intervencion2.setDotacion(dotaciones);
        
        Intervencion intervencion3 = new Intervencion("Tucuman 308", "Incendio de Edificio", estadoEnCurso);
        intervencion3.setHistorial(historial);
        intervencion3.setEncargado(encargado);
        intervencion3.setDotacion(dotaciones);
        
        Intervencion intervencion4 = new Intervencion("Sucre 208", "Incendio de Edificio", new Firmada());
        Intervencion intervencion5 = new Intervencion("Sarmiento 1008", "Incendio de Edificio", new Abortada());
        Intervencion intervencion6 = new Intervencion("Chacabuco 800", "Incendio de Edificio", new Finalizada());
        Intervencion intervencion7 = new Intervencion("San Martin 310", "Incendio de Edificio", new Convocada());
        Intervencion intervencion8 = new Intervencion("Belgrano 400", "Incendio de Edificio", new Cancelada());
        Intervencion intervencion9 = new Intervencion("Colon 302", "Incendio de Edificio", new Convocada());
        Intervencion intervencion10 = new Intervencion("Santa Fe 808", "Incendio de Edificio", new Nueva());
        intervenciones.add(intervencion);
        intervenciones.add(intervencion2);
        intervenciones.add(intervencion3);
        intervenciones.add(intervencion4);
        intervenciones.add(intervencion5);
        intervenciones.add(intervencion6);
        intervenciones.add(intervencion7);
        intervenciones.add(intervencion8);
        intervenciones.add(intervencion9);
        intervenciones.add(intervencion10);
    }

    public ArrayList<Intervencion> getIntervenciones() {
        return intervenciones;
    }
    
    
}
