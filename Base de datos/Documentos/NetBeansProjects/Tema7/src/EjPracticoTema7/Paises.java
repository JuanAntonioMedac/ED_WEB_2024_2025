package EjPracticoTema7;

public class Paises {
    
    private String pais = "España";
    private String habitantes = "48 millones";
    private int ciudades = 8131;
    private int comunidades = 17;
     
    public void nombrePais(){
        System.out.println("Este pais es " + pais);
    }//Cierre void
    
    public void numeroHabitantes(){
        System.out.println("El numero de habitantes es " + habitantes);
    }//Cierre void
    
    protected void numeroCiudades(){
        System.out.println("El numero de ciudades es " + ciudades);
    }//Cierre void
    
    protected void numeroComunidades(){
        System.out.println("El numero de comunidades autonomas es " + comunidades);
    }//Cierre void
}
