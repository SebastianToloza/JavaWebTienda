package Modelo.Sql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.ModeloHumedad;
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


   
        
       
        
        
        public ArrayList<Object> obtenerTodasHumedades(int valor) throws SQLException {
            ArrayList<Object> listaHumedades = new ArrayList<>();
            String sql = "SELECT * FROM control_humedad WHERE id_registro = ?";
            PreparedStatement consultaSentencia = this.conex.prepareStatement(sql);
            consultaSentencia.setInt(1, valor);
            
            this.resultadoConsulta = consultaSentencia.executeQuery();
            System.out.println("EL REsultSet"+consultaSentencia);

            while (this.resultadoConsulta.next()) {
                int id = this.resultadoConsulta.getInt("id_registro");
                String tipoEntidad = this.resultadoConsulta.getString("tipo_entidad");
                double nivelHumedad = this.resultadoConsulta.getDouble("nivel_humedad");
                String tipoHumedad = this.resultadoConsulta.getString("tipo_humedad");
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
            String sql = "UPDATE control_humedad SET tipo_entidad = ?, nivel_humedad = ?, tipo_humedad = ?, fecha= ? WHERE id_registro = ?";

            try (PreparedStatement consultaSentencia= this.conex.prepareStatement(sql)) {
                consultaSentencia.setString(1, tipo_entidad);
                consultaSentencia.setDouble(2, nivel_humedad );
                consultaSentencia.setString(3, tipo_humedad);
                consultaSentencia.setString(4, fecha);
                consultaSentencia.setInt(5, id_registro);

                int filasAfectadas = consultaSentencia.executeUpdate();
                System.out.println("Filas actualizadas: " + filasAfectadas);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        public boolean confirmarInformacionRegistro(int dato) throws SQLException{
            String sqlText = "SELECT id_registro FROM control_humedad WHERE id_registro = ?";
            PreparedStatement consultarSentencia = this.conex.prepareStatement(sqlText);
            consultarSentencia.setInt(1, dato);
            this.resultadoConsulta = consultarSentencia.executeQuery();



            if( this.resultadoConsulta.next()){
                String cedulas =  this.resultadoConsulta.getString("id_registro");
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
        public boolean eliminarPorId(int id) {
        String sql = "DELETE FROM control_humedad WHERE id_registro = ?";
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
    


