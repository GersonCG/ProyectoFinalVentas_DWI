
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductosDAO implements IProductos {
    
    Connection conexion;
    public ProductosDAO() throws ClassNotFoundException{
        Conexion cnx = new Conexion();
        conexion = cnx.getConexion();
    }
    
    @Override
    public List<Productos> listarProductos() {

        PreparedStatement ps;
        ResultSet rs;
        List<Productos> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT prd_id,prd_nombre,prd_cantidad,prd_precio,prd_descripcion from tb_producto");
            rs = ps.executeQuery();
            
            while (rs.next()) {
               int idproducto = rs.getInt(1); // aqui : int idproducto = rs.getInt("prd_id");
               String nombre = rs.getString("prd_nombre");
               int cantidad = rs.getInt("prd_cantidad");
               double precio = rs.getDouble(4); // aqui : double precio = rs.getDouble("prd_precio");
               String descripcion = rs.getString("prd_descripcion");
                                             
               Productos pro = new Productos(idproducto,nombre,cantidad,precio,descripcion);
               lista.add(pro);
               
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Productos mostrarProducto(int id) { // aqui : public Productos mostrarProducto(int id)
        PreparedStatement ps;
        ResultSet rs;
        Productos pro=null;
        try {
            ps = conexion.prepareStatement("SELECT prd_id,prd_nombre,prd_cantidad,prd_precio,prd_descripcion from tb_producto where prd_id=?");
            ps.setInt(1, id); // aqui : ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
               int idproducto = rs.getInt(1); // aqui : int idproducto = rs.getInt("id");
               String nombre = rs.getString("prd_nombre");
               int cantidad = rs.getInt("prd_cantidad");
               double precio = rs.getDouble(4); // aqui : double precio = rs.getDouble("prd_precio");
               String descripcion = rs.getString("prd_descripcion");
 
               pro = new Productos(idproducto,nombre,cantidad,precio,descripcion);
 
            }
            
            return pro;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean insertarProducto(Productos pro) {
        PreparedStatement ps;
        try {
            
            ps = conexion.prepareStatement("INSERT INTO tb_producto (prd_id,prd_nombre,prd_cantidad,prd_precio,prd_descripcion) VALUES(?,?,?,?,?)");
            
            ps.setInt(1, pro.getIdproducto());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getCantidad());
            ps.setDouble(4, pro.getPrecio());
            ps.setString(5, pro.getDescripcion());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            //RETORNA FALSO
            return false;
        }
    }

    @Override
    public boolean modificarProducto(Productos pro) {
        PreparedStatement ps;
        try {
       
            ps = conexion.prepareStatement("UPDATE tb_producto SET prd_nombre=?,prd_cantidad=?,prd_precio=?,prd_descripcion=? WHERE prd_id=?");
            
            ps.setString(1, pro.getNombre());
            ps.setInt(2, pro.getCantidad());
            ps.setDouble(3, pro.getPrecio());
            ps.setString(4, pro.getDescripcion());
            ps.setInt(5, pro.getIdproducto());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            //RETORNA FALSO
            return false;
        }
        
    }

    @Override
    public boolean eliminarProducto(int id) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("DELETE FROM tb_producto WHERE prd_id=?");
            ps.setInt(1, id);
            ps.execute();
            return true;
                        
        } catch (SQLException e) {
            System.out.println(e.toString());
            //RETORNA FALSO
            return false;
        }
        
    }
    
    @Override
    public boolean actualizarStock(Productos pro) {
    PreparedStatement ps;
    try {
        ps = conexion.prepareStatement("UPDATE tb_producto SET prd_cantidad=? WHERE prd_id=?");
        ps.setInt(1, pro.getCantidad());
        ps.setInt(2, pro.getIdproducto());
        ps.execute();
        return true;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
    }
}
}
