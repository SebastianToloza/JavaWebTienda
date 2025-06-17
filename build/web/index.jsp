<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/stylesheet.css">
        <title>Registro Producción Agrícola</title>
    </head>
    <body>
        <div id="contenedorGeneral">
            
            <div id="registros">
                <h2>Buscar Registros</h2>
                <form action="buscar.jsp" method="get" id="barraBusqueda">
                    <input type="text" name="query" placeholder="Buscar..." required>
                    <button type="submit" id="busqueda">Buscar</button>
                </form>
                <div id="datos">
                    <!-- Aquí se cargarán los datos filtrados -->
                </div>
            </div>

            <div id="container">
                <h1>Registro Producción Agrícola</h1>
                <form action="procesar.jsp" method="post">
                    <label for="id">Digite el id: </label>
                    <input type="text" id="id" name="id" required>
                    
                    <label for="nombre">Digite el nombre: </label>
                    <input type="text" id="nombre" name="nombre" required>

                    <label for="tipo">Digite el tipo: </label>
                    <input type="text" id="tipo" name="tipo" required>

                    <label for="cantidad">Digite la cantidad: </label>
                    <input type="text" id="cantidad" name="cantidad" required>

                    <label for="tamaño">Digite el tamaño: </label>
                    <input type="text" id="tamaño" name="tamaño" required>

                    <button type="submit" id="enviar">Registrar</button>
                </form>
            </div>
            
        </div>
    </body>
</html>