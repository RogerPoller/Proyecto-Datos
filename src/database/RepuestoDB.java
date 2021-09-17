/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import clases.Cliente;
import clases.Repuesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Roger
 */
public class RepuestoDB {
    int aux_repuesto = 0;
     int aux_Stock = 0;
    Connection cnx = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
   public void insertar_stock(){
       try{
        
        Connection cnx ;
        Statement st ;
        ResultSet rs;
        cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
            rs = st.executeQuery("Select max(id_Stock)+1 from stock");
            while(rs.next()){
                aux_Stock = rs.getInt(1);
                System.out.println("aux es " + aux_Stock);
            }
            
         Connection cnx4 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst4 = cnx4.prepareStatement
                ("INSERT INTO stock(id_stock, cantidad, stock_inicial,fecha_stock_inicial,ubicacion_repuesto) "
                        + "VALUES(?,?,?,?,?)");
            pst4.setInt(1, aux_Stock);
            pst4.setInt(2, 0);
            pst4.setInt(3, 0);
            pst4.setString(4, "11/07/2020");
            pst4.setString(5,"Gondola 1");
            pst4.executeUpdate();
            System.out.println("El ingreso de stock fue exito");
           } catch (SQLException ex) {
            Logger.getLogger(RepuestoDB.class.getName()).log(Level.SEVERE, null, ex);
        }  
   }
            
          
      public void insertar_repuesto(Repuesto repuesto){
          
        try{
          Connection cnx1 ;
        Statement st1 ;
        ResultSet rs1;
        cnx1 = DataBaseConnect.ObtenerConexion();
            st1 = cnx1.createStatement();
            rs1 = st1.executeQuery("Select max(id_repuesto)+1 from repuesto");
            while(rs1.next()){
                aux_repuesto = rs1.getInt(1);
                System.out.println("aux es " + aux_repuesto);
            }
      
        Connection cnx3 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst3 = cnx3.prepareStatement
                ("INSERT INTO repuesto(id_repuesto,nombre_rep,descripcion,modelo_vehiculo,marca_vehiculo,precio,tipo_sistema,medidas,material,calidad,garantia,id_Stock) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst3.setInt(1, aux_repuesto);
            pst3.setString(2, repuesto.getNombre_rep());
            pst3.setString(3, repuesto.getDescripcion());
            pst3.setString(4, repuesto.getModelo_vehiculo());
            pst3.setString(5, repuesto.getMarca_vehiculo());
            pst3.setInt(6,repuesto.getPrecio());
            pst3.setString(7, repuesto.getTipo_sistema());
            pst3.setString(8,repuesto.getMedidas());
            pst3.setString(9, repuesto.getMaterial());
            pst3.setString(10, repuesto.getCalidad());
            pst3.setString(11, repuesto.getGarantia());
            pst3.setInt(12, aux_Stock);
            pst3.executeUpdate();
        
      
            JOptionPane.showMessageDialog(null, "El ingreso del nuevo repuesto fue exitosa");
       } catch (SQLException ex) {
            Logger.getLogger(RepuestoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
      
      public void actualizar_precio(Repuesto rp){
          try {
           Connection cnx3 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst3 = cnx3.prepareStatement 
                    ("UPDATE Repuesto SET "
                    + "precio=?"
                    + " WHERE id_repuesto=?");
            pst3.setInt(1, rp.getPrecio());
            pst3.setInt(2, rp.getID_repuesto());
            pst3.executeQuery();
            JOptionPane.showMessageDialog(null, "La actualización del precio se realizo con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
      }
      
       public void actualizar_garantia(Repuesto rp){
          try {
           Connection cnx3 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst3 = cnx3.prepareStatement 
                    ("UPDATE Repuesto SET "
                    + "garantia=?"
                    + " WHERE id_repuesto=?");
            pst3.setString(1, rp.getGarantia());
            pst3.setInt(2, rp.getID_repuesto());
            pst3.executeQuery();
            JOptionPane.showMessageDialog(null, "La actualización de la Garantía se realizo con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
      }

         
    
    public ArrayList<Repuesto> getListadosRepuestos() {
        ArrayList<Repuesto> r1 = new ArrayList<>();
         try {
              Connection cnx1 = null;
              Statement st1 = null;
              ResultSet rs1 = null;
              PreparedStatement pst1 = null;
             cnx1 = DataBaseConnect.ObtenerConexion();
            st1 = cnx1.createStatement();
            rs1 = st1.executeQuery("Select * from repuesto order by id_repuesto asc"); 
            while(rs1.next()){
                Repuesto rep = new Repuesto();
                rep.setID_repuesto(rs1.getInt(1));
                rep.setNombre_rep(rs1.getString(2));
                rep.setDescripcion(rs1.getString(3));
                rep.setModelo_vehiculo(rs1.getString(4));
                rep.setMarca_vehiculo(rs1.getString(5));
                rep.setPrecio(rs1.getInt(6));
                rep.setTipo_sistema(rs1.getString(7));
                rep.setMedidas(rs1.getString(8));
                rep.setMaterial(rs1.getString(9));
                rep.setCalidad(rs1.getString(10));
                rep.setGarantia(rs1.getString(11));
                rep.setID_Stock(rs1.getInt(12));
                r1.add(rep);
            }
           
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }  
         return r1;
        }
          
          public ArrayList<Repuesto> getListaFiltrada(String nombre, String modelo, String marca, String tipo_sistema) {
                ArrayList<Repuesto> r1 = new ArrayList<>();
         try {
             
             cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
             System.out.println("nombre: " + nombre);
             System.out.println("modelo:" + modelo);
             System.out.println("marca:" + marca);
             System.out.println("tipo_sistema:" + tipo_sistema);
            rs = st.executeQuery(
                    "Select * from repuesto  "
                            + " where nombre_Rep = '" + nombre +"' "
                            + "  and modelo_vehiculo = '" + modelo +"'"
                            + " and marca_vehiculo = '" + marca +"'"
                            + " and tipo_sistema = '" + tipo_sistema + "'"); 
            while(rs.next()){
                Repuesto rep = new Repuesto();
                rep.setID_repuesto(rs.getInt(1));
                System.out.println("codigo repuesto: " + rep.getID_repuesto());
                rep.setNombre_rep(rs.getString(2));
                rep.setDescripcion(rs.getString(3));
                rep.setModelo_vehiculo(rs.getString(4));
                rep.setMarca_vehiculo(rs.getString(5));
                rep.setPrecio(rs.getInt(6));
                rep.setTipo_sistema(rs.getString(7));
                rep.setMedidas(rs.getString(8));
                rep.setMaterial(rs.getString(9));
                rep.setCalidad(rs.getString(10));
                rep.setGarantia(rs.getString(11));
                rep.setID_Stock(rs.getInt(12));
                r1.add(rep);
            }
           
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }  
         return r1;
        }
         
        /* public ArrayList<> BuscarStock(){
             
         }*/
          
         public ArrayList<Repuesto>  BuscarRepuesto(int id_rep) {
                ArrayList<Repuesto> r1 = new ArrayList<>();
         try {
             cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
             System.out.println("hola");
            rs = st.executeQuery(
                    "Select * from repuesto  "
                            + " where id_repuesto = '" + id_rep +"' "); 
            while(rs.next()){
                Repuesto rep = new Repuesto();
                rep.setID_repuesto(rs.getInt(1));
                System.out.println("codigo repuesto: " + rep.getID_repuesto());
                rep.setNombre_rep(rs.getString(2));
                 rep.setDescripcion(rs.getString(3));
                rep.setModelo_vehiculo(rs.getString(4));
                rep.setMarca_vehiculo(rs.getString(5));
                rep.setPrecio(rs.getInt(6));
                rep.setTipo_sistema(rs.getString(7));
                rep.setMedidas(rs.getString(8));
                rep.setMaterial(rs.getString(9));
                rep.setCalidad(rs.getString(10));
                rep.setGarantia(rs.getString(11));
                rep.setID_Stock(rs.getInt(12));
                r1.add(rep);
            }
         
           
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }  
         return r1;
        } 
   
         
    public ArrayList<Repuesto> MostrarInventario(int id_rep) {
        ArrayList<Repuesto> r1 = new ArrayList<>();
         try {
             cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
             //System.out.println("hola");
            rs = st.executeQuery(
                    "Select * from repuesto  "
                            + " where id_repuesto = '" + id_rep +"' "); 
            while(rs.next()){
                Repuesto rep = new Repuesto();
                rep.setID_repuesto(rs.getInt(1));
                System.out.println("codigo repuesto: " + rep.getID_repuesto());
                rep.setNombre_rep(rs.getString(2));
                rep.setDescripcion(rs.getString(3));
                rep.setModelo_vehiculo(rs.getString(4));
                rep.setMarca_vehiculo(rs.getString(5));
                rep.setPrecio(rs.getInt(6));
                rep.setTipo_sistema(rs.getString(7));
                rep.setMedidas(rs.getString(8));
                rep.setMaterial(rs.getString(9));
                rep.setCalidad(rs.getString(10));
                rep.setGarantia(rs.getString(11));
                rep.setID_Stock(rs.getInt(12));
                r1.add(rep);
            }
         
           
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }  
         return r1;
        }
    
    public int seleccionar_Stock(Repuesto rp){
        
        int aux_stock_id = 0;
        try{
        cnx = DataBaseConnect.ObtenerConexion();
        st = cnx.createStatement();
        rs = st.executeQuery(
                    "Select id_Stock from repuesto  "
                            + " where id_repuesto = " + rp.getID_repuesto()); 
        
        while(rs.next()){
            aux_stock_id = rs.getInt(1);
        }
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }
        
        return aux_stock_id;
    }
    
     public int seleccionar_id_repuesto(int cod){
        
        int aux_repuesto_id = 0;
        try{
        cnx = DataBaseConnect.ObtenerConexion();
        st = cnx.createStatement();
        rs = st.executeQuery(
                    "Select id_repuesto from repuesto  "
                            + " where id_stock = " + cod); 
        
        while(rs.next()){
            aux_repuesto_id = rs.getInt(1);
        }
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }
        
        return aux_repuesto_id;
    }
}
    

