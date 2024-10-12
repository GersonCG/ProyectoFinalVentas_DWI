<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>INKAVIDA-CLIENTES</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!-- BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <!-- END BOOTSTRAP -->
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
                <h2>Modificar Cliente</h2>
            </div><br>

            <!-- Formulario de modificación de cliente -->
            <form name="frmMod" action="ClientesController?accion=actualizar" method="post" autocomplete="off" class="row g-3">
                <div class="col-md-6">
                    <label for="txtIDCli" class="form-label">ID Cliente:</label>
                    <input type="text" class="form-control" id="txtIDCli" name="txtIDCli" value="<c:out value='${cliente.idcliente}' />" readonly>
                </div>

                <div class="col-md-6">
                    <label for="txtNomCli" class="form-label">Nombre:</label>
                    <input type="text" class="form-control" id="txtNomCli" name="txtNomCli" value="<c:out value='${cliente.clnombre}' />" required>
                </div>

                <div class="col-md-6">
                    <label for="txtApeCli" class="form-label">Apellido:</label>
                    <input type="text" class="form-control" id="txtApeCli" name="txtApeCli" value="<c:out value='${cliente.clapellido}' />" required>
                </div>

                <div class="col-md-6">
                    <label for="txtDNICli" class="form-label">DNI:</label>
                    <input type="text" class="form-control" id="txtDNICli" name="txtDNICli" value="<c:out value='${cliente.clDNI}' />" required>
                </div>
                
                <div class="col-md-6">
                    <label for="txtTelCli" class="form-label">Teléfono:</label>
                    <input type="tel" class="form-control" id="txtTelCli" name="txtTelCli" value="<c:out value='${cliente.cltelefono}' />" required>
                </div>
                                
                <div class="col-md-6">
                    <label for="txtEmailCli" class="form-label">Correo Electrónico:</label>
                    <input type="email" class="form-control" id="txtEmailCli" name="txtEmailCli" value="<c:out value='${cliente.clcorreo}' />" required>
                </div>

                <div class="col-md-6">
                    <label for="txtDireCli" class="form-label">Dirección:                                                                                                                                                                                                                                                                                                                                                                                                                                                                     </label>
                    <input type="text" class="form-control" id="txtDireCli" name="txtDireCli" value="<c:out value='${cliente.cldireccion}' />" required>
                </div>

                <div class="col-12 text-center">
                    <button type="submit" class="btn btn-primary">Grabar</button>
                </div>
            </form>
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
