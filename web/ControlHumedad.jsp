<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/StyleControlHumedad.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <div id="contenedor">
            
            <div id="contenedorFormulario">
                <div id="header">
                    <h1>Control de humedad</h1>
                </div>
                <form action="ContolHuInfo" method="post">

                    <div>
                        <label for="id">Identificador del Registro</label>
                        <input type="text"  id="id" name="identificador" required><br>
                    </div>

                    <div>
                        <label for="entidad">Tipo entidad:</label>
                        <select id="entidad" name="tipoEntidad" required>
                            <option value="corral">corral</option>
                            <option value="huerto">huerto</option>
                        </select><br>
                    </div>


                    <div>
                        <label for="nvHumedad">Nivel de humedad</label>
                        <input id="nvHumedad" type="number" value="1" min="1" name="nivelHumedad"  required><br>
                    </div>

                    <div>
                        <label for="tipHumedad">Tipo humedad</label>
                        <select id="tipHumedad" name="tipoHumedad" required>
                            <option value="condensacion">condensación</option>
                            <option value="filtracion">filtración </option>
                            <option value="capilaridad">capilaridad</option>
                        </select><br>
                    </div>


                    <div>
                        <label for="fecha">Fecha de registro</label>
                        <input id="fecha" type="date" name="fechaRegistro" required><br>
                    </div>

                    <div id="boton">
                        <input  type="submit" text="Guardar" class="botonesFinales">
                        <input  type="submit" text="Eviar" class="botonesFinales">
                    </div>
                </form>

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
                        }else {
                    %>
                                <p>No se encontraron datos.</p>
                    <%
                        }
                    %>
                    
                </div>

            </div>
            
            
        </div>
        <script src="<%= request.getContextPath()%>/Interacciones/InteractHum.js" defer></script>
                        
                    
    </body> 
</html>
