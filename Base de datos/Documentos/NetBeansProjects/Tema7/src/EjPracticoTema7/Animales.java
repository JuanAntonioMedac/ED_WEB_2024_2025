package EjPracticoTema7;

public class Animales {
    
    private String nombre = "gato";
    private int edad = 2;
    private String raza = "bombay";
    private String genero = "macho";
    
    public void tipoAnimal(){
        System.out.println("Este animal es " + nombre);
    }//Cierre void
    
    public void edadAnimal(){
        System.out.println("La edad de este animal es " + edad + " años");
    }//Cierre void
    
    protected void razaAnimal(){
        System.out.println("La raza de este animal es " + raza);
    }//Cierre void
    
    protected void colorAnimal(){
        System.out.println("El genero de este animal es " + genero);
    }//Cierre void    
}//Cierre Main
