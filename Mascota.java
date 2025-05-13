public class Mascota {
    //Atributos 
    private String nombre;
    private int chip;
    private String tipoAnimal;
    private String fechaNacimiento;
    //Constructor que permite crear objetos de tipo Mascota pasando los atributos como parámetro
    public Mascota(String nombre, int chip, String tipoAnimal, String fechaNacimiento) {
        this.nombre = nombre;
        this.chip = chip;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
    }
    //Métodos getter y setter. Permiten obtener o modificar el nombre de la mascota.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Métodos  getter y setter. Permiten acceder o modificar el número de chip.
    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }
    //Métodos getter y setter. Acceder o cambiar el tipo de animal.
    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    //Métodos getter y setter. Permite consultar o cambiar la fecha de nacimiento
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
