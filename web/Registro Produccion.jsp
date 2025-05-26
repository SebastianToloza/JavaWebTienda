

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Producción Agrícola</title>
    </head>
    <body>
        <div id="container">
            <h1>Registro Producción Agrícola</h1>
            <form action="procesar.jsp" method="post">
                <label for="nombre">Digite el nombre:</label>
                <input type="text" id="nombre" name="nombre">
                
                <label for="tipo">Digite el tipo:</label>
                <input type="text" id="tipo" name="tipo">
                
                <label for="cantidad">Digite la cantidad:</label>
                <input type="text" id="cantidad" name="cantidad">
                
                <label for="tamaño">Digite el tamaño:</label>
                <input type="text" id="tamaño" name="tamaño">
                
                <label for="descripcion">Digite la descripción:</label>
                <input type="text" id="descripcion" name="descripcion">
                
                <button type="submit">Registrar</button>
            </form>
        </div>
    </body>
</html>
