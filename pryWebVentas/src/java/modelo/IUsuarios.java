package modelo;
import java.util.List;

public interface IUsuarios {
    
    public List<Usuarios> listarUsuarios();
    public Usuarios mostrarUsuario(int id);
    public boolean insertarUsuario(Usuarios user);
    public boolean modificarUsuario(Usuarios user);
    public boolean eliminarUsuario(int id);
    
}
