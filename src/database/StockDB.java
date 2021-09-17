/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import clases.Repuesto;
import clases.Stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Roger
 */
public class StockDB {
    
    public void insertar_Stock() throws SQLException{
        int aux = 0;
        Connection cnx ;
        Statement st ;
        ResultSet rs;
        cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
            rs = st.executeQuery("Select max(id_Stock)+1 from stock");
            while(rs.next()){
                aux = rs.getInt(1);
                System.out.println("aux es " + aux);
            }
        /*
        cnx2 = DataBaseConnect.ObtenerConexion();
        st2 = cnx2.createStatement();
        rs2 = st2.executeQuery("insert into stock ((select max(id_stock)+1 from stock),0,0,sysdate,'gondola A2')");*/
      
        Date fecha = new Date();
    SimpleDateFormat formatofecha =  new SimpleDateFormat("MM/dd/yyyy");    
    String aux_fecha =formatofecha.format(fecha);
       Connection cnx2 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst = cnx2.prepareStatement
                ("INSERT INTO stock(id_stock, cantidad, stock_inicial,fecha_stock_inicial,ubicacion_repuesto) "
                        + "VALUES(?,?,?,?,?)");
            pst.setInt(1, aux);
            pst.setInt(2, 0);
            pst.setInt(3, 0);
            pst.setString(4, aux_fecha);//CAMBIOSSSS
            pst.setString(5,"Gondola 1");
            pst.executeUpdate();
        
        
        
    }
    
    public ArrayList<Stock>  mostrar_stock(int cod_stock){
         ArrayList<Stock> stock = new ArrayList<>();
         try {
            Connection cnx ;
            Statement st ;
            ResultSet rs;
            cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
             System.out.println("conexion establecida");
            rs = st.executeQuery(
                    "Select * from stock  "
                            + " where id_Stock = '" + cod_stock +"' "); 
            while(rs.next()){
                Stock stck = new Stock();
                stck.setID_Stock(rs.getInt(1));
                stck.setCantidad(rs.getInt(2));
                stck.setStock_inicial(rs.getInt(3));
                stck.setFecha_stock_inicial(rs.getString(4));
                stck.setUbicacion_repuesto(rs.getString(5));
                stock.add(stck);
            }
         
           
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            System.out.println(ex.getMessage());
          }  
         return stock;
        }
    
    public void actualizar_stock_compra(Stock stc){
                  try {
           Connection cnx3 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst3 = cnx3.prepareStatement 
                    ("UPDATE Stock SET "
                    + "cantidad= cantidad + " + stc.getCantidad()
                    + " WHERE id_Stock=?");
            pst3.setInt(1, stc.getID_Stock());
            pst3.executeQuery();
            JOptionPane.showMessageDialog(null, "Se actualizo la cantidad");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
        public void actualizar_stock_venta(int cod, int cant){
                  try {
           Connection cnx3 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst3 = cnx3.prepareStatement 
                    ("UPDATE Stock SET "
                    + "cantidad= cantidad - " + cant
                    + " WHERE id_Stock=?");
            pst3.setInt(1, cod);
            pst3.executeQuery();
            JOptionPane.showMessageDialog(null, "Se actualizo la cantidad");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
         public void actualizar_fecha(Stock stc){
                  try {
           Connection cnx3 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst3 = cnx3.prepareStatement 
                    ("UPDATE Stock SET "
                    + " fecha_stock_inicial = '" + stc.getFecha_stock_inicial() + "'"
                    + " WHERE id_Stock=?");
            pst3.setInt(1, stc.getID_Stock());
            pst3.executeQuery();
            JOptionPane.showMessageDialog(null, "Se actualizo la fecha");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
         
         public void actualizar_stock_inicial(Stock stc){
                  try {
           Connection cnx3 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst3 = cnx3.prepareStatement 
                    ("UPDATE Stock SET "
                    + " stock_inicial = cantidad " 
                    + " WHERE id_Stock=?");
            pst3.setInt(1, stc.getID_Stock());
            pst3.executeQuery();
            JOptionPane.showMessageDialog(null, "Se actualizo el stock_inicial");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
         
         public void actualizar_ubicacion(String ubicacion, int cod){
                  try {
           Connection cnx3 = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst3 = cnx3.prepareStatement 
                    ("UPDATE Stock SET "
                    + " ubicacion_repuesto =  '" +ubicacion + "'"
                    + " WHERE id_Stock=?");
            pst3.setInt(1, cod);
            pst3.executeQuery();
            JOptionPane.showMessageDialog(null, "Se actualizo la ubicación del repuesto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    }

