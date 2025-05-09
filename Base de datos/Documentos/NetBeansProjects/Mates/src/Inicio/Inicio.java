package Inicio;

import java.util.Scanner;
import static mates.Enteros.div;
import static mates.Enteros.fecha;
import static mates.Enteros.mult;
import static mates.Enteros.resta;
import static mates.Enteros.suma;
import static mates.Enteros.vacio;

/**
 *
 * @author Alex Beltrán
 */

public class Inicio {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el primer entero: ");
        int numl = scanner.nextInt();
        System.out.print("Introduce el segundo entero: ");
        int num2 = scanner.nextInt();

        int suma = suma(numl, num2);
        int resta = resta(numl, num2);
        int multiplicacion = mult(numl, num2);
        int division = div(numl, num2);
        String vacio = vacio();
        String fechas = fecha();
        System.out.println("La suma es: " + suma);
        System.out.println("La resta es: " + resta);
    

    }
}
