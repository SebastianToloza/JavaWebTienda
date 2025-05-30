

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Style/StyleControlCorralHuerto  .css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Control de corrales </h1>
         <form action="SAlto" method="GET">
            <label>digite el numero de corral:</label>
            <input type "text" name="idCorral"></br>
            
            <label>digite la cantidad de animales:</label>
            <input type="number" name="cantidadAnimales"></br>
            
            <label>digite el estado de los corrales:</label>
            <select id="estado">
                    <option value="Buen estado">Buen estado</option>
                    <option value="Mal estado">Mal estado</option>
                    
                </select><br>
                
            <label>digite el registro de limpieza :</label>
            <input type="date" name="corralesLimpios"></br>
            <input type="submit"name="enviarinfo">
        </form>
    </body>
</html>
