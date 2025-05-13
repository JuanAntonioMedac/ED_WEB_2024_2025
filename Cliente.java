
/**
 * Clase Cliente que hereda atributos de la clase Persona y tiene los de IDCli como ID de cliente y el número de mascotas del cliente
 *
 * @author Angel Marín (Documentador)
 */
public class Cliente extends Persona {//Cliente hereda de la clase Persona

    private int IDCli;
    private int numeroMascotas;
//REVISAR FECHA DE NACIMIENTO.
    //Constructor que recibe parámetros para inicializar los atributos de la clase Cliente  y Persona

    /**
     * Constructor por parámetros que recibe los parámetros de nombre, dni,
     * fechaNacimmiento, tipoPersona, IDCli y numeroMascotas
     *
     * @param nombre Nombre de la persona
     * @param dni DNI de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param tipoPersona Tipo de persona
     * @param IDCli ID de cliente
     * @param numeroMascotas Número de mascotas del cliente
     */
    public Cliente(String nombre, String dni, String fechaNacimiento, String tipoPersona, int IDCli, int numeroMascotas) {
        super(nombre, dni, fechaNacimiento, tipoPersona);//Llama al constructor de la clase  Persona 
        this.IDCli = IDCli;//ID del Cliente
        this.numeroMascotas = numeroMascotas;//Guarda las mascotas
    }
    //Método get para obtener el valor del atributo  IDCli

    /**
     * Método get del atributo de IDCli para obtener el ID de cliente del
     * cliente
     *
     * @return IDCli
     */
    public int getIDCli() {
        return IDCli;
    }
    //Método set para modificar el valor

    /**
     * Método set del atributo de IDCli para modificar el ID de cliente del
     * cliente
     *
     * @param IDCli ID del cliente
     */
    public void setIDCli(int IDCli) {
        this.IDCli = IDCli;
    }
    //Método get para obtener el número de mascotas

    /**
     * Método get del atributo de numeroMascotas para obtener el número de
     * mascotas del cliente
     *
     * @return numeroMascotas
     */
    public int getNumeroMascotas() {
        return numeroMascotas;
    }
    //Método set para modificar el número de mascotas

    /**
     * Método set del atributo de numeroMascotas para modificar el número de
     * mascotas del cliente
     *
     * @param numeroMascotas
     */
    public void setNumeroMascotas(int numeroMascotas) {
        this.numeroMascotas = numeroMascotas;
    }
}
