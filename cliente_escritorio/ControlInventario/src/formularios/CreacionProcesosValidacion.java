/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import com.toedter.calendar.JDateChooser;
import comMdf.devazt.networking.HttpClient;
import comMdf.devazt.networking.OnHttpRequestComplete;
import comMdf.devazt.networking.Response;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Funcionario;
import dao.FuncionarioDAO;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author DELL
 */
public class CreacionProcesosValidacion extends javax.swing.JFrame {

    FuncionarioDAO fun = new FuncionarioDAO();
    List<Funcionario> funcionarios = fun.listarFuncionarios();
    DefaultListModel modeloLista = new DefaultListModel();
    int log = 0;
    String idProceso = "";

    /**
     * Creates new form CreacionProcesosValidacion
     */
    public CreacionProcesosValidacion() {
        initComponents();
        this.setTitle("Procesos de Validación");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        bloqueoProceso();
        cargarJlistFuncionarios();
        cargarProcesos();
        botonesInicio();
        jtxtFecha.setDate(new Date());
    }

    private void botonesInicio() {
        jbtnCrear.setEnabled(false);
        jbtnActualizar.setEnabled(false);
    }

    private void bloqueoProceso() {
        jtxtNombre.setEnabled(false);
        jtxtFecha.setEnabled(false);
        jlistEmpleados.setEnabled(false);
    }

    private void camposEditarProceso() {
        jbtnCrear.setEnabled(false);
        jbtnActualizar.setEnabled(true);
        jtxtNombre.setText(jcbxProcesos.getSelectedItem().toString());
        jtxtNombre.setEnabled(false);
        jtxtFecha.setEnabled(false);
        jlistEmpleados.setEnabled(true);
    }

    private void camposCrearProceso() {
        jbtnCrear.setEnabled(true);
        jbtnActualizar.setEnabled(false);
        jtxtNombre.setText("");
        jtxtNombre.setEnabled(true);
        jtxtFecha.setEnabled(true);
        jtxtFecha.setDate(new Date());
        jlistEmpleados.setEnabled(true);
    }

    public void cargarJlistFuncionarios() {

        jlistEmpleados.setModel(modeloLista);

        for (Funcionario f : funcionarios) {
            modeloLista.addElement(f);
        }

    }

    public void cargarProcesos() {
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {//Respuesta del servicio
                    if (status.isSuccess()) {
                        try {
                            DefaultComboBoxModel modeloCBX = new DefaultComboBoxModel();

                            jcbxProcesos.setModel(modeloCBX);

                            //Ciclo para añadir a la tabla los datos de todos los funcionarios
                            JSONObject funcionariosArray = new JSONObject(status.getResult());
                            jcbxProcesos.addItem("");
                            //Ciclo para añadir a la tabla los datos de todos los funcionarios
                            for (int i = 0;; i++) {
                                Object[] obj = new Object[2];
                                obj[0] = funcionariosArray.getJSONObject("" + i + "").get("TIT_PRO").toString();
                                modeloCBX.addElement(obj[0]);
                            }
                        } catch (JSONException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            });
            cliente.excecute("http://localhost/servicios/cargarProcesos.php");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void cargarEditar() {
        camposEditarProceso();

        List<Integer> seleccionados = new ArrayList<>();
        int agregar = 0;
        int filas = jtblFuncionarios.getRowCount();
        if (filas > 0) {
            for (int i = 0; i < filas; i++) {
                agregar = buscarLista(jtblFuncionarios.getValueAt(i, 1).toString());
                if (agregar != -1) {
                    seleccionados.add(agregar);
                }
            }
            int[] indices = new int[seleccionados.size()];
            for (int j = 0; j < seleccionados.size(); j++) {
                indices[j] = seleccionados.get(j);
            }
            jlistEmpleados.setSelectedIndices(indices);
        }

    }

    public int buscarLista(String nombreTabla) {
        int lista = modeloLista.getSize();

        for (int i = 0; i < lista; i++) {
            if (modeloLista.getElementAt(i).toString().equals(nombreTabla)) {
                return i;
            }
        }
        return -1;
    }

    public boolean comprobarCamposLlenos() {
        if (jtxtNombre.getText().equals("")) {
            return false;
        }
        if (jtxtFecha.equals("")) {
            return false;
        }
        int[] selectedIx = this.jlistEmpleados.getSelectedIndices();
        if (selectedIx.length <= 0) {
            JOptionPane.showMessageDialog(this, "No se puede crear un proceso sin funcionarios", "Mensaje", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean comprobarCamposLlenosActualizar() {

        int[] selectedIx = this.jlistEmpleados.getSelectedIndices();
        if (selectedIx.length <= 0) {
            JOptionPane.showMessageDialog(this, "No se puede crear un proceso sin funcionarios", "Mensaje", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblFuncionarios = new javax.swing.JTable();
        jcbxProcesos = new javax.swing.JComboBox();
        jlblFecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jbtnNuevo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistEmpleados = new javax.swing.JList();
        jtxtFecha = new com.toedter.calendar.JDateChooser();
        jbtnCrear = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jbtnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 223, 213));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Procesos de Validación");

        jtblFuncionarios.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jtblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblFuncionarios);

        jcbxProcesos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbxProcesos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbxProcesosItemStateChanged(evt);
            }
        });

        jlblFecha.setText("Fecha: ");

        jPanel2.setBackground(new java.awt.Color(208, 223, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Proceso"));

        jLabel3.setText("Nombre:");

        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha:");

        jLabel5.setText("Empleados:");

        jlistEmpleados.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlistEmpleados);

        jtxtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtxtFechaMouseClicked(evt);
            }
        });
        jtxtFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtFechaPropertyChange(evt);
            }
        });

        jbtnCrear.setText("Crear");
        jbtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCrearActionPerformed(evt);
            }
        });

        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(jtxtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addComponent(jbtnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnNuevo)
                    .addComponent(jLabel3)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCrear))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnActualizar))
                .addContainerGap())
        );

        jbtnRegresar.setText("Regresar");
        jbtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbxProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtnRegresar)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbxProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblFecha))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnRegresar)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        // TODO add your handling code here:
        camposCrearProceso();
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegresarActionPerformed
        // TODO add your handling code here:

        FuncionariosYActivos nuevo = new FuncionariosYActivos();
        this.dispose();
        nuevo.setVisible(true);
    }//GEN-LAST:event_jbtnRegresarActionPerformed

    private void jcbxProcesosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbxProcesosItemStateChanged
        // TODO add your handling code here:
        cargarFecha(jcbxProcesos.getSelectedItem().toString());
        cargarTabla(jcbxProcesos.getSelectedItem().toString());
        if (log > 0) {
            cargarEditar();
        }
        log++;
    }//GEN-LAST:event_jcbxProcesosItemStateChanged

    private void jbtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCrearActionPerformed
        // TODO add your handling code here:
        if (!comprobarCamposLlenos()) {
            JOptionPane.showMessageDialog(this, "Revise los campos de su proceso", "Mensaje", JOptionPane.WARNING_MESSAGE);
        } else {
            String titulo = this.jtxtNombre.getText();

            Date fecha = jtxtFecha.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy");
            String fechaTexto = formatter.format(fecha);

            Funcionario funcionarioSeleccionado = null;

            int[] selectedIx = this.jlistEmpleados.getSelectedIndices();
            String[] idFuncionarios = new String[selectedIx.length];
            for (int i = 0; i < selectedIx.length; i++) {
                funcionarioSeleccionado = (Funcionario) jlistEmpleados.getModel().getElementAt(selectedIx[i]);
                idFuncionarios[i] = funcionarioSeleccionado.getId();
                System.out.println(idFuncionarios[i]);
            }
            String funcionarios = recorrerFuncionarios(idFuncionarios);
            crearProceso(titulo, fechaTexto, funcionarios);
        }
    }//GEN-LAST:event_jbtnCrearActionPerformed

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        // TODO add your handling code here:
        if (!comprobarCamposLlenosActualizar()) {
            JOptionPane.showMessageDialog(this, "Revise los campos de su proceso", "Mensaje", JOptionPane.WARNING_MESSAGE);
        } else {
            String titulo = this.jtxtNombre.getText();

            Funcionario funcionarioSeleccionado = null;

            int[] selectedIx = this.jlistEmpleados.getSelectedIndices();
            String[] idFuncionarios = new String[selectedIx.length];
            for (int i = 0; i < selectedIx.length; i++) {
                funcionarioSeleccionado = (Funcionario) jlistEmpleados.getModel().getElementAt(selectedIx[i]);
                idFuncionarios[i] = funcionarioSeleccionado.getId();
                System.out.println(idFuncionarios[i]);
            }
            cargarIdProceso(titulo);
            String funcionarios = recorrerFuncionarios(idFuncionarios);
            actualizarProceso(idProceso, titulo, funcionarios);
        }
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jtxtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtFechaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jtxtFechaMouseClicked

    private void jtxtFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtFechaPropertyChange
        // TODO add your handling code here:
        System.out.println(jtxtFecha.getDate());
    }//GEN-LAST:event_jtxtFechaPropertyChange

    private void jtblFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblFuncionariosMouseClicked
        // TODO add your handling code here:
        int fila = this.jtblFuncionarios.rowAtPoint(evt.getPoint());
        idProceso = this.jtblFuncionarios.getValueAt(fila, 0).toString();
        String nombreProceso = jcbxProcesos.getSelectedItem().toString();
        String nombreFuncionario = this.jtblFuncionarios.getValueAt(fila, 1).toString();
        Observaciones ventana = new Observaciones(this, true, idProceso, nombreFuncionario, nombreProceso);
        ventana.setVisible(true);
    }//GEN-LAST:event_jtblFuncionariosMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreacionProcesosValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreacionProcesosValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreacionProcesosValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreacionProcesosValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreacionProcesosValidacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnCrear;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnRegresar;
    private javax.swing.JComboBox jcbxProcesos;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JList jlistEmpleados;
    private javax.swing.JTable jtblFuncionarios;
    private com.toedter.calendar.JDateChooser jtxtFecha;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables

    private void actualizarProceso(String id, String titulo, String idFuncionarios) {

        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.equals("Actualizado correctamente")) {
                        System.out.println("Actualizado");
                    }
                }

            });
            cliente.excecute("http://localhost/servicios/updateProcesoValidacion.php?" + idFuncionarios + "id=" + id);
            JOptionPane.showMessageDialog(null, "Proceso actualizado exitosamente.");
            ProcesoCreado();
            this.jcbxProcesos.setSelectedItem(titulo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    private void cargarIdProceso(String urlString) {

        if (urlString.contains(" ")) {
            urlString = urlString.replace(" ", "%20");
        }
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {//Respuesta del servicio
                    if (status.isSuccess()) {
                        try {

                            //Ciclo para añadir a la tabla los datos de todos los funcionarios
                            JSONObject funcionariosArray = new JSONObject(status.getResult());

                            //Ciclo para añadir a la tabla los datos de todos los funcionarios
                            String obj = new String();
                            obj = funcionariosArray.getJSONObject("0").get("ID_PRO").toString();
                            idProceso = obj;

                        } catch (JSONException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            });
            cliente.excecute("http://localhost/servicios/cargarIdProcesos.php?titulo=" + urlString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void cargarFecha(String urlString) {
        if (urlString.contains(" ")) {
            urlString = urlString.replace(" ", "%20");
        }
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {//Respuesta del servicio
                    if (status.isSuccess()) {
                        try {

                            //Ciclo para añadir a la tabla los datos de todos los funcionarios
                            JSONObject funcionariosArray = new JSONObject(status.getResult());

                            //Ciclo para añadir a la tabla los datos de todos los funcionarios
                            String obj = new String();
                            obj = funcionariosArray.getJSONObject("0").get("FEC_PRO").toString();
                            jlblFecha.setText(obj);
                            jtxtFecha.setDate(new Date(obj));

                        } catch (JSONException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            });
            cliente.excecute("http://localhost/servicios/cargarFechasDeProcesos.php?titulo=" + urlString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarTabla(String string) {
        if (string.contains(" ")) {
            string = string.replace(" ", "%20");
        }
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {//Respuesta del servicio
                    if (status.isSuccess()) {
                        try {
                            DefaultTableModel modeloTabla = new DefaultTableModel();

                            //Encabezado de la tabla
                            modeloTabla.addColumn("ID");
                            modeloTabla.addColumn("Funcionario");
                            modeloTabla.addColumn("CantidadActivos");
                            modeloTabla.addColumn("Estado");

                            jtblFuncionarios.setModel(modeloTabla);

                            String nomApe;

                            //Ciclo para añadir a la tabla los datos de todos los funcionarios
                            JSONObject funcionariosArray = new JSONObject(status.getResult());
                            //Ciclo para añadir a la tabla los datos de todos los funcionarios
                            for (int i = 0;; i++) {
                                Object[] obj = new Object[4];
                                obj[0] = funcionariosArray.getJSONObject("" + i + "").get("ID_PRO_DET").toString();
                                obj[1] = funcionariosArray.getJSONObject("" + i + "").get("NOM_FUN").toString() + " "
                                        + funcionariosArray.getJSONObject("" + i + "").get("APE_FUN").toString();
                                obj[2] = funcionariosArray.getJSONObject("" + i + "").get("NUM_ACT_FUN").toString();
                                obj[3] = funcionariosArray.getJSONObject("" + i + "").get("EST_PRO").toString();
                                modeloTabla.addRow(obj);
                            }

                        } catch (JSONException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            });
            cliente.excecute("http://localhost/servicios/cargarDetalleProceso.php?titulo=" + string);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void crearProceso(String titulo, String fechaTexto, String idFuncionarios) {
        String titulo2 = "";
        if (titulo.contains(" ")) {
            titulo2 = titulo.replace(" ", "%20");
        } else {
            titulo2 = titulo;
        }
        try {
            HttpClient cliente = new HttpClient(new OnHttpRequestComplete() {
                @Override
                public void onComplete(Response status) {
                    if (status.equals("El proceso se creo correctamente")) {
                        System.out.println("Creado");
                    }
                }

            });
            cliente.excecute("http://localhost/servicios/nuevoProcesoControl.php?titulo=" + titulo2 + "&" + idFuncionarios + "fecha=" + fechaTexto);
            JOptionPane.showMessageDialog(null, "Proceso creado exitosamente.");
            ProcesoCreado();
            this.jcbxProcesos.setSelectedItem(titulo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private String recorrerFuncionarios(String[] idFuncionarios) {
        String url = "";
        System.out.println(idFuncionarios.length);
        for (int i = 0; i < idFuncionarios.length; i++) {
            System.out.println(url);
            url += "funcionarios[" + i + "]=" + idFuncionarios[i] + "&";
        }
        System.out.println(url);
        return url;
    }

    private void ProcesoCreado() {
        jtxtNombre.setText("");
        jtxtFecha.setToolTipText("");
        bloqueoProceso();
        cargarProcesos();
    }
}
