
package Modelo;
import java.sql.*;


public class Produccion_Agricola{
    public String usuario;
    public String url;
    public String clave;
    public Connection conex;
    public ResultSet resultadoConsulta;
    
    
    public Produccion_Agricola(){
        this.usuario = "root";
        this.url = "jdbc:mysql://localhost:3306/registro_agricola?zeroDateTimeBehavior=CONVERT_TO_NULL";
        this.clave = "";
        this.conex = null;
        this.resultadoConsulta=null;
    }
    
    public void hacerConexion() throws SQLException {

        try {
            conex = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException e) {
            System.out.println("ERROR");
        }
    }
    
    public ResultSet getCedula() throws SQLException{
        String sqlText="SELECT cedula FROM persona";
        Statement consultarSentencia =this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        
        return resultadoConsulta;
    }
    
    public ResultSet getCorreo() throws SQLException {
        String sqlText = "SELECT correo	 FROM persona";
        Statement consultarSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
        
    }
    
    public ResultSet getContraseña() throws SQLException {
        String sqlText = "SELECT contraseña FROM persona";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta =consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }   
    
    
    
    public ResultSet getNombre() throws SQLException {
        String sqlText = "SELECT nombre FROM persona";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }

    
    public boolean confirmarInformacionRegistro(int dato) throws SQLException{
        String sqlText = "SELECT cedula	 FROM persona WHERE cedula = ?";
        PreparedStatement consultarSentencia = this.conex.prepareStatement(sqlText);
        consultarSentencia.setInt(1, dato);
        this.resultadoConsulta = consultarSentencia.executeQuery();

        System.out.println(consultarSentencia);
        
        
        if( this.resultadoConsulta.next()){
            String cedulas =  this.resultadoConsulta.getString("cedula");
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
    
    public boolean agregarUsuario(int cedula, String nombre,String correo,String contraseña) throws SQLException{
        String textosql = "INSERT INTO persona(cedula, nombre, correo, contraseña) VALUES (?, ?, ?, ?)";
        PreparedStatement modific = this.conex.prepareStatement(textosql);
        modific.setInt(1, cedula);
        modific.setString(2, nombre);
        modific.setString(3, correo);
        modific.setString(4, contraseña	);


        int filasInsertadas = modific.executeUpdate();

        return  filasInsertadas>0;
    
    }
}
