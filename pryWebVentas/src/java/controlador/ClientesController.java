package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Clientes;  // Asegúrate de tener esta clase
import modelo.ClientesDAO;  // Asegúrate de tener esta clase

@WebServlet(name = "ClientesController", urlPatterns = {"/ClientesController"})
public class ClientesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            ClientesDAO clienteDao = new ClientesDAO();  // Cambiado a ClientesDAO
            String accion;
            RequestDispatcher rd = null;
            accion = request.getParameter("accion");
            
            if (accion == null || accion.isEmpty()) {
                rd = request.getRequestDispatcher("clientes/index.jsp");
                List<Clientes> listaClientes = clienteDao.listarClientes();  // Cambiado a listarClientes
                request.setAttribute("listaClientes", listaClientes);
                
            } else if (accion.equals("nuevo")) {
                rd = request.getRequestDispatcher("clientes/nuevo.jsp");
                
            } else if (accion.equals("insertar")) {
                // Asegúrate de que los nombres de los parámetros coincidan con los del formulario
                int idcliente = Integer.parseInt(request.getParameter("txtIDCli"));
                String clnombre = request.getParameter("txtNomCli");
                String clapellido = request.getParameter("txtApeCli");
                String clDNI = request.getParameter("txtDNICli");
                int cltelefono = Integer.parseInt(request.getParameter("txtTelCli"));
                String clcorreo = request.getParameter("txtEmailCli");
                String cldireccion = request.getParameter("txtDireCli");
                
                Clientes cliente = new Clientes(idcliente, clnombre, clapellido,clDNI,cltelefono,clcorreo,cldireccion);  // Asegúrate de que el constructor esté definido
                clienteDao.insertarCliente(cliente);  // Cambiado a insertarCliente
                
                rd = request.getRequestDispatcher("clientes/index.jsp");
                List<Clientes> listaClientes = clienteDao.listarClientes();  // Cambiado a listarClientes
                request.setAttribute("listaClientes", listaClientes);
                
            } else if (accion.equals("modificar")) {
                rd = request.getRequestDispatcher("clientes/modificar.jsp");
                int idCliente = Integer.parseInt(request.getParameter("txtIDCli"));  // Asegúrate de que se use el ID correcto
                Clientes cliente = clienteDao.mostrarCliente(idCliente);  // Cambiado a mostrarCliente
                request.setAttribute("cliente", cliente);
                
            } else if (accion.equals("actualizar")) {
                int idcliente = Integer.parseInt(request.getParameter("txtIDCli"));
                String clnombre = request.getParameter("txtNomCli");
                String clapellido = request.getParameter("txtApeCli");
                String clDNI = request.getParameter("txtDNICli");
                int cltelefono = Integer.parseInt(request.getParameter("txtTelCli"));
                String clcorreo = request.getParameter("txtEmailCli");
                String cldireccion = request.getParameter("txtDireCli");
                
                Clientes cliente = new Clientes(idcliente, clnombre, clapellido,clDNI,cltelefono,clcorreo,cldireccion);  // Asegúrate de que el constructor esté definido
                clienteDao.modificarCliente(cliente);  // Cambiado a modificarCliente
                rd = request.getRequestDispatcher("clientes/index.jsp");
                List<Clientes> listaClientes = clienteDao.listarClientes();  // Cambiado a listarClientes
                request.setAttribute("listaClientes", listaClientes);
                
            } else if (accion.equals("eliminar")) {
                int idCliente = Integer.parseInt(request.getParameter("txtIDCliente"));
                clienteDao.eliminarCliente(idCliente);  // Cambiado a eliminarCliente
                rd = request.getRequestDispatcher("clientes/index.jsp");
                List<Clientes> listaClientes = clienteDao.listarClientes();  // Cambiado a listarClientes
                request.setAttribute("listaClientes", listaClientes);
                
            } else {
                rd = request.getRequestDispatcher("clientes/index.jsp");
                List<Clientes> listaClientes = clienteDao.listarClientes();  // Cambiado a listarClientes
                request.setAttribute("listaClientes", listaClientes);
            }
            
            rd.forward(request, response);
            
        } catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
