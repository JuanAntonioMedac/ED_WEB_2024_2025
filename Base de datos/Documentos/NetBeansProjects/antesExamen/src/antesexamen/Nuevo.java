package antesexamen;

import java.util.Scanner;

public class Nuevo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el dia");
        //int numeroSemana = teclado.nextInt();
        String palabra = teclado.nextLine();
        switch (palabra) {
            case "Lunes":
                System.out.println("Ya es Lunes");
                break;
            case "Martes":
                System.out.println("Ya es Martes");
                break;
            default:
                System.out.println("Error inesperado");
                break;
        }

    }

}
