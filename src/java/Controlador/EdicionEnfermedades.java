
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import Modelo.Date_enfermedades;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "EdicionEnfermedades", urlPatterns = {"/EdicionEnfermedades"})
public class EdicionEnfermedades extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
    
         
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String id = request.getParameter("id");
            int valor = Integer.parseInt(id);

        Date_enfermedades objDAO = new Date_enfermedades();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        
        String jsonResponse = null;

        
        try {
            objDAO.hacerConexion();
            Boolean confirmador = objDAO.confirmarInformacionRegistro(valor);
            if(!confirmador){
                ArrayList<Object> lista =(ArrayList<Object>) objDAO.obtenerTodasEnfermedades(valor);
                jsonResponse = gson.toJson(lista);

            }
            else{
                jsonResponse = gson.toJson(Collections.singletonMap("mensaje", "ID recibido: " + id));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EdicionCorrales.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
        response.getWriter().write(jsonResponse);
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
