<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/stylesheet.css">
        <title>Registro Producción Agrícola</title>
    </head>
    <body>
        <img src="Caballo.png" class="caballito">
<div id="contenedor">
            <div id="header">
                <h1>Produccion de Corrales</h1>
            </div>
    <form action="RegistroProduccion" method="post">
                
                <div>
                <label for="id">Identificador de produccion</label>
                <input type="text"  id="id" name="identificador"><br>
                </div>
                
                <div>
                <label for="animales">Tipo de animales:</label>
                <select id="animales" name="animal">
                    <option value="Pollos">Pollos</option>
                    <option value="Vacas">Vacas</option>
                    <option value="Ovejas">Ovejas</option>
                    <option value="Conejos">Conejos</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de Produccion</label>
                <input id="Cantidad" type="number" name="cantidades"><br>
                </div>
                
                <div>
                <label for="estado">Estado de la produccion:</label>
                <select id="estado" name="estados">
                    <option value="Buen estado">Buen estado</option>
                    <option value="Mal estado">Mal estado</option>
                </select><br>
                </div>
                
                
                <div>
                <label for="fecha">Fecha de registro</label>
                <input id="fecha" type="date" name="fechas"><br>
                </div>
                
                <div id="boton">
                    <input  type="submit" text="Guardar" class="botonesFinales">
                    <input  type="submit" text="Eviar" class="botonesFinales">
                </div>
            </form>
           
            
            
            
        </div>
    <body>
<div id="contenedores">
            <div id="header">
                <h1>RegistroProduccion</h1>
            </div>
            <form action="RegistroProduccion" method="post">
                
                <div>
                <label for="id">Identificador de produccion</label>
                <input type="text"  id="id" name="identificador"><br>
                </div>
                
                <div>
                <label for="huerto">Tipo de huerto:</label>
                <select id="huerto" name="animal">
                    <option value="Huerto en cajoneras">Cilantro</option>
                    <option value="Huerto colgantes">Tomate</option>
                    <option value="Huerto vertical">Papa</option>
                    <option value="Huerto en tierra">Yuca</option>
                    <option value="Huerto en invernadero">Pimenton</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de produccion</label>
                <input id="Cantidad" type="number" name="cantidades"><br>
                </div>
                
                
                <div>
                <label for="estado">Estado de la produccion:</label>
                <select id="estado" name="estados">
                    <option value="Buen estado">Buen estado</option>
                    <option value="Mal estado">Mal estado</option>
                </select><br>
                </div>
                
                
                <div>
                <label for="fecha">Fecha de registro</label>
                <input id="fecha" type="date" name="fechas"><br>
                </div>
                
                <div id="boton">
                    <input  type="submit" text="Guardar" class="botonesFinales">
                    <input  type="submit" text="Enviar" class="botonesFinales">
                </div>
            </form>
           
