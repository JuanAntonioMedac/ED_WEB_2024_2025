package antesexamen;

import java.util.Scanner;

public class EjercicioArray {

//Funcion para que el usuario inserte el numero de niveles y la puntuacion de cada nivel
    public static double[] obtenerPuntuaciones() {
        Scanner teclado = new Scanner(System.in);       
        System.out.println("Introduce el numero de niveles");
        //Solicitamos el numero de niveles
        int tamano = teclado.nextInt();
        //Creamos el array para almacenar los datos de cada nivel
        double[] array = new double[tamano];
        //Creamos un bucle for para que el usuario inserte la puntuacion de cada nivel
        for (int i = 0; i < tamano; i++) {
            System.out.println("Introduce el valor de la posicion " + i);
            array[i] = teclado.nextInt();
        }//for
        for (int i = 0; i < tamano; i++) {
            System.out.println("El valor de la posicion " + i + " es " + array[i]);
        }//for
        return array;
    }//funcion double

//Funcion para calcular el promedio
    public static void calcularPromedio(double[] puntuaciones) {
        double resultado = 0;
        for (int i = 0; i < puntuaciones.length; i++) {
            if (puntuaciones[i] >= 0) {
                resultado = resultado + puntuaciones[i];
            }//if
        }//for
        //Aqui calculamos el promedio
        double promedio = resultado / puntuaciones.length;
        System.out.println("La media entre " + resultado + " entre " + puntuaciones.length + " es: " + promedio);
    }//funcion void
    
//funcion para el analisis de las puntuaciones
    public static void analizarPuntuaciones(double[] resultado) {
        //Creamos las variables para calcular el valor maximo y minimo introducidos por el usuario
        double maximo = 0;
        double minimo = 99999999;
        //Creamos un for y un if para comparar cada valor con la variable minimo
        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i] > maximo) {
                maximo = resultado[i];               
            }//if
        }//for
        System.out.println("La puntuacion maxima es " + maximo);
        //Creamos un for y un if para comparar cada valor con la variable maximo
        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i] < minimo) {
                minimo = resultado[i];                
            }//if
        }//for
        System.out.println("La puntuacion minima es " + minimo);
    }//funcion void

//Funcion de tipo void
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Llamamos a la funcion obtenerPuntuaciones y la convertimos en una variable array para que pueda almacenar 
        //los valores obtenidos
        double[] array = obtenerPuntuaciones();
        boolean salir = true;
        //Creamos un bucle while que contiene la condicion de repetirse mientras que salir sea igual a true
        while (salir == true) {
            //Panel de opciones para el usuario
            System.out.println("Pulsa 1 para volver a introducir las puntntuaciones");
            System.out.println("Pulsa 2 para calcular el promedio");
            System.out.println("Pulsa 3 para analizar puntntuaciones");
            System.out.println("Pulsa 4 para salir del programa");
            int opcion = teclado.nextInt();
            //Creamos el switch de la variable opcion
            switch (opcion) {
            //Cada case tendra las funciones ya creadas anteriormente
                case 1:
                //Este case permite introducir de nuevo el numero de niveles y la puntuacion de cada nivel
                    array = obtenerPuntuaciones();
                    break;            
                case 2:
                //Este case permite calcular el promedio de la puntuacion de los niveles
                    calcularPromedio(array);
                    break;        
                case 3:
                //Este case nos muestra la puntuacion minima y maxima      
                    analizarPuntuaciones(array);
                    break;
                case 4:
                //Este case nos permite salir del bucle y finalizar el programa, ya que el valor de la funcion pasa
                //a ser false    
                    salir = false;
                    break;
            }//switch
            
        }//while
        
    }//funcion main

}//class