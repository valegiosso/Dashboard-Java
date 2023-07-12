<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proyecto Final</title>
    <link rel="stylesheet" href="./styles/main.css">
    <link rel="stylesheet" href="./styles/crear.css">
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
                    <a class="nav_button-active" href="SvUsuarios?accion=crear"><i class="ri-user-add-line"></i></i><span>Create user</span></a>
                </li>
                <li>
                    <a class="nav_button" href="SvUsuarios?accion=ver"><i class="ri-table-line"></i><span>View users</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <main>
        <div class="create-container">
            <div class="data-section">
                <h1>User Management Control</h1>
                <span><a href="/PrimerServlet">Dashboard</a> / User Management View</span>
            </div>
            <span>For user to check they list</span>
            
            <form action="SvUsuarios" method="POST">
                <h4>User view detail</h4>
                <table class="form-table">
                    <tr>
                        <td>
                            <label class="label"><i class="ri-user-3-line"></i>First Name</label>
                        </td>
                        <td>
                            <input autocomplete="off" name="name" id="Name" class="input" type="text" placeholder="First name" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="label"><i class="ri-user-3-line"></i>Last Name</label>
                        </td>
                        <td>
                            <input autocomplete="off" name="last" id="Last" class="input" type="text" placeholder="Last name" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="label"><i class="ri-pass-valid-line"></i>D.N.I</label>
                        </td>
                        <td>
                            <input autocomplete="off" name="DNI" id="DNI" class="input" type="text" placeholder="DNI" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="label"><i class="ri-mail-line"></i></i>Email</label>
                        </td>
                        <td>
                            <input autocomplete="off" name="email" id="Email" class="input" type="email" placeholder="Email" required>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="button-container">
                            <button class="button" type="submit">
                                <span class="button__text">Add User</span>
                                <span class="button__icon"><svg class="svg" fill="none" height="24" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><line x1="12" x2="12" y1="5" y2="19"></line><line x1="5" x2="19" y1="12" y2="12"></line></svg></span>
                            </button>
                        </td>
                    </tr>
                </table>
            
            </form>
        </div>
    </main>
    <footer>
        <span class="footer__copy">© Valentin Giosso. All rigths reserved</span>
    </footer>
    <link href="https://cdn.jsdelivr.net/npm/remixicon@3.4.0/fonts/remixicon.css" rel="stylesheet">
</body>
</html>
