/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;
import java.util.List;

public interface IClientes {
    public List<Clientes> listarClientes();
    public Clientes mostrarCliente(int id);
    public boolean insertarCliente(Clientes clie);
    public boolean modificarCliente(Clientes clie);
    public boolean eliminarCliente(int id); 
    
}
