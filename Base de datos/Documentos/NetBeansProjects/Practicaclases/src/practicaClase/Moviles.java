package practicaClase;

/**
 * Clase de moviles que permite comparar el numero de serie y el año de
 * fabricacion entre dos moviles
 *
 * @author AlumnoT
 * @version 1.0.
 */
public class Moviles {

    private String modelo;
    private String marca;
    private String color;
    private int numeroSerie;
    private int yearFabricacion;

    /**
     * Constructor por defecto
     */
    public Moviles() {
        modelo = "";
        marca = "";
        color = "";
        numeroSerie = 0;
        yearFabricacion = 0;
    }

    /**
     * Constructor por parametro
     *
     * @param modelo el modelo del movil
     * @param marca la marca del movil
     * @param color el color del movil
     * @param numeroSerie el numero de serie del movil
     * @param yearFabricacion el año en el que se fabrico el movil
     */
    public Moviles(String modelo, String marca, String color, int numeroSerie, int yearFabricacion) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.numeroSerie = numeroSerie;
        this.yearFabricacion = yearFabricacion;
    }

    /**
     * Metodo get de la variable modelo
     *
     * @return devuelve el modelo del movil
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Metodo get de la variable marca
     *
     * @return devuelve la marca del movil
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo get de la variable color
     *
     * @return devuelve el color del movil
     */
    public String getColor() {
        return color;
    }

    /**
     * Metodo get de la variable numeroSerie
     *
     * @return devuelve el numero de serie del movil
     */
    public int getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Metodo get de la variable yearFabricacion
     *
     * @return devuelve el año de fabricacion del movil
     */
    public int getYearFabricacion() {
        return yearFabricacion;
    }

    /**
     * Metodo set de la variable modelo
     *
     * @param modelo El modelo del movil
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo set de la variable marca
     *
     * @param marca la marca del movil
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Metodo set de la variable color
     *
     * @param color el color del movil
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Metodo set de la variable numeroSerie
     *
     * @param numeroSerie El numero de serie del movil
     */
    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Metodo set de la variable yearFabricacion
     *
     * @param yearFabricacion El año de fabricacion del movil
     */
    public void setYearFabricacion(int yearFabricacion) {
        this.yearFabricacion = yearFabricacion;
    }

    /**
     * Metodo override que permite imprimir el valor de todas las variables
     *
     * @return devuelve el valor de las variables, modelo, marca, color,
     * numeroSerie y yearFabricacion
     */
    @Override
    public String toString() {
        return "El modelo es " + modelo
                + " La marca de este movil es " + marca
                + " El color de este movil es " + color
                + " El numero de serie de este movil es " + numeroSerie
                + " El año de fabricacion de este movil es " + yearFabricacion;
    }

    /**
     * Metodo personalizado que permite comparar el numero de serie de dos
     * moviles
     *
     * @param numero numero de serie introducido por el usuario
     */
    public void comprobarNumeroSerie(int numero) {
        if (numero == numeroSerie) {
            System.out.println("El numero de serie de estos moviles son el mismo, por lo que fueron fabricados en la misma serie de fabricacion");
        } else {
            System.out.println("Estos moviles fueron fabricados en diferentes series");
        }
    }

    /**
     * Metodo personalizado que permite comparar el año de fabricacion de dos
     * moviles diferentes
     *
     * @param año año de fabricacion de otro movil introducido por el usuario
     */
    public void comprobarYearFabricacion(int año) {
        if (año == yearFabricacion) {
            System.out.println("El año de fabricacion de este movil es el mismo");
        } else if (año > yearFabricacion) {
            System.out.println("Este modelo de movil es mas nuevo");
        } else {
            System.out.println("Este modelo de movil es mas antiguo");
        }

    }
}
