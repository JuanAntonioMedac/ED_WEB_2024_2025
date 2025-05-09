package practicaClase;

/**
 * Clase de ordenadores que puede comprobar la categoria y la marca de dos
 * ordenadores
 *
 * @author Lola Avila
 * @version 1.0.
 */
public class Ordenadores {

    private String modelo;
    private String marca;
    private String categoria;
    private String sistemaOperativo;
    private int yearFabricacion;

    /**
     * Constructor por defecto
     */
    public Ordenadores() {
        modelo = "";
        marca = "";
        categoria = "";
        sistemaOperativo = "";
        yearFabricacion = 0;
    }

    /**
     * Constructor por parametro
     *
     * @param modelo el modelo del ordenador
     * @param marca la marca del ordenador
     * @param categoria la categoria del ordenador
     * @param sistemaOperativo el sistema operativo del ordenador
     * @param yearFabricacion el año de fabricacion del ordenador
     */
    public Ordenadores(String modelo, String marca, String categoria, String sistemaOperativo, int yearFabricacion) {
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.sistemaOperativo = sistemaOperativo;
        this.yearFabricacion = yearFabricacion;
    }

    /**
     * Metodo get de la variable modelo
     *
     * @return devuelve el modelo del ordenador
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Metodo get de la variable marca
     *
     * @return devuelve la marca del ordenador
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo get de la variable categoria
     *
     * @return devuelve la categoria del ordenador
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Metodo get de la variable sistemaOperativo
     *
     * @return devuelve el sistema operativo del ordenador
     */
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    /**
     * Metodo get de la variable yearFabricacion
     *
     * @return devuelve el año de fabricacion del ordenador
     */
    public int getYearFabricacion() {
        return yearFabricacion;
    }

    /**
     * Metodo set de la variable modelo
     *
     * @param modelo El modelo del ordenador
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo set de la variable marca
     *
     * @param marca la marca del ordenador
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Metodo set de la variable categoria
     *
     * @param categoria la categoria del ordenador
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Metodo set de la variable sistemaOperativo
     *
     * @param sistemaOperativo devuelve el sistema operativo del ordenador
     */
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * Metodo set de la variable yearFabricacion
     *
     * @param yearFabricacion El año de fabricacion del ordenador
     */
    public void setYearFabricacion(int yearFabricacion) {
        this.yearFabricacion = yearFabricacion;
    }

    /**
     * Metodo override que permite imprimir el valor de todas las variables
     *
     * @return devuelve el valor de las variables, modelo, marca, categoria,
     * sistemaOperativo y yearFabricacion
     */
    @Override
    public String toString() {
        return "El modelo de este ordenador es " + modelo
                + " la marca de este ordenador es " + marca
                + " La categoria de este ordenador es " + categoria
                + " El sistema operativo de este ordenador es " + sistemaOperativo
                + " El año de fabricacion de este ordenador es " + yearFabricacion;
    }

    /**
     * Metodo personalizado que permite comparar la categoria de dos ordenadores
     * distintos
     *
     * @param categoria2 categoria nueva introducida por el usuario
     */
    public void comprobarCategoria(String categoria2) {
        if (categoria2 == categoria) {
            System.out.println("Este modelo de ordenador pertenece a la misma categoria");
        } else {
            System.out.println("Este modelo de ordenador es de diferente categoria");
        }

    }

    /**
     * Metodo personalizado que permite comparar la marca de dos moviles
     * distintos
     *
     * @param marca2 marca del otro movil introducida por el usuario
     */
    public void comprobarMarca(String marca2) {
        if (marca == marca2) {
            System.out.println("Este modelo de ordenador es de la misma marca");
        } else {
            System.out.println("Este modelo de ordenador es de marca diferente");
        }
    }
}
