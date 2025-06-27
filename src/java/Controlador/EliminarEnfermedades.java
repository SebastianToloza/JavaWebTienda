
package Controlador;

import Modelo.Date_enfermedades;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "EliminarEnfermedades", urlPatterns = {"/EliminarEnfermedades"})
public class EliminarEnfermedades extends HttpServlet {

  
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
