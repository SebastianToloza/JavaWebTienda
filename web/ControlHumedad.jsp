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
            <div id="header">
                <h1>Control de humedad</h1>
            </div>
            <form action="ContolHuInfo" method="post">
                
                <div>
                <label for="id">Identificador del Registro</label>
                <input type="text"  id="id" name="identificador"><br>
                </div>
                
                <div>
                <label for="entidad">Tipo entidad:</label>
                <select id="entidad" name="tipoEntidad">
                    <option value="corral">corral</option>
                    <option value="huerto">huerto</option>
                </select><br>
                </div>
                
                
                
                <div>
                <label for="nvHumedad">Nivel de humedad</label>
                <input id="nvHumedad" type="number" name="nivelHumedad"><br>
                </div>
                
                <div>
                <label for="tipHumedad">Tipo humedad</label>
                <select id="tipHumedad" name="tipoHumedad">
                    <option value="condensacion">condensación</option>
                    <option value="filtracion">filtración </option>
                    <option value="capilaridad">capilaridad</option>
                </select><br>
                </div>
                
                
                <div>
                <label for="fecha">Fecha de registro</label>
                <input id="fecha" type="date" name="fechaRegistro"><br>
                </div>
                
                <div id="boton">
                    <input  type="submit" text="Guardar" class="botonesFinales">
                    <input  type="submit" text="Eviar" class="botonesFinales">
                </div>
            </form>
            
            <% %>
            
        </div>
        
    </body>
</html>
