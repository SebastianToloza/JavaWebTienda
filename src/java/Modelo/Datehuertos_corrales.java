package Modelo;
import java.sql.*;
import java.util.ArrayList;


   public class Datehuertos_corrales {
    public String usuario;
    public String url;
    public String clave;
    public Connection conex;
    public ResultSet resultadoConsulta;
    
    
    public Datehuertos_corrales(){
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
        String sqlText="SELECT id FROM monitoreo_huertos_corrales";
        Statement consultarSentencia =this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        
        return resultadoConsulta;
    }
    
    public ResultSet getanimal() throws SQLException {
        String sqlText = "SELECT Establos FROM monitoreo_huertos_corrales";
        Statement consultarSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultarSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
        
    }
    
    public ResultSet getCantidad() throws SQLException {
        String sqlText = "SELECT cantidad FROM monitoreo_huertos_corrales";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta =consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }   
    
    
    
    public ResultSet getestado() throws SQLException {
        String sqlText = "SELECT estado FROM monitoreo_huertos_corrales";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }
    
        public ResultSet getfecha() throws SQLException {
        String sqlText = "SELECT fecha FROM monitoreo_huertos_corrales";
        Statement consultaSentencia = this.conex.createStatement();
        this.resultadoConsulta = consultaSentencia.executeQuery(sqlText);
        return this.resultadoConsulta;
    }

    
    public boolean confirmarInformacionRegistro(int dato) throws SQLException{
        String sqlText = "SELECT id FROM monitoreo_huertos_corrales WHERE id = ?";
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
        String textosql = "INSERT INTO monitoreo_huertos_corrales(id, Establos, cantidad, estado, fecha) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement modific = this.conex.prepareStatement(textosql);
        modific.setInt(1, id);
        modific.setString(2, animales);
        modific.setInt(3, cantidad);
        modific.setString(4, estado);
        modific.setString(5, fecha);


        int filasInsertadas = modific.executeUpdate();

        return  filasInsertadas>0;
    
    }
    
    public ArrayList<Object> obtenerTodosControles(int valor) throws SQLException {
            ArrayList<Object> listaControl = new ArrayList<>();
            String sql = "SELECT * FROM monitoreo_huertos_corrales WHERE id = ?";
            PreparedStatement consultaSentencia = this.conex.prepareStatement(sql);
            consultaSentencia.setInt(1, valor);
            
            this.resultadoConsulta = consultaSentencia.executeQuery();
            System.out.println("EL REsultSet"+consultaSentencia);

            while (this.resultadoConsulta.next()) {
                int id = this.resultadoConsulta.getInt("id");
                String Establos = this.resultadoConsulta.getString("Establos");
                double cantidad = this.resultadoConsulta.getDouble("cantidad");
                String estado = this.resultadoConsulta.getString("estado");
                String fecha = this.resultadoConsulta.getString("fecha");
                
                System.out.println("El id qva a qui"+id);

                listaControl.add(id);
                listaControl.add(Establos);
                listaControl.add(cantidad);
                listaControl.add(estado);
                listaControl.add(fecha);
            }
            System.out.println("la fuckin lista"+listaControl);
            this.resultadoConsulta.close();
            consultaSentencia.close();

            return listaControl;
        }
    
    
    public void actualizarUsuario(int id, String Establos, double cantidad, String estado, String fecha) {
            String sql = "UPDATE monitoreo_huertos_corrales SET Establos = ?, cantidad = ?, estado = ?, fecha= ? WHERE id = ?";

            try (PreparedStatement consultaSentencia= this.conex.prepareStatement(sql)) {
                consultaSentencia.setString(1, Establos);
                consultaSentencia.setDouble(2, cantidad );
                consultaSentencia.setString(3, estado);
                consultaSentencia.setString(4, fecha);
                consultaSentencia.setInt(5, id);

                int filasAfectadas = consultaSentencia.executeUpdate();
                System.out.println("Filas actualizadas: " + filasAfectadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public boolean eliminarPorId(int id) {
        String sql = "DELETE FROM monitoreo_huertos_corrales WHERE id = ?";
        boolean opcion =true;
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
