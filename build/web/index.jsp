<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página con Botones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/StyleIndex.css">
</head>
<body>
    <div class="container">
        <div class="header">
            Mi Encabezado
        </div>
        
        <div class="body">
            <p>Presiona uno de los botones:</p>
            <div class="button-container">
                <form action="SaltoFormulario" method="Post">
                    <button name="eleccion" value="produccionAgricola">produccion agricola</button>
                    <button name="eleccion" value="ControlHuertosCorrales">Control huertos corrales</button>
                    <button name="eleccion" value="registroEnfermedades"> registro enfermedades</button>
                    <button name="eleccion" value="controlHumedad">control humedad</button>
                </form>
               
            </div>
        </div>

        <div class="footer">
        </div>
    </div>
</body>
</html>