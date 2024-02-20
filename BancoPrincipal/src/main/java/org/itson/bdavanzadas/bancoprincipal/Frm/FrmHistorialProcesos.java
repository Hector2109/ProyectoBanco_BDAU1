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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransacciones = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rtbnTransferencia = new javax.swing.JRadioButton();
        rbtnRetiros = new javax.swing.JRadioButton();
        rbtnAmbos = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateDesde = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateHasta = new com.toedter.calendar.JDateChooser();
        btnActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(rtbnTransferencia);
        rtbnTransferencia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        rtbnTransferencia.setText("Transferencia");

        buttonGroup1.add(rbtnRetiros);
        rbtnRetiros.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        rbtnRetiros.setText("Retiros");

        buttonGroup1.add(rbtnAmbos);
        rbtnAmbos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        rbtnAmbos.setText("Ambos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnAmbos)
                    .addComponent(rbtnRetiros)
                    .addComponent(rtbnTransferencia))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rtbnTransferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnRetiros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnAmbos)
                .addGap(27, 27, 27))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Fecha desde");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Fecha Hasta");

        btnActualizar.setBackground(new java.awt.Color(204, 204, 204));
        btnActualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateHasta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateDesde, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));

        btnVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Filtrar por:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("HISTORIAL DE TRANSACCIONES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ActualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed

    private void llenarTabla() {
        List<Transaccion> transacciones = new LinkedList<>();
        try {
            transacciones = transaccionDAO.consultar(cliente);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("TRANSACCION No");
            modelo.addColumn("FECHA");
            modelo.addColumn("MONTO");
            modelo.addColumn("TIPO TRANSACCION");
            modelo.addColumn("CUENTA");
            for (Transaccion transaccion : transacciones) {
                Object[] fila = {
                    transaccion.getId_transaccion(),
                    transaccion.getFecha(),
                    transaccion.getSaldo_transaccion(),
                    transaccion.getTipo_transaccion(),
                    transaccion.getNum_cuenta()
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
            modelo.addColumn("CUENTA");
            for (Transaccion transaccion : transacciones) {
                Object[] fila = {
                    transaccion.getId_transaccion(),
                    transaccion.getFecha(),
                    transaccion.getSaldo_transaccion(),
                    transaccion.getTipo_transaccion(),
                    transaccion.getNum_cuenta()
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
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateDesde;
    private com.toedter.calendar.JDateChooser jDateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTransacciones;
    private javax.swing.JRadioButton rbtnAmbos;
    private javax.swing.JRadioButton rbtnRetiros;
    private javax.swing.JRadioButton rtbnTransferencia;
    // End of variables declaration//GEN-END:variables
}
