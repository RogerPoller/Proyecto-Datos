/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Roger
 */
public class database {
    public static void main(String args[]){  
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object
String conexion = "jdbc:oracle:thin:@localhost:1521:xe";
String usuario = "system";
String password = "roger";
Connection con=DriverManager.getConnection(  
conexion,usuario,password);  
  
//step3 create the statement object  
Statement stmt=con.createStatement();  
    System.out.println("Conexion establecida");
//step4 execute query  
ResultSet rs=stmt.executeQuery("select * from proveedores");  
while(rs.next())  
{
System.out.println(rs.getLong(1) +" "  + rs.getString(2) + " " + rs.getString(3));  
}
//step5 close the connection object  

con.close();  
  
}catch(Exception e){ System.out.println(e);}  
  
}  
}
    

