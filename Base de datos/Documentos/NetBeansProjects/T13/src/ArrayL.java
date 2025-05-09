/**
 *
 * @author AlumnoT
 */
import java.util.ArrayList;
public class ArrayL {
    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i = 0; i < 10; i++){
            array.add(i);
        }
        array.remove(0);
        array.set(0,100);
        for (int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
            
        }
    }

}
