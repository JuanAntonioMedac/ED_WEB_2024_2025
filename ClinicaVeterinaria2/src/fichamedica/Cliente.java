public class Cliente extends Persona {
    private int IDCli;
    private int numeroMascotas;
//REVISAR FECHA DE NACIMIENTO.
    public Cliente(String nombre, String dni, String fechaNacimiento, String tipoPersona, int IDCli, int numeroMascotas) {
        super(nombre, dni, fechaNacimiento, tipoPersona);
        this.IDCli = IDCli;
        this.numeroMascotas = numeroMascotas;
    }

    public int getIDCli() {
        return IDCli;
    }

    public void setIDCli(int IDCli) {
        this.IDCli = IDCli;
    }

    public int getNumeroMascotas() {
        return numeroMascotas;
    }

    public void setNumeroMascotas(int numeroMascotas) {
        this.numeroMascotas = numeroMascotas;
    }
}

