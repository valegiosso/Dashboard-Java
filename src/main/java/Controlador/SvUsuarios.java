
package Controlador;

import Config.Conexion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    
    String listarUsuarios = "vistas/mostrarUsuarios.jsp"; //definimos la ruta donde se encuentra la vista
    String crearUsuarios = "vistas/crearUsuario.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*List<Usuario> listaUsuarios = new ArrayList();
        listaUsuarios.add(new Usuario("456132","Luis","Giosso","546562"));
        listaUsuarios.add(new Usuario("1325432","Osvaldo","Giosso","3357542"));
        listaUsuarios.add(new Usuario("35461","Raul","Medina","645343"));
        listaUsuarios.add(new Usuario("635373","Humberto","Giosso","782728"));
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaUsuarios", listaUsuarios);
        response.sendRedirect("mostrarUsuarios.jsp");*/
        
        String acceso = "";
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("ver")){
            acceso = listarUsuarios;
        }else if(accion.equalsIgnoreCase("crear")){
            acceso = crearUsuarios;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("name");
        String apellido = request.getParameter("last");
        String dni = request.getParameter("DNI");
        String email = request.getParameter("email");
        
        System.out.println("dni: " + dni);
        System.out.println("nombre: " + nombre);
        System.out.println("apellido: " + apellido);
        System.out.println("email: "+ email);
        
        // Obtener la instancia de conexión desde la clase Conexion
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnect();
        
         // Lógica de ejecución de sentencia SQL para insertar los datos
        String sql = "INSERT INTO users (DNI, Nombre, apellido, Contacto) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dni);
            statement.setString(2, nombre);
            statement.setString(3, apellido);
            statement.setString(4, email);

            statement.executeUpdate();

            // Redireccionar a una página de éxito o mostrar un mensaje de éxito
            response.sendRedirect("/PrimerServlet");

        } catch (SQLException e) {
            // Manejo de errores
            e.printStackTrace();
            // Redireccionar a una página de error o mostrar un mensaje de error
            response.sendRedirect("/PrimerServlet");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
