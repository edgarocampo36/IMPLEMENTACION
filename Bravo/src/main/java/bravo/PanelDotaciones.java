/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo;

import static bravo.VistaPrincipal.contenedor;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Edgar
 */
public class PanelDotaciones extends javax.swing.JPanel {

    String[][] matrizDotaciones;
    GestorFinalizarIntervencion gestor;

    public PanelDotaciones(String[][] matrizDotaciones, GestorFinalizarIntervencion gestor) {
        this.matrizDotaciones = matrizDotaciones;
        this.gestor = gestor;

        initComponents();
        //metodo 28 y metodo 29
        mostrarDatosObtenidosDotacion(matrizDotaciones);
        deshabilitar();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        txtHora = new javax.swing.JFormattedTextField();
        txtFecha = new javax.swing.JFormattedTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(500, 500));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla);

        jLabel1.setText("Kilometros");

        jLabel2.setText("Hora");

        txtKm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKmKeyTyped(evt);
            }
        });

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraKeyTyped(evt);
            }
        });

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaKeyTyped(evt);
            }
        });

        btnAgregar.setText("Agregar o Modificar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        jLabel4.setText("Dotaciones de la Intervencion Seleccionada");

        jLabel3.setText("Seleccione cada dotacion para agregarle el kilometraje, la hora y la fecha al momento de regresar al cuartel");

        jLabel5.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnContinuar)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtKm)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregar))
                                .addGap(124, 124, 124)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addGap(39, 39, 39)
                .addComponent(btnContinuar)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //PanelPrincipal panelPrincipal = new PanelPrincipal();

        //this.setVisible(false);
        //contenedor.add(panelPrincipal);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtKmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKmKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtKmKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int filaSeleccionada = tabla.getSelectedRow();
        if (!(filaSeleccionada == -1)) {
            habitilarAgregar();

        } else {
            deshabilitar();
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void txtHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtHoraKeyTyped

    private void txtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
        }
    }//GEN-LAST:event_txtFechaKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        int fila = tabla.getSelectedRow();

        String km = txtKm.getText();
        String hora = txtHora.getText() + ":00";
        String fecha = txtFecha.getText();
        if (hora.length() == 8 && fecha.length() == 10) {
            String horaFecha = hora + " " + fecha;
            if (validarKmYFechaHoraIngresada(km, horaFecha, fila)) {
                modelo.setValueAt(km, fila, 3);
                modelo.setValueAt(horaFecha, fila, 4);
                txtKm.setText(null);
                txtHora.setText(null);
                txtFecha.setText(null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hora o fecha mal ingresada, vuelva a ingresar los datos");
            txtHora.setText(null);
            txtFecha.setText(null);
        }

        int n = 0;
        for (int i = 0; i < matrizDotaciones.length; i++) {
            if (modelo.getValueAt(i, 3) != null) {
                n++;
            }
        }
        if (n == matrizDotaciones.length) {
            btnContinuar.setEnabled(true);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Confirmar Finalizar Intervencion");
        if(n==0){
            gestor.confirmarFinalizacion();
            JOptionPane.showMessageDialog(null, "La Intervencion fue finalizada con exito");
            
        }
    }//GEN-LAST:event_btnContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tabla;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtKm;
    // End of variables declaration//GEN-END:variables

//metodo 28
    public void mostrarDatosObtenidosDotacion(String matrizDotacion[][]) {

        String nombreColumnas[] = {"Kilometraje al Salir", "Hora y Fecha de Salida", "Dominio de Unidad Movil"};
        DefaultTableModel modelo = new DefaultTableModel(matrizDotacion, nombreColumnas);
        modelo.addColumn("Kilometraje al Llegar");
        modelo.addColumn("Hora y Fecha de Llegada");
        tabla.setModel(modelo);
    }

    public void deshabilitar() {
        txtKm.setEnabled(false);
        txtHora.setEnabled(false);
        txtFecha.setEnabled(false);
        btnContinuar.setEnabled(false);
        btnAgregar.setEnabled(false);
    }

    public void habitilarAgregar() {
        txtKm.setEnabled(true);
        txtHora.setEnabled(true);
        txtFecha.setEnabled(true);
        btnAgregar.setEnabled(true);
    }

    public boolean validarKmYFechaHoraIngresada(String km, String horaFecha, int indexDotacion) {

        boolean flag = gestor.tomarFechaHoraLlegadaYKilometraje(horaFecha, km, indexDotacion);
        if (!flag) {
            JOptionPane.showMessageDialog(null, "El kilometraje y/o la hora y fecha de llegada ingresadas son menores que al salir la dotacion. Ingrese los datos nuevamente");
            txtKm.setText(null);
            txtHora.setText(null);
            txtFecha.setText(null);
            return false;
        } else {
            return true;
        }
    }
}
