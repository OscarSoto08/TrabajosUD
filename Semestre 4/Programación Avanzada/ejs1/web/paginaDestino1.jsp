<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Destino JSP</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h1 class="text-center mb-4">Página de destino</h1>
        <h2 class="text-center text-muted mb-4">Datos recibidos</h2>

        <%
        // Capturar los parámetros enviados en el objeto "request"
        String transp = request.getParameter("transporte");
        String ciudad = request.getParameter("ciudad");
        String bosque = request.getParameter("bosque");
        String playa = request.getParameter("playa");
        %>

        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <table class="table table-hover">
                            <tr>
                                <th class="text-end">Transporte preferido:</th>
                                <td><%= transp != null ? transp : "No especificado" %></td>
                            </tr>
                        </table>

                        <p class="mt-3">Destinos seleccionados:</p>
                        <ul class="list-group">
                            <% if (ciudad != null) { %>
                                <li class="list-group-item">Ciudad</li>
                            <% } %>
                            <% if (bosque != null) { %>
                                <li class="list-group-item">Bosque</li>
                            <% } %>
                            <% if (playa != null) { %>
                                <li class="list-group-item">Playa</li>
                            <% } %>
                            <% if (ciudad == null && bosque == null && playa == null) { %>
                                <li class="list-group-item">No se seleccionaron destinos</li>
                            <% } %>
                        </ul>

                        <div class="text-center mt-4">
                            <form action="index.jsp" method="post">
                                <button type="submit" class="btn btn-primary">Regresar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
