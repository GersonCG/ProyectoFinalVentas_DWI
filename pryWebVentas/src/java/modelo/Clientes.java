
package modelo;

public class Clientes {
    
    int idcliente; // ID del cliente
    String clnombre; // Nombre del cliente
    String clapellido; // Apellido del cliente
    String clDNI; // DNI del cliente
    int cltelefono; // Teléfono del cliente
    String clcorreo; // Correo electrónico del cliente
    String cldireccion; // Dirección del cliente

    public Clientes() {
    }

    public Clientes(int idcliente, String clnombre, String clapellido, String clDNI, int cltelefono, String clcorreo, String cldireccion) {
        this.idcliente = idcliente;
        this.clnombre = clnombre;
        this.clapellido = clapellido;
        this.clDNI = clDNI;
        this.cltelefono = cltelefono;
        this.clcorreo = clcorreo;
        this.cldireccion = cldireccion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getClnombre() {
        return clnombre;
    }

    public void setClnombre(String clnombre) {
        this.clnombre = clnombre;
    }

    public String getClapellido() {
        return clapellido;
    }

    public void setClapellido(String clapellido) {
        this.clapellido = clapellido;
    }

    public String getClDNI() {
        return clDNI;
    }

    public void setClDNI(String clDNI) {
        this.clDNI = clDNI;
    }

    public int getCltelefono() {
        return cltelefono;
    }

    public void setCltelefono(int cltelefono) {
        this.cltelefono = cltelefono;
    }

    public String getClcorreo() {
        return clcorreo;
    }

    public void setClcorreo(String clcorreo) {
        this.clcorreo = clcorreo;
    }

    public String getCldireccion() {
        return cldireccion;
    }

    public void setCldireccion(String cldireccion) {
        this.cldireccion = cldireccion;
    }


}

