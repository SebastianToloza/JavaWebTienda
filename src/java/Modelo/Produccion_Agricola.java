package Modelo;
import java.sql.*;
import java.util.ArrayList;


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
    
    public ResultSet getId() throws SQLException{
        String sqlText="SELECT id FROM registro_produccion";
        Statement consultarSentencia =this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        
        return resultadoConsulta;
    }
    
    public ResultSet getAnimal() throws SQLException {
        String sqlText = "SELECT tipodeespecie FROM registro_produccion";
        Statement consultarSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
        
    }
    
    public ResultSet getCantidad() throws SQLException {
        String sqlText = "SELECT cantidad FROM registro_produccion";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta =consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }   
    
    
    
    public ResultSet getestado() throws SQLException {
        String sqlText = "SELECT estado FROM registro_produccion";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }
    
        public ResultSet getfecha() throws SQLException {
        String sqlText = "SELECT fecha FROM registro_produccion";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }

    
    public boolean confirmarInformacionRegistro(int dato) throws SQLException{
        String sqlText = "SELECT id FROM registro_produccion WHERE id = ?";
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
    
    public boolean agregarUsuario(int id, String animales,int cantidad, String estado, String fecha) throws SQLException{
        String textosql = "INSERT INTO registro_produccion(id, tipodeespecie, cantidad, estado, fecha) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement modific = this.conex.prepareStatement(textosql);
        modific.setInt(1, id);
        modific.setString(2, animales);
        modific.setInt(3, cantidad);
        modific.setString(4, estado);
        modific.setString(5, fecha);


        int filasInsertadas = modific.executeUpdate();

        return  filasInsertadas>0;
    
    }
    
    /*.-------------- faltan cosistas :< --------------*/
    public ArrayList<Object> obtenerTodasHumedades(int valor) throws SQLException {
            ArrayList<Object> listaHumedades = new ArrayList<>();
            String sql = "SELECT * FROM registro_produccion WHERE id = ?";
                PreparedStatement consultaSentencia = this.conex.prepareStatement(sql);
            consultaSentencia.setInt(1, valor);
            
            this.resultadoConsulta = consultaSentencia.executeQuery();
            System.out.println("EL REsultSet"+consultaSentencia);

            while (this.resultadoConsulta.next()) {
                int id = this.resultadoConsulta.getInt("id");
                String tipoEntidad = this.resultadoConsulta.getString("tipodeespecie");
                double nivelHumedad = this.resultadoConsulta.getDouble("cantidad");
                String tipoHumedad = this.resultadoConsulta.getString("estado");
                String fecha = this.resultadoConsulta.getString("fecha");
                
                System.out.println("El id qva a qui"+id);

                listaHumedades.add(id);
                listaHumedades.add(tipoEntidad);
                listaHumedades.add(nivelHumedad);
                listaHumedades.add(tipoHumedad);
                listaHumedades.add(fecha);
            }
            System.out.println("la fuckin lista"+listaHumedades);
            this.resultadoConsulta.close();
            consultaSentencia.close();

            return listaHumedades;
        }
    
    
       public void actualizarUsuario(int id_registro, String tipo_entidad, double nivel_humedad, String tipo_humedad, String fecha) {
           String sql = "UPDATE registro_produccion SET tipodeespecie = ?, cantidad = ?, estado = ?, fecha= ? WHERE id = ?";

           try (PreparedStatement consultaSentencia = this.conex.prepareStatement(sql)) {
               consultaSentencia.setString(1, tipo_entidad);
               consultaSentencia.setDouble(2, nivel_humedad);
               consultaSentencia.setString(3, tipo_humedad);
               consultaSentencia.setString(4, fecha);
               consultaSentencia.setInt(5, id_registro);

               int filasAfectadas = consultaSentencia.executeUpdate();
               System.out.println("Filas actualizadas: " + filasAfectadas);

           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       
       
       
       public boolean eliminarPorId(int id) {
           String sql = "DELETE FROM registro_produccion WHERE id = ?";
           boolean opcion = true;
           try (PreparedStatement consultarSentencia = this.conex.prepareStatement(sql)) {
               consultarSentencia.setInt(1, id);

               int filasAfectadas = consultarSentencia.executeUpdate();
               opcion = filasAfectadas > 0;
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return opcion;     
       }
   
}