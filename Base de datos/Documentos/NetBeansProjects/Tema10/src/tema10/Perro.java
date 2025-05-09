package tema10;

/**
 * Clase de Perros que puede comprobar la edad, nombre y la raza de los perros
 *
 * @author Lola Avila
 * @version 1.0.
 */
public class Perro extends Granja {

    private int edadPerro;
    private String nombrePerro;
    private String razaPerro;

    /**
     * Constructor por defecto
     */
    public Perro() {
        edadPerro = 0;
        nombrePerro = "";
        razaPerro = "";
    }

    /**
     * Constructor por parametro
     *
     * @param edadPerro la edad del perro
     * @param nombrePerro el nombre del perro
     * @param razaPerro la raza del perro
     * @param nombre el nombre del animal que sea
     * @param ubicacion la ubicacion del sitio
     * @param claseDeAnimal la clase de animal que sea
     * @param capacidad las capacidades que tenga el animal
     */
    public Perro(int edadPerro, String nombrePerro, String razaPerro, String nombre, String claseDeAnimal, String ubicacion, String capacidad) {
        super(nombre, claseDeAnimal, ubicacion, capacidad);
        this.edadPerro = edadPerro;
        this.nombrePerro = nombrePerro;
        this.razaPerro = razaPerro;
    }

    /**
     * Metodo get de la variable edadPerro
     *
     * @return devuelve la edad del perro
     */
    public int getEdadPerro() {
        return edadPerro;
    }

    /**
     * Metodo get de la variable nombrePerro
     *
     * @return devuelve el nombre del perro
     */
    public String getNombrePerro() {
        return nombrePerro;
    }

    /**
     * Metodo get de la variable razaPerro
     *
     * @return devuelve la raza del perro
     */
    public String getRazaPerro() {
        return razaPerro;
    }

    /**
     * Metodo set de la variable edadPerro
     *
     * @param edadPerro La edad del perro
     */
    public void setEdadPerro(int edadPerro) {
        this.edadPerro = edadPerro;
    }

    /**
     * Metodo set de la variable nombrePerro
     *
     * @param nombrePerro El nombre del perro
     */
    public void setNombrePerro(String nombrePerro) {
        this.nombrePerro = nombrePerro;
    }

    /**
     * Metodo set de la variable razaPerro
     *
     * @param razaPerro La raza del perro
     */
    public void setRazaPerro(String razaPerro) {
        this.razaPerro = razaPerro;
    }

    /**
     * Metodo override que permite imprimir el valor de todas las variables
     *
     * @return devuelve el valor de las variables edadPerro, nombrePerro y
     * razaPerro
     */
    @Override
    public String toString() {
        return super.toString() + "Perro{" + "edadPerro=" + edadPerro + ", nombrePerro=" + nombrePerro + ", razaPerro=" + razaPerro + '}';
    }

    @Override
    public void sonido() {
        System.out.println("guau");
    }
}
