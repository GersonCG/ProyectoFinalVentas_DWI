package modelo;

public class Categoria {
    int idcategoria; // ID de la categoría
    String caDescripcion; // Descripción de la categoría

    // Constructor
    public Categoria(int idcategoria, String caDescripcion) {
        this.idcategoria = idcategoria;
        this.caDescripcion = caDescripcion;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCaDescripcion() {
        return caDescripcion;
    }

    public void setCaDescripcion(String caDescripcion) {
        this.caDescripcion = caDescripcion;
    }

    // Método toString para representar la categoría como cadena
    @Override
    public String toString() {
        return "Categoria{" +
                "categId=" + idcategoria +
                ", categDescripcion='" + caDescripcion + '\'' +
                '}';
    }
}
