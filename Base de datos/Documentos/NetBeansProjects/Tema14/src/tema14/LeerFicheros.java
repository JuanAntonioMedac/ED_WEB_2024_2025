package tema14;

import java.io.*;

/**
 *
 * @author AlumnoT
 */
public class LeerFicheros {

    public static void main(String[] args) {

        File fichero = null; //Para abrir fichero
        FileReader fr = null; //Para leer caracter a caracter
        BufferedReader br = null; //Para leer una cadena de caracteres

        String linea;

        try {
            fichero = new File("fichero.txt");
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            }

        } catch (IOException e) {
            System.err.println("Error en el fichero " + e);
        } finally {

            try {
                br.close();
                fr.close();

            } catch (IOException e) {
                System.err.println("Error en el fichero " + e);

            }

        }

    }
}
