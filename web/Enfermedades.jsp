
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/JavaWebTienda22/Style/StyleEnfermedades.css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenedor">
            <div id="header">
                <h1>Enfermedades Animales</h1>
            </div>
            <form>
                
                <div>
                <label for="id">Identificador de enfermedades</label>
                <input type="text"  id="id" name="identificado"><br>
                </div>
                
                <div>
                <label for="enfermedad">Tipo de enfermerdad:</label>
                <select id="enfermedad">
                    <option value="Infecciones respiratorias">Infecciones respiratorias</option>
                    <option value="Gastrointestinales">Gastrointestinales</option>
                    <option value="Parasitarias">Parasitarias</option>
                    <option value="Fiebre aftosa">Fiebre aftosa</option>
                    <option value="Mastitis">Mastitis</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de animales enfermos</label>
                <input id="Cantidad" type="number"><br>
                </div>
                
                <div>
                <label for="estado">Estado del animal:</label>
                <select id="estado">
                    <option value="Estable">Estable</option>
                    <option value="Delicado">Delicado</option>
                    <option value="Grave">Grave</option>
                     <option value="Critico">Critico</option>
                </select><br>
                </div>
                
                
                <div>
                <label for="fecha">Fecha de registro</label>
                <input id="fecha" type="date"><br>
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
                <h1>Enfermedades Plantas</h1>
            </div>
            <form>
                
                <div>
                <label for="id">Identificador de enfermedades</label>
                <input type="text"  id="id" name="identificado"><br>
                </div>
                
                <div>
                <label for="huerto">Tipo de enfermedad:</label>
                <select id="huerto">
                    <option value="Enfermedades por hongos">Enfermedades por hongos</option>
                    <option value="Enfermedades por bacterias">Enfermedades por bacterias</option>
                    <option value="Enfermedades por virus">Enfermedades por virus</option>
                    <option value="Enfermedades por nematodos">Enfermedades por nematodos</option>
                    <option value="Enfermedades fisiologicas">Enfermedades fisiologicas</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de plantas Enfermas</label>
                <input id="Cantidad" type="number"><br>
                </div>
                
                <div>
                <label for="estados">Estado de las plantas:</label>
                <select id="estados">
                    <option value="Sana">Sana</option>
                    <option value="Estresada">Estresada</option>
                     <option value="Enferma">Enferma</option>
                    <option value="Muerta">Muerta</option>
                </select><br>
                </div>
                
                <div>
                <label for="fecha">Fecha de registro</label>
                <input id="fecha" type="date"><br>
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
