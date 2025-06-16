<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id="contenedorGeneral">
            
            <div id="registros">
                <div id="barraBusqueda"></div>
                <input type="text" name="query" placeholder="Buscar...">
                <button type="submit" id="busqueda">Buscar</button>
                <div id="datos">
                    
                </div>
                
            </div>

            <div id="container">
                <h1>Registro Producción Agrícola</h1>
                <form action="procesar.jsp" method="post">
                    <label for="id">Digite el id:</label>
                    <input type="text" id="nombre" name="nombre">
                    
                    <label for="nombre">Digite el nombre:</label>
                    <input type="text" id="nombre" name="nombre">

                    <label for="tipo">Digite el tipo:</label>
                    <input type="text" id="tipo" name="tipo">

                    <label for="cantidad">Digite la cantidad:</label>
                    <input type="text" id="cantidad" name="cantidad">

                    <label for="tamaño">Digite el tamaño:</label>
                    <input type="text" id="tamaño" name="tamaño">

                    <button type="submit" id="enviar">Registrar</button>
                </form>
            </div>
            
        </div>
         
       
    </body
