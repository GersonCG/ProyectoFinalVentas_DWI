package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDAO implements ICategoria{
    Connection conexion;

    public CategoriaDAO() throws ClassNotFoundException {
        Conexion cnx = new Conexion();
        conexion = cnx.getConexion();
    }
    
    @Override
    public List<Categoria> listarCategorias() {
        
        PreparedStatement ps;
        ResultSet rs;
        List<Categoria> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT categ_id, categ_descripcion FROM tb_categoria");
            rs = ps.executeQuery();

            while (rs.next()) {
                int idcategoria = rs.getInt("categ_id");
                String cadescripcion = rs.getString("categ_descripcion");
                
                Categoria cate = new Categoria(idcategoria, cadescripcion);
                lista.add(cate);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
