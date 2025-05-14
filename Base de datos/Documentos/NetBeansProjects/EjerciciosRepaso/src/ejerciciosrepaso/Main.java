package ejerciciosrepaso;

import java.util.Scanner;

/**
 *
 * @author AlumnoT
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int sumaCapacidadAutobus = 0;
        int sumaCapacidadTren = 0;
        int lineas = 0;
        int[] autobus = new int[0];
        Autobus autobus1 = new Autobus();
        int vagones = 0;
        int[] tren = new int[0];
        Transporte transporte1 = new Transporte(10, 120, "Transporte publico");
        Tren tren1 = new Tren();
        int CapacidadTotal = 0;
        int capacidadAutobuses = 0;
        int capacidadTrenes = 0;

        boolean salir = true;

        while (salir == true) {
            System.out.println("Menu de transporte: ");
            System.out.println("Seleccione la operación a realizar: ");
            System.out.println("1. Añadir transporte");
            System.out.println("2. Lista de información de transportes");
            System.out.println("3. Mostrar capacidad total de transportes");
            System.out.println("4. Salir");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el tipo de transporte");
                    System.out.println("1. Autobus");
                    System.out.println("2. Tren");
                    opcion = teclado.nextInt();

                    if (opcion == 1) {

                        System.out.println("Introduce el numero de lineas de autobus");
                        lineas = teclado.nextInt();
                        autobus = new int[lineas];

                        for (int i = 0; i < autobus.length; i++) {
                            System.out.println("Introduce la capacidad de la linea " + (i + 1));
                            autobus[i] = teclado.nextInt();
                            autobus1.setCapacidad(autobus[i]);
                            sumaCapacidadAutobus = autobus1.getCapacidad() + sumaCapacidadAutobus;
                        }

                    } else if (opcion == 2) {
                        System.out.println("Introduce el numero de trenes");
                        vagones = teclado.nextInt();
                        tren = new int[vagones];

                        for (int i = 0; i < tren.length; i++) {
                            System.out.println("Introduce la capacidad del vagon" + (i + 1));
                            tren[i] = teclado.nextInt();
                            tren1.setCapacidad(tren[i]);
                            sumaCapacidadTren = autobus1.getCapacidad() + sumaCapacidadTren;
                        }

                    } else {
                        System.out.println("Tiene que elegir una opcion valida.");
                    }
                    break;

                case 2:
                    System.out.println("Elija de que quieres saber la info");
                    System.out.println("1. Autobus");
                    System.out.println("2. Tren");
                    opcion = teclado.nextInt();

                    if (opcion == 1) {
                        for (int i = 0; i < autobus.length; i++) {
                            System.out.println("Linea " + (i + 1) + ": " + autobus[i]);
                        }
                    } else if (opcion == 2) {
                        for (int i = 0; i < tren.length; i++) {
                            System.out.println("Tren " + (i + 1) + ": " + tren[i]);
                        }
                    } else {
                        System.out.println("Tiene que elegir una opcion valida.");
                    }
                    break;
                case 3:
                    for (int i = 0; i < autobus.length; i++) {
                        capacidadAutobuses += autobus[i];
                    }
                    for (int i = 0; i < tren.length; i++) {
                        capacidadTrenes += tren[i];
                    }
                    int capacidadTotal = sumaCapacidadAutobus + sumaCapacidadTren;
                    transporte1.setCapacidad(capacidadTotal);

                    System.out.println("Capacidad de Autobuses: " + sumaCapacidadAutobus);
                    System.out.println("Capacidad de Trenes: " + sumaCapacidadTren);
                    System.out.println("Capacidad Total: " + capacidadTotal);

                    break;
                case 4:
                    salir = false;
                    break;

            }

        }

    }

}
