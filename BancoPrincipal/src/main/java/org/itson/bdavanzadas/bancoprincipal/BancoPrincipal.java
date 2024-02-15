package org.itson.bdavanzadas.bancoprincipal;

import com.itson.bdaavanzadas.bancopersistencia.DAO.ClientesDAO;
import com.itson.bdaavanzadas.bancopersistencia.DAO.IClientesDAO;
import com.itson.bdaavanzadas.bancopersistencia.conexion.Conexion;
import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import org.itson.bdavanzadas.bancoprincipal.Frm.FrmMain;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class BancoPrincipal {

    public static void main(String[] args) {

        FrmMain form = new FrmMain ();
        String cadenaConexion = "jdbc:mysql://localhost/betobank_bda";
        String usuario = "root";
        String contrasenia = "Alluka04";
        //String contrasenia = "Itson";
        //String contrasenia = "kikin22";
        IConexion conexion = new Conexion (cadenaConexion, usuario, contrasenia);
        FrmMain main = new FrmMain();
        main.setVisible(true);
    }
}
