package antesexamen;
import java.util.Scanner;
public class Tema3 {

    public static void main(String[] args) {
        
    Scanner teclado = new Scanner (System.in);
    System.out.println("Introduce tu nota: ");
    int notas = teclado.nextInt();
    
    //Siempre se empieza con if
    //&& es para que se cumplan las dos variables
        if(notas >= 0 && notas < 5){
            System.out.println("Estas suspenso");
        }
        
    //Para seguir siempre se usa else if y puedes poner los que quieras    
    //== es para comparar las dos variables
        else if(notas == 5){
            System.out.println("Suficiente");
        }
    
    //Else siempre se usa para acabar    
        else{
            System.out.println("Tienes buena nota");
        
    }
        
    }
    
}


