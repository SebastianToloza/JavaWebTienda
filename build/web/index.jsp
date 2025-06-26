<%@page import="java.util.ArrayList"%>
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
        <div id="contenedorGeneral">
            <div id="contenedor">
                        <div id="header">
                            <h1>Produccion de Corrales</h1>
                        </div>
                <form action="RegistroProduccion" method="post">

                    <div>
                    <label for="id">Identificador de produccion: </label>
                    <input type="text"  id="id" name="identificador"><br>
                    </div>

                    <div>
                    <label for="animales">Tipo de animales:</label>
                    <select id="animales" name="animal">
                        <option value="Pollos">Pollos</option>
                        <option value="Vacas">Vacas</option>
                        <option value="Ovejas">Ovejas</option>
                        <option value="Conejos">Conejos</option>
                        <option value="Cilantro">Cilantro</option>
                        <option value="Tomate">Tomate</option>
                        <option value="Papa">Papa</option>
                        <option value="Yuca">Yuca</option>
                        <option value="Pimenton">Pimenton</option>
                    </select><br>

                    </div>

                    <div>
                    <label for="Cantidad">Cantidad de Produccion: </label>
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
                    <label for="fecha">Fecha de registro: </label>
                    <input id="fecha" type="date" name="fechas"><br>
                    </div>

                    <div id="boton">
                        <input  type="submit" text="Guardar" class="botonesFinales">
                        <input  type="submit" text="Eviar" class="botonesFinales">
                    </div>
                </form>

            </div>
            <!-- ---------------Registros--------------- -->
           <div id="registros">
                <form action="ControlCorralesHuertosRegistros" method="get" id="Buscador">
                    <input id="barraBuscador" type="text" placeholder="Ingrese el id o Fecha">
                </form>
                
                <div id="registroConCorralesHuertos">
                    
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
                        }else {
                    %>
                                <p>No se encontraron datos.</p>
                    <%
                        }
                    %>
                    
                </div>

            </div>
          
    </body>
</html>
