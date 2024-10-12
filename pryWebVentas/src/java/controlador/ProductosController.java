package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Clientes;
import modelo.ClientesDAO;
import modelo.ProductosDAO;
import modelo.Productos;

@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            ProductosDAO proDao = new ProductosDAO();
            ClientesDAO clienteDao = new ClientesDAO();

            String accion;
            RequestDispatcher rd = null;
            accion = request.getParameter("accion");

            if (accion == null || accion.isEmpty()) {
                rd = request.getRequestDispatcher("productos/index.jsp");
                List<Productos> listaProductos = proDao.listarProductos();
                request.setAttribute("listaProductos", listaProductos);

                List<Clientes> listarClientes = clienteDao.listarClientes();
                request.setAttribute("listarClientes", listarClientes);

            } else if (accion.equals("nuevo")) {

                rd = request.getRequestDispatcher("productos/nuevo.jsp");

            } else if (accion.equals("insertar")) {

                int idproducto = Integer.parseInt(request.getParameter("txtIDProd"));
                String nombre = request.getParameter("txtNomProd");
                int cantidad = Integer.parseInt(request.getParameter("txtCanProd"));
                double precio = Double.parseDouble(request.getParameter("txtPreProd"));
                String descripcion = request.getParameter("txtDesProd");

                Productos pro = new Productos(idproducto, nombre, cantidad, precio, descripcion);
                proDao.insertarProducto(pro);

                rd = request.getRequestDispatcher("productos/index.jsp");
                List<Productos> listaProductos = proDao.listarProductos();
                request.setAttribute("listaProductos", listaProductos);

            } else if (accion.equals("modificar")) {

                rd = request.getRequestDispatcher("productos/modificar.jsp");
                int idproducto = Integer.parseInt(request.getParameter("txtIDProd")); // aqui : int idproducto = Integer.parseInt(request.getParameter("txtIDProd"));
                Productos pro = proDao.mostrarProducto(idproducto); // aqui : Productos pro = proDao.mostrarProducto(idproducto);
                request.setAttribute("producto", pro);

            } else if (accion.equals("actualizar")) {

                int idproducto = Integer.parseInt(request.getParameter("txtIDProd"));
                String nombre = request.getParameter("txtNomProd");
                int cantidad = Integer.parseInt(request.getParameter("txtCanProd"));
                double precio = Double.parseDouble(request.getParameter("txtPreProd"));
                String descripcion = request.getParameter("txtDesProd");

                Productos pro = new Productos(idproducto, nombre, cantidad, precio, descripcion);
                proDao.modificarProducto(pro);
                rd = request.getRequestDispatcher("productos/index.jsp");
                List<Productos> listaProductos = proDao.listarProductos();
                request.setAttribute("listaProductos", listaProductos);

            } else if (accion.equals("eliminar")) {

                int idproducto = Integer.parseInt(request.getParameter("txtIDProd"));
                proDao.eliminarProducto(idproducto);
                rd = request.getRequestDispatcher("productos/index.jsp");
                List<Productos> listaProductos = proDao.listarProductos();
                request.setAttribute("listaProductos", listaProductos);

            } else if (accion.equals("actualizarStock")) {
                int idproducto = Integer.parseInt(request.getParameter("txtIDProd"));
                Productos producto = proDao.mostrarProducto(idproducto);
                request.setAttribute("producto", producto);
                rd = request.getRequestDispatcher("productos/actualizarStock.jsp");
            }else if (accion.equals("actualizarStockAction")) {
                int idproducto = Integer.parseInt(request.getParameter("txtIDProd"));
                int cantidadActual = Integer.parseInt(request.getParameter("cantidadActual"));
                int cantidadNueva = Integer.parseInt(request.getParameter("cantidadNueva"));

                int nuevaCantidad = cantidadActual + cantidadNueva;

                Productos producto = new Productos();
                producto.setIdproducto(idproducto);
                producto.setCantidad(nuevaCantidad);

                boolean actualizado = proDao.actualizarStock(producto);

                if (actualizado) {
                    request.setAttribute("mensaje", "Stock actualizado correctamente.");
                } else {
                    request.setAttribute("mensaje", "Error al actualizar el stock.");
                }
                response.sendRedirect("ProductosController");
                return;
            }else {

                rd = request.getRequestDispatcher("productos/index.jsp");
                List<Productos> listaProductos = proDao.listarProductos();
                request.setAttribute("listaProductos", listaProductos);

            }if (rd != null) {
                rd.forward(request, response);
            }

        } catch (ClassNotFoundException | ServletException | IOException ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Establecer el tipo de contenido
        response.setContentType("application/json");

        // Leer y procesar el JSON enviado desde el frontend
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }
}
