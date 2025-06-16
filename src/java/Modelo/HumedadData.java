package Modelo;

import java.sql.*;

public class HumedadData {
    
    String usuario;
    String url;
    String clave;
    Connection conex;
    public ResultSet resultadoConsulta;

    public HumedadData(){
        
        this.usuario ="root";
        this.url="jdbc:mysql://localhost:3306/registro_agricola?zeroDateTimeBehavior=CONVERT_TO_NULL";
        this.clave="";
        this.conex =null;
        this.resultadoConsulta = null;
    }
    public void hacerConexion () throws SQLException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
      
            this.conex=DriverManager.getConnection(url,usuario,clave);
            
        }catch(SQLException e){
            System.out.println("ERROR:" + e);
             throw e;
        }
    }
    
    public ResultSet getId() throws SQLException{
        String sqlText="SELECT id_registro FROM control_humedad";
        Statement consultarSentencia =this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }
    
    
    public ResultSet getEntidad() throws SQLException {
        String sqlText = "SELECT tipo_entidad FROM control_humedad";
        Statement consultarSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
        
    }
    
    public ResultSet getNvHumedad() throws SQLException {
        String sqlText = "SELECT nivel_humedad FROM control_humedad";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta =consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }   
    
    
    
    public ResultSet getTpHumedad() throws SQLException {
        String sqlText = "SELECT tipo_humedad FROM control_humedad";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }
    
    public ResultSet getFecha() throws SQLException {
        String sqlText = "SELECT fecha FROM control_humedad";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }
    

    
    public boolean confirmarInformacionRegistro(int dato) throws SQLException{
        String sqlText = "SELECT id_registro FROM control_humedad WHERE id_registro = ?";
        PreparedStatement consultarSentencia = this.conex.prepareStatement(sqlText);
        consultarSentencia.setInt(1, dato);
        this.resultadoConsulta = consultarSentencia.executeQuery();

        System.out.println(consultarSentencia);
        
        
        if( this.resultadoConsulta.next()){
            String cedulas =  this.resultadoConsulta.getString("id_registro");
            System.out.println(cedulas);
            if (cedulas == null) {
                return true;
            } else if (cedulas.equals(dato)) {
                return false;
            } else {
                return false;
            }
        
        }else{ 
            
            return true;
        }
    }
    
    public boolean agregarRegistro(int id_registro, String tipo_entidad, double nivel_humedad, String tipo_humedad, String fecha) throws SQLException{
        System.out.println("hola");
        String textosql = "INSERT INTO control_humedad(id_registro, tipo_entidad, nivel_humedad, tipo_humedad, fecha) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement modific = this.conex.prepareStatement(textosql);
        modific.setInt(1, id_registro);
        modific.setString(2, tipo_entidad);
        modific.setDouble(3, nivel_humedad);
        modific.setString(4, tipo_humedad);
        modific.setString(5, fecha);


        int filasInsertadas = modific.executeUpdate();

        return  filasInsertadas>0;
    
    }
}
