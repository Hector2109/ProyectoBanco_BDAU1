/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.bancoprincipal.Frm;

import com.itson.bdaavanzadas.bancopersistencia.DAO.ClientesDAO;
import com.itson.bdaavanzadas.bancopersistencia.DAO.CuentasDAO;
import com.itson.bdaavanzadas.bancopersistencia.DAO.IClientesDAO;
import com.itson.bdaavanzadas.bancopersistencia.DAO.ICuentasDAO;
import com.itson.bdaavanzadas.bancopersistencia.DAO.ITransferenciasDAO;
import com.itson.bdaavanzadas.bancopersistencia.DAO.TransferenciasDAO;
import com.itson.bdaavanzadas.bancopersistencia.conexion.Conexion;
import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;

/**
 *
 * @author Enrique Rodriguez
 */
public class FrmCuentas extends javax.swing.JFrame {

    private Cliente cliente;
    private final ICuentasDAO cuentasDAO;

    /**
     * Creates new form FrmCuentas
     */
    public FrmCuentas(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        String cadenaConexion = "jdbc:mysql://localhost/betobank_bda";
        String usuario = "root";
        String contrasenia = "hector21";
        //String contrasenia = "Itson";
        //String contrasenia = "kikin22";
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        cuentasDAO = new CuentasDAO(conexion);
        lblNombreCliente.setText(cliente.getNombre());
        llenarTabla();
        setVisible(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCuentas = new javax.swing.JTable();
        lblNombreCliente = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnCrearNuevaCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTableCuentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCuentas);

        lblNombreCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNombreCliente.setText("Hope");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Hola,");

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));

        btnVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnCrearNuevaCuenta.setBackground(new java.awt.Color(204, 204, 204));
        btnCrearNuevaCuenta.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnCrearNuevaCuenta.setText("Crear nueva");
        btnCrearNuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearNuevaCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearNuevaCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearNuevaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearNuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearNuevaCuentaActionPerformed
        dispose();
        DlgCuentaNueva cuentaNueva = new DlgCuentaNueva(this.cliente);
    }//GEN-LAST:event_btnCrearNuevaCuentaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        String cadenaConexion = "jdbc:mysql://localhost/betobank_bda";
        String usuario = "root";
        String contrasenia = "hector21";
        //String contrasenia = "Itson";
        //String contrasenia = "Alluka04";
        IConexion conexion = new Conexion(cadenaConexion, usuario, contrasenia);
        dispose();
        IClientesDAO clientesDAO = new ClientesDAO(conexion);
        dispose();
        FrmMenuPerfil menu = new FrmMenuPerfil(cliente, clientesDAO);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void llenarTabla() {

        List<Cuenta> cuentas = new LinkedList<>();
        try {
            cuentas = cuentasDAO.consultar(cliente);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("CUENTA No");
            modelo.addColumn("SALDO");
            modelo.addColumn("ESTADO");
            modelo.addColumn("AGREGAR MONTO");
            modelo.addColumn("TRANSFERIR");
            modelo.addColumn("RETIRO SIN CUENTA");
            modelo.addColumn("DESACTIVAR/ACTIVAR");

            for (Cuenta cuenta : cuentas) {
                Object[] fila = {
                    cuenta.getNum_cuenta(),
                    cuenta.getSaldo(),
                    cuenta.getEstado(),
                    "AGREGAR SALDO",
                    "TRANSFERIR",
                    "RETIRO SIN CUENTA",
                    "DESACTIVAR"
                };
                modelo.addRow(fila);
            }
            jTableCuentas.setModel(modelo);
            TableColumnModel columnModel = jTableCuentas.getColumnModel();

            ButtonColumn modificarButtonColumn = new ButtonColumn("Agregar saldo", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = jTableCuentas.convertRowIndexToModel(jTableCuentas.getEditingRow());
                    try {
                        Cuenta cuenta = obtenerSocioDesdeFila(row);

                    } catch (PersistenciaException ex) {
                        Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            ButtonColumn eliminarButtonColumn = new ButtonColumn("DESACTIVAR/ACTIVAR", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = jTableCuentas.convertRowIndexToModel(jTableCuentas.getEditingRow());
                    try {
                        Cuenta cuenta = obtenerSocioDesdeFila(row);
                        cuentasDAO.activacionCuenta(cuenta);
                        llenarTabla();
                    } catch (PersistenciaException ex) {
                        Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            ButtonColumn transferirButtonColumn = new ButtonColumn("Transferir", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = jTableCuentas.convertRowIndexToModel(jTableCuentas.getEditingRow());
                    try {
                        Cuenta cuenta = obtenerSocioDesdeFila(row);
                        if (cuenta.getEstado() == 1) {
                            dlgTransferencia transferencia = new dlgTransferencia(cuenta, cuentasDAO);
                            transferencia.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "La cuenta necesita estar activa","No es posible realizar una transferencia", JOptionPane.WARNING_MESSAGE);
                        }

                    } catch (PersistenciaException ex) {
                        Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            ButtonColumn crearRetiroButtonColumn = new ButtonColumn("Crear retiro", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = jTableCuentas.convertRowIndexToModel(jTableCuentas.getEditingRow());
                    try {
                        Cuenta cuenta = obtenerSocioDesdeFila(row);
                        System.out.println(cuenta);
                        System.out.println("transferir");
                        DlgCrearRetiro retiro = new DlgCrearRetiro(cuenta, cuentasDAO);
                        retiro.setVisible(true);
                    } catch (PersistenciaException ex) {
                        Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            columnModel.getColumn(3).setCellRenderer(modificarButtonColumn);
            columnModel.getColumn(3).setCellEditor(modificarButtonColumn);

            columnModel.getColumn(4).setCellRenderer(transferirButtonColumn);
            columnModel.getColumn(4).setCellEditor(transferirButtonColumn);

            columnModel.getColumn(5).setCellRenderer(crearRetiroButtonColumn);
            columnModel.getColumn(5).setCellEditor(crearRetiroButtonColumn);

            columnModel.getColumn(6).setCellRenderer(eliminarButtonColumn);
            columnModel.getColumn(6).setCellEditor(eliminarButtonColumn);

        } catch (PersistenciaException ex) {
            Logger.getLogger(FrmCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Cuenta obtenerSocioDesdeFila(int fila) throws PersistenciaException {
        List<Cuenta> cuentas = cuentasDAO.consultar(this.cliente);
        if (fila >= 0 && fila < cuentas.size()) {
            return cuentas.get(fila);
        } else {
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearNuevaCuenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCuentas;
    private javax.swing.JLabel lblNombreCliente;
    // End of variables declaration//GEN-END:variables
}
