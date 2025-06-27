
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Modelo.Datehuertos_corrales;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "EliminarCorrales", urlPatterns = {"/EliminarCorrales"})
public class EliminarCorrales extends HttpServlet {
    
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

        Datehuertos_corrales objDAO = new Datehuertos_corrales();
        boolean exito = true;

        
        try {
            objDAO.hacerConexion();
            exito = objDAO.eliminarPorId(valor);
        } catch (SQLException ex) {
        response.setContentType("text/plain");
            Logger.getLogger(EdicionCorrales.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(exito ? "ok" : "error");
        
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
