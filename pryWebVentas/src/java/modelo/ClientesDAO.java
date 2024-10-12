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
public class ClientesDAO implements IClientes{
    
    Connection conexion;
    public ClientesDAO() throws ClassNotFoundException{
        Conexion cnx = new Conexion();
        conexion = cnx.getConexion();
    }
    
    @Override
    public List<Clientes> listarClientes() {
        
        PreparedStatement ps;
        ResultSet rs;
        List<Clientes> lista = new ArrayList<>();
        
        try {
            
            ps = conexion.prepareStatement("SELECT cli_id,cli_nombre,cli_apellido,cli_DNI,cli_telefono,cli_correo,cli_direccion from tb_cliente");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int idcliente = rs.getInt(1);
                String clnombre = rs.getString("cli_nombre");
                String clapellido = rs.getString("cli_apellido");
                String clDNI= rs.getString("cli_DNI");
                int cltelefono = rs.getInt("cli_telefono");
                String clcorreo = rs.getString("cli_correo");
                String cldireccion = rs.getString("cli_direccion");
                
                Clientes clie = new Clientes(idcliente,clnombre,clapellido,clDNI,cltelefono,clcorreo,cldireccion);
                lista.add(clie);
               
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    @Override
    public Clientes mostrarCliente(int id) {

        PreparedStatement ps;
        ResultSet rs;
        Clientes clie = null;

        try {

            ps = conexion.prepareStatement("SELECT cli_id,cli_nombre,cli_apellido,cli_DNI,cli_telefono,cli_correo,cli_direccion from tb_cliente WHERE cli_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                int idcliente = rs.getInt(1);
                String clnombre = rs.getString("cli_nombre");
                String clapellido = rs.getString("cli_apellido");
                String clDNI= rs.getString("cli_DNI");
                int cltelefono = rs.getInt(5);
                String clcorreo = rs.getString("cli_correo");
                String cldireccion = rs.getString("cli_direccion");

                clie = new Clientes(idcliente,clnombre,clapellido,clDNI,cltelefono,clcorreo,cldireccion);

            }

            return clie;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }
    
    @Override
    public boolean insertarCliente(Clientes clie) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO tb_cliente (cli_id,cli_nombre,cli_apellido,cli_DNI,cli_telefono,cli_correo,cli_direccion) VALUES(?,?,?,?,?,?,?)");
            
            ps.setInt(1, clie.getIdcliente());
            ps.setString(2, clie.getClnombre());
            ps.setString(3, clie.getClapellido());
            ps.setString(4, clie.getClDNI());
            ps.setInt(5, clie.getCltelefono());
            ps.setString(6, clie.getClcorreo());
            ps.setString(7, clie.getCldireccion());
            ps.execute();
            
            return true;
                        
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean modificarCliente(Clientes clie) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("UPDATE tb_cliente SET cli_nombre=?,cli_apellido=?,cli_DNI=?,cli_telefono=?,cli_correo=?,cli_direccion=? WHERE cli_id=?");
            
            ps.setString(1, clie.getClnombre());
            ps.setString(2, clie.getClapellido());
            ps.setString(3, clie.getClDNI());
            ps.setInt(4, clie.getCltelefono());
            ps.setString(5, clie.getClcorreo());
            ps.setString(6, clie.getCldireccion());
            ps.setInt(7, clie.getIdcliente());
            ps.execute();

            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean eliminarCliente(int id) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("DELETE FROM tb_cliente WHERE cli_id=?");
            ps.setInt(1, id);
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }

}