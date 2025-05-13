public class Mascota {
    private String nombre;
    private int chip;
    private String tipoAnimal;
    private String fechaNacimiento;

    public Mascota(String nombre, int chip, String tipoAnimal, String fechaNacimiento) {
        this.nombre = nombre;
        this.chip = chip;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
