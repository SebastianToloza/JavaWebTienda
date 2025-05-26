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
        url="jdbc:mysql://localhost:3306/Persona";
        clave="";
        conex =null;
        
        
    }
}
