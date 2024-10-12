package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FacturasDAO implements IFactura{
    Connection conexion;

    public FacturasDAO() throws ClassNotFoundException {
        Conexion cnx = new Conexion();
        conexion = cnx.getConexion();
    }
    
    @Override
    public List<Factura> listarFacturas() {

        PreparedStatement ps;
        ResultSet rs;
        List<Factura> lista = new ArrayList<>();
        try {
            // Consulta SQL con JOIN y CONCAT para obtener el nombre completo del cliente
            ps = conexion.prepareStatement(
                "SELECT cv.cab_id, cv.cab_cantidad, cv.cab_fecha, CONCAT(c.cli_nombre, ' ', c.cli_apellido) AS nombre_completo " +
                "FROM tb_cabecera_venta cv " +
                "JOIN tb_cliente c ON cv.cli_id = c.cli_id"
            );
            rs = ps.executeQuery();

            while (rs.next()) {
                int idcabecera = rs.getInt("cab_id");
                int cbcantidad = rs.getInt("cab_cantidad");
                String cbfecha = rs.getString("cab_fecha");
                String nombreCompleto = rs.getString("nombre_completo");

                // Crea un objeto Factura con los datos obtenidos
                Factura fact = new Factura(idcabecera, cbcantidad, cbfecha, nombreCompleto);
                lista.add(fact);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
}
