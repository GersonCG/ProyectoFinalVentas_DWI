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

import modelo.Factura;  // Asegúrate de tener esta clase
import modelo.FacturasDAO;  // Asegúrate de tener esta clase

@WebServlet(name = "FacturasController", urlPatterns = {"/FacturasController"})
public class FacturasController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            FacturasDAO facturaDao = new FacturasDAO();
            String accion;
            RequestDispatcher rd = null;
            accion = request.getParameter("accion");
            
            if (accion == null || accion.isEmpty()) {
                rd = request.getRequestDispatcher("facturas/index.jsp");
                List<Factura> listaFacturas = facturaDao.listarFacturas();
                request.setAttribute("listaFacturas", listaFacturas);
                
            }else {
                
                rd = request.getRequestDispatcher("facturas/index.jsp");
                List<Factura> listaFacturas = facturaDao.listarFacturas();
                request.setAttribute("listaFacturas", listaFacturas);

            }
            
            rd.forward(request, response);
            
        } catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(FacturasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
