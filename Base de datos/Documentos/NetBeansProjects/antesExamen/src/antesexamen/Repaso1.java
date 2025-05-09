//Escribe un programa que permita a un profesor ingresar las notas de sus estudiantes.
//El profesor debe ingresar el número de estudiantes y, a continuación, ingresar las notas de
//cada estudiante. Al final, muestra las notas ingresadas.
//Añade una función para calcular y mostrar el promedio de las notas ingresadas.
//Añade otra función para identificar y mostrar las notas que son mayores o iguales al promedio.

package antesexamen;

import java.util.Scanner;

public class Repaso1 {

    public static double[] notasEstudiantes() {
    Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el numero de estudiantes");
        int numeroEstudiantes = teclado.nextInt();
        
        double[] notas = new double[numeroEstudiantes];
        for (int i = 0; i < numeroEstudiantes; i++){            
            System.out.println("Tienes " + numeroEstudiantes + " estudiantes, ingresa la nota de cada uno ");
            notas[i] = teclado.nextInt();
                        
        }//for
        for (int i = 0; i < numeroEstudiantes; i++) {
            System.out.println("La nota del estudiante " + i + " es " + notas[i]);
        }//for       
        return notas;    
}//funcion double
    
    public static void calcularPromedio(double[] notas) {
        double resultado = 0;
        for (int i = 0; i < notas.length; i++){
            if (notas[i] >= 0) {
                resultado = resultado + notas[i];
            }//if
        }//for
        double promedio = resultado / notas.length;
        System.out.println("La media de " + resultado + " entre " + notas.length + " es: " + promedio);
    }//funcion void
    
    public static void identificarNotas(double[] notas) {
        
        
        
    }
    
    
    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       double[]notas = notasEstudiantes();
       calcularPromedio(notas);
       
    }

}
