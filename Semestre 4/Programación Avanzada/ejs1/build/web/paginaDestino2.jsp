<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Página Destino JSP</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body class="bg-light">
    <% 
        // Extracción de resultados
        String idioma = request.getParameter("idioma");
        String[] lenguajes = request.getParameterValues("lenguajes");
    %>
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h1>Bienvenido a la Página de Destino</h1>
            <h2>Aquí se despliegan los datos recibidos</h2>
        </div>            

        <div class="card mb-4">
            <div class="card-header">
                Resultados
            </div>
            <div class="card-body">
                <table class="table table-hover">
                    <tbody>
                        <tr>
                            <td><strong>Tu idioma natal es:</strong></td>
                            <td class="table-info"><%= idioma != null ? idioma : "No especificado" %></td>
                        </tr>
                    </tbody>
                </table>
                <p><strong>Manejas los siguientes lenguajes de programación:</strong></p>
                <ul class="list-group">
                    <%
                        if (lenguajes != null) {
                            for (String lenguaje : lenguajes) {
                    %>
                        <li class="list-group-item"><%= lenguaje %></li>
                    <%
                            }
                        } else {
                    %>
                        <li class="list-group-item">No se especificaron lenguajes.</li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>

        <div class="text-center">
            <form action="index.jsp" method="post">
                <button type="submit" class="btn btn-primary">Regresar</button>                      
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-xxxx" crossorigin="anonymous"></script>
</body>
</html>
