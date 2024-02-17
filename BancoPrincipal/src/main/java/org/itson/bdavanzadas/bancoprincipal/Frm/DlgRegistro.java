/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.itson.bdavanzadas.bancoprincipal.Frm;

import com.itson.bdaavanzadas.bancopersistencia.DAO.IClientesDAO;
import com.itson.bdaavanzadas.bancopersistencia.DTO.ClienteNuevoDTO;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.ValidacionDTOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.itson.bdavanzadas.bancodominio.Cliente;

/**
 *
 * @author Hector Espinoza y Enrique Rodríguez
 */
public class DlgRegistro extends javax.swing.JDialog {

    private final IClientesDAO clientesDAO;

    public DlgRegistro(IClientesDAO clientesDAO) {
        initComponents();
        this.clientesDAO = clientesDAO;
    }

    private void guardar() {
        String nombre = txtNombre.getText();
        String aP = txtApellidoPa.getText();
        String aM = txtApellidoMa.getText();
        String calle = txtCalle.getText();
        String colonia = txtColonia.getText();
        String num_casa = txtNumCasa.getText();
        String cp = txtCp.getText();
        String contra = txtContrasenia.getText();
        String correo = txtCorreo.getText();

        ClienteNuevoDTO clienteNuevo = new ClienteNuevoDTO();

        clienteNuevo.setNombre(nombre);
        clienteNuevo.setApellido_pa(aP);
        clienteNuevo.setApellido_ma(aM);
        java.util.Date fechaSeleccionada = jDateFechaNacimiento.getDate();
        java.sql.Date fechaNacimiento = new java.sql.Date(fechaSeleccionada.getTime());
        clienteNuevo.setFecha_nacimiento(fechaNacimiento);
        clienteNuevo.setCalle(calle);
        clienteNuevo.setColonia(colonia);
        clienteNuevo.setNumero_casa(num_casa);
        clienteNuevo.setCp(cp);
        clienteNuevo.setContrasenia(contra);
        clienteNuevo.setCorreo(correo);
        try {
            clienteNuevo.esValido();
            Cliente cliente = this.clientesDAO.agregarCliente(clienteNuevo);
            JOptionPane.showMessageDialog(this, "Se registró el cliente", "Todo correcto", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } catch (ValidacionDTOException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Rellena todas las casillas", JOptionPane.ERROR_MESSAGE);
        } catch (PersistenciaException ex) {
            Logger.getLogger(DlgRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellidoPa.setText("");
        txtApellidoMa.setText("");
        txtCalle.setText("");
        txtColonia.setText("");
        txtNumCasa.setText("");
        txtCp.setText("");
        txtCorreo.setText("");
        txtContrasenia.setText("");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtApellidoPa = new javax.swing.JTextField();
        txtApellidoMa = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtColonia = new javax.swing.JTextField();
        txtNumCasa = new javax.swing.JTextField();
        txtCp = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAceptar.setText("aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnRestaurar.setText("restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnAceptar)
                        .addGap(33, 33, 33)
                        .addComponent(btnRestaurar)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtApellidoMa, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellidoPa))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNumCasa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCp, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(txtCorreo)
                                    .addComponent(txtContrasenia))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(txtApellidoPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtApellidoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnRestaurar)
                    .addComponent(btnCancelar))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        guardar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRestaurar;
    private com.toedter.calendar.JDateChooser jDateFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtApellidoMa;
    private javax.swing.JTextField txtApellidoPa;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCp;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumCasa;
    // End of variables declaration//GEN-END:variables
}
