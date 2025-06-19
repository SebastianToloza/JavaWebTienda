package Modelo;
import java.sql.*;


   public class Produccion_Agricola {
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
        String sqlText="SELECT id FROM iregistro_produccion";
        Statement consultarSentencia =this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return resultadoConsulta;
    }
    
    public ResultSet getanimal() throws SQLException {
        String sqlText = "SELECT animal FROM iregistro_produccion";
        Statement consultarSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
        
    }
    
    public ResultSet getCantidad() throws SQLException {
        String sqlText = "SELECT cantidad FROM iregistro_produccion";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta =consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }   
    
    
    
    public ResultSet getestado() throws SQLException {
        String sqlText = "SELECT estado FROM iregistro_produccion";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }
    
        public ResultSet getfecha() throws SQLException {
        String sqlText = "SELECT fecha FROM iregistro_produccion";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }

    
    public boolean confirmarInformacionRegistro(String dato) throws SQLException{
        String sqlText = "SELECT id FROM iregistro_produccion WHERE id = ?";
        PreparedStatement consultarSentencia = this.conex.prepareStatement(sqlText);
        consultarSentencia.setString(1, dato);
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
    
    public boolean agregarUsuario(int id, String animales,int cantidad, String estado, String fecha) throws SQLException{
        String textosql = "INSERT INTO iregistro_produccion(id, animal, cantidad, estado, fecha) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement modific = this.conex.prepareStatement(textosql);
        modific.setInt(1, id);
        modific.setString(2, animales);
        modific.setInt(3, cantidad);
        modific.setString(4, estado);
        modific.setString(5, fecha);


        int filasInsertadas = modific.executeUpdate();

        return  filasInsertadas>0;
    
    }
}
