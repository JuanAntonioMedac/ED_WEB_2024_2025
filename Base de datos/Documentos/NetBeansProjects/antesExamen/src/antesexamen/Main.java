package antesexamen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//Indicamos lo primero que va a mostrar la pantalla y que los datos se introduzcan por el teclado
        System.out.println("Buenas tardes, estas en el canal de Lola y vamos a jugar a multiples juegos!");
        Scanner teclado = new Scanner(System.in);
//Indicamos la variable para introducir el numero de subscriptores, además de declarar que multiplique 3euros por cada subscriptor
        int subscriptores;
        System.out.println("Introduce tu numero de subscriptores");
        subscriptores = teclado.nextInt();
        int ganancias = subscriptores * 3;
//Indicamos pocas ganancias si el valor es mayor o igual que 0 y menor o igual que 1200   
        if (ganancias >= 0 && ganancias <= 1200){
            System.out.println("Vaya! Eres pobre, tienes" + ganancias + "euros");
        }
//Indicamos otro rango de ganancias si el valor es mayor o igual que 1201 y menor o igual que 2000           
        else if (ganancias >= 1201 && ganancias <= 2000){
            System.out.println("Vaya! Eres de clase media baja, tienes " + ganancias + "euros");
        }
//Indicamos otro rango de ganancias si el valor es mayor o igual que 2001 y menor o igual que 5000
        else if (ganancias >= 2001 && ganancias <= 5000){
            System.out.println("Enhorabuena! Eres de clase media alta, tienes " + ganancias + "euros");
        }
//Indicamos que si no se cumple ninguna de las funciones anteriores se muestre otro mensaje en pantalla        
        else{
            System.out.println("Eres millonario, tienes " + ganancias + "euros, vete a andorra");
        }
    }
    
}
