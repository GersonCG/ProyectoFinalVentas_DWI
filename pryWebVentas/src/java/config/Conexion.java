package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    
    String pro="jdbc:mysql://";
    String ip="127.0.0.1";
    String pue="3306";
    String bd="db_ventas";  
    String usu="root";
    String cla="";
    public Connection getConexion() {
        try {

            String cad = pro + ip + ":" + pue + "/" + bd;

            Class.forName("com.mysql.jdbc.Driver");

            Connection cnx = DriverManager.getConnection(cad, usu, cla);
            System.out.println("Conexion OK");

            return cnx;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
