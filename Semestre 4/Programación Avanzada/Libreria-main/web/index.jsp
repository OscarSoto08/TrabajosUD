<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${requestScope.titulo_pag}</title>
        <!-- Tailwind -->
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="icon" href="${pageContext.request.contextPath}/img/libro.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <jsp:include page="/componentes/navbar.jsp" />

        <!-- Redirección controlada con JSTL -->
        <c:choose>
            <c:when test="${empty sessionScope.redirigido}">
                <c:set var="redirigido" value="true" scope="session" />
                <script>
                    window.location.href = 'libros/inicio';
                </script>
                <jsp:include page="/paginas/bienvenida.jsp" />
            </c:when>
            <c:otherwise>
                <jsp:include page="${requestScope.pagina}" />
            </c:otherwise>
        </c:choose>

        <script src="https://kit.fontawesome.com/14596e32cc.js" crossorigin="anonymous"></script>
    </body>
</html>
