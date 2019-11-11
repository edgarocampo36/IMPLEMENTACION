/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edgar
 */
public class ConversorFecha {

    public ConversorFecha() {

    }

    public Date formatoDate(Date fechaHora) {
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy"); //Formateador de fecha
        String fechaString = formato.format(fechaHora); //formatea la fecha actual y devuelve un string
        try {
            fechaHora = formato.parse(fechaString); //convierte la fecha en string a un Date
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaHora;
    }
    
    public Date stringADate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
}
