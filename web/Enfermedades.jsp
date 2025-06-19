
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/JavaWebTienda22/Style/StyleEnfermedades.css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <img src="Caballo.png" class="caballito">
        <div id="contenedor">
            <div id="header">
                 <img src="Vaca.png" class="Vaquita">
                <h1>Enfermedades Animales</h1>
                 <img src="Vaca.png" class="Vaquita2">
            </div>
            <form action="Enfermedades" method="post">
                
                <div>
                <label for="id">Identificador de enfermedades</label>
                <input type="text"  id="id" name="identificador"><br>
                </div>
                
                <div>
                <label for="enfermedad">Tipo de enfermerdad:</label>
                <select id="enfermedad" name="enfermedades">
                    <option value="Infecciones respiratorias">Infecciones respiratorias</option>
                    <option value="Gastrointestinales">Gastrointestinales</option>
                    <option value="Parasitarias">Parasitarias</option>
                    <option value="Fiebre aftosa">Fiebre aftosa</option>
                    <option value="Mastitis">Mastitis</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de animales enfermos</label>
                <input id="Cantidad" type="number" name="cantidades"><br>
                </div>
                
                <div>
                <label for="estado">Estado del animal:</label>
                <select id="estado" name="estados">
                    <option value="Estable">Estable</option>
                    <option value="Delicado">Delicado</option>
                    <option value="Grave">Grave</option>
                     <option value="Critico">Critico</option>
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
            <button onclick="window.location.href='index.jsp';">Ver Control de corrales y huertos</button>
            
          </div>
    <body>
<div id="contenedores">
            <div id="header">
                  <img src="Planta.png" class="Plantita">
                <h1>Enfermedades Plantas</h1>
                  <img src="Planta.png" class="Plantita2">
            </div>
              <form action="Enfermedades" method="post">
                
                <div>
                <label for="id">Identificador de enfermedades</label>
                <input type="text"  id="id" name="identificador"><br>
                </div>
                
                <div>
                <label for="huerto">Tipo de enfermedad:</label>
                <select id="huerto" name="enfermedades">
                    <option value="Enfermedades por hongos">Enfermedades por hongos</option>
                    <option value="Enfermedades por bacterias">Enfermedades por bacterias</option>
                    <option value="Enfermedades por virus">Enfermedades por virus</option>
                    <option value="Enfermedades por nematodos">Enfermedades por nematodos</option>
                    <option value="Enfermedades fisiologicas">Enfermedades fisiologicas</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de plantas Enfermas</label>
                <input id="Cantidad" type="number" name="cantidades"><br>
                </div>
                
                <div>
                <label for="estado">Estado de las plantas:</label>
                <select id="estado" name="estados">
                    <option value="Sana">Sana</option>
                    <option value="Estresada">Estresada</option>
                     <option value="Enferma">Enferma</option>
                    <option value="Muerta">Muerta</option>
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
            <button onclick="window.location.href='index.jsp';">Ver Control de corrales y huertos</button>
            
            
        </div>
        </form>
    </body>
</html>
