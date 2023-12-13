<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDAO.UsersDAO"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <!--bootstrap-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"
            />
        <title>Proyecto Final</title>
        <link rel="stylesheet" href="./styles/main.css">
        <link rel="stylesheet" href="./styles/mostrar.css">
    </head>
    <body>
        <nav>
            <div class="navbar-container">
                <div class="nav-title">
                    <h1>DASHBOARD</h1>
                </div>
                <ul>
                    <li><h3>MENU</h3></li>
                    <li>
                        <a class="nav_button" href="/PrimerServlet"><i class="ri-home-2-line"></i><span>Home</span></a>
                    </li>
                    <li>
                        <a class="nav_button" href="SvUsuarios?accion=crear"><i class="ri-user-add-line"></i></i><span>Create user</span></a>
                    </li>
                    <li>
                        <a class="nav_button-active" href="SvUsuarios?accion=ver"><i class="ri-table-line"></i><span>View users</span></a>
                    </li>
                </ul>
            </div>
        </nav>
        <main>
            <div class="users-container">
                <div class="data-section">
                    <h1>User Management Control</h1>
                    <span><a href="/PrimerServlet">Dashboard</a> / User Management</span>
                </div>
                <span>For user to check they list</span>
                <div class="table-container">

                    <table class="table table-bordered">
                        <span>Users Database</span>
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="">First name</th>
                                <th class="">Last Name</th>
                                <th class="">DNI</th>
                                <th class="">Email</th>
                                <th class="">Modify</th>
                            </tr>
                        </thead>

                        <tbody>
                            <%
                                UsersDAO registrosDao = new UsersDAO();
                                List<Usuario> lista = registrosDao.listarUsuarios();

                                Iterator<Usuario> iter = lista.iterator();
                                Usuario u = null;
                                while(iter.hasNext()){
                                    u = iter.next();  
                            %>
                            <tr>
                                <td class="text-center"><%= u.getId() %></td>
                                <td><%= u.getNombre() %></td>
                                <td><%= u.getApellido() %></td>
                                <td><%= u.getDni() %></td>
                                <td><%= u.getContacto() %></td>
                                <td class="actions">
                                    
                                    <form action="SvUpdateUser" method="POST">
                                        <input type="hidden" name="idUsuario" value="<%= u.getId() %>">
                                        <button type="submit" class="btn btn-success">Update</button>
                                    </form>
                                    
                                    <form action="SvUsuarios" method="POST">
                                        <input type="hidden" name="idUsuario" value="<%= u.getId() %>">
                                        <button type="submit" class="btn btn-danger" href="SvUsuarios?accion=eliminar">Delete</button>
                                    </form>
                                    
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
        <footer>
            <span class="footer__copy">© Valentin Giosso. All rigths reserved</span>
        </footer>
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.4.0/fonts/remixicon.css" rel="stylesheet">
    </body>
</html>
