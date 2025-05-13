
/**
 * Clase Mascota que contiene los atributos de nombre de la mascota, el número de chip de la mascota, el tipo de animal de la mascota y la fecha de nacimiento de la mascota
 *
 * @author Angel Marín (Documentador)
 */
public class Mascota {

    //Atributos 
    private String nombre;
    private int chip;
    private String tipoAnimal;
    private String fechaNacimiento;
    //Constructor que permite crear objetos de tipo Mascota pasando los atributos como parámetro

    /**
     * Constructor por defecto que recibe los parámetros de nombre, chip,
     * tipoAnimal y fechaNacimiento
     *
     * @param nombre Nombre de la mascota
     * @param chip Número de chip de la mascota
     * @param tipoAnimal Tipo de mascota
     * @param fechaNacimiento Fecha de nacimiento de la mascota
     */
    public Mascota(String nombre, int chip, String tipoAnimal, String fechaNacimiento) {
        this.nombre = nombre;
        this.chip = chip;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
    }
    //Métodos getter y setter. Permiten obtener o modificar el nombre de la mascota.

    /**
     * Método get del atributo de nombre para obtener el nombre de la mascota
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método set del atributo de nombre para modificar el nombre de la mascota
     *
     * @param nombre Nombre de la mascota
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Métodos  getter y setter. Permiten acceder o modificar el número de chip.

    /**
     * Método get del atributo de chip para obtener el chip de la mascota
     *
     * @return chip
     */
    public int getChip() {
        return chip;
    }

    /**
     * Método set del atributo de chip para modificar el chip de la mascota
     *
     * @param chip Chip de la mascota
     */
    public void setChip(int chip) {
        this.chip = chip;
    }
    //Métodos getter y setter. Acceder o cambiar el tipo de animal.

    /**
     * Método get del atributo de tipoAnimal para obtener el tipo de animal de
     * la mascota
     *
     * @return tipoAnimal
     */
    public String getTipoAnimal() {
        return tipoAnimal;
    }

    /**
     * Método set del atributo de tipoAnimal para modificar el tipo de animal de
     * la mascota
     *
     * @param tipoAnimal Tipo de mascota
     */
    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    //Métodos getter y setter. Permite consultar o cambiar la fecha de nacimiento

    /**
     * Método get del atributo de fechaNacimiento para obtener la fecha de
     * nacimiento de la mascota
     *
     * @return fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método set del atributo de fechaNacimiento para modificar la fecha de
     * nacimiento de la mascota
     *
     * @param fechaNacimiento Fecha de nacimiento de la mascota
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
