<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/JavaWebTienda22/Style/StyleControlCorralHuerto.css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <img src="Imagenes/Caballo.png" class="caballito">
         <div class="contenedorprincipal">
         <div class="filasuperior">
<div id="contenedor">
            <div id="header">
                   <img src="Imagenes/Cerdo.webp" class="Cerdito">
                <h1>Control Corrales/Huertos</h1>
                <img src="Imagenes/Mazorca.png" class="Mazorquita">
            </div>
    <form action="ControlCorrales" method="post">
                
                <div>
                <label for="id">Identificador del corral:</label>
                <input type="text"  id="id" name="identificador"><br>
                </div>
                
                <div>
                <label for="animales">Tipo de Animales/Huertos:</label>
                <select id="animales" name="animal">
                    <option value="Pollos">Pollos</option>
                    <option value="Vacas">Vacas</option>
                    <option value="Caballos">Caballos</option>
                    <option value="Ovejas">Ovejas</option>
                    <option value="Conejos">Conejos</option>
                    <option value="Huerto en cajoneras">Huerto en cajoneras</option>
                    <option value="Huerto colgantes">Huerto colgantes</option>
                    <option value="Huerto vertical">Huerto vertical</option>
                    <option value="Huerto en tierra">Huerto en tierra</option>
                    <option value="Huerto en invernadero">Huerto en invernadero</option>
                </select><br>
                
                </div>
                
                
                
                <div>
                <label for="Cantidad">Cantidad de Animales/Huertos:</label>
                <input id="Cantidad" type="number" name="cantidades"><br>
                </div>
                
                <div>
                <label for="estado">Estado de los corrales/Huertos:</label>
                <select id="estado" name="estados">
                    <option value="Buen estado">Buen estado</option>
                    <option value="Mal estado">Mal estado</option>
                    <option value="En Mantenimiento">En Mantenimiento</option>
                </select><br>
                </div>
                
                
                <div>
                <label for="fecha">Fecha de registro:</label>
                <input id="fecha" type="date" name="fechas"><br>
                </div>
                
                <div id="boton">
                    <input  type="submit" text="Guardar" class="botonesFinales">
                    <input  type="submit" text="Eviar" class="botonesFinales">
                </div>
            </form>
            <button onclick="window.location.href='Enfermedades.jsp';">Ver Enfermedades</button>
            
        </div>
         
         <div id="registros">
                <form action="ControlHumedadRegistros" method="get" id="Buscador">
                    <input id="barraBuscador" type="text" placeholder="Ingrese el id o Fecha">
                </form>

                <div id="registroConHumedad">
                    <%
                        Object[] datos = (Object[]) session.getAttribute("datosTabla");
                        if (datos != null) {
                            ArrayList<String> listaID = (ArrayList<String>) datos[0];
                            ArrayList<String> listaFecha = (ArrayList<String>) datos[1];
                            for (int i = 0 ; i<listaID.size() ; i++) {
                    %>  
                    <div class="ContenerdExt">
                        <div class="InformacionRegistro">
                            <p>ID Registro: <%=listaID.get(i) %> </p>
                            <p>Fecha de registro: <%=listaFecha.get(i)%></p>
                        </div>
                        <img class="Eliminar" src="Imagenes/Basurero.png">
                    </div>
                    <%
                            }
                        } else {
                    %>
                    <p>No se encontraron datos.</p>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
        
        </form>
        <script src="<%= request.getContextPath() %>/Interacciones/CorralesInteraccion.js" defer></script>
    </body>
    
</html>