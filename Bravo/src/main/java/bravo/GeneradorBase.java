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
import Sesion.*;

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
    private ArrayList<Bombero> encargados = new ArrayList<>();
    private Usuario usuarioActual;

    
    
    public GeneradorBase(){
        this.generarIntervenciones();
    }
    
    public void generarIntervenciones(){
        Date fechaHora1, fechaHora2, fechaHora3;
        ConversorFecha conversor = new ConversorFecha();
        fechaHora1 = conversor.stringADate("10:00:00 11/10/2019");
        fechaHora2 = conversor.stringADate("09:00:00 08/11/2019");
        fechaHora3 = conversor.stringADate("11:00:00 10/10/2019");

        //creacion estados de historiales
        Estado estadoNueva = new Nueva();
        Estado estadoConvocada = new Convocada();
        Estado estadoEnCurso = new EnCurso();
        
        Date fechaHoraHasta = new Date();
        fechaHoraHasta = conversor.formatoDate(fechaHoraHasta);

        //Creacion de historiales de estado EsNueva
        HistorialIntervencion historialNueva1 = new HistorialIntervencion(fechaHora1, estadoNueva);
        historialNueva1.setFechaHoraHasta(fechaHoraHasta);
        HistorialIntervencion historialNueva2 = new HistorialIntervencion(fechaHora2, estadoNueva);
        historialNueva2.setFechaHoraHasta(fechaHoraHasta);
        HistorialIntervencion historialNueva3 = new HistorialIntervencion(fechaHora3, estadoNueva);
        historialNueva3.setFechaHoraHasta(fechaHoraHasta);

        //Creacion de historiales de estado Convocada
        HistorialIntervencion historialConvocada1 = new HistorialIntervencion(fechaHora1, estadoConvocada);
        historialConvocada1.setFechaHoraHasta(fechaHoraHasta);
        HistorialIntervencion historialConvocada2 = new HistorialIntervencion(fechaHora2, estadoConvocada);
        historialConvocada2.setFechaHoraHasta(fechaHoraHasta);
        HistorialIntervencion historialConvocada3 = new HistorialIntervencion(fechaHora3, estadoConvocada);
        historialConvocada3.setFechaHoraHasta(fechaHoraHasta);

        //Creacion de historiales de estado EnCurso
        HistorialIntervencion historialEnCurso1 = new HistorialIntervencion(fechaHora1, estadoEnCurso);
        HistorialIntervencion historialEnCurso2 = new HistorialIntervencion(fechaHora2, estadoEnCurso);
        HistorialIntervencion historialEnCurso3 = new HistorialIntervencion(fechaHora3, estadoEnCurso);

        //Creacion de Array de historiales para las intervenciones
        ArrayList<HistorialIntervencion> listHistorial1 = new ArrayList<>();
        listHistorial1.add(historialNueva1);
        listHistorial1.add(historialConvocada1);
        listHistorial1.add(historialEnCurso1);

        ArrayList<HistorialIntervencion> listHistorial2 = new ArrayList<>();
        listHistorial2.add(historialNueva2);
        listHistorial2.add(historialConvocada2);
        listHistorial2.add(historialEnCurso2);

        ArrayList<HistorialIntervencion> listHistorial3 = new ArrayList<>();
        listHistorial3.add(historialNueva3);
        listHistorial3.add(historialConvocada3);
        listHistorial3.add(historialEnCurso3);

        //Generacion UsuarioLogueado y Rol
        Date fechaActual = new Date();
        Usuario usuario1 = new Usuario("123456", fechaActual, "cperez");
        usuarioActual = new Usuario("123456", fechaActual, "pgonzalez");
        Rol rol = new Rol("Encargado de guardia");

        //Generacion de bomberos
        Bombero encargado = new Bombero(true, "Carlos", "Perez", usuario1, rol);
        Bombero encargado2 = new Bombero(true, "Pedro", "Gonzalez",usuarioActual, rol );
        encargados.add(encargado);
        encargados.add(encargado2);
        usuario1.setBombero(encargado);
        usuarioActual.setBombero(encargado2);
        
        //Generacion de las unidades moviles
        UnidadMovil unidad1 = new UnidadMovil("001", true, 100, 0);
        UnidadMovil unidad2 = new UnidadMovil("002", true, 10000, 1000);
        UnidadMovil unidad3 = new UnidadMovil("003", true, 8000, 8000);
        
        unidadesMoviles.add(unidad1);
        unidadesMoviles.add(unidad2);
        unidadesMoviles.add(unidad3);
        
        //Generacion de las dotaciones
        Dotacion dot1 = new Dotacion(fechaHora2, unidadesMoviles.get(0));
        Dotacion dot2 = new Dotacion(fechaHora2, unidadesMoviles.get(1));
        Dotacion dot3 = new Dotacion(fechaHora2, unidadesMoviles.get(2));
        
        dotaciones.add(dot1);
        dotaciones.add(dot2);
        //dotaciones.add(dot3);
        
        //Generacion de intervenciones
        Intervencion intervencion1 = new Intervencion("Colon 3008", "Incendio de Edificio", estadoEnCurso);
        intervencion1.setHistorial(listHistorial1);
        intervencion1.setEncargado(encargado);
        intervencion1.setDotacion(dotaciones);
        
        Intervencion intervencion2 = new Intervencion("General Paz 3008", "Incendio de Edificio", estadoEnCurso);
        intervencion2.setHistorial(listHistorial2);
        intervencion2.setEncargado(encargado2);
        intervencion2.setDotacion(dotaciones);
        
        Intervencion intervencion3 = new Intervencion("Tucuman 308", "Incendio de Edificio", estadoEnCurso);
        intervencion3.setHistorial(listHistorial3);
        intervencion3.setEncargado(encargado);
        intervencion3.setDotacion(dotaciones);
        
        Intervencion intervencion4 = new Intervencion("Sucre 208", "Incendio de Edificio", new Firmada());
        Intervencion intervencion5 = new Intervencion("Sarmiento 1008", "Incendio de Edificio", new Abortada());
        Intervencion intervencion6 = new Intervencion("Chacabuco 800", "Incendio de Edificio", new Finalizada());
        Intervencion intervencion7 = new Intervencion("San Martin 310", "Incendio de Edificio", new Convocada());
        Intervencion intervencion8 = new Intervencion("Belgrano 400", "Incendio de Edificio", new Cancelada());
        Intervencion intervencion9 = new Intervencion("Colon 302", "Incendio de Edificio", new Convocada());
        Intervencion intervencion10 = new Intervencion("Santa Fe 808", "Incendio de Edificio", new Nueva());
        intervenciones.add(intervencion1);
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

    public ArrayList<Bombero> getEncargados() {
        return encargados;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}
