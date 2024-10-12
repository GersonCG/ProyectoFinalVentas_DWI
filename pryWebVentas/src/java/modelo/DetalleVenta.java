/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gerson
 */
public class DetalleVenta {
    
   private int det_id;
   private int det_cantidad;
   private double det_precio;
   private double det_total;
   private int prd_id;
   private int cab_id;

    public DetalleVenta() {
    }

    public DetalleVenta(int det_id, int det_cantidad, double det_precio, double det_total, int prd_id, int cab_id) {
        this.det_id = det_id;
        this.det_cantidad = det_cantidad;
        this.det_precio = det_precio;
        this.det_total = det_total;
        this.prd_id = prd_id;
        this.cab_id = cab_id;
    }

    public int getDet_id() {
        return det_id;
    }

    public void setDet_id(int det_id) {
        this.det_id = det_id;
    }

    public int getDet_cantidad() {
        return det_cantidad;
    }

    public void setDet_cantidad(int det_cantidad) {
        this.det_cantidad = det_cantidad;
    }

    public double getDet_precio() {
        return det_precio;
    }

    public void setDet_precio(double det_precio) {
        this.det_precio = det_precio;
    }

    public double getDet_total() {
        return det_total;
    }

    public void setDet_total(double det_total) {
        this.det_total = det_total;
    }

    public int getPrd_id() {
        return prd_id;
    }

    public void setPrd_id(int prd_id) {
        this.prd_id = prd_id;
    }

    public int getCab_id() {
        return cab_id;
    }

    public void setCab_id(int cab_id) {
        this.cab_id = cab_id;
    }
   
}
