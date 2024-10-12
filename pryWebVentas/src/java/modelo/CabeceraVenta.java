/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author gerson
 */
public class CabeceraVenta {
   private int cab_id;
   private int cab_cantidad;
   private Date cab_fecha;
   private int cli_id;

    public CabeceraVenta(int cab_id, int cab_cantidad, Date cab_fecha, int cli_id) {
        this.cab_id = cab_id;
        this.cab_cantidad = cab_cantidad;
        this.cab_fecha = cab_fecha;
        this.cli_id = cli_id;
    }

    public CabeceraVenta() {
    }

    public int getCab_id() {
        return cab_id;
    }

    public void setCab_id(int cab_id) {
        this.cab_id = cab_id;
    }

    public int getCab_cantidad() {
        return cab_cantidad;
    }

    public void setCab_cantidad(int cab_cantidad) {
        this.cab_cantidad = cab_cantidad;
    }

    public Date getCab_fecha() {
        return cab_fecha;
    }

    public void setCab_fecha(Date cab_fecha) {
        this.cab_fecha = cab_fecha;
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

   
   
   
}
