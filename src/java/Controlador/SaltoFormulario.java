
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "SaltoFormulario", urlPatterns = {"/SaltoFormulario"})
public class SaltoFormulario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession misession = request.getSession();
        String accion = request.getParameter("eleccion");

        switch (accion) {
            case "produccionAgricola":
                response.sendRedirect("RegistroProduccion.jsp");
                break;
            case "ControlHuertosCorrales":
                response.sendRedirect("ControlHuertosCorrales.jsp");
                break;
            case "registroEnfermedades":
                response.sendRedirect("RegistroEnfermedades.jsp");
                break;
            case "controlHumedad":
                
               
                response.sendRedirect("ControlHumedad.jsp");
                break;
            default:
                response.sendRedirect("error.jsp");
                break;
        }
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
