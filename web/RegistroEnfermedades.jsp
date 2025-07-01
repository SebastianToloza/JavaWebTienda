<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/JavaWebTienda22/Style/StyleEnfermedades.css">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="Imagenes/Caballo.png" class="caballito">
         <div class="contenedorprincipal">
         <div class="filasuperior">
            <div id="contenedor">
                <div id="header">
                     <img src="Imagenes/Vaca.png" class="Vaquita">
                    <h1>Enfermedades Animales/Plantas</h1>
                     <img src="Imagenes/Planta.png" class="Plantita">
                </div>
                <form action="Enfermedades" method="post">

                    <div>
                    <label for="id">Identificador de enfermedades:</label>
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
                        <option value="Enfermedades por hongos">Enfermedades por hongos</option>
                        <option value="Enfermedades por bacterias">Enfermedades por bacterias</option>
                        <option value="Enfermedades por virus">Enfermedades por virus</option>
                        <option value="Enfermedades por nematodos">Enfermedades por nematodos</option>
                        <option value="Enfermedades fisiologicas">Enfermedades fisiologicas</option>
                    </select><br>

                    </div>



                    <div>
                    <label for="Cantidad">Cantidad de Animales/Plantas:</label>
                    <input id="Cantidad" type="number" name="cantidades"><br>
                    </div>

                    <div>
                    <label for="estado">Estado de los Animales/Plantas Enfermas:</label>
                    <select id="estado" name="estados">
                        <option value="Estable">Estable</option>
                        <option value="Delicado">Delicado</option>
                        <option value="Grave">Grave</option>
                        <option value="Critico">Critico</option>
                        <option value="Sana">Sana</option>
                        <option value="Estresada">Estresada</option>
                        <option value="Enferma">Enferma</option>
                        <option value="Muerta">Muerta</option>
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
        <button onclick="window.location.href='index.jsp';">Ver Control de corrales y huertos</button>

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
                <script src="<%= request.getContextPath() %>/Interacciones/EnfermedadesInteraccion.js" defer></script>

    </body>
</html>
