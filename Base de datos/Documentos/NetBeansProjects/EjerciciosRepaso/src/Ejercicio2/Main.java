package Ejercicio2;
import java.util.Scanner;
/**
 *
 * @author AlumnoT
 */
public class Main {
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        
        int mamifero = 0;
        String[] mamiferoArray = new String [0];
        Mamifero mamifero1 = new Mamifero();
        int ave = 0;
        String[] aveArray = new String [0];
        Ave ave1 = new Ave();
        
        int mamiferosTotales = 0;
        int avesTotales = 0;
        
        boolean salir = true;
        
        while (salir == true){
        System.out.println("Menu: ");
        System.out.println("1. Registrar Mamifero");
        System.out.println("2. Registrar Ave");
        System.out.println("3. Listar animales");
        System.out.println("4. Mostrar cantidad de animales");
        System.out.println("5. Salir");
        int opcion = teclado.nextInt();
        
        switch (opcion){
            case 1:
                System.out.println("Introduce el numero de mamiferos");
                mamifero = teclado.nextInt();
                mamiferoArray = new String [mamifero];
                
                for (int i = 0; i < mamiferoArray.length; i++) {
                    System.out.println("Introduce el tipo de pelaje del mamifero " + (i + 1));
                    mamiferoArray[i] = teclado.next(); 
                                        
                }
                
                break;
            case 2:
                System.out.println("Indique el numero de aves");
                ave = teclado.nextInt();
                aveArray = new String [ave];
                
                for (int i = 0; i < aveArray.length; i++) {
                    System.out.println("Introduce la envergadura de alas de la ave " + (i + 1));
                    aveArray[i] = teclado.next();
                }
                
                break;
            case 3:
                System.out.println("Elija de que quiere listar la información");
                System.out.println("1. Mamiferos");
                System.out.println("2. Aves");
                opcion = teclado.nextInt();
                
                if (opcion == 1){
                    for (int i = 0; i < mamiferoArray.length; i++) {
                        System.out.println("Mamifero " + (i + 1) + ": " + mamiferoArray[i]);
                    }
                }
                else if (opcion == 2){
                    for (int i = 0; i < aveArray.length; i++) {
                        System.out.println("Ave " + (i + 1) + ": " + aveArray[i]);
                    }
                }
                    
                break;
                
            case 4:
                for (int i = 0; i < mamiferoArray.length; i++) {
                    mamiferosTotales = i + mamiferosTotales;
                    
                }
                System.out.println("mamiferos totales: " + mamiferosTotales);
                for (int i = 0; i < aveArray.length; i++) {
                    avesTotales = i + avesTotales;
                }
                System.out.println("Aves totales: " + avesTotales);
                break;
            case 5:
                salir = false;
                break;
        }
        
        
        }  
        
    }
}
