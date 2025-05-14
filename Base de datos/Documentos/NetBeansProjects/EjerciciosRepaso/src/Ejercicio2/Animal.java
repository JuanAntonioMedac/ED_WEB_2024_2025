package Ejercicio2;

/**
 *
 * @author AlumnoT
 */
public class Animal {
    private String nombre;
    private String habitat;

    public Animal(){
        nombre = "";
        habitat = "";
    }
    
    public Animal(String nombre, String habitat) {
        this.nombre = nombre;
        this.habitat = habitat;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    
    
    
    
    
    
    
}
