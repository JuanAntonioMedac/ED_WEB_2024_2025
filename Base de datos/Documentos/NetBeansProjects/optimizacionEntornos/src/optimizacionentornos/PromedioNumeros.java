package optimizacionentornos;

/**
 *
 * @author Lola Ávila
 */
import java.util.Scanner;

public class PromedioNumeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int CANTIDAD = 5;
        int[] numeros = new int[CANTIDAD];

        System.out.println("Ingrese " + CANTIDAD + " números:");
        for (int i = 0; i < CANTIDAD; i++) {
            numeros[i] = scanner.nextInt();
        }
        int suma = calcularSuma(numeros);
        double promedio = (double) suma / CANTIDAD;

        System.out.println("La suma de los números es: " + suma);
        System.out.println("El promedio de los números es: " + promedio);
        scanner.close();
    }
    // Método para calcular la suma de los elementos del arreglo
    public static int calcularSuma(int[] arreglo) {
        int total = 0;
        for (int numero : arreglo) {
            total += numero;
        }
        return total;
    }
}
