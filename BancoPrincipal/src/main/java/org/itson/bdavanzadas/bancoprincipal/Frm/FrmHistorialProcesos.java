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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransacciones = new javax.swing.JTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void llenarTabla() {

        List<Transaccion> transacciones = new LinkedList<>();
        try {
            transacciones = transaccionDAO.consultar(cliente);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("TRANSACCION No");
            modelo.addColumn("FECHA");
            modelo.addColumn("ESTADO");
            modelo.addColumn("AGREGAR MONTO");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTransacciones;
    // End of variables declaration//GEN-END:variables
}
