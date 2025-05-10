package ejerciciosrepaso;

/**
 *
 * @author AlumnoT
 */
public class Tren extends Transporte {

    private int numeroVagones;

    /**
     *
     */
    public Tren() {
        super();
        numeroVagones = 0;
    }

    /**
     *
     * @param numeroVagones
     * @param capacidad
     * @param velocidadMaxima
     * @param nombreTransporte
     */
    public Tren(int numeroVagones, int capacidad, int velocidadMaxima, String nombreTransporte) {
        super(capacidad, velocidadMaxima, nombreTransporte);
        this.numeroVagones = numeroVagones;
    }

    /**
     *
     * @return
     */
    public int getNumeroVagones() {
        return numeroVagones;
    }

    /**
     *
     * @param numeroVagones
     */
    public void setNumeroVagones(int numeroVagones) {
        this.numeroVagones = numeroVagones;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "\nLos numeros de vagones son: " + numeroVagones;
    }

}
