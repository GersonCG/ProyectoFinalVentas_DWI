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

import modelo.Usuarios;
import modelo.UsuariosDAO;

/**
 *
 * @author Cesar
 */

@WebServlet(name = "UsuariosController", urlPatterns = {"/UsuariosController"})
public class UsuariosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            UsuariosDAO userDao = new UsuariosDAO();
            String accion;
            RequestDispatcher rd = null;
            accion = request.getParameter("accion");
            
            if (accion==null || accion.isEmpty()) {
                
                rd = request.getRequestDispatcher("usuarios/index.jsp");
                List<Usuarios> listaUsuarios = userDao.listarUsuarios();
                request.setAttribute("listaUsuarios", listaUsuarios);
                
            } else if (accion.equals("nuevo")){
                
                rd = request.getRequestDispatcher("usuarios/nuevo.jsp");
                
            } else if (accion.equals("insertar")) {
                
                int idusuario = Integer.parseInt(request.getParameter("txtIDUser"));
                String unombre = request.getParameter("txtNomUser");
                String uapellido = request.getParameter("txtApeUser");
                String uusuario = request.getParameter("txtUseUser");
                String upassword = request.getParameter("txtPasUser");
                int utelefono = Integer.parseInt(request.getParameter("txtTelUser"));
                String urol = request.getParameter("txtRolUser");
                
                Usuarios user = new Usuarios (idusuario,unombre,uapellido,uusuario,upassword,utelefono,urol);
                userDao.insertarUsuario(user);
                
                rd = request.getRequestDispatcher("usuarios/index.jsp");
                List<Usuarios> listaUsuarios = userDao.listarUsuarios();
                request.setAttribute("listaUsuarios", listaUsuarios);
                
            } else if (accion.equals("modificar")) {
                
                rd = request.getRequestDispatcher("usuarios/modificar.jsp");
                int idusuario = Integer.parseInt(request.getParameter("txtIDUser"));
                Usuarios user = userDao.mostrarUsuario(idusuario);
                request.setAttribute("usuario", user);
                
            } else if (accion.equals("actualizar")){
                
                int idusuario = Integer.parseInt(request.getParameter("txtIDUser"));
                String unombre = request.getParameter("txtNomUser");
                String uapellido = request.getParameter("txtApeUser");
                String uusuario = request.getParameter("txtUseUser");
                String upassword = request.getParameter("txtPasUser");
                int utelefono = Integer.parseInt(request.getParameter("txtTelUser"));
                String urol = request.getParameter("txtRolUser");
                
                Usuarios user = new Usuarios (idusuario,unombre,uapellido,uusuario,upassword,utelefono,urol);
                userDao.modificarUsuario(user);
                rd = request.getRequestDispatcher("usuarios/index.jsp");
                List<Usuarios> listaUsuarios = userDao.listarUsuarios();
                request.setAttribute("listaUsuarios", listaUsuarios);
                
            } else if (accion.equals("eliminar")){
                
                int idusuario = Integer.parseInt(request.getParameter("txtIDUser"));
                userDao.eliminarUsuario(idusuario);
                rd = request.getRequestDispatcher("usuarios/index.jsp");
                List<Usuarios> listaUsuarios = userDao.listarUsuarios();
                request.setAttribute("listaUsuarios", listaUsuarios);
                
            } else {
                
                rd = request.getRequestDispatcher("usuarios/index.jsp");
                List<Usuarios> listaUsuarios = userDao.listarUsuarios();
                request.setAttribute("listaUsuarios", listaUsuarios);

            }
            
            rd.forward(request, response);
            
        } catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

}
