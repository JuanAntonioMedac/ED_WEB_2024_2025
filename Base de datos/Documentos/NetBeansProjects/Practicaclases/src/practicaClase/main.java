package practicaClase;

import java.util.Scanner;

public class main {

    public static void Main(String[] args) {
        Ordenadores ordenador1 = new Ordenadores();
        Moviles movil1 = new Moviles();

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el modelo del ordenador:");
        String modelo = teclado.next();
        ordenador1.setModelo(modelo);
        System.out.println("El modelo es " + ordenador1.getModelo());

        System.out.println("Introduce el color del movil");
        String color = teclado.next();
        movil1.setColor(color);
        System.out.println("El color del movil es " + movil1.getColor());

        System.out.println("Introduce el modelo del ordenador");
        String modelo1 = teclado.next();
        System.out.println("Introduce la marca del ordenador");
        String marca1 = teclado.next();
        System.out.println("Introduce la categoria del ordenador");
        String categoria = teclado.next();
        System.out.println("Introduce el sistema operativo del ordenador");
        String sistemaOperativo = teclado.next();
        System.out.println("Introduce el año de fabricacion del ordenador");
        int yearFabricacion1 = teclado.nextInt();

        Ordenadores ordenadores2 = new Ordenadores(modelo1, marca1, categoria, sistemaOperativo, yearFabricacion1);
        System.out.println(ordenadores2);

        System.out.println("Introduce el modelo del movil");
        String modelo2 = teclado.next();
        System.out.println("Introduce la marca del movil");
        String marca2 = teclado.next();
        System.out.println("Introduce el color del movil");
        String color1 = teclado.next();
        System.out.println("Introduce el numero de serie del movil");
        int numeroSerie = teclado.nextInt();
        System.out.println("Introduce el año de fabricacion del movil");
        int yearFabricacion2 = teclado.nextInt();

        Moviles moviles2 = new Moviles(modelo2, marca2, color1, numeroSerie, yearFabricacion2);
        System.out.println(moviles2);

        System.out.println("Introduce otra categoria de ordenador");
        String categoria2 = teclado.next();
        ordenadores2.comprobarCategoria(categoria2);

        System.out.println("Introduce la marca de tu ordenador");
        String marca3 = teclado.next();
        ordenadores2.comprobarMarca(marca3);

        System.out.println("Introduce el numero de serie de tu movil");
        int numeroSerie2 = teclado.nextInt();
        moviles2.comprobarNumeroSerie(numeroSerie2);

        System.out.println("Introduce el año de fabricacion de tu movil");
        int yearFabricacion3 = teclado.nextInt();
        moviles2.comprobarYearFabricacion(yearFabricacion3);

    }

}
