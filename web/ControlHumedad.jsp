<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Control de humedad</h1>
            <form >
                <!-- id_registro	tipo_entidad	nivel_humedad	tipo_humedad	fecha	 -->
                <label>Identificador del Registro</label>
                <input type="text" name="id"><br>

                <label for="fruta">Tipo entidad:</label>
                <select id="frutas">
                    <option value="manzana">Manzana</option>
                    <option value="banana">Banana</option>
                    <option value="naranja">Naranja</option>
                </select>
            </form>
            
        </div>
        
    </body>
</html>
