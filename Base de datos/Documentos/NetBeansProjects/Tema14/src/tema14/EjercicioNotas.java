package tema14;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Lola Ávila Version 1.0.
 */
public class EjercicioNotas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File fichero1 = null;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fichero = null;
        PrintWriter pw = null;
        String linea;
        double notaMedia = 0;
        double suma = 0;
        double[][] notas = new double[3][3];
        try {
            fichero = new FileWriter("C:\\Users\\AlumnoT\\Documents\\NetBeansProjects\\Tema14\\fichero.txt", false);
            pw = new PrintWriter(fichero);
            for (int i = 0; i < 3; i++) {
                System.out.println("Introduzca las notas del alumno " + (i + 1) + ": ");
                for (int j = 0; j < 3; j++) {
                    System.out.println("Nota " + (j + 1) + ": ");
                    notas[i][j] = teclado.nextDouble();
                }
            }

            for (int i = 0; i < 3; i++) {
                pw.println("Notas " + (i + 1) + ": ");
                for (int j = 0; j < 3; j++) {
                    pw.println(notas[i][j]);
                    pw.println(" ");
                }
            }

            for (int i = 0; i < 3; i++) {
                pw.println("Nota media del alumno " + (i + 1) + ": ");
                suma = 0;
                for (int j = 0; j < 3; j++) {
                    suma = notas[i][j] + suma;
                }
                notaMedia = suma / 3;
                if (notaMedia >= 9 && notaMedia <= 10) {
                    pw.println(notaMedia + " = Sobresaliente");
                } else if (notaMedia >= 7 && notaMedia < 9) {
                    pw.println(notaMedia + " = Notable");
                } else if (notaMedia >= 6 && notaMedia < 7) {
                    pw.println(notaMedia + " = Bien");
                } else if (notaMedia >= 5 && notaMedia < 6) {
                    pw.println(notaMedia + " = Suficiente");
                } else if (notaMedia >= 0 && notaMedia < 5) {
                    pw.println(notaMedia + " = Insuficiente");
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el fichero : " + e);
        }finally{
            
            try {
                pw.close();
                fichero.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        try {
            fichero1 = new File("\"C:\\\\Users\\\\AlumnoT\\\\Documents\\\\NetBeansProjects\\\\Tema14\\\\fichero.txt\", false");
            fr = new FileReader(fichero1);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            }
        } catch (IOException e) {
            System.err.println("Error en el fichero : " + e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el fichero " + e);
            }
        }

    }
}
