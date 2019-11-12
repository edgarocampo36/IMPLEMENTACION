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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgar
 */
public class Ventana extends JFrame{
    
    ArrayList<Intervencion> listIntervenciones = new ArrayList<>();
    JPanel panel;
    JLabel titulo;
    JButton finalizar;
    
    public Ventana() {

        super("Bravo - Sistema de gestion para cuarteles de Bomberos");
        
        this.setSize(800, 600);
        this.setVisible(true);
        iniciarComponentes();
        
        //Se cargan las intervenciones en memoria
        GeneradorBase generador = new GeneradorBase();
        listIntervenciones = generador.getIntervenciones();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
    }
    
    private void iniciarComponentes(){
        panel = new JPanel();
        panel.setBackground(Color.red);
        this.getContentPane().add(panel);
        
        titulo = new JLabel("Gestiones disponibles");
        titulo.setForeground(Color.YELLOW);
        titulo.setFont(new Font("Arial", 0, 20));
        panel.add(titulo);
        
        finalizar = new JButton("Finalizar Intervencion");
        finalizar.setBounds(300, 200, 200, 30);
        panel.add(finalizar);
        finalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TablaIntervenciones t1 = new TablaIntervenciones();
                DefaultTableModel modelo = t1.armarTableModel(listIntervenciones);
                JTable tabla = new JTable(modelo);
                tabla.setBounds(10, 30, 400, 700);
                JScrollPane scroll = new JScrollPane(tabla);
                scroll.setBounds(10, 30, 400, 700);
                titulo.setText("Selecciones la Intervencion a Finalizar");
                finalizar.setVisible(false);
                panel.add(scroll);
            }
        });
        
        
    }

//-- METODO MAIN
    public static void main(String[] ARGS) {
        

        Ventana ventana = new Ventana();
        
        String user = "bombero";
        String contrasenia = "123456";
        Date fechaActual = new Date();
        Usuario usuarioActual = new Usuario(contrasenia, fechaActual, user);
        Sesion sesionActual = new Sesion(fechaActual, usuarioActual);
        

        
        GestorFinalizarIntervencion gestor = new GestorFinalizarIntervencion(sesionActual, usuarioActual);
        
        
        
        
        
        
        
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


