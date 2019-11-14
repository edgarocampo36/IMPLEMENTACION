/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo;

import Interfaz.TablaIntervenciones;
import Intervencion.Intervencion;
import Sesion.*;

import java.awt.*;
import java.awt.event.*;
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
        panel1.setVisible(false);
        return mostrarIntervencionesEnCurso(intervencionesEnCurso);
    }

    //metodo18
    public JTable mostrarIntervencionesEnCurso(ArrayList<Intervencion> intervencionesEnCurso) {
        
        panel1 = new JPanel();
        panel1.setBackground(Color.red);
        this.getContentPane().add(panel1);
        
        titulo1.setText("Intervenciones En Curso");
        panel1.add(titulo1);
        TablaIntervenciones t1 = new TablaIntervenciones();
        DefaultTableModel modelo = t1.armarTableModel(intervencionesEnCurso);
        JTable tabla = new JTable(modelo);
        tabla.setBounds(10, 30, 400, 700);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 30, 400, 700);
        panel1.add(scroll);
        seleccionar = new JButton("Seleccionar Intervencion");
        panel1.add(seleccionar);

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
                        ArrayList<Intervencion> intervencionesEnCurso = gestor.getIntervencionesEnCursoOrdenadas();
                        Intervencion intervencionSeleccionada = intervencionesEnCurso.get(filaSeleccionada);
                        //metodo 20
                        String[][] matrizDotaciones = tomarSeleccionIntervencion(intervencionSeleccionada);
                        //metodo 28
                        tabla.setVisible(false);
                        seleccionar.setVisible(false);
                        panel1.setVisible(false);
                        mostrarDatosObtenidosDotacion(matrizDotaciones);
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
    public String[][] tomarSeleccionIntervencion(Intervencion intervencionSeleccionada){
        return gestor.tomarSeleccionIntervencion(intervencionSeleccionada);
    }

    //metodo 28
    public void mostrarDatosObtenidosDotacion(String matrizDotacion[][]) {
        
        String nombreColumnas[] = {"Kilometraje al Salir", "Fecha y Hora de Salida", "Dominio de Unidad Movil"};
        JTable tablaDotaciones = new JTable(matrizDotacion, nombreColumnas);
        tablaDotaciones.setBounds(10, 30, 100, 100);
        JScrollPane scroll2 = new JScrollPane(tablaDotaciones);
        scroll2.setBounds(10, 30, 100, 100);
        titulo1.setText("Dotaciones de la Intervencion Seleccionada");
        panel1.add(titulo1, BorderLayout.CENTER);
        panel1.add(scroll2, BorderLayout.SOUTH);




        //metodo 29
        solicitarFechaHoraLLegadaYKilometraje(matrizDotacion);

    }

    //medoto 29
    public void solicitarFechaHoraLLegadaYKilometraje(String matrizDotacion[][]) {

        JLabel labelKm = new JLabel("Kilometraje al Volver");
        JTextField textKm = new JTextField("Ingresar numeros");
        JLabel labelFechaHora = new JLabel("Fecha y Hora de Regreso (formato 'hh:mm:ss dd/mm/aaaa')");
        JTextField textFechaHora = new JTextField();
        textFechaHora.setBounds(new Rectangle(25, 15, 250, 21));
        panel1.add(labelKm, BorderLayout.AFTER_LAST_LINE);
        panel1.add(textKm);
        panel1.add(labelFechaHora, BorderLayout.AFTER_LAST_LINE);
        panel1.add(textFechaHora);

        ArrayList<String[]> arrayDatos = new ArrayList<>();
        for (int i=0; i<matrizDotacion.length; i++){
            String datos[] = new String[2];
            String km = JOptionPane.showInputDialog("Ingrese kilometraje al llegar para Dotacion ");
            String fechaHora = JOptionPane.showInputDialog("Ingrese hora y fecha (formato 'hh:mm:ss dd/mm/aaaa') al llegar para Dotacion ");
            datos[0] = km;
            datos[1] = fechaHora;
            arrayDatos.add(datos);
        }
        System.out.println("datos "+arrayDatos.size());

        //showMessageDialog(null, "Ingrese kilometraje, fecha y hora de cada dotacion");



    }

    private void validarNumero(java.awt.event.KeyEvent ke){
        char validar =  ke.getKeyChar();

        if(Character.isLetter(validar)){
            getToolkit().beep();
            ke.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
        }
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
        //Ventana ventana = new Ventana(usuarioActual, sesionActual, gestor);

        //gestor.setVentana(ventana);

    }
    
    

}
