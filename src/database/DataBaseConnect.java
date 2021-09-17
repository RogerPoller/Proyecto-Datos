/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import proyectodatos.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roger
 */
public class DataBaseConnect {
    public static Connection ObtenerConexion(){ 
    try{  
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        String conexion = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "system";
        String password = "roger";
        Connection con=DriverManager.getConnection(conexion,usuario,password);  
        return con;
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
}
  


  


    

