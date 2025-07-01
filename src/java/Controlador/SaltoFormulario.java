
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Modelo.Date_enfermedades;
import  Modelo.Datehuertos_corrales;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;



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
        ArrayList<String> listaDatosID = new ArrayList<>();
        ArrayList<String> listaDatosFecha = new ArrayList<>();
        listaDatosID.clear();
        listaDatosFecha.clear();

        
        

        

        
        String accion = request.getParameter("eleccion");

        switch (accion) {
            case "produccionAgricola":
                /*---------------------- 1 -------------------*/

                
                
                response.sendRedirect("RegistroProduccion.jsp");
                break;
            case "ControlHuertosCorrales":
                /*---------------------- 2 -------------------*/
                
                    Datehuertos_corrales objDatehuertos_corrales2 = new Datehuertos_corrales();

                try {
                    objDatehuertos_corrales2.hacerConexion();
                    ResultSet rsId = objDatehuertos_corrales2.getid();
                    ResultSet rsFecha = objDatehuertos_corrales2.getfecha();

                    while (rsId.next()) {

                        listaDatosID.add(rsId.getString("id"));

                    }

                    while (rsFecha.next()) {

                        listaDatosFecha.add(rsFecha.getString("fecha"));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SaltoFormulario.class.getName()).log(Level.SEVERE, null, ex);
                }
                Object vector2[] = {listaDatosID, listaDatosFecha};
                System.out.println(vector2);
                HttpSession misession2 = request.getSession();
                misession2.setAttribute("datosTabla", vector2);
                
                response.sendRedirect("ControlHuertosCorrales.jsp");

                break;
            case "registroEnfermedades":
                /*---------------------- 3 -------------------*/
                Date_enfermedades objDate_enfermedades = new Date_enfermedades();

                try {
                    objDate_enfermedades.hacerConexion();
                    ResultSet rsId = objDate_enfermedades.getid();
                    ResultSet rsFecha = objDate_enfermedades.getfecha();

                    while (rsId.next()) {

                        listaDatosID.add(rsId.getString("id"));

                    }

                    while (rsFecha.next()) {

                        listaDatosFecha.add(rsFecha.getString("fecha"));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(SaltoFormulario.class.getName()).log(Level.SEVERE, null, ex);
                }
                Object vector3[] = {listaDatosID, listaDatosFecha};
                System.out.println(vector3);
                HttpSession misession3 = request.getSession();
                misession3.setAttribute("datosTabla", vector3);
                
                response.sendRedirect("RegistroEnfermedades.jsp");
                break;
                
                
                
            case "Corrales_Huertos":
                /*---------------------- 4 -------------------*/

                
                response.sendRedirect("Corrales_Huertos.jsp");
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
