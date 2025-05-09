package tema10;

/**
 * Clase de Gatos que puede comprobar la edad, nombre y la raza de los gatos
 *
 * @author Lola Avila
 * @version 1.0.
 */
public class Gato extends Granja {

    private int edadGato;
    private String nombreGato;
    private String razaGato;

    /**
     * Constructor por defecto
     */
    public Gato() {
        edadGato = 0;
        nombreGato = "";
        razaGato = "";
    }

    /**
     * Constructor por parametro
     *
     * @param edadGato la edad del gato
     * @param nombreGato el nombre del gato
     * @param razaGato la raza del gato
     * @param nombre el nombre del animal que sea
     * @param ubicacion la ubicacion del sitio
     * @param claseDeAnimal la clase de animal que sea
     * @param capacidad las capacidades que tenga el animal
     */
    public Gato(int edadGato, String nombreGato, String razaGato, String nombre, String claseDeAnimal, String ubicacion, String capacidad) {
        super(nombre, claseDeAnimal, ubicacion, capacidad);
        this.edadGato = edadGato;
        this.nombreGato = nombreGato;
        this.razaGato = razaGato;
    }

    /**
     * Metodo get de la variable edadGato
     *
     * @return devuelve la edad del gato
     */
    public int getEdadGato() {
        return edadGato;
    }

    /**
     * Metodo get de la variable nombreGato
     *
     * @return devuelve el nombre del gato
     */
    public String getNombreGato() {
        return nombreGato;
    }

    /**
     * Metodo get de la variable razaGato
     *
     * @return devuelve la raza del gato
     */
    public String getRazaGato() {
        return razaGato;
    }

    /**
     * Metodo set de la variable edadGato
     *
     * @param edadGato La edad del gato
     */
    public void setEdadGato(int edadGato) {
        this.edadGato = edadGato;
    }

    /**
     * Metodo set de la variable nombreGato
     *
     * @param nombreGato El nombre del gato
     */
    public void setNombreGato(String nombreGato) {
        this.nombreGato = nombreGato;
    }

    /**
     * Metodo set de la variable razaGato
     *
     * @param razaGato La raza del gato
     */
    public void setRazaGato(String razaGato) {
        this.razaGato = razaGato;
    }

    /**
     * Metodo override que permite imprimir el valor de todas las variables
     *
     * @return devuelve el valor de las variables edadGato, nombreGato y
     * razaGato
     */
    @Override
    public String toString() {
        return super.toString() + "Gato{" + "edadGato=" + edadGato + ", nombreGato=" + nombreGato + ", razaGato=" + razaGato + '}';
    }

    @Override
    public void sonido() {
        System.out.println("miau");
    }

}
