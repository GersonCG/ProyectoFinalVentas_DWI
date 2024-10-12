///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gerson
 */
public class CabeceraVentaDAO implements ICabeceraVenta {
    
    Connection conexion;

    public CabeceraVentaDAO() throws ClassNotFoundException {
        Conexion cnx = new Conexion();
        conexion = cnx.getConexion();
    }
    
    @Override
    public int registrarCabecera(CabeceraVenta cvent) {
        PreparedStatement ps;
        ResultSet rs = null; // Variable para almacenar el ResultSet
        int idGenerado = 0;

        try {
            // Preparar la consulta de inserción con RETURN_GENERATED_KEYS
            ps = conexion.prepareStatement(
                "INSERT INTO tb_cabecera_venta (cab_cantidad, cab_fecha, cli_id) VALUES (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS // Importante para obtener el ID
            );

            // Establecer los parámetros
            ps.setInt(1, cvent.getCab_cantidad());
            ps.setDate(2, new java.sql.Date(cvent.getCab_fecha().getTime()));
            ps.setInt(3, cvent.getCli_id());

            // Ejecutar la inserción
            ps.executeUpdate(); // Cambiar a executeUpdate para operaciones de actualización

            // Obtener el ID generado
            rs = ps.getGeneratedKeys(); // Obtener las claves generadas
            if (rs.next()) {
                idGenerado = rs.getInt(1); // El primer columna del resultado es el ID
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            return 0; // Retorna 0 en caso de error
        } finally {
            // Cerrar el ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return idGenerado; // Retorna el ID generado
    }
}
