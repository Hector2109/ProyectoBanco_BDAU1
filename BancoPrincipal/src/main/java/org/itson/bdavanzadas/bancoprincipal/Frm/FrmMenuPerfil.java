/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.bancoprincipal.Frm;

import com.itson.bdaavanzadas.bancopersistencia.DAO.IClientesDAO;
import java.util.List;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;

/**
 *
 * @author Hector Espinoza
 */
public class FrmMenuPerfil extends javax.swing.JFrame {
    
    private Cliente cliente;
    private final IClientesDAO clientesDAO;
    /**
     * Creates new form FrmMenuPerfil
     */
    public FrmMenuPerfil(Cliente cliente, IClientesDAO clientesDAO) {
        initComponents();
        this.cliente = cliente;
        setVisible(true);
        this.clientesDAO = clientesDAO;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRetiro = new javax.swing.JButton();
        btnCuentas = new javax.swing.JButton();
        btnHistorialTransferencia = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel1.setText("BETOBANK");

        btnRetiro.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnRetiro.setText("AJUSTES");
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });

        btnCuentas.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnCuentas.setText("CUENTA(S)");
        btnCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentasActionPerformed(evt);
            }
        });

        btnHistorialTransferencia.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnHistorialTransferencia.setText("HISTORIAL TRANSFERENCIAS");
        btnHistorialTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialTransferenciaActionPerformed(evt);
            }
        });

        jButton1.setText("CERRAR SESION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(321, 321, 321))
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHistorialTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHistorialTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRetiro, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroActionPerformed

    private void btnCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasActionPerformed
        FrmCuentas cuentas = new FrmCuentas(cliente);
        setVisible(false);
    }//GEN-LAST:event_btnCuentasActionPerformed

    private void btnHistorialTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialTransferenciaActionPerformed
        FrmHistorialProcesos historial = new FrmHistorialProcesos(cliente);
        setVisible(false);
    }//GEN-LAST:event_btnHistorialTransferenciaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmMain s = new FrmMain(clientesDAO);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void llenarTabla(){
        List<Cuenta> listaCuenta;
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuentas;
    private javax.swing.JButton btnHistorialTransferencia;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
