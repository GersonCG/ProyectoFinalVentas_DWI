<%-- 
    Document   : modificar
    Created on : Oct 9, 2024, 9:15:53 PM
    Author     : Cesar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>MODIFICAR - USUARIO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
        
        <div class="container">
            <div class="d-flex justify-content-center">
                <h2>Modificar Usuario</h2>
            </div><br>

            <!-- Formulario modificado con Bootstrap -->
            <form name="frmMod" action="UsuariosController?accion=actualizar" method="post" autocomplete="off" class="row g-3">
                <!-- ID Usuario (deshabilitado) -->
                <div class="col-md-6">
                    <label for="txtIDUser" class="form-label">ID:</label>
                    <input type="text" class="form-control" name="txtIDUser" id="txtIDUser" value="<c:out value='${usuario.idusuario}'/>" readonly>
                </div>

                <!-- Nombre -->
                <div class="col-md-6">
                    <label for="txtNomUser" class="form-label">Nombre:</label>
                    <input type="text" class="form-control" name="txtNomUser" id="txtNomUser" value="<c:out value='${usuario.unombre}'/>" placeholder="Ingrese nombre">
                </div>

                <!-- Apellido -->
                <div class="col-md-6">
                    <label for="txtApeUser" class="form-label">Apellido:</label>
                    <input type="text" class="form-control" name="txtApeUser" id="txtApeUser" value="<c:out value='${usuario.uapellido}'/>" placeholder="Ingrese apellido">
                </div>

                <!-- Usuario -->
                <div class="col-md-6">
                    <label for="txtUseUser" class="form-label">Usuario:</label>
                    <input type="text" class="form-control" name="txtUseUser" id="txtUseUser" value="<c:out value='${usuario.uusuario}'/>" placeholder="Ingrese usuario">
                </div>

                <!-- Contraseña -->
                <div class="col-md-6">
                    <label for="txtPasUser" class="form-label">Contraseña:</label>
                    <input type="password" class="form-control" name="txtPasUser" id="txtPasUser" value="<c:out value='${usuario.upassword}'/>" placeholder="Ingrese contraseña">
                </div>

                <!-- Teléfono -->
                <div class="col-md-6">
                    <label for="txtTelUser" class="form-label">Teléfono:</label>
                    <input type="tel" class="form-control" name="txtTelUser" id="txtTelUser" value="<c:out value='${usuario.utelefono}'/>" placeholder="Ingrese teléfono">
                </div>

                <!-- Rol -->
                <div class="col-md-6">
                    <label for="txtRolUser" class="form-label">Rol:</label>
                    <input type="text" class="form-control" name="txtRolUser" id="txtRolUser" value="<c:out value='${usuario.urol}'/>" placeholder="Ingrese rol">
                </div>

                <!-- Botón Grabar -->
                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary">Grabar</button>
                </div>
            </form>
        </div><br>

        <!-- Pie de página -->
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
      
        <!-- Scripts de Bootstrap -->
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>

