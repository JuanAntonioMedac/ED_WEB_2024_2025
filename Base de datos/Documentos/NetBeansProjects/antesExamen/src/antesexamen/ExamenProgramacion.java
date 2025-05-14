package antesexamen;

import java.util.Scanner;

public class ExamenProgramacion {

    public static double[] numeroAnimales() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido a la granja mu-mu Lola Avila, introduce el numero de animales");
        int animales = teclado.nextInt();
        //Creamos el array para introducir los datos de los animales
        double[] array = new double[animales];                   
        return array;

    }//funcion double

    //Creamos la funcion añadirAnimal
    public static double anadirAnimal(double[] animales) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el nombre del animal");
        String animal = teclado.nextLine();
        System.out.println("Ingresa el precio del animal");
        double array = teclado.nextDouble();
        System.out.println("El " + animal + " ha sido añadido");       
        return array;

    }//funcion double

    //Creamos la funcion consultarGranja 
    public static void consultarGranja(double[] animales) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Tienes " + animales.length + " animales en tu granja");
        
    }//funcion double

    //Creamos la funcion saldoDisponible
    public static double saldoDisponible(double[] animales) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Tu saldo es: 1000");
        return 0;

    }//funcion double

    //Funcion de tipo void
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Llamamos a la funcion numeroAnimales y la convertimos en una variable array para que pueda almacenar los valores obtenidos
        double[] array = numeroAnimales();
        boolean salir = true;
        //Creamos un bucle while que contiene la condicion de repetirse mientras que salir sea igual a true
        while (salir == true) {
            //Panel de opciones para el usuario
            System.out.println("Pulse 1 para añadir un animal a la granja");
            System.out.println("Pulse 2 para consultar la granja");
            System.out.println("Pulse 3 para ver saldo disponible");
            System.out.println("Pulse 4 para salir del programa");
            int opcion = teclado.nextInt();
            //Creamos el switch de la variable opcion
            switch (opcion) {
                case 1:
                    anadirAnimal(array);
                    break;
                case 2:
                    consultarGranja(array);
                    break;
                case 3:
                    saldoDisponible(array);
                    break;
                case 4:
                    salir = false;
                    break;
            }//switch

        }//while
    }//funcion main

}//class

