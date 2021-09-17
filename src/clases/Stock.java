/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Roger
 */
public class Stock {
    public int ID_Stock;
    public int cantidad;
    public int stock_inicial;
    public String fecha_stock_inicial;
    public String ubicacion_repuesto;

    public Stock() {
    }

    public int getID_Stock() {
        return ID_Stock;
    }

    public void setID_Stock(int ID_Stock) {
        this.ID_Stock = ID_Stock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock_inicial() {
        return stock_inicial;
    }

    public void setStock_inicial(int stock_inicial) {
        this.stock_inicial = stock_inicial;
    }

    public String getFecha_stock_inicial() {
        return fecha_stock_inicial;
    }

    public void setFecha_stock_inicial(String fecha_stock_inicial) {
        this.fecha_stock_inicial = fecha_stock_inicial;
    }

    public String getUbicacion_repuesto() {
        return ubicacion_repuesto;
    }

    public void setUbicacion_repuesto(String ubicacion_repuesto) {
        this.ubicacion_repuesto = ubicacion_repuesto;
    }
    
    
}
