package calculadora5;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Calculadora5 calculadora = new Calculadora5();
        System.out.println("Esta es la Calculadora5 Medac");
        System.out.println("Introduzca el primer numero");
        double num1 = teclado.nextDouble();
        calculadora.setA(num1);
        System.out.println("Introduzca el segundo numero");
        double num2 = teclado.nextDouble();
        calculadora.setB(num2);

        boolean salir = true;
        while (salir == true) {
            System.out.println("Menu de opciones:");
            System.out.println("1 para sumar");
            System.out.println("2 para restar");
            System.out.println("3 para multiplicar");
            System.out.println("4 para dividir");
            System.out.println("5 para raiz cuadrada");
            System.out.println("6 para potencia");
            System.out.println("7 para logaritmo");
            System.out.println("8 para factorial");
            System.out.println("9 para cambiar los numeros");
            System.out.println("10 para salir");

            try {
                int opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("resultado: " + calculadora.sumar());
                        break;
                    case 2:
                        System.out.println("resultado: " + calculadora.restar());
                        break;
                    case 3:
                        System.out.println("resultado: " + calculadora.multiplicar());
                        break;
                    case 4:
                        System.out.println("resultado: " + calculadora.dividir());
                        break;
                    case 5:
                        System.out.println("resultado: " + calculadora.raizCuadrada(calculadora.getA()));
                        break;
                    case 6:
                        System.out.println("resultado: " + calculadora.potencia());
                        break;
                    case 7:
                        System.out.println("resultado: " + calculadora.log(calculadora.getA()));
                        break;
                    case 8:
                        System.out.println("resultado: " + calculadora.factorial(calculadora.getA()));
                        break;
                    case 9:
                        System.out.println("Introduzca el primer numero");
                        num1 = teclado.nextDouble();
                        calculadora.setA(num1);
                        System.out.println("Introduzca el segundo numero");
                        num2 = teclado.nextDouble();
                        calculadora.setB(num2);
                        break;
                    case 10:
                        salir = false;
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
