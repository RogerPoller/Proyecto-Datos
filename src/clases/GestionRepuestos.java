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
public class GestionRepuestos {
   int  id_Repuesto;
   int id_compra;
   String fecha_entregable;

    public GestionRepuestos() {
    }

    public int getId_Repuesto() {
        return id_Repuesto;
    }

    public void setId_Repuesto(int id_Repuesto) {
        this.id_Repuesto = id_Repuesto;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getFecha_entregable() {
        return fecha_entregable;
    }

    public void setFecha_entregable(String fecha_entregable) {
        this.fecha_entregable = fecha_entregable;
    }
   
   
   
   
}

