package Modelo;

import java.sql.*;

public class Persona {
     //creando atributos de la clase 
    String usuario;
    String url;
    String clave;
    Connection conex;//la magia
    //crear el constructor
    public Persona(){
        
        usuario = "sebas";
        url="jdbc:mysql://localhost:3306/registro_agricola";
        clave="";
        conex =null;
        
        
    }
    public void hacerConexion () throws SQLException{
        try{
            conex=DriverManager.getConnection(url,usuario,clave);
            System.out.println("Dato conexion:" + conex.toString());
        }catch(SQLException e){
            System.out.println("ERROR:" + e);
        }
    }
    public void guardarDatos(){
    
    }
}
