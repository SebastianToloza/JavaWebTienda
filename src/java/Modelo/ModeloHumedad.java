package Modelo;

public class ModeloHumedad {
    private int idRegistro;
    private String tipoEntidad;
    private double nivelHumedad;
    private String tipoHumedad;
    private String fecha;

    public ModeloHumedad(int idRegistro, String tipoEntidad, double nivelHumedad, String tipoHumedad, String fecha) {
        this.idRegistro = idRegistro;
        this.tipoEntidad = tipoEntidad;
        this.nivelHumedad = nivelHumedad;
        this.tipoHumedad = tipoHumedad;
        this.fecha = fecha;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public double getNivelHumedad() {
        return nivelHumedad;
    }

    public void setNivelHumedad(double nivelHumedad) {
        this.nivelHumedad = nivelHumedad;
    }

    public String getTipoHumedad() {
        return tipoHumedad;
    }

    public void setTipoHumedad(String tipoHumedad) {
        this.tipoHumedad = tipoHumedad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean Validarnivel() {
        return nivelHumedad >= 0 && nivelHumedad <= 100;
    }

    @Override
    public String toString() {
        return "ModeloHumedad{" +
                "idRegistro=" + idRegistro +
                ", tipoEntidad='" + tipoEntidad + '\'' +
                ", nivelHumedad=" + nivelHumedad +
                ", tipoHumedad='" + tipoHumedad + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
