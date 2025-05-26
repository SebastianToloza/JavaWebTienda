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
                <form action="controlador" method="Post">
                    <button>Botón 1</button>
                    <button>Botón 2</button>
                    <button>Botón 3</button>
                    <button>Botón 4</button>
                </form>
               
            </div>
        </div>

        <div class="footer">
        </div>
    </div>
</body>
</html>