/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo;

import Interfaz.TablaIntervenciones;
import Intervencion.Intervencion;
import Sesion.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgar
 */
public class Ventana extends JFrame{
    
    GestorFinalizarIntervencion gestor;
    Usuario usuarioActual;
    Sesion sesionActual;
    JPanel panel1;
    JLabel titulo1;
    JLabel titulo2;
    JButton finalizar;
    JButton seleccionar;

    public Ventana(Usuario usuario, Sesion sesion, GestorFinalizarIntervencion gestor) {
        super("Bravo - Sistema de gestion para cuarteles de Bomberos");

        usuarioActual = usuario;
        sesionActual = sesion;
        this.gestor = gestor;

        this.setSize(800, 600);
        this.setVisible(true);
        iniciarComponentes();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        panel1 = new JPanel();
        panel1.setBackground(Color.red);
        this.getContentPane().add(panel1);

        titulo1 = new JLabel("Gestiones disponibles");
        titulo1.setForeground(Color.YELLOW);
        titulo1.setFont(new Font("Arial", 0, 20));
        panel1.add(titulo1);

        finalizar = new JButton("Finalizar Intervencion");
        finalizar.setBounds(300, 200, 200, 30);
        panel1.add(finalizar);

        finalizar.addActionListener((ActionEvent ae) -> {
            //metodo 2
            
            JTable tabla = opcionFinalizarIntervencion(gestor);
            
            //metodo 19
            pedirSeleccionIntervencion(tabla);
            
        });
    }

    public void setGestor(GestorFinalizarIntervencion gestor) {
        this.gestor = gestor;
    }

    //metodo 2
    public JTable opcionFinalizarIntervencion(GestorFinalizarIntervencion gestor) {
        //metodo 3
        ArrayList<Intervencion> intervencionesEnCurso = gestor.opcionFinalizarIntervencion(sesionActual, usuarioActual);
        
        //metodo 18
        return mostrarIntervencionesEnCurso(intervencionesEnCurso);
    }

    //metodo18
    public JTable mostrarIntervencionesEnCurso(ArrayList<Intervencion> intervencionesEnCurso) {

        finalizar.setVisible(false);
        titulo1.setText("Intervenciones En Curso");
        TablaIntervenciones t1 = new TablaIntervenciones();
        System.out.println(intervencionesEnCurso.size());
        DefaultTableModel modelo = t1.armarTableModel(intervencionesEnCurso);
        JTable tabla = new JTable(modelo);
        tabla.setBounds(10, 30, 400, 700);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 30, 400, 700);
        panel1.add(scroll, BorderLayout.CENTER);
       
        /*titulo2 = new JLabel("Intervenciones En Curso");
        titulo2.setForeground(Color.YELLOW);
        titulo2.setFont(new Font("Arial", 0, 20));
        panel1.add(titulo2, BorderLayout.WEST);*/
        seleccionar = new JButton("Seleccionar Intervencion");
        panel1.add(seleccionar, BorderLayout.SOUTH);

        return tabla;
    }

    //metodo 19
    public void pedirSeleccionIntervencion(JTable tabla) {
        JOptionPane.showMessageDialog(null, "Seleccione la intervencion que desea finalizar");
        
        seleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int filaSeleccionada = tabla.getSelectedRow();
                try {
                    if (filaSeleccionada != -1) {
                        System.out.println("fila " + filaSeleccionada);
                        ArrayList<Intervencion> intervencionesEnCurso = gestor.getIntervencionesEnCursoOrdenadas();
                        Intervencion intervencionSeleccionada = intervencionesEnCurso.get(filaSeleccionada);
                        //metodo 20
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna intervencion");
                    }
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    //metodo 20
    public void tomarSeleccionIntervencion(Intervencion intervencionSeleccionada){
        gestor.tomarSeleccionIntervencion(intervencionSeleccionada);
    }

    //metodo 28
    public void mostrarDatosObtenidosDotacion(String matrizDotacion[][]) {
        int i = 0;
        int j = 0;
        while (matrizDotacion[i][j] != null) {
            System.out.println("Dotacion " + (i + 1) + ":");
            while (matrizDotacion[i][j] != null) {
                System.out.println(matrizDotacion[i][j]);
                j++;
            }
            i++;
        }
    }

    //medoto 29
    public void solicitarFechaHoraLLegadaYKilometraje() {

    }

    //metodo 30
    public void tomarFechaHoraLlegadaYKilometraje() {

    }

    //metodo 34
    public void solicitarConfirmacionFinalizacion() {

    }

    //metodo 35
    public void confirmarFinalizacion() {

    }
    
//-- METODO MAIN
    public static void main(String[] ARGS) {

        //Carga los objetos en memoria
        GeneradorBase generador = new GeneradorBase();
        ArrayList<Intervencion> listIntervenciones = generador.getIntervenciones();

        Bombero bomberoLogueado = generador.getEncargados().get(1);
        Date fechaActual = new Date();
        Usuario usuarioActual = generador.getUsuarioActual();
        Sesion sesionActual = new Sesion(fechaActual, usuarioActual);

        //Se carga gestor en memoria
        GestorFinalizarIntervencion gestor = new GestorFinalizarIntervencion(sesionActual, usuarioActual, listIntervenciones);

        //metodo 2
        Ventana ventana = new Ventana(usuarioActual, sesionActual, gestor);

        gestor.setVentana(ventana);

    }
    
    

}
