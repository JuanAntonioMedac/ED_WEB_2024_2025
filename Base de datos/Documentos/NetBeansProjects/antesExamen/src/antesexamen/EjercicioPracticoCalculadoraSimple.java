package antesexamen;

import java.util.Scanner;

public class EjercicioPracticoCalculadoraSimple {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Escribimos todas las variables posibles
        int numero1;
        int numero2;

        //Esto es para que el usuario pueda introducir cualquier valor 
        System.out.println("Introduce el primer numero");
        numero1 = teclado.nextInt();
        System.out.println("Introduce el segundo numero");
        numero2 = teclado.nextInt();

        //Esto es para poder realizar todas las operaciones
        int resultadoSuma = numero1 + numero2;
        int resultadoResta = numero1 - numero2;
        int resultadoMultiplicacion = numero1 * numero2;
        int resultadoDivision = numero1 / numero2;
        System.out.println("El resultado de la suma es " + resultadoSuma);
        System.out.println("El resultado de la resta es " + resultadoResta);
        System.out.println("El resultado de la multiplicacion es " + resultadoMultiplicacion);
        System.out.println("El resultado de la division es " + resultadoDivision);
    }

}
