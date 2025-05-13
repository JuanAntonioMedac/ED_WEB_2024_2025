public class Cliente extends Persona {//Cliente hereda de la clase Persona
    private int IDCli;
    private int numeroMascotas;
//REVISAR FECHA DE NACIMIENTO.
    //Constructor que recibe parámetros para inicializar los atributos de la clase Cliente  y Persona
    public Cliente(String nombre, String dni, String fechaNacimiento, String tipoPersona, int IDCli, int numeroMascotas) {
        super(nombre, dni, fechaNacimiento, tipoPersona);//Llama al constructor de la clase  Persona 
        this.IDCli = IDCli;//ID del Cliente
        this.numeroMascotas = numeroMascotas;//Guarda las mascotas
    }
    //Método get para obtener el valor del atributo  IDCli
    public int getIDCli() {
        return IDCli;
    }
    //Método set para modificar el valor
    public void setIDCli(int IDCli) {
        this.IDCli = IDCli;
    }
    //Método get para obtener el número de mascotas
    public int getNumeroMascotas() {
        return numeroMascotas;
    }
    //Método set para modificar el número de mascotas
    public void setNumeroMascotas(int numeroMascotas) {
        this.numeroMascotas = numeroMascotas;
    }
}
