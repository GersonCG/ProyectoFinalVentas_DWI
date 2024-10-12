package modelo;

public class Factura {
    int idcabecera;
    int cbcantidad;
    String cbfecha;
    String nombreCompleto;
  
    // Constructor

    public Factura(int idcabecera, int cbcantidad, String cbfecha, String nombreCompleto) {
        this.idcabecera = idcabecera;
        this.cbcantidad = cbcantidad;
        this.cbfecha = cbfecha;
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdcabecera() {
        return idcabecera;
    }

    public void setIdcabecera(int idcabecera) {
        this.idcabecera = idcabecera;
    }

    public int getCbcantidad() {
        return cbcantidad;
    }

    public void setCbcantidad(int cbcantidad) {
        this.cbcantidad = cbcantidad;
    }

    public String getCbfecha() {
        return cbfecha;
    }

    public void setCbfecha(String cbfecha) {
        this.cbfecha = cbfecha;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
      
}
