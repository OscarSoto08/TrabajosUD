<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Destino JSP</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <<link rel="stylesheet" href="style.css"/>
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h1 class="text-center">Página Destino</h1>
                        <h2 class="text-muted text-center mb-4">Datos recibidos</h2>

                        <%
                        // Extracción de los parámetros recibidos
                        String areaTexto = request.getParameter("area2");
                        %>

                        <div class="alert alert-info text-center">
                            <strong>El usuario escribió:</strong> 
                            <p class="mt-2"><%= areaTexto != null ? areaTexto : "No se recibió ningún texto." %></p>
                        </div>

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
