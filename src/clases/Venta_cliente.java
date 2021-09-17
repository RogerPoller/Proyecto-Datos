/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import database.*;
import clases.Cliente;

/**
 *
 * @author Roger
 */

    public class Venta_cliente extends Cliente {
    int ID_venta_Cliente = 0;
    int cantidad_venta = 0;
    int total_venta = 0;
    int id_repuesto;
    int DNi;
    long ruc_Sede;

    public Venta_cliente(){
        
    }
    /*public venta_cliente(int id_clientes, String nombre_cliente, String apellido_cliente, String telefono, int cantidad, String direccion, int DNI) {
        super(id_clientes, nombre_cliente, apellido_cliente, telefono, cantidad, direccion, DNI);
    }*/

    public int getID_venta_Cliente() {
        return ID_venta_Cliente;
    }

    public void setID_venta_Cliente(int ID_venta_Cliente) {
        this.ID_venta_Cliente = ID_venta_Cliente;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public int getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(int total_venta) {
        this.total_venta = total_venta;
    }

    public int getId_repuesto() {
        return id_repuesto;
    }

    public void setId_repuesto(int id_repuesto) {
        this.id_repuesto = id_repuesto;
    }

    public long getRuc_Sede() {
        return ruc_Sede;
    }

    public void setRuc_Sede(long ruc_Sede) {
        this.ruc_Sede = ruc_Sede;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    
 
    
    
    
    
}


