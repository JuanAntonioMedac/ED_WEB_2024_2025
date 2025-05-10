package ejerciciosrepaso;

/**
 *
 * @author AlumnoT
 */
public class Transporte {

    private int capacidad;
    private int velocidadMaxima;
    private String nombreTransporte;

    /**
     *
     */
    public Transporte() {
        capacidad = 0;
        velocidadMaxima = 0;
        nombreTransporte = "";
    }

    /**
     *
     * @param capacidad
     * @param velocidadMaxima
     * @param nombreTransporte
     */
    public Transporte(int capacidad, int velocidadMaxima, String nombreTransporte) {
        this.capacidad = capacidad;
        this.velocidadMaxima = velocidadMaxima;
        this.nombreTransporte = nombreTransporte;
    }

    /**
     *
     * @return
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     *
     * @return
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     *
     * @return
     */
    public String getNombreTransporte() {
        return nombreTransporte;
    }

    /**
     *
     * @param capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     *
     * @param velocidadMaxima
     */
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     *
     * @param nombreTransporte
     */
    public void setNombreTransporte(String nombreTransporte) {
        this.nombreTransporte = nombreTransporte;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Capacidad: " + capacidad + "\nVelocidad Maxima: " + velocidadMaxima + "\nNombre del transporte:" + nombreTransporte;
    }

}
