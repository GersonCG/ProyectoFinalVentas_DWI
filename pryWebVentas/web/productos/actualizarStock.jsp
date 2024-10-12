<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Actualizar Stock</title>
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
</head>
<body>
    <div class="container-md mt-5">
        <h2 class="mb-4">Actualizar Stock para el Producto</h2>
        <div class="card">
            <div class="card-body">
                <form action="ProductosController?accion=actualizarStockAction" method="post">
                    <input type="hidden" name="txtIDProd" value="${producto.idproducto}">
                    <div class="mb-3">
                        <label for="cantidadActual" class="form-label">Cantidad Actual</label>
                        <input type="number" class="form-control" id="cantidadActual" name="cantidadActual" value="${producto.cantidad}" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="cantidadNueva" class="form-label">Cantidad a Agregar</label>
                        <input type="number" class="form-control" id="cantidadNueva" name="cantidadNueva" required>
                    </div>
                    <div class="d-flex justify-content-between">
                        <button type="submit" class="btn btn-primary">Actualizar</button>
                        <a href="ProductosController" class="btn btn-secondary">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
