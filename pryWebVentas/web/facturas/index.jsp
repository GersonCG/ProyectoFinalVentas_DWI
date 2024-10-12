<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>INKAVIDA-CLIENTES</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="references/css/navbar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- BOOTSTRAP -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <!-- END BOOTSTRAP -->
    <style>
        .table-orange th {
            background-color: #FFA500; /* Color naranja */
            color: white; /* Texto blanco */
        }
    </style>
    <script src="references/js/navbar.js"></script>
</head>

<body>
    <header>
        <div class="container text-center my-4">
            <div class="d-flex justify-content-center align-items-center">
                <img src="./img/Logo.JPG" class="img-fluid me-2" style="height: 60px;">
                <h1>INKAVIDA GLOBAL</h1>
            </div>
        </div>
    </header>

    <!-- Menu superior -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.html">Inicio</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="VentasController">Ventas</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Gestionar
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="ProductosController">Productos</a></li>
                            <li><a class="dropdown-item" href="ClientesController">Clientes</a></li>
                            <li><a class="dropdown-item" href="UsuariosController">Usuarios</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="FacturasController">Facturas</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav><br>

    <div class="container-xl">
        <div class="d-flex justify-content-center">
            <h2>BOLETAS</h2>
        </div><br>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
                <thead class="table-orange">
                    <tr>
                        <th scope="col" class="text-center">ID</th>
                        <th scope="col" class="text-center">Cantidad</th>
                        <th scope="col" class="text-center">Fecha</th>
                        <th scope="col" class="text-center">Cliente</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="fact" items="${listaFacturas}">
                        <tr>
                            <td class="text-center"><c:out value="${fact.idcabecera}" /></td>
                            <td class="text-center"><c:out value="${fact.cbcantidad}" /></td>
                            <td class="text-center"><c:out value="${fact.cbfecha}" /></td>
                            <td class="text-center"><c:out value="${fact.nombreCompleto}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div><br>

    <!-- pie de pagina-->
    <footer style="background-color: #333; color: white; text-align: center; padding: 20px;">
            <p>© 2024 Elaborado por Corzo Giraldo, Gerson - Chanamé Gil, Angel David - Gonzalo Chauca, Christian José - Nunja Astacio, Cesar Ernesto </p>
            <div>
                <a href="https://www.facebook.com" target="_blank" style="margin: 0 10px; color: white;">
                    <i class="fab fa-facebook fa-2x"></i>
                </a>
                <a href="https://www.twitter.com" target="_blank" style="margin: 0 10px; color: white;">
                    <i class="fab fa-twitter fa-2x"></i>
                </a>
                <a href="https://www.instagram.com" target="_blank" style="margin: 0 10px; color: white;">
                    <i class="fab fa-instagram fa-2x"></i>
                </a>
                <a href="https://www.linkedin.com" target="_blank" style="margin: 0 10px; color: white;">
                    <i class="fab fa-linkedin fa-2x"></i>
                </a>
            </div>
    </footer>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
