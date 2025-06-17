
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

/**
 *
 * @author SENA
 */
@WebServlet(name = "Enfermedades", urlPatterns = {"/Enfermedades"})
public class Enfermedades extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
                String tipoEntidad = request.getParameter("enfermedades");
                int nivelHumedad = Integer.parseInt(request.getParameter("cantidades"));
                String tipoHumedad = request.getParameter("estados");
                String fecha = request.getParameter("fechas");

                boolean confirmador = true;
                Date_enfermedades objDatoCorral = new Date_enfermedades();

                try {
                    objDatoCorral.hacerConexion();
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


