
package modelo;

public class Usuarios {
    
    int idusuario;
    String unombre;
    String uapellido;
    String uusuario;
    String upassword;
    int utelefono;
    String urol;

    public Usuarios() {
    }

    public Usuarios(int idusuario, String unombre, String uapellido, String uusuario, String upassword, int utelefono, String urol) {
        this.idusuario = idusuario;
        this.unombre = unombre;
        this.uapellido = uapellido;
        this.uusuario = uusuario;
        this.upassword = upassword;
        this.utelefono = utelefono;
        this.urol = urol;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUnombre() {
        return unombre;
    }

    public void setUnombre(String unombre) {
        this.unombre = unombre;
    }

    public String getUapellido() {
        return uapellido;
    }

    public void setUapellido(String uapellido) {
        this.uapellido = uapellido;
    }

    public String getUusuario() {
        return uusuario;
    }

    public void setUusuario(String uusuario) {
        this.uusuario = uusuario;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public int getUtelefono() {
        return utelefono;
    }

    public void setUtelefono(int utelefono) {
        this.utelefono = utelefono;
    }

    public String getUrol() {
        return urol;
    }

    public void setUrol(String urol) {
        this.urol = urol;
    }

    
    
    
    
}
