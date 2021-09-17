/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import clases.Cliente;
import clases.Repuesto;
import clases.Venta_cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Roger
 */

    

    public class Venta_clienteDB  {
        ClienteDB cliente = new ClienteDB();
        Venta_cliente venta = new Venta_cliente();
        Repuesto repuesto = new Repuesto();
        
        int aux_vt_cliente = 0; 
        public void max_venta() throws SQLException{
            Connection cnx ;
            Statement st ;
            ResultSet rs;
            cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
            rs = st.executeQuery("Select max(id_venta_cliente)+1 from venta_cliente");
            while(rs.next()){
                aux_vt_cliente = rs.getInt(1);
                System.out.println("aux de venta es " + aux_vt_cliente);
            }
        }
        
       
        public long seleccionar_ruc_sede(String nombre){
       long aux_ruc_sede = 0; 
            try{
            
                Connection cnx;
                Statement st ;
                ResultSet rs ;
                PreparedStatement pst = null;
                cnx = DataBaseConnect.ObtenerConexion();
                st = cnx.createStatement();
                rs = st.executeQuery(
                    "Select Ruc_sede from sede where direccion_sede = '"+nombre+"'"); 
        
        while(rs.next()){
            aux_ruc_sede = rs.getLong(1); 
            break;
        }
            System.out.println("el cidgo de sedes : " +aux_ruc_sede );
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error seleccionando sede");
            System.out.println(ex.getMessage());
          }
        return aux_ruc_sede;
        }
        
        
        public void insertar_vents(Venta_cliente venta_cliente, Repuesto rep, ClienteDB cli){
        
            try {
            Connection cnx = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst = cnx.prepareStatement
                ("INSERT INTO venta_cliente (ID_venta_cliente, cantidad_venta, total_venta,ID_repuesto,DNI,RUC_Sede) "
                        + "VALUES(?,?,?,?,?,?)");
            pst.setInt(1, aux_vt_cliente);
            System.out.println("cantidad: " + venta_cliente.getCantidad_venta());
            pst.setInt(2, venta_cliente.getCantidad_venta());
                   System.out.println("repuesto: " + repuesto.getPrecio());
                System.out.println("total: " + venta_cliente.getCantidad_venta() * rep.getPrecio()); 
            pst.setInt(3, (venta_cliente.getCantidad_venta() * rep.getPrecio()));
             System.out.println("Codigo repuest: " + rep.getID_repuesto());
            pst.setInt(4, rep.getID_repuesto());
               System.out.println("cliente:" + cli.getDNI_test());
            pst.setLong(5, cli.getDNI_test());
                
            pst.setLong(6,31692264418L); 
            
            pst.executeUpdate();
            System.out.println("ecselente");
            
            JOptionPane.showMessageDialog(null, "La compra fue exitosa, el codigo de su compra es el: " + aux_vt_cliente );
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
        }
        }
  

 
    
    
    
    
}


