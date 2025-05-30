
package Controlador;

import Modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@WebServlet(name = "SAlto", urlPatterns = {"/SAlto"})
public class SAlto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SAlto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SAlto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String idCorral = request.getParameter("idCorral");
        String cantidadAnimales = request.getParameter("cantidadAnimales");
        String estadoCorrales = request.getParameter("estadoCorrales");
        int corralesLimpios =Integer.parseInt(request.getParameter("corralesLimpios"));
        
        Persona  objPersona  = new Persona (idCorral,cantidadAnimales,estadoCorrales,corralesLimpios);
        objPersona .imprimir_dato();
        
        ArrayList<Persona >listaPersonas  = new ArrayList<>();
        listaPersonas.add(new  Persona  ("4567", "pablo", "perez", 300));
        listaPersonas.add(new Persona  ("0987", "ricardo", "garcia", 200));
        listaPersonas.add(new Persona  ("1234","taylor", "bernate", 100));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



