
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


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
        
        String identificador = request.getParameter("identificador");
        String tipoEntidad = request.getParameter("tipoEntidad");
        String nivelHumedad = request.getParameter("nivelHumedad");
        String tipoHumedad = request.getParameter("tipoHumedad");
        String fechaRegistro = request.getParameter("fechaRegistro");
        System.out.println("Holaaaaaaaaaaa");
        System.out.println("ID: "+identificador);

         
        processRequest(request, response);
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
