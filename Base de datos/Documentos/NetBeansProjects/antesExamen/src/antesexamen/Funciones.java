package antesexamen;

import java.util.Scanner;

public class Funciones {

    public static void panelOpciones(){
        System.out.println("panel de opciones");
        System.out.println("pulse 1 para sumar");
        System.out.println("pulse 2 para restar");
    }
    
    
    public static double suma(double a, double b){
        
        double resultado = a + b;
        
        return resultado;      
        
    }
    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        panelOpciones();
        
        double numero1, numero2, resultado;
        System.out.println("valor 1: ");
        numero1 = teclado.nextDouble();
        System.out.println("valor 2: ");
        numero2 = teclado.nextDouble();
        suma (numero1, numero2);
        
        resultado = suma(numero1, numero2);
        System.out.println("resultado: " + suma(numero1, numero2));
    }
    
}
