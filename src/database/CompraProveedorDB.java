/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import clases.Compra_proveedor;
import clases.Repuesto;
import clases.Stock;
import clases.Venta_cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Roger
 */
public class CompraProveedorDB {
        int aux_id_compra = 0;
        int aux_costo = 0;
        
    public void ajustar_costo(long cod){
        try{
               Connection cnx1 ;
        Statement st1 ;
        ResultSet rs1;
        cnx1 = DataBaseConnect.ObtenerConexion();
            st1 = cnx1.createStatement();
            rs1 = st1.executeQuery("Select costo_unit_Rep from compra_proveedor where ruc_proveedor = " + cod);
            while(rs1.next()){
                aux_costo = rs1.getInt(1);
                System.out.println("aux costo es:  " + aux_costo);
                break;
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
        }
           }
    
    public void registrar_compra(Compra_proveedor compra_prov){
        
            try {
             Connection cnx1 ;
             Statement st1 ;
             ResultSet rs1;
             cnx1 = DataBaseConnect.ObtenerConexion();
             st1 = cnx1.createStatement();
             rs1 = st1.executeQuery("Select max(id_compra)+1 from compra_proveedor");
             while(rs1.next()){
                aux_id_compra = rs1.getInt(1);
                System.out.println("aux es " + aux_id_compra);
             }    
                                               
            Connection cnx = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst = cnx.prepareStatement
                ("INSERT INTO compra_proveedor (id_compra,fecha_compra,costo_unit_rep,cantidad_compra,monto,medio_pago,ruc_proveedor,id_Stock) "
                        + "VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1, aux_id_compra);
            pst.setString(2, compra_prov.getFecha_compra());
            pst.setInt(3, aux_costo);
            pst.setInt(4, compra_prov.getCantidad_compra());
            pst.setInt(5, (aux_costo * compra_prov.getCantidad_compra()));
            pst.setString(6, compra_prov.getMedio_pago());
            pst.setLong(7,compra_prov.getRuc_proveedor() );
            pst.setInt(8, compra_prov.getId_Stock());
            
            pst.executeUpdate();
            System.out.println("ecselente");
            
            JOptionPane.showMessageDialog(null, "La compra fue exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
        }
        }
            
    public ArrayList<Compra_proveedor>  mostrar_compra_filtrada(int codigo){
                       ArrayList<Compra_proveedor> r1 = new ArrayList<>();
         try {
               Connection cnx ;
        Statement st ;
        ResultSet rs;
             cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();            
            rs = st.executeQuery(
                    "Select * from compra_proveedor  "
                            + " where id_compra = " + codigo); 
            while(rs.next()){
                Compra_proveedor c_pro = new Compra_proveedor();
                c_pro.setId_compra(rs.getInt(1));
                c_pro.setFecha_compra(rs.getString(2));
                c_pro.setCosto(rs.getInt(3));
                c_pro.setCantidad_compra(rs.getInt(4));
                c_pro.setMonto(rs.getInt(5));
                c_pro.setMedio_pago(rs.getString(6));
                c_pro.setRuc_proveedor(rs.getLong(7));
                c_pro.setId_Stock(rs.getInt(8));
                r1.add(c_pro);
            }
         
           
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }  
         return r1;
        }
            
    public ArrayList<Compra_proveedor>  mostrar_compras(){
                       ArrayList<Compra_proveedor> r1 = new ArrayList<>();
         try {
               Connection cnx ;
        Statement st ;
        ResultSet rs;
             cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();            
            rs = st.executeQuery(
                    "Select * from compra_proveedor"); 
            while(rs.next()){
                Compra_proveedor c_pro = new Compra_proveedor();
                c_pro.setId_compra(rs.getInt(1));
                c_pro.setFecha_compra(rs.getString(2));
                c_pro.setCosto(rs.getInt(3));
                c_pro.setCantidad_compra(rs.getInt(4));
                c_pro.setMonto(rs.getInt(5));
                c_pro.setMedio_pago(rs.getString(6));
                c_pro.setRuc_proveedor(rs.getLong(7));
                c_pro.setId_Stock(rs.getInt(8));
                r1.add(c_pro);
            }
         
           
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }  
         return r1;
        }
  int aux_compra_pv = 0;           
 public int max_compra() throws SQLException{
            Connection cnx ;
            Statement st ;
            ResultSet rs;
            cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
            rs = st.executeQuery("Select max(id_compra)+1 from compra_proveedor");
            while(rs.next()){
                aux_compra_pv = rs.getInt(1);
                
            }
            System.out.println("aux de compra proveedor es " + aux_compra_pv);
            return aux_compra_pv;
        }










}
  

