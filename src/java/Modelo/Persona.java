package Modelo;

import java.sql.*;

public class Persona {
    
    String usuario;
    String url;
    String clave;
    Connection conex;
    public ResultSet resultadoConsulta;

    public Persona(){
        
        usuario = "sebas";
        url="jdbc:mysql://localhost:3306/registro_agricola";
        clave="";
        conex =null;
        this.resultadoConsulta = null;
    }
    public void hacerConexion () throws SQLException{
        try{
            conex=DriverManager.getConnection(url,usuario,clave);
            System.out.println("Dato conexion:" + conex.toString());
        }catch(SQLException e){
            System.out.println("ERROR:" + e);
        }
    }
    
    public ResultSet getId() throws SQLException{
        String sqlText="SELECT id_registro FROM control_humedad";
        Statement consultarSentencia =this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return resultadoConsulta;
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
    
    public boolean agregarRegistro(int id_registro, String tipo_entidad, double nivel_humedad, String tipo_humedad, Date fecha) throws SQLException{
        String textosql = "INSERT INTO control_humedad(id_registro, tipo_entidad, nivel_humedad, tipo_humedad, fecha) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement modific = this.conex.prepareStatement(textosql);
        modific.setInt(1, id_registro);
        modific.setString(2, tipo_entidad);
        modific.setDouble(3, nivel_humedad);
        modific.setString(4, tipo_humedad);
        modific.setDate(5, fecha);


        int filasInsertadas = modific.executeUpdate();

        return  filasInsertadas>0;
    
    }
}
