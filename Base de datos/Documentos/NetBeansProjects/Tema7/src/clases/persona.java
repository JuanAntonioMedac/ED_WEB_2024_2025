package clases;
//Creamos el esqueleto
public class persona {
    
    private String nombre = "Lola";
    private String DNI;
    private int edad = 18;
    
    
    public void comer(){
        System.out.println("Comiendo");
    }//Void
    
    public void obtenerNombre(){
        System.out.println("Nombre: " + nombre);
    }//Void
    
}//Class
