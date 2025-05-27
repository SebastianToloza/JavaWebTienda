<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/StyleControlHumedad.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenedor">
            <h1>Control de humedad</h1>
            <form>
                
                <label for="id">Identificador del Registro</label>
                <input type="text"  id="id" name="identificado"><br>

                <label for="fruta">Tipo entidad:</label>
                <select id="frutas">
                    <option value="manzana">Manzana</option>
                    <option value="banana">Banana</option>
                    <option value="naranja">Naranja</option>
                </select><br>
                
                <label for="nvHumedad">Nivel de humedad</label>
                <input id="nvHumedad" type="number"><br>
                
                <label for="fruta">Tipo entidad:</label>
                <select id="frutas">
                    <option value="manzana">Manzana</option>
                    <option value="banana">Banana</option>
                    <option value="naranja">Naranja</option>
                </select><br>
                
                <label for="fecha">Fecha de registro</label>
                <input id="fecha" type="date"><br>
                
                <input type="submit" text="Eviar">
            </form>
            
        </div>
        
    </body>
</html>
