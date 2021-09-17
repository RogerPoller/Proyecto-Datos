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
public class Repuesto {
    int ID_repuesto ;
    String nombre_rep;
    String descripcion; 
    String modelo_vehiculo; 
    String marca_vehiculo; 
    int precio;
    String tipo_sistema; 
    String medidas; 
    String material; 
    String calidad; 
    String garantia; 
    int ID_Stock;
    
    public Repuesto(){
        
    }
    
    public Repuesto(int ID_repuesto, String nombre_rep, String descripcion, String modelo_vehiculo, String marca_vehiculo, int precio, String tipo_sitema, String medidas, String material, String calidad, String garantia, int ID_Stock) {
        this.ID_repuesto = ID_repuesto;
        this.nombre_rep = nombre_rep;
        this.descripcion = descripcion;
        this.modelo_vehiculo = modelo_vehiculo;
        this.marca_vehiculo = marca_vehiculo;
        this.precio = precio;
        this.tipo_sistema = tipo_sitema;
        this.medidas = medidas;
        this.material = material;
        this.calidad = calidad;
        this.garantia = garantia;
        this.ID_Stock = ID_Stock;
    }

    public int getID_repuesto() {
        return ID_repuesto;
    }

    public void setID_repuesto(int ID_repuesto) {
        this.ID_repuesto = ID_repuesto;
    }

    public String getNombre_rep() {
        return nombre_rep;
    }

    public void setNombre_rep(String nombre_rep) {
        this.nombre_rep = nombre_rep;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo_vehiculo() {
        return modelo_vehiculo;
    }

    public void setModelo_vehiculo(String modelo_vehiculo) {
        this.modelo_vehiculo = modelo_vehiculo;
    }

    public String getMarca_vehiculo() {
        return marca_vehiculo;
    }

    public void setMarca_vehiculo(String marca_vehiculo) {
        this.marca_vehiculo = marca_vehiculo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo_sistema() {
        return tipo_sistema;
    }

    public void setTipo_sistema(String tipo_sistema) {
        this.tipo_sistema = tipo_sistema;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public int getID_Stock() {
        return ID_Stock;
    }

    public void setID_Stock(int ID_Stock) {
        this.ID_Stock = ID_Stock;
    }
 
}

