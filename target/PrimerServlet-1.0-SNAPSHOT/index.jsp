<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proyecto Final</title>
    <link rel="stylesheet" href="./styles/main.css">
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
                    <a class="nav_button-active" href="/PrimerServlet"><i class="ri-home-2-line"></i><span>Home</span></a>
                </li>
                <li>
                    <a class="nav_button" href="SvUsuarios?accion=crear"><i class="ri-user-add-line"></i></i><span>Create user</span></a>
                </li>
                <li>
                    <a class="nav_button" href="SvUsuarios?accion=ver"><i class="ri-table-line"></i><span>View users</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <main>
        <div>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Vero nostrum reprehenderit distinctio mollitia numquam laudantium iure voluptatibus. Rem, quas expedita. In magni optio corporis iusto deserunt harum voluptatum maiores nemo!
        </div>
    </main>
     <footer>
        <span class="footer__copy">© Valentin Giosso. All rigths reserved</span>
    </footer>
    <link href="https://cdn.jsdelivr.net/npm/remixicon@3.4.0/fonts/remixicon.css" rel="stylesheet">
</body>
</html>
