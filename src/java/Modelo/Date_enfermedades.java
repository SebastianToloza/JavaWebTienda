
package Modelo;
import java.sql.*;


   public class Date_enfermedades {
    public String usuario;
    public String url;
    public String clave;
    public Connection conex;
    public ResultSet resultadoConsulta;
    
    
    public Date_enfermedades(){
        this.usuario = "root";
        this.url = "jdbc:mysql://localhost:3306/registro_agricola?zeroDateTimeBehavior=CONVERT_TO_NULL";
        this.clave = "";
        this.conex = null;
        this.resultadoConsulta=null;
    }
    
    public void hacerConexion() throws SQLException {
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            conex = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException e) {
            System.out.println("ERROR");
        }
    }
    
    public ResultSet getid() throws SQLException{
        String sqlText="SELECT id FROM registro_enfermedades";
        Statement consultarSentencia =this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        
        return resultadoConsulta;
    }
    
    public ResultSet getenfermedad() throws SQLException {
        String sqlText = "SELECT enfermedad FROM registro_enfermedades";
        Statement consultarSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
        
    }
    
    public ResultSet getCantidad() throws SQLException {
        String sqlText = "SELECT Cantidad FROM registro_enfermedades";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta =consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }   
    
    
    
    public ResultSet getestado() throws SQLException {
        String sqlText = "SELECT estado FROM registro_enfermedades";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }
    
        public ResultSet getfecha() throws SQLException {
        String sqlText = "SELECT fecha FROM registro_enfermedades";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }

    
    public boolean confirmarInformacionRegistro(int dato) throws SQLException{
        String sqlText = "SELECT id FROM registro_enfermedades WHERE id = ?";
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
    
    public boolean agregarUsuario(int id, String enfermedad,int Cantidad, String estado, String fecha) throws SQLException{
        String textosql = "INSERT INTO registro_enfermedades(id, enfermedad, Cantidad, estado, fecha) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement modific = this.conex.prepareStatement(textosql);
        modific.setInt(1, id);
        modific.setString(2, enfermedad);
        modific.setInt(3, Cantidad);
        modific.setString(4, estado);
        modific.setString(5, fecha);


        int filasInsertadas = modific.executeUpdate();

        return  filasInsertadas>0;
    
    }

   
}

