<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>INKAVIDA-PRODUCTOS</title>
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

        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <div class="container my-4">
            <h2 class="text-center mb-4">Formulario de Venta</h2>
            <form id="form-pedido">
                <div class="row">


                    <div class="col-md-3">
                        <label for="clientes" class="form-label">Clientes</label>
                        <select id="clientes" class="form-select">
                            <option value="0">Selecciona un cliente</option>
                            <c:forEach var="usu" items="${listarClientes}">
                                <option value="${usu.idcliente}">${usu.clnombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <!-- Selección de Producto -->
                    <div class="col-md-3">
                        <label for="productos" class="form-label">Productos</label>
                        <select id="producto" class="form-select">
                            <option value="0">Selecciona un producto</option>
                            <c:forEach var="pro" items="${listaProductos}">
                                <option value="${pro.idproducto}">${pro.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <!-- Visualización del Stock Disponible -->
                    <div class="col-md-2">
                        <label for="stock" class="form-label">Stock Disponible</label><br>
                        <input id="cantidad" disabled value="" class="form-control">
                    </div>

                    <!-- Selección de Cantidad -->
                    <div class="col-md-2">
                        <label for="cantidad" class="form-label">Cantidad</label>
                        <select id="listado_cantidad" class="form-select">
                            <option value="0">Selecciona cantidad</option>
                        </select>
                    </div>


                   
                    <!-- Visualización del Precio Unitario -->
                    <div class="col-md-2">
                        <label for="precio" class="form-label">Precio Unitario</label><br>
                        <input id="precio" disabled value="" class="form-control">
                    </div>

                

                    <div class="text-center"><br>
                        <button type="button" id="btn-agregar" class="btn" style="color: white;background-color: #ff8426;font-weight: 500;">Agregar al pedido</button>
                    </div>
                </div>
            </form>


            <!-- Tabla para mostrar los productos agregados al pedido -->
            <div class="table-responsive my-4">
                <table class="table table-striped table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Producto</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Precio Unitario</th>
                            <th scope="col">Precio Total</th>
                            <th scope="col">Acción</th>

                        </tr>
                    </thead>
                    <tbody id="tabla-pedido">
                        <!-- Aquí se irán agregando los productos -->
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="4" class="text-end"><strong>Total Final:</strong></td>
                            <td id="total-precio" class="text-end">S/0.00</td>
                            <td></td>
                        </tr>
                    </tfoot>
                </table>                                                </div>

            <div class="text-center" style="display: flex;justify-content: end;">
                <button type="button" id="btn-procesar" class="btn" style="color: white;background-color: #069926;font-weight: 500;width: 15%;">Procesar pedido</button>
            </div>

        </div>





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

<!-- Librerías JS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {

        // Cargar stock y precio del producto seleccionado
        $('#producto').change(function () {
            var productId = $('#producto').val();
            if (productId) {
                $.ajax({
                    url: 'VentasController',
                    type: 'GET',
                    data: {accion: 'obtenerDatosProducto', id: productId},
                    success: function (response) {
                        var stock = response.stock;
                        var precio = response.precio;

                        // Actualizar el stock y precio en el formulario
                        $('#cantidad').val(stock);
                        $('#precio').val(precio.toFixed(2));

                        // Actualizar el combo de cantidad según el stock disponible
                        var comboCantidad = document.getElementById("listado_cantidad");
                        comboCantidad.innerHTML = ""; // Limpiar todas las opciones anteriores
                        for (var i = 1; i <= stock; i++) {
                            var option = document.createElement("option");
                            option.value = i;
                            option.text = i;
                            comboCantidad.appendChild(option);
                        }
                    },
                    error: function () {
                        alert('Error al obtener los datos del producto.');
                    }
                });
            } else {
                // Limpiar campos si no se selecciona un producto
                $('#cantidad').val('');
                $('#precio').val('');
                $('#listado_cantidad').html('<option value="0">Selecciona cantidad</option>');
            }
        });

        // Función para calcular el total
        function calcularTotal() {
            let total = 0;
            $('#tabla-pedido tr').each(function () {
                let precioTotal = parseFloat($(this).find('td:eq(5)').text().replace('S/', '').trim()) || 0;
                total += precioTotal;
            });
            $('#total-precio').text('S/' + total.toFixed(2));
        }

        // Agregar producto a la tabla de pedidos
        $('#btn-agregar').click(function () {
            var producto = $('#producto option:selected').text();
            var cantidad = $('#listado_cantidad').val();
            var precioUnitario = parseFloat($('#precio').val());
            var total = cantidad * precioUnitario;
            var idproducto = $('#producto option:selected').val();
            // Validar que se seleccione un producto y una cantidad válida
            if (producto !== "Selecciona un producto" && cantidad > 0) {
                // Añadir fila con los detalles del producto al pedido
                var fila = '<tr>' +
                        '<td>' + ($("#tabla-pedido tr").length + 1) + '</td>' +
                        '<td style="display:none">' + idproducto + '</td>' + // Oculatamos el id
                        '<td>' + producto + '</td>' +
                        '<td>' + cantidad + '</td>' +
                        '<td>S/' + precioUnitario.toFixed(2) + '</td>' +
                        '<td>S/' + total.toFixed(2) + '</td>' +
                        '<td><button type="button" class="btn btn-danger btn-quitar">Quitar</button></td>' + // Botón Quitar
                        '</tr>';
                $('#tabla-pedido').append(fila);
                   calcularTotal();
            } else {
                alert("Selecciona un producto y una cantidad válida.");
            }
        });

        // Evento para eliminar la fila correspondiente
        $(document).on('click', '.btn-quitar', function () {
            $(this).closest('tr').remove(); // Eliminar la fila correspondiente
              calcularTotal(); // Actualizar el total
        });

        //


        //

        // Procesar pedido
        $('#btn-procesar').click(function () {
            var productos = [];
            $('#tabla-pedido tr').each(function () {
                var idProducto = $(this).find('td:eq(1)').text(); // Obtenemos el id oculto
                var cantidad = $(this).find('td:eq(3)').text();
                var precioUnitario = $(this).find('td:eq(4)').text().replace('S/', '');
                var total = $(this).find('td:eq(5)').text().replace('S/', '');
                productos.push({
                    idProducto: idProducto,
                    cantidad: cantidad,
                    precioUnitario: precioUnitario,
                    total: total
                });
            });

            var idCliente = $('#clientes').val();
            var fechaGuia = new Date().toISOString().slice(0, 10); // Obtener fecha actual

            // Enviar los datos al servidor
            $.ajax({
                url: 'VentasController',
                type: 'POST',
                data: JSON.stringify({
                    idCliente: idCliente,
                    fechaGuia: fechaGuia,
                    productos: productos
                }),
                contentType: 'application/json',
                success: function (response) {
                    alert("Pedido procesado correctamente.");
                    // Limpiar la tabla de pedido
                    $('#tabla-pedido').empty();
                    $('#cantidad').val('');
                    $('#precio').val('');
                    $('#listado_cantidad').html('<option value="0">Selecciona cantidad</option>');
                    $('#producto').val('0');
                    $('#clientes').val('0');

                },
                error: function () {
                    alert("Error al procesar el pedido.");
                }
            });
        });
    });
</script>
