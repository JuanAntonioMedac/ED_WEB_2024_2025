package mates;
import java.time.LocalDate;
/**
 *
 * @author Alex Beltrán
 */
public class Enteros {
public static int suma(int a, int b){
    return a + b;
}
public static int resta(int a, int b){
    return a - b;
}
public static int mult(int a, int b){
    return a * b;
}
public static int div(int a, int b){
    return a / b;
}
public static String vacio(){
    return "";
}
public static String fecha(){
    LocalDate hoy = LocalDate.now();
    StringBuilder fechas = new StringBuilder();
    
    for (int i = 0; i < 5; i++) {
        
    }
    return null;
}    
}
