/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.itson.bdavanzadas.bancoprincipal.Frm;

import com.itson.bdaavanzadas.bancopersistencia.DAO.IClientesDAO;
import com.itson.bdaavanzadas.bancopersistencia.DTO.ClienteActualizadoDTO;
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
    private int operacion;
    private Cliente cliente;

    public DlgRegistro(IClientesDAO clientesDAO, int operacion) {
        initComponents();
        this.clientesDAO = clientesDAO;
        this.operacion = operacion;

    }

    public DlgRegistro(IClientesDAO clientesDAO, int operacion, Cliente cliente) {
        initComponents();
        this.clientesDAO = clientesDAO;
        this.operacion = operacion;
        this.cliente = cliente;

        if (this.operacion == ConstantesGUI.ACTUALIZAR) {
            this.txtNombre.setText(cliente.getNombre());
            this.txtApellidoPa.setText(cliente.getApellido_pa());
            this.txtApellidoMa.setText(cliente.getApellido_ma());
            this.jDateFechaNacimiento.setDate(cliente.getFecha_nacimiento());
            this.txtColonia.setText(cliente.getColonia());
            this.txtCalle.setText(cliente.getCalle());
            this.txtNumCasa.setText(cliente.getNumero_casa());
            this.txtCp.setText(cliente.getCp());
            this.txtContrasenia.setText(cliente.getContrasenia());
            this.txtCorreo.setText(cliente.getCorreo());
            this.txtCorreo.setEditable(false);
        }
    }

    /**
     * Método el cual obitiene los datos de los txt para guardar un cliente
     */
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

    private void actualizar() {

        String nombre = txtNombre.getText();
        String aP = txtApellidoPa.getText();
        String aM = txtApellidoMa.getText();
        String calle = txtCalle.getText();
        String colonia = txtColonia.getText();
        String num_casa = txtNumCasa.getText();
        String cp = txtCp.getText();
        String contra = txtContrasenia.getText();
        String correo = txtCorreo.getText();


        ClienteActualizadoDTO clienteActualizado = new ClienteActualizadoDTO();

        clienteActualizado.setNombre(nombre);
        clienteActualizado.setApellido_pa(aP);
        clienteActualizado.setApellido_ma(aM);
        java.util.Date fechaSeleccionada = jDateFechaNacimiento.getDate();
        java.sql.Date fechaNacimiento = new java.sql.Date(fechaSeleccionada.getTime());
        clienteActualizado.setFecha_nacimiento(fechaNacimiento);
        clienteActualizado.setCalle(calle);
        clienteActualizado.setColonia(colonia);
        clienteActualizado.setNumero_casa(num_casa);
        clienteActualizado.setCp(cp);
        clienteActualizado.setContrasenia(contra);
        clienteActualizado.setCorreo(correo);
        try {
            clienteActualizado.esValido();
            try {
                Cliente cliente = this.clientesDAO.actualizarCliente(clienteActualizado);
            } catch (PersistenciaException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error al actualizar el cliente", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ValidacionDTOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Rellena todas las casillas", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void limpiar() {
        if (this.operacion == ConstantesGUI.REGISTRAR) {
            txtNombre.setText("");
            txtApellidoPa.setText("");
            txtApellidoMa.setText("");
            txtCalle.setText("");
            txtColonia.setText("");
            txtNumCasa.setText("");
            txtCp.setText("");
            txtCorreo.setText("");
            txtContrasenia.setText("");
        } else if (this.operacion == ConstantesGUI.ACTUALIZAR) {
            this.txtNombre.setText(cliente.getNombre());
            this.txtApellidoPa.setText(cliente.getApellido_pa());
            this.txtApellidoMa.setText(cliente.getApellido_ma());
            this.jDateFechaNacimiento.setDate(cliente.getFecha_nacimiento());
            this.txtColonia.setText(cliente.getColonia());
            this.txtCalle.setText(cliente.getCalle());
            this.txtNumCasa.setText(cliente.getNumero_casa());
            this.txtCp.setText(cliente.getCp());
            this.txtContrasenia.setText(cliente.getContrasenia());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoPa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtContrasenia = new javax.swing.JPasswordField();
        txtCalle = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtNumCasa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRestaurar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Apellido Paterno:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Apellido Materno:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Fecha de nacimiento:");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Calle:");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Colonia:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("Número de casa:");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setText("CP:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setText("Contraseña:");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setText("Correo:");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel11.setText("REGISTRO");

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));

        btnRestaurar.setBackground(new java.awt.Color(204, 204, 204));
        btnRestaurar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnRestaurar.setText("restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(204, 204, 204));
        btnAceptar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnAceptar.setText("aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btnRestaurar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtApellidoPa)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidoMa)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(txtColonia)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumCasa)
                            .addComponent(txtCp)
                            .addComponent(jLabel7)))
                    .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(48, 48, 48)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidoPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (operacion == ConstantesGUI.REGISTRAR) {
            guardar();
        } else if (operacion == ConstantesGUI.ACTUALIZAR) {
            actualizar();
        }

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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
