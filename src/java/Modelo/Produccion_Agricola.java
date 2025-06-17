package Modelo;
import jakarta.websocket.Decoder;
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
    
    
    
    public ResultSet getId() throws SQLException{
        String sqlText="SELECT id FROM Registro_Produccion";
        Statement consultarSentencia =this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return resultadoConsulta;
    }
    
    public ResultSet getNombre() throws SQLException{
        String sqlText = "SELECT Nombre FROM Registro_Produccion";
        Statement consultarSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }
    
    public ResultSet getTipo() throws SQLException {
        String sqlText = "SELECT tipo FROM Registro_Produccion";
        Statement consultarSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
        
    }
    
    public ResultSet getCantidad() throws SQLException {
        String sqlText = "SELECT Cantidad FROM Registro_Produccion";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta =consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }   
   
    public ResultSet getTamaño() throws SQLException {
        String sqlText = "SELECT tamaño FROM Registro_Produccion";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }

    public boolean confirmarInformacionRegistro(int dato) throws SQLException{
        String sqlText = "SELECT id FROM Resgristro_Produccion WHERE id = ?";
        PreparedStatement consultarSentencia = this.conex.prepareStatement(sqlText);
        consultarSentencia.setInt(1, dato);
        this.resultadoConsulta = consultarSentencia.executeQuery();

        System.out.println(consultarSentencia);
        
        
        if( this.resultadoConsulta.next()){
            String id =  this.resultadoConsulta.getString("id");
            System.out.println(id);
            if (id == null) {
                return true;
            } else if (id.equals(dato)) {
                return false;
            } else {
                return false;
            }
        
        }else{
            return true;
        }
    }
    
    public boolean agregarUsuario(int id, String nombre, String tipo,String cantidad,int tamaño) throws SQLException{
        String textosql = "INSERT INTO Registro_Produccion(id, nombre, tipo, cantiad, tamaño) VALUES (?, ?, ?, ?)";
        PreparedStatement modific = this.conex.prepareStatement(textosql);
        modific.setInt(1, id);
        modific.setString(2,nombre);
        modific.setString(3,tipo );
        modific.setString(4, cantidad);
        modific.setInt(5, tamaño);
  
        int filasInsertadas = modific.executeUpdate();

        return  filasInsertadas>0;
    
    }
}
