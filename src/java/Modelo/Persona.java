
package Modelo;


public class Persona {
      private String id_Corral;
    private String cantidadAnimales;
    private String estadoCorrales;
    private int corralesLimpios;
    
    public Persona (){
        
    }
    public Persona  (String id_Corral, String cantidadAnimales, String estadoCorrales, int corralesLimpios ){
        
    }

    public String getId_corral (){
        return id_Corral;
    }

    public void setId_corral(String id_persona) {
        this.id_Corral=id_Corral ;
    }

    public String getCantidadanimales () {
        return cantidadAnimales;
    }

    public void setCantidadanimales(String cantidadAnimales) {
        this.cantidadAnimales = cantidadAnimales;
    }

    public String getestadoCorrales() {
        return estadoCorrales;
    }

    public void setestadoCorrales(String estadoCorrales_persona) {
        this.estadoCorrales = estadoCorrales_persona;
    }

    public int getcorralesLimpios() {
        return corralesLimpios;
    }

    public void setcorralesLimpios(int corraleslimpios) {
        this.corralesLimpios = corraleslimpios;
    }
    
    public void imprimir_dato(){
        System.out.println("Clave:" + getId_corral() + "Cantidad:" +getCantidadanimales() + "Estado:" + getestadoCorrales() + "Corraleslimpios:" +getcorralesLimpios());
    }
        
            
}

