package antesexamen;

import java.util.Scanner;

public class Ejrepaso1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int numero1;
        int numero2;
        System.out.println("Escribe el primer valor");
        numero1 = teclado.nextInt();
        System.out.println("Escribe el segundo valor");
        numero2 = teclado.nextInt();
        int resultado = 0;
        
        for (int i = numero1; i <= numero2; i++)
        {

            if (i % 2 == 0) {
                resultado = resultado + i;
            }
        }

    }
}
