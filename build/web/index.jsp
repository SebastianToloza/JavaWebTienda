
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/JavaWebTienda22/Style/StyleControlCorralHuerto.css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <img src="Caballo.png" class="caballito">
<div id="contenedor">
            <div id="header">
                   <img src="Cerdo.webp" class="Cerdito">
                <h1>Control de corrales</h1>
                <img src="Chivo.png" class="Chivito">
            </div>
    <form action="ControlCorrales" method="post">
                
                <div>
                <label for="id">Identificador del corral</label>
                <input type="text"  id="id" name="identificador"><br>
                </div>
                
                <div>
                <label for="animales">Tipo de animales:</label>
                <select id="animales" name="animal">
                    <option value="Pollos">Pollos</option>
                    <option value="Vacas">Vacas</option>
                    <option value="Caballos">Caballos</option>
                    <option value="Ovejas">Ovejas</option>
                    <option value="Conejos">Conejos</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de animales</label>
                <input id="Cantidad" type="number" name="cantidades"><br>
                </div>
                
                <div>
                <label for="estado">Estado de los corrales:</label>
                <select id="estado" name="estados">
                    <option value="Buen estado">Buen estado</option>
                    <option value="Mal estado">Mal estado</option>
                    <option value="En Mantenimiento">En Mantenimiento</option>
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
            <button onclick="window.location.href='Enfermedades.jsp';">Ver Enfermedades</button>
            
            
            
        </div>
    <body>
<div id="contenedores">
            <div id="header">
                <img src="Mazorca.png" class="Mazorquita">
                <h1>Control de huertos</h1>
                <img src="Tomate.png" class="Tomatito">
            </div>
            <form action="ControlCorrales" method="post">
                
                <div>
                <label for="id">Identificador del huerto</label>
                <input type="text"  id="id" name="identificador"><br>
                </div>
                
                <div>
                <label for="huerto">Tipo de huerto:</label>
                <select id="huerto" name="animal">
                    <option value="Huerto en cajoneras">Huerto en cajoneras</option>
                    <option value="Huerto colgantes">Huerto colgantes</option>
                    <option value="Huerto vertical">Huerto vertical</option>
                    <option value="Huerto en tierra">Huerto en tierra</option>
                    <option value="Huerto en invernadero">Huerto en invernadero</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de plantas</label>
                <input id="Cantidad" type="number" name="cantidades"><br>
                </div>
                
                
                <div>
                <label for="estado">Estado de los huertos:</label>
                <select id="estado" name="estados">
                    <option value="Buen estado">Buen estado</option>
                    <option value="Mal estado">Mal estado</option>
                    <option value="En Mantenimiento">En Mantenimiento</option>
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
            <button onclick="window.location.href='Enfermedades.jsp';">Ver Enfermedades</button>
            
            
        </div>
        </form>
    </body>
</html>