package tema10;

/**
 * Clase de Granja que puede comprobar la clase, ubicacion y capacidad de los
 * animales
 *
 * @author Lola Avila
 * @version 1.0.
 */
public class Granja {

    private String nombre;
    private String claseDeAnimal;
    private String ubicacion;
    private String capacidad;

    /**
     * Constructor por defecto
     */
    public Granja() {
        nombre = "";
        claseDeAnimal = "";
        ubicacion = "";
        capacidad = "";
    }

    /**
     * Constructor por parametro
     *
     * @param nombre el nombre del animal que sea
     * @param ubicacion la ubicacion del sitio
     * @param claseDeAnimal la clase de animal que sea
     * @param capacidad las capacidades que tenga el animal
     */
    public Granja(String nombre, String claseDeAnimal, String ubicacion, String capacidad) {
        this.nombre = nombre;
        this.claseDeAnimal = claseDeAnimal;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    /**
     * Metodo get de la variable nombre
     *
     * @return devuelve el nombre del animal
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo get de la variable claseDeAnimal
     *
     * @return devuelve la clase de animal que es
     */
    public String getClaseDeAnimal() {
        return claseDeAnimal;
    }

    /**
     * Metodo get de la variable ubicacion
     *
     * @return devuelve la ubicacion del animal
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Metodo get de la variable capacidad
     *
     * @return devuelve las capacidades que tiene el animal
     */
    public String getCapacidad() {
        return capacidad;
    }

    /**
     * Metodo set de la variable nombre
     *
     * @param nombre El nombre del animal
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo set de la variable claseDeAnimal
     *
     * @param claseDeAnimal La clase del animal
     */
    public void setClaseDeAnimal(String claseDeAnimal) {
        this.claseDeAnimal = claseDeAnimal;
    }

    /**
     * Metodo set de la variable ubicacion
     *
     * @param ubicacion La ubicacion del animal
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Metodo set de la variable capacidad
     *
     * @param capacidad Las capacidades que tiene el animal
     */
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Metodo override que permite imprimir el valor de todas las variables
     *
     * @return devuelve el valor de las variables nombre, claseDeAnimal,
     * ubicacion y capacidad
     */
    @Override
    public String toString() {
        return "Granja{" + "nombre=" + nombre + ", claseDeAnimal=" + claseDeAnimal + ", ubicacion=" + ubicacion + ", capacidad=" + capacidad + '}';
    }
     /**
      * 
      */
    public void sonido() {
        System.out.println("guau");
        System.out.println("miau");
    }

    public final void hola() {
        System.out.println("Hola, esta es la Granja Paradis");
    }

}
