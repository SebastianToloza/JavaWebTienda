
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import  Modelo.HumedadData;
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
        HumedadData objHumedadData = new HumedadData();
        ArrayList<String> listaDatosID = new ArrayList<>();
        ArrayList<String> listaDatosFecha = new ArrayList<>();

        
        
        try {
            objHumedadData.hacerConexion();
        } catch (SQLException ex) {
            Logger.getLogger(SaltoFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ResultSet rsId = objHumedadData.getId();
            ResultSet rsFecha = objHumedadData.getFecha();

            
            while (rsId.next()) {

                listaDatosID.add(rsId.getString("id_registro"));
                System.out.println("Lista de IDs: " + listaDatosID);

            }
            
            while(rsFecha.next()){
                
                listaDatosFecha.add(rsFecha.getString("fecha"));
                System.out.println("Lista de IDs: " + listaDatosFecha);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaltoFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object vector[]={listaDatosID,listaDatosFecha};
        System.out.println(vector);
        HttpSession misession = request.getSession();
        misession.setAttribute("datosTabla", vector);

        
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
