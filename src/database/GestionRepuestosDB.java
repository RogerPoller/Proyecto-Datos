/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import clases.GestionRepuestos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Roger
 */
public class GestionRepuestosDB {
    
    public void Insertar_gt_repuestos(GestionRepuestos GestionRP){
            try {
            Connection cnx = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst = cnx.prepareStatement
                ("INSERT INTO gestion_repuestos(id_repuesto, id_compra, fecha_entregable) "
                        + "VALUES(?,?,?)");
            pst.setInt(1, GestionRP.getId_Repuesto());
            pst.setInt(2, GestionRP.getId_compra());
            pst.setString(3, GestionRP.getFecha_entregable());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Se actualizo la gestión de repuestos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
        }
    }
}
