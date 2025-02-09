<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Destino JSP</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css"/>
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h1 class="text-center mb-4">Solicitud Recibida</h1>
        <h2 class="mb-4 text-center">Tus datos son:</h2>

        <%
        // Extracción de los parámetros recibidos
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String mail = request.getParameter("mail");
        String genero = request.getParameter("genero");
        String java = request.getParameter("java");
        String c = request.getParameter("c");
        String basic = request.getParameter("basic");
        String html = request.getParameter("html");
        String[] idiomasSelec = request.getParameterValues("idiomas");
        %>

        <div class="row justify-content-center">
            <div class="col-md-8">
                <table class="table table-bordered bg-white shadow-sm">
                    <tr>
                        <th class="text-end">Nombre:</th>
                        <td><%= nombre %></td>
                    </tr>
                    <tr>
                        <th class="text-end">Apellidos:</th>
                        <td><%= apellidos %></td>
                    </tr>
                    <tr>
                        <th class="text-end">Correo:</th>
                        <td><%= mail %></td>
                    </tr>
                    <tr>
                        <th class="text-end">Género:</th>
                        <td><%= genero %></td>
                    </tr>
                    <tr>
                        <th class="text-end">Conocimientos:</th>
                        <td>
                            <% if (java != null) { %> Java <% } %> 
                            <% if (c != null) { %> C/C++ <% } %> 
                            <% if (basic != null) { %> Basic <% } %> 
                            <% if (html != null) { %> HTML <% } %>
                        </td>
                    </tr>
                    <tr>
                        <th class="text-end">Idiomas que comprendes:</th>
                        <td>
                            <ul class="list-unstyled mb-0">
                                <% 
                                if (idiomasSelec != null) {
                                    for (String idioma : idiomasSelec) { 
                                %>
                                    <li><%= idioma %></li>
                                <% 
                                    }
                                } 
                                %>
                            </ul>
                        </td>
                    </tr>
                </table>

                <div class="text-center mt-4">
                    <form action="index.jsp" method="post">
                        <button type="submit" class="btn btn-primary">Regresar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
