package Controlador;

import ModeloDAO.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvUpdateUser", urlPatterns = {"/SvUpdateUser"})
public class SvUpdateUser extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        
        // Puedes redirigir a una página de edición o cargar los datos en un formulario de edición
        response.sendRedirect("vistas/actualizarUsuario.jsp?idUsuario=" + idUsuario);
        
       /* String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("DNI");
        String contacto = request.getParameter("contacto");
        
        UsersDAO usuarioDAO = new UsersDAO();
        try {
            usuarioDAO.actualizarUsuario(idUsuario, nombre, apellido, dni, contacto);
            //response.sendRedirect("vistas/mostrarUsuarios.jsp");
        }catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores: puedes redirigir a una página de error o mostrar un mensaje en la misma página
        }*/
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
