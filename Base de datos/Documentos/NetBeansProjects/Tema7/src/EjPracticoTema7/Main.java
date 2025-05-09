package EjPracticoTema7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//Creamos un objeto (variable)        
        Videojuegos juego1 = new Videojuegos();
        Scanner teclado = new Scanner(System.in);
        juego1.nombreJuego();
        juego1.lanzamientoJuego();
        juego1.edadJuego();
        juego1.generoJuego();

        Animales animal1 = new Animales();
        animal1.tipoAnimal();
        animal1.colorAnimal();
        animal1.edadAnimal();
        animal1.razaAnimal();

        Vehiculos vehiculo1 = new Vehiculos();
        vehiculo1.tipoVehiculo();
        vehiculo1.fabricacionVehiculo();
        vehiculo1.marcaVehiculo();
        vehiculo1.colorVehiculo();

        Paises pais1 = new Paises();
        pais1.nombrePais();
        pais1.numeroHabitantes();
        pais1.numeroCiudades();
        pais1.numeroComunidades();

    }//Main            

}
