package Controlador;

import Modelo.Produccion_Agricola;
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

@WebServlet(name = "RegistroProduccion", urlPatterns = {"/RegistroProduccion"})
public class RegistroProduccion extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("Eleccion");
        System.out.println("Hola");
        
                int identificador = Integer.parseInt(request.getParameter("identificador"));
                String tipoEntidad = request.getParameter("animal");
                int nivelHumedad = Integer.parseInt(request.getParameter("cantidades"));
                String tipoHumedad = request.getParameter("estados");
                String fecha = request.getParameter("fechas");

                boolean confirmador = true;
                Produccion_Agricola objDatoCorral = new Produccion_Agricola();
        try {
            objDatoCorral.hacerConexion();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroProduccion.class.getName()).log(Level.SEVERE, null, ex);
        }

                try {
                    confirmador = objDatoCorral.confirmarInformacionRegistro(identificador);
                    if (confirmador) {
                        objDatoCorral.agregarUsuario(identificador, tipoEntidad, nivelHumedad, tipoHumedad, fecha);
                    } else {
                        System.out.println("HOla");
                    }
                } catch (SQLException ex) {
                }
           
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}