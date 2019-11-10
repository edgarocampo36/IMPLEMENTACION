/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Intervencion.Intervencion;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edgar
 */
public class TablaIntervenciones extends JFrame {

    public TablaIntervenciones(ArrayList<Intervencion> intervenciones) {
        super("Intervenciones En Curso");
        DefaultTableModel modelo = new DefaultTableModel();
        if (!(intervenciones.size() == 0)) {
            modelo.addColumn("Intervencion");
            modelo.addColumn("Fecha y Hora de Creacion");
            modelo.addColumn("Ubicacion");
            modelo.addColumn("Resumen siniestro");

            armarTabla(modelo, intervenciones);
        } else {
            modelo.addColumn("");
            String[] f = {"No hay intervenciones en curso"};
            modelo.addRow(f);
        }
        JTable tabla;
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        tabla.setBounds(12, 22, 500, 500);
        setSize(600, 300);
        scroll.setBounds(12, 22, 500, 500);

        add(scroll);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public void armarTabla(DefaultTableModel modelo, ArrayList<Intervencion> intervenciones) {
        int n = 1;
        for (Intervencion i : intervenciones) {
            String[] f = {"" + n + "", "" + i.getFechaHoraSolicitud() + "", i.getDomicilioReportado(), i.getResumenSiniestroInformante()};
            modelo.addRow(f);
            n++;
        }
    }

}
