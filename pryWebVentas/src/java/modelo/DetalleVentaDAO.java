/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gerson
 */
public class DetalleVentaDAO implements IDetalleVenta{
 
    Connection conexion;
    public DetalleVentaDAO() throws ClassNotFoundException{
        Conexion cnx = new Conexion();
        conexion = cnx.getConexion();
    }
    
    public boolean registrarVenta(DetalleVenta dvent) {
        
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO tb_detalle_venta (det_cantidad,det_precio,det_total,prd_id,cab_id) VALUES(?,?,?,?,?)");
            
            ps.setInt(1, dvent.getDet_cantidad());
            ps.setDouble(2, dvent.getDet_precio());
            ps.setDouble(3, dvent.getDet_total());
            ps.setInt(4, dvent.getPrd_id());
            ps.setInt(5, dvent.getCab_id());
           
          
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            //RETORNA FALSO
            return false;
        }
        
    }   

    public boolean actualizarStock(int idProducto, int cantidadVendida) {
        PreparedStatement ps;

        try {
            // Reduce la cantidad del stock del producto
            ps = conexion.prepareStatement("UPDATE tb_producto SET prd_cantidad = prd_cantidad - ? WHERE prd_id = ?");
            ps.setInt(1, cantidadVendida);
            ps.setInt(2, idProducto);
            ps.executeUpdate(); // Cambiar a executeUpdate para operaciones de modificación
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

}
