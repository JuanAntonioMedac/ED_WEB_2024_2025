package ejerciciosrepaso;

/**
 *
 * @author AlumnoT
 */
public class Autobus extends Transporte {

    private int numeroRutasAsignadas;

    /**
     *
     */
    public Autobus() {
        super();
        numeroRutasAsignadas = 0;
    }

    /**
     *
     * @param numeroRutasAsignadas
     * @param capacidad
     * @param velocidadMaxima
     * @param nombreTransporte
     */
    public Autobus(int numeroRutasAsignadas, int capacidad, int velocidadMaxima, String nombreTransporte) {
        super(capacidad, velocidadMaxima, nombreTransporte);
        this.numeroRutasAsignadas = numeroRutasAsignadas;
    }

    /**
     *
     * @return
     */
    public int getNumeroRutasAsignadas() {
        return numeroRutasAsignadas;
    }

    /**
     *
     * @param numeroRutasAsignadas
     */
    public void setNumeroRutasAsignadas(int numeroRutasAsignadas) {
        this.numeroRutasAsignadas = numeroRutasAsignadas;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "\nCantidad de rutas asignadas: " + numeroRutasAsignadas;
    }

}
