package tema16;

/**
 *
 * @author Lola Ávila
 */
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String nombre;
        Jugador jugador1;
        Enemigo enemigo;
        Boolean salir = true;
        int opcion, opcionCompra, random, dineroRecibido, puntosSaludPerdidos;
        String[] nombres_enemigos = {"Jose", "Javi", "Luis", "Miguel"};

        System.out.println("Bienvenido/a al reinado de Medac");
        System.out.println("Introduce tu nombre");
        nombre = teclado.nextLine();
        jugador1 = new Jugador(nombre);

        System.out.println("Vamos a calcular tu fuerza inicial...");
        jugador1.calcularFuerzaInicial();
        System.out.println("Tu fuerza inicial es de... " + jugador1.getPuntosAtaque() + " puntos!");
        System.out.println("Pulse 1 Si quieres cambiar de forma aleatoria tu fuerza inicial (cuesta 1 oro)");
        System.out.println("Pulse 2 para continuar el juego");
        opcion = teclado.nextInt();
        if (opcion == 1) {
            jugador1.calcularFuerzaInicial();
            System.out.println("Tu fuerza inicial es de... " + jugador1.getPuntosAtaque() + " puntos!");
            jugador1.setDinero(jugador1.getDinero() - 1);

        } else if (opcion == 2) {
            System.out.println("Decides quedate con tus " + jugador1.getPuntosAtaque() + " puntos de ataque");
        } else {
            System.out.println("Opcion incorrecta, el juego va a continuar");
        }

        System.out.println(nombre + " tu aventura empieza ahora...¡Conquista Medac!");

        do {

            menuPrincipal();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Has encontrado un enemigo!!");
                    random = (int) (Math.random() * 4);
                    enemigo = new Enemigo(nombres_enemigos[random]);
                    System.out.println("Vas a enfrentarte a... " + enemigo.getNombre() + "!!!");
                    enemigo.calcularFuerzaEnemigo();
                    System.out.println("Tienes " + jugador1.getPuntosAtaque() + " puntos de ataque y " + enemigo.getNombre() + " tiene " + enemigo.getPuntosAtaque() + " puntos de ataque");
                    if (jugador1.getPuntosAtaque() >= enemigo.getPuntosAtaque()) {

                        dineroRecibido = enemigo.soltarDinero();
                        System.out.println("Has ganado el combate!! Has recibido " + dineroRecibido + " oros" + " al vencer a " + enemigo.getNombre());
                        jugador1.setDinero(jugador1.getDinero() + dineroRecibido);

                    } else {
                        puntosSaludPerdidos = enemigo.getPuntosAtaque() - jugador1.getPuntosAtaque();
                        System.out.println(enemigo.getNombre() + " te ha machacado y has perdido " + puntosSaludPerdidos + " puntos de salud");
                        jugador1.setPuntosSalud(jugador1.getPuntosSalud() - puntosSaludPerdidos);
                        if (jugador1.getPuntosSalud() <= 0) {
                            System.out.println("Game Over");
                            salir = false;
                        }
                    }
                    break;
                case 2:
                    bazarteria();
                    opcionCompra = teclado.nextInt();
                    if (opcionCompra == 1 && jugador1.getDinero() >= 5) {
                        System.out.println("Has comprado una calculadora");
                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 3);
                        jugador1.setDinero(jugador1.getDinero() - 5);
                    } else if (opcionCompra == 2 && jugador1.getDinero() >= 7) {
                        System.out.println("Has comprado un pu�o americano");
                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 5);
                        jugador1.setDinero(jugador1.getDinero() - 7);
                    } else if (opcionCompra == 3 && jugador1.getDinero() >= 10) {
                        System.out.println("Has comprado un martillo");
                        jugador1.setPuntosAtaque(jugador1.getPuntosAtaque() + 7);
                        jugador1.setDinero(jugador1.getDinero() - 10);
                    } else if (opcionCompra == 4 && jugador1.getDinero() >= 8) {
                        System.out.println("Has comprado vendas");
                        jugador1.setPuntosSalud(jugador1.getPuntosSalud() + 5);
                        jugador1.setDinero(jugador1.getDinero() - 8);
                    } else {
                        System.out.println("No tienes fondos o has elegido una opcion incorrecta");
                    }
                    break;
                case 3:
                    
                    break;
                case 4:
                        System.out.println(jugador1);
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Gracias por jugar, hasta pronto!");
                    salir = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta, inténtelo de nuevo.");
                    break;
            }
        } while (salir == true);

        teclado.close();
    }

    public static void bazarteria() {
        System.out.println("Visitas la Tienda para comprar un arma");
        System.out.println("Escoja el objeto que desea comprar");
        System.out.println("1. Calculadora -> +3p de ataque -> 5 oros");
        System.out.println("2. Puño americano -> +5p de ataque -> 7 oros");
        System.out.println("3. Martillo -> +7p de ataque -> 10 oros");
        System.out.println("4. Vendas -> +5p de salud -> 8 oros");
    }

    public static void menuPrincipal() {
        System.out.println("Pulse 1 para luchar contra un enemigo");
        System.out.println("Pulse 2 para comprar un objeto");
        System.out.println("Pulse 3 para mostrar inventario");
        System.out.println("Pulse 4 para consultar tus estadísticas");
        System.out.println("Pulse 5 para usar un objeto");
        System.out.println("Pulse 6 para salir");
    }
}
