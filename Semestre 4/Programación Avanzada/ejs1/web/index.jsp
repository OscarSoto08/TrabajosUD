<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicios JSP</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css"/>
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h4 class="mb-4 text-center">Ej. 3.7: Recepción de los valores de radio-button y checkbox</h4>

        <form action="paginaDestino1.jsp" method="post">
            <div class="mb-4">
                <p class="fw-bold">Elige tu transporte preferido:</p>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="transporte" id="transporteCoche" value="Coche" checked>
                    <label class="form-check-label" for="transporteCoche">Coche</label>
                </div>
                
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="transporte" id="transporteAvion" value="Avion">
                    <label class="form-check-label" for="transporteAvion">Avión</label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="transporte" id="transporteAutobus" value="Autobus">
                    <label class="form-check-label" for="transporteAutobus">Autobús</label>
                </div>
            </div>

            <div class="mb-4">
                <p class="fw-bold">¿Cuáles son tus destinos favoritos?</p>

                <div class="btn-group" role="group" aria-label="Destinos favoritos">
                    <input type="checkbox" class="btn-check" name="destinos" id="destinoCiudad" value="Ciudad" autocomplete="off">
                    <label class="btn btn-outline-primary" for="destinoCiudad">Ciudad</label>
                  
                    <input type="checkbox" class="btn-check" name="destinos" id="destinoBosque" value="Bosque" autocomplete="off">
                    <label class="btn btn-outline-primary" for="destinoBosque">Bosque</label>
                  
                    <input type="checkbox" class="btn-check" name="destinos" id="destinoPlaya" value="Playa" autocomplete="off">
                    <label class="btn btn-outline-primary" for="destinoPlaya">Playa</label>
                </div>
            </div>
            
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
        </form>
    </div>

    <div class="container mt-5">
        <h4 class="mb-4 text-center">Ej. 3.8: Recepción de valores en lista de opciones</h4>

        <form action="paginaDestino2.jsp" method="post">
            <div class="mb-4">
                <p class="fw-bold">Idioma Natal:</p>
                <select name="idioma" class="form-select">
                    <option selected>Español</option>
                    <option>Inglés</option>
                    <option>Francés</option>
                    <option>Alemán</option>
                </select>
            </div>

            <div class="mb-4">
                <p class="fw-bold">Selecciona tu lenguaje de programación: <br><small>(Ctrl + clic para elegir varias opciones)</small></p>
                <select name="lenguajes" multiple class="form-select">
                    <option selected>Java</option>
                    <option>C/C++</option>
                    <option>Basics</option>
                    <option>Python</option>
                    <option>Pascal</option>
                </select>
            </div>
           
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
        </form>
    </div>

    <div class="container mt-5">
        <h4 class="mb-4 text-center">Ej. 3.9: Recepción de un área de texto</h4>

        <form action="paginaDestino3.jsp" method="post">
            <div class="mb-4">
                <p class="fw-bold">Se puede desplegar texto por default </p>
                <textarea class="form-control" name="transporteComentario" rows="3" name="area1" cols="30" placeholder="Escribe tus comentarios aquí...">Si la cantidad de palabras del texto es mayor a los tres renglones que se especificaron para esta area de texto, entonces se despliega automáticamente una barra de desplazamiento vertical.
                </textarea>
                
                
                <textarea class="form-control" name="area2" rows="3" cols="60">O puede ser un area en blanco para capturar texto
                </textarea>
            </div>
           
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
        </form>
    </div>
    
    <div class="container mt-5">
        <h4 class="mb-4 text-center">Ej. 3.10: Práctica</h4>
        <p class="fw-bold text-center">Después de introducir tus datos, oprime el botón "Enviar".</p>

        <form action="paginaDestino4.jsp" class="p-4 border rounded bg-white shadow-sm">
            <div class="mb-3 row">
                <label for="nombre" class="col-sm-3 col-form-label text-end">Nombre:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingresa tu nombre">
                </div>
            </div>

            <div class="mb-3 row">
                <label for="apellidos" class="col-sm-3 col-form-label text-end">Apellidos:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Ingresa tus apellidos">
                </div>
            </div>

            <div class="mb-3 row">
                <label for="email" class="col-sm-3 col-form-label text-end">Correo:</label>
                <div class="col-sm-9">
                    <input type="email" class="form-control" id="email" name="mail" placeholder="Ingresa tu correo electrónico">
                </div>
            </div>

            <div class="mb-3">
                <p class="mb-1">Eres:</p>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="genero" id="hombre" value="masculino" checked>
                    <label class="form-check-label" for="hombre">Hombre</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="genero" id="mujer" value="femenino">
                    <label class="form-check-label" for="mujer">Mujer</label>
                </div>
            </div>

            <div class="mb-3">
                <p class="mb-1">Selecciona lo que sabes:</p>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="java" id="java" value="java">
                    <label class="form-check-label" for="java">Java</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="c" id="c" value="c">
                    <label class="form-check-label" for="c">C/C++</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="basic" id="basic" value="basic">
                    <label class="form-check-label" for="basic">Basic</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="html" id="html" value="html">
                    <label class="form-check-label" for="html">HTML</label>
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-md-6">
                    <label for="idiomas" class="form-label">Selecciona los idiomas que comprendes:</label>
                    <select name="idiomas" id="idiomas" class="form-select" multiple>
                        <option selected>Español</option>
                        <option>Inglés</option>
                        <option>Francés</option>
                        <option>Alemán</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <label for="comentarios" class="form-label">Comentarios adicionales:</label>
                    <textarea name="comentario" id="comentarios" rows="3" class="form-control"></textarea>
                </div>
            </div>

            <div class="text-center">
                <button type="reset" class="btn btn-secondary me-2">Borrar</button>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xxxx" crossorigin="anonymous"></script>
</body>
</html>
