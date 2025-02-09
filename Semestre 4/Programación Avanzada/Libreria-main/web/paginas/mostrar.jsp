<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="my-5 form-container">
    <h2>Información del Libro</h2>
    <form method="post" action="/libreria/libros/editar">
        <input type="hidden" value="${libro.id}" name="id" />
        
        <div class="form-group">
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" value="${libro.isbn}" required>
        </div>
        
        <div class="form-group">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" value="${libro.titulo}" required>
        </div>
        
        <div class="form-group">
            <label for="autor">Autor:</label>
            <input type="text" id="autor" name="autor" value="${libro.autor}" required>
        </div>
        
        <div class="form-group">
            <label for="anio">Año:</label>
            <input type="number" id="anio" name="anio" value="${libro.anio}" required />
        </div>
        
        <div class="form-group">
            <label for="editorial">Editorial:</label>
            <input type="text" id="editorial" name="editorial" value="${libro.editorial}" required>
        </div>
        
        <div class="btn-container">
            <button type="submit" class="mx-auto btn btn-success">Guardar Cambios</button>
        </div>
    </form>
    
    <div class="btn btn-danger">
        <form action="/libreria/libros/borrar" method="post">
            <input type="hidden" value="${libro.id}" name="id_eliminar" />
            <button type="submit">Eliminar</button>
        </form>
    </div>
</div>
