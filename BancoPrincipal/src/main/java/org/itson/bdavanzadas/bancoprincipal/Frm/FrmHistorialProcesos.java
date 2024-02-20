/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.bancoprincipal.Frm;

import com.itson.bdaavanzadas.bancopersistencia.DAO.CuentasDAO;
import com.itson.bdaavanzadas.bancopersistencia.DAO.ITransaccionDAO;
import com.itson.bdaavanzadas.bancopersistencia.DAO.TransaccionDAO;
import com.itson.bdaavanzadas.bancopersistencia.conexion.Conexion;
import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Transaccion;

/**
 *
 * @author Enrique Rodriguez
 */
public class FrmHistorialProcesos extends javax.swing.JFrame {

    private Cliente cliente;
    private final ITransaccionDAO transaccionDAO;

    public FrmHistorialProcesos(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        String cadenaConexion = "jdbc:mysql://localhost/betobank_bda";
        String usuario = "root";
        String contrasenia = "hector21";
        //String contrasenia = "Itson";
        //String contrasenia = "kikin22";
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        transaccionDAO = new TransaccionDAO(conexion);
        llenarTabla();
        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransacciones = new javax.swing.JTable();
        rtbnTransferencia = new javax.swing.JRadioButton();
        rbtnRetiros = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateDesde = new com.toedter.calendar.JDateChooser();
        jDateHasta = new com.toedter.calendar.JDateChooser();
        btnActualizar = new javax.swing.JButton();
        rbtnAmbos = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableTransacciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableTransacciones);

        buttonGroup1.add(rtbnTransferencia);
        rtbnTransferencia.setText("Transferencia");

        buttonGroup1.add(rbtnRetiros);
        rbtnRetiros.setText("Retiros");

        jLabel1.setText("Fecha desde");

        jLabel2.setText("Fecha Hasta");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnAmbos);
        rbtnAmbos.setText("Ambos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rtbnTransferencia)
                                    .addComponent(rbtnRetiros)
                                    .addComponent(rbtnAmbos)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(rtbnTransferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnRetiros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnAmbos)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnActualizar)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ActualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void llenarTabla() {
        List<Transaccion> transacciones = new LinkedList<>();
        try {
            transacciones = transaccionDAO.consultar(cliente);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("TRANSACCION No");
            modelo.addColumn("FECHA");
            modelo.addColumn("MONTO");
            modelo.addColumn("TIPO TRANSACCION");
            for (Transaccion transaccion : transacciones) {
                Object[] fila = {
                    transaccion.getId_transaccion(),
                    transaccion.getFecha(),
                    transaccion.getSaldo_transaccion(),
                    transaccion.getTipo_transaccion()
                };

                modelo.addRow(fila);

            }
            jTableTransacciones.setModel(modelo);
            TableColumnModel columnModel = jTableTransacciones.getColumnModel();

        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ActualizarTabla() {
        List<Transaccion> transacciones = new LinkedList<>();
        try {
            transacciones = transaccionDAO.consultar(cliente);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("TRANSACCION No");
            modelo.addColumn("FECHA");
            modelo.addColumn("MONTO");
            modelo.addColumn("TIPO TRANSACCION");
            for (Transaccion transaccion : transacciones) {
                Object[] fila = {
                    transaccion.getId_transaccion(),
                    transaccion.getFecha(),
                    transaccion.getSaldo_transaccion(),
                    transaccion.getTipo_transaccion()
                };

                try {
                    //Desde
                    Calendar calDesde = Calendar.getInstance();
                    calDesde.setTime(jDateDesde.getDate());
                    calDesde.set(Calendar.HOUR_OF_DAY, 0);
                    calDesde.set(Calendar.MINUTE, 0);
                    calDesde.set(Calendar.SECOND, 0);
                    calDesde.set(Calendar.MILLISECOND, 0);
                    //Hasta
                    Calendar calHasta = Calendar.getInstance();
                    calHasta.setTime(jDateHasta.getDate());
                    calHasta.set(Calendar.HOUR_OF_DAY, 0);
                    calHasta.set(Calendar.MINUTE, 0);
                    calHasta.set(Calendar.SECOND, 0);
                    calHasta.set(Calendar.MILLISECOND, 0);

                    if ((transaccion.getFecha().after(calDesde.getTime()) || transaccion.getFecha().equals(calDesde.getTime()))
                            && (transaccion.getFecha().before(calHasta.getTime()) || transaccion.getFecha().equals(calHasta.getTime()))) {
                        if (rtbnTransferencia.isSelected() && transaccion.getTipo_transaccion().equalsIgnoreCase("transferencia")) {
                            modelo.addRow(fila);
                        } else if (rbtnRetiros.isSelected() && transaccion.getTipo_transaccion().equalsIgnoreCase("retiro")) {
                            modelo.addRow(fila);
                        }
                        else if (rbtnAmbos.isSelected()) {
                            modelo.addRow(fila);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Rellene todos los campos");
                    llenarTabla();
                }

            }
            jTableTransacciones.setModel(modelo);
            TableColumnModel columnModel = jTableTransacciones.getColumnModel();

        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateDesde;
    private com.toedter.calendar.JDateChooser jDateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTransacciones;
    private javax.swing.JRadioButton rbtnAmbos;
    private javax.swing.JRadioButton rbtnRetiros;
    private javax.swing.JRadioButton rtbnTransferencia;
    // End of variables declaration//GEN-END:variables
}
