/**
 *
 * @author AlumnoT
 */
public class Tema13 {
    
    public static void dividir(int a, int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("No se puede dividir entre 0");
        }
        int c = a/b;
        System.out.println("Resultado: " + c);
    }
    
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c;
        try{
            dividir(a,b);
            
        }catch(ArithmeticException e){
            
            System.out.println("error: " + e.toString());
        }
        System.out.println("hola mundo");
    }//main
}//clase
