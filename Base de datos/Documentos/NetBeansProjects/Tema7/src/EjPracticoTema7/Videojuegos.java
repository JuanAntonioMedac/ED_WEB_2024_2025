package EjPracticoTema7;

public class Videojuegos {
    
    private String nombre = "Call of duty";
    private String genero = "shooter";
    private int fechaLanzamiento = 2003;
    private String edadRecomendada = "+17";
    
    
    public void nombreJuego(){
        System.out.println("Este videojuego se llama " + nombre);
    }//Cierre void
    
    public void lanzamientoJuego(){
        System.out.println("La fecha de lanzamiento de este videojuego fue en " + fechaLanzamiento);
    }//Cierre void
    
    protected void edadJuego(){
        System.out.println("La edad recomendada para este videojuego es " + edadRecomendada);
    }//Cierre void
    
    protected void generoJuego(){
        System.out.println("El genero de este videojuego es " + genero);
    }//Cierre void
}//Cierre main
