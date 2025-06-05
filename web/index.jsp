
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/JavaWebTienda22/Style/StyleControlCorralHuerto.css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<div id="contenedor">
            <div id="header">
                <h1>Control de corrales</h1>
            </div>
            <form>
                
                <div>
                <label for="id">Identificador del corral</label>
                <input type="text"  id="id" name="identificado"><br>
                </div>
                
                <div>
                <label for="animales">Tipo de animales:</label>
                <select id="animales">
                    <option value="Pollos">Pollos</option>
                    <option value="Vacas">Vacas</option>
                    <option value="Caballos">Caballos</option>
                    <option value="Ovejas">Ovejas</option>
                    <option value="Conejos">Conejos</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de animales</label>
                <input id="Cantidad" type="number"><br>
                </div>
                
                <div>
                <label for="estado">Estado de los corrales:</label>
                <select id="estado">
                    <option value="Buen estado">Buen estado</option>
                    <option value="Mal estado">Mal estado</option>
                    <option value="En Mantenimiento">En Mantenimiento</option>
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
            
            
            
        </div>
    <body>
<div id="contenedores">
            <div id="header">
                <h1>Control de huertos</h1>
            </div>
            <form>
                
                <div>
                <label for="id">Identificador del huerto</label>
                <input type="text"  id="id" name="identificado"><br>
                </div>
                
                <div>
                <label for="huerto">Tipo de huerto:</label>
                <select id="huerto">
                    <option value="Huerto en cajoneras">Huerto en cajoneras</option>
                    <option value="Huerto colgantes">Huerto colgantes</option>
                    <option value="Huerto vertical">Huerto vertical</option>
                    <option value="Huerto en tierra">Huerto en tierra</option>
                    <option value="Huerto en invernadero">Huerto en invernadero</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de plantas</label>
                <input id="Cantidad" type="number"><br>
                </div>
                
                <div>
                <label for="estados">Estado de las plantas:</label>
                <select id="estados">
                    <option value="Necesita agua">Necesita agua</option>
                    <option value="Necesita sol">Necesita sol</option>
                     <option value="Necesita sombra">Necesita sombra</option>
                    <option value="Contaminada">Contaminada</option>
                </select><br>
                </div>
                
                <div>
                <label for="estado">Estado de los huertos:</label>
                <select id="estado">
                    <option value="Buen estado">Buen estado</option>
                    <option value="Mal estado">Mal estado</option>
                    <option value="En Mantenimiento">En Mantenimiento</option>
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
            
            
            
        </div>
        </form>
    </body>
</html>