/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

@WebServlet(name = "SvSaveUser", urlPatterns = {"/SvSaveUser"})
public class SvSaveUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String contacto = request.getParameter("contacto");
        
        
        // Lógica para guardar los cambios en la base de datos
        UsersDAO usuarioDAO = new UsersDAO();
        try {
            usuarioDAO.actualizarUsuario(idUsuario, nombre, apellido, dni, contacto);
        }catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores: puedes redirigir a una página de error o mostrar un mensaje en la misma página
        }

        // Después de guardar los cambios, puedes redirigir a la página principal o a donde desees
        response.sendRedirect("vistas/mostrasUsuarios.jsp");     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
