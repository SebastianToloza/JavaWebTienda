
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

import Modelo.Sql.HumedadData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ContolHuInfo", urlPatterns = {"/ContolHuInfo"})
public class ContolHuInfo extends HttpServlet {
  
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
        
        
        
        int identificador = Integer.parseInt( request.getParameter("identificador"));
        String tipoEntidad = request.getParameter("tipoEntidad");
        int nivelHumedad = Integer.parseInt(request.getParameter("nivelHumedad"));
        String tipoHumedad = request.getParameter("tipoHumedad");
        String fecha = request.getParameter("fechaRegistro");
        
        
        boolean confirmador = true;
        HumedadData objPersona = new HumedadData();

        
        try {
            objPersona.hacerConexion();
            confirmador = objPersona.confirmarInformacionRegistro(identificador);
            System.out.println("Antes");
            if (confirmador) {
                System.out.println("Intenta crear");
                objPersona.agregarRegistro(identificador, tipoEntidad, nivelHumedad, tipoHumedad, fecha);
            }else{
                System.out.println("Intenta actualizar");

                objPersona.actualizarUsuario(identificador, tipoEntidad, nivelHumedad, tipoHumedad, fecha);
            }

        } catch (SQLException ex) {
                   Logger.getLogger(ContolHuInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
       

         
        processRequest(request, response);
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
