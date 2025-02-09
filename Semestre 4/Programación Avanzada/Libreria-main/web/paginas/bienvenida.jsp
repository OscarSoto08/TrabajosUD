<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container mx-auto mt-5">
    <!-- Mostrar mensaje si no hay libros -->
    <c:choose>
        <c:when test="${empty datos}">
            <h1 class="text-3xl text-center my-auto">No se encuentran registros, ¡crea uno!</h1>
        </c:when>
        <c:otherwise>
            <div class="grid grid-cols-4 gap-4">
                <c:forEach var="libro" items="${datos}">
                    <jsp:include page="/componentes/card.jsp">
                        <jsp:param name="libro_titulo" value="${libro.titulo}" />
                        <jsp:param name="libro_autor" value="${libro.autor}" />
                        <jsp:param name="libro_editorial" value="${libro.editorial}" />
                        <jsp:param name="libro_slug" value="${libro.slug}" />
                        <jsp:param name="libro_anio" value="${libro.anio}" />
                        <jsp:param name="libro_id" value="${libro.id}" />
                    </jsp:include>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>        
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
    const busqueda = $("#busqueda");
    busqueda.on("keyup", function(){
        const txt = busqueda.val();
        if(txt.length >= 3){
        $.ajax({
            url: "/libreria/libros/buscar",
            method: "GET",
            data: {valor: txt},
            dataType: "JSON",
            sucess: function(data){
                alert("si")
            },
            error: function(no){
                alert("no")
            }
        });
    }
});
</script>
</div>
