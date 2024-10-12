package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cesar
 */
public class UsuariosDAO implements IUsuarios{
    
    Connection conexion;
    public UsuariosDAO() throws ClassNotFoundException{
        Conexion cnx = new Conexion();
        conexion = cnx.getConexion();
    }
    
    @Override
    public List<Usuarios> listarUsuarios() {
        
        PreparedStatement ps;
        ResultSet rs;
        List<Usuarios> lista = new ArrayList<>();
        
        try {
            
            ps = conexion.prepareStatement("SELECT usr_id,usr_nombre,usr_apellido,usr_usuario,usr_password,usr_telefono,usr_rol from tb_usuario");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int idusuario = rs.getInt(1);
                String unombre = rs.getString("usr_nombre");
                String uapellido = rs.getString("usr_apellido");
                String uusuario = rs.getString("usr_usuario");
                String upassword = rs.getString("usr_password");
                int utelefono = rs.getInt(6);
                String urol = rs.getString("usr_rol");
                
                Usuarios user = new Usuarios(idusuario,unombre,uapellido,uusuario,upassword,utelefono,urol);
                lista.add(user);
               
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    @Override
    public Usuarios mostrarUsuario(int id) {

        PreparedStatement ps;
        ResultSet rs;
        Usuarios user = null;

        try {

            ps = conexion.prepareStatement("SELECT usr_id,usr_nombre,usr_apellido,usr_usuario,usr_password,usr_telefono,usr_rol from tb_usuario WHERE usr_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                int idusuario = rs.getInt(1);
                String unombre = rs.getString("usr_nombre");
                String uapellido = rs.getString("usr_apellido");
                String uusuario = rs.getString("usr_usuario");
                String upassword = rs.getString("usr_password");
                int utelefono = rs.getInt(6);
                String urol = rs.getString("usr_rol");

                user = new Usuarios(idusuario, unombre, uapellido, uusuario, upassword, utelefono, urol);

            }

            return user;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }
    
    @Override
    public boolean insertarUsuario(Usuarios user) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO tb_usuario (usr_id,usr_nombre,usr_apellido,usr_usuario,usr_password,usr_telefono,usr_rol) VALUES(?,?,?,?,?,?,?)");
            
            ps.setInt(1, user.getIdusuario());
            ps.setString(2, user.getUnombre());
            ps.setString(3, user.getUapellido());
            ps.setString(4, user.getUusuario());
            ps.setString(5, user.getUpassword());
            ps.setInt(6, user.getUtelefono());
            ps.setString(7, user.getUrol());
            ps.execute();
            
            return true;
                        
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean modificarUsuario(Usuarios user) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("UPDATE tb_usuario SET usr_nombre=?,usr_apellido=?,usr_usuario=?,usr_password=?,usr_telefono=?,usr_rol=? WHERE usr_id=?");
            
            ps.setString(1, user.getUnombre());
            ps.setString(2, user.getUapellido());
            ps.setString(3, user.getUusuario());
            ps.setString(4, user.getUpassword());
            ps.setInt(5, user.getUtelefono());
            ps.setString(6, user.getUrol());
            ps.setInt(7, user.getIdusuario());
            ps.execute();

            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(int id) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("DELETE FROM tb_usuario WHERE usr_id=?");
            ps.setInt(1, id);
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }

}