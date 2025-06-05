
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

import Modelo.Persona;

@WebServlet(name = "ContolHuInfo", urlPatterns = {"/ContolHuInfo"})
public class ContolHuInfo extends HttpServlet {
    Persona objPersona = new  Persona();
  
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
        
        String identificador = request.getParameter("identificador");
        String tipoEntidad = request.getParameter("tipoEntidad");
        int nivelHumedad = Integer.parseInt(request.getParameter("nivelHumedad"));
        String tipoHumedad = request.getParameter("tipoHumedad");
        
        
        
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaRegistro = formato.parse("fechaRegistro");

            System.out.println("Fecha registrada: " + fechaRegistro);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String Datos[]={identificador, tipoEntidad, tipoHumedad};
        
        
        
        System.out.println("-------------------------");
        for(int i=0 ; i<Datos.length; i++){
            
           if(Datos[i].equalsIgnoreCase("")&& nivelHumedad==0){
           
           }
        }
        
        
        System.out.println("ID: " + Datos[0]);
        System.out.println("tipo Entidad: " + Datos[1]);
        System.out.println("nivelHumedad: " + Datos[2]);
        System.out.println("tipoHumedad: " + Datos[3]);
        System.out.println("fechaRegistro: " + Datos[4]);

         
        processRequest(request, response);
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
