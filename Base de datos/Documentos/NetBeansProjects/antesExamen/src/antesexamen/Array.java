package antesexamen;

import java.util.Scanner;

public class Array {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int n = 3;
        int[] array = {4, 6, 7, 2, 4, 6, 2, 46};
            System.out.println("Introduce el tamaño del array");
        int tamano = teclado.nextInt();

        int[] arrayNuevo = new int[tamano];
        for (int i = 0; i < arrayNuevo.length; i++) {
            System.out.println("Introduce el valor de la posición");
            arrayNuevo[i] = teclado.nextInt();
        }

        for (int i = 0; i < tamano; i++) {
            System.out.println("El valor de la posicion " + i + " es " + arrayNuevo[i]);
        }
    }

}
