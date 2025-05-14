package EjPracticoTema7;

public class Vehiculos {
    
    private String tipoDeVehiculo = "coche";
    private int fechaFabricacion = 1980;
    private String marca = "terrano";
    private String color = "verde";
    
    
    public void tipoVehiculo(){
        System.out.println("Este vehiculo es " + tipoDeVehiculo);
    }//Cierre void
    
    public void fabricacionVehiculo(){
        System.out.println("La fecha de lanzamiento de este videojuego fue en " + fechaFabricacion);
    }//Cierre void
    
    protected void marcaVehiculo(){
        System.out.println("La edad recomendada para este videojuego es " + marca);
    }//Cierre void
    
    protected void colorVehiculo(){
        System.out.println("El genero de este videojuego es " + color);
    }//Cierre void
}
