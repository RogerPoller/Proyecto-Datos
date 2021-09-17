/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import clases.Cliente;
import database.DataBaseConnect;
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

public class ClienteDB {
    
    long DNI_test;

    public ClienteDB() {
    }

    public long getDNI_test() {
        return DNI_test;
    }

    public void setDNI_test(long DNI_test) {
        this.DNI_test = DNI_test;
    }

  
    
    

 
     
        /*public ArrayList<Cliente> getListadosCliente() {
        ArrayList<Cliente> cli = new ArrayList<>();
        try {
            cnx = ConexionDB.getConneccion();
            st = cnx.createStatement();
            rs = st.executeQuery("SELECT IDCLIENTE,NOMBRE,APELLIDO,DNI,TELEFONO,DIRECCION"
                    + " FROM CLIENTES ");
            while (rs.next()) {
                Clientes c = new Clientes();
                c.setId_cliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setDireccion(rs.getString(6));
                cli.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cli;*/
    
    public void insertar_cliente(Cliente cliente){
        try {
            Connection cnx = DataBaseConnect.ObtenerConexion();
            PreparedStatement pst = cnx.prepareStatement
                ("INSERT INTO CLIENTE(DNI, NOMBRE_CLIENTE, APELLIDO_CLIENTE,TELEFONO,CANTIDAD_COMPRAS,DIRECCION) "
                        + "VALUES(?,?,?,?,?,?)");
            pst.setLong(1, cliente.getDNI());
            pst.setString(2, cliente.getNombre_cliente());
            pst.setString(3, cliente.getApellido_cliente());
            pst.setString(4, cliente.getTelefono());
            pst.setInt(5, 0);
            pst.setString(6,cliente.getDireccion());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El ingreso fue exitoso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El DNI ya existe");
            System.out.println(ex.getMessage());
        }
    }
    
    public void comprobar_cliente(long DNI){
            Connection cnx ;
            Statement st ;
            ResultSet rs ;
            PreparedStatement pst = null;
        
        try {
            cnx = DataBaseConnect.ObtenerConexion();
            st = cnx.createStatement();
            rs = st.executeQuery("Select DNI from cliente where DNI = '" +DNI + "'");
            while(rs.next()){
            if(rs.getLong(1) == DNI){
                this.setDNI_test(DNI);
                JOptionPane.showMessageDialog(null, "EL usuario fue registrado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "El usuario no existe, ¡Registrese ya!");
            }
        } }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error");
            Logger.getLogger(ClienteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

