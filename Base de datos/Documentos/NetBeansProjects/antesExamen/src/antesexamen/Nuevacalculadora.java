package antesexamen;

import java.util.Scanner;

public class Nuevacalculadora {

    public static void panelOpciones() {
//Esto es lo que saldrá en pantalla
        System.out.println("Pulse 1 para sumar");
        System.out.println("Pulse 2 para restar");
        System.out.println("Pulse 3 para multiplicar");
        System.out.println("Pulse 4 para dividir");
        System.out.println("Pulse 5 para el modulo");
        System.out.println("Pulse 6 para introducir nuevos valores");
        System.out.println("Pulse 7 para salir");

    }

    public static double uno() {
//Creamos la primera función
        Scanner teclado = new Scanner(System.in);
        double numero1;
        numero1 = teclado.nextInt();
        return numero1;

    }

    public static double dos() {
//Creamos la segunda función
        Scanner teclado = new Scanner(System.in);
        double numero2;
        numero2 = teclado.nextInt();
        return numero2;

    }

//Las siguientes funciones son para declarar los numeros y realizar todas las operaciones
    public static double suma(double a, double b) {
        double resultado = a + b;
        return resultado;
    }

    public static double resta(double a, double b) {
        double resultado = a - b;
        return resultado;
    }

    public static double multiplicacion(double a, double b) {
        double resultado = a * b;
        return resultado;
    }

    public static double division(double a, double b) {
        double resultado = a / b;
        return resultado;
    }

    public static double modulo(double a, double b) {
        double resultado = a % b;
        return resultado;

    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in); 
//El booleano indica que siempre será true para que el programa se ejecute
        boolean salir = true;
//Comenzamos el programa
        System.out.println("Bienvenido a la calculadora");
        System.out.println("Introduce el primer numero");
        double numero1 = uno();
        System.out.println("Introduce el segundo numero");
        double numero2 = dos();
        while (salir == true) {
//Cuando el usuario declare el caso 7 (false) el programa terminara de ejecutarse
            panelOpciones();

            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("El resultado de la suma es " + suma(numero1, numero2));
                    break;
                case 2:
                    System.out.println("El resultado de la resta es " + resta(numero1, numero2));
                    break;
                case 3:
                    System.out.println("El resultado de la multiplicacion es " + multiplicacion(numero1, numero2));
                    break;
                case 4:
                    System.out.println("El resultado de la division es " + division(numero1, numero2));
                    break;
                case 5:
                    System.out.println("El resultado de la division es " + modulo(numero1, numero2));
                    break;
                case 6:
                    System.out.println("Introduce el primer numero");
                    numero1 = uno();
                    System.out.println("Introduce el segundo numero");
                    numero2 = dos();
                    break;
                case 7:
                    salir = false;
                    break;
                default:
                    System.out.println("Error ");
                    break;

            }

        }

    }

}
