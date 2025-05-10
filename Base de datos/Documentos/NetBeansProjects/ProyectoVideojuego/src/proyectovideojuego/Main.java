package proyectovideojuego;

import java.util.Random;
import java.util.Scanner;

public class Main {
    //funcion para la tienda 1
    public static void tienda1() {
        System.out.println("1. puntos de escudo");
        System.out.println("2. armadura de rodrigo");
        System.out.println("3. espada bendecida por Jose");
        System.out.println("4. trinidad josefain");
        System.out.println("5. salir");
        System.out.println("seleccione un objeto para ver mas detalles");
    }
    //funcion para la tienda 2
    public static void tienda2() {
        System.out.println("1. puntos de escudo");
        System.out.println("2. casco de Javi el castigador");
        System.out.println("3. cuchillo de Evelyn la despiadada");
        System.out.println("4. doble hacha de los hermanos Amador y Pepin");
        System.out.println("5. salir");
        System.out.println("seleccione un objeto para ver mas detalles");
    }
    //funcion para la tienda 3
    public static void tienda3() {
        System.out.println("1. puntos de escudo");
        System.out.println("2. talisman verde de Yuan");
        System.out.println("3. llave inglesa de Truka chatarra ");
        System.out.println("4. tico tico de marquitos");
        System.out.println("5. salir");
        System.out.println("seleccione un objeto para ver mas detalles");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Jugador jugador1 = new Jugador();
        Enemigo enemigo1 = new Enemigo();
        //introduccion al juego
        System.out.println("Bienvenido al reinado de medac, los profesores y alumnos pelean entre si por");
        System.out.println("desafiar al gran jose, el creador del universo y asi tener el honor de ser su reina.");
        System.out.println("El mensaje de Jose es claro: 'quien consiga llegar a mi y derrotarme, compartira todo el universo a mi lado");
        System.out.println("y tendra el placer de recibir mi amor incondicional para el resto de la eternidad'.");
        //nombre del jugador introducido por el usuario
        System.out.println("Si desea intentarlo, ingrese su nombre:");
        String nombreJugador = teclado.next();
        jugador1.setName(nombreJugador);

        boolean salir = true;
        jugador1.calcularFuerzaInicial();
        //bucle while para el calculo de la fuerza inicial del jugador.
        while (salir == true) {

            System.out.println("tienes: " + jugador1.getDinero() + " de oro");
            System.out.println("Que desea hacer?");
            System.out.println("1 Asignar fuerza de nuevo (cuesta 1 de oro)");
            System.out.println("2 Comenzar con la fuerza actual");
            int opcion = teclado.nextInt();
            //switch para que el usuario elija si quiere comenzar o cambiar el valor de fuerza
            switch (opcion) {

                case 1:
                    if (jugador1.getDinero() > 0) {
                        jugador1.calcularFuerzaInicial();
                        System.out.println("tu nueva fuerza es de: " + jugador1.getAtaque() + " puntos");
                        jugador1.restarDinero();
                    } else {
                        System.out.println("oro insuficiente");
                    }
                    break;
                case 2:
                    salir = false;
                    break;
            }
        }

        boolean salir2 = true;
        //bucle while del menu principal
        while (salir2 == true) {
            Random random = new Random();

            if (jugador1.getSalud() <= 0) {
                System.out.println(enemigo1.getNombre() + " te ha derrotado");
                salir2 = false;
            }

            System.out.println("elige tu siguiente movimiento:");
            System.out.println("1. Luchar contra un enemigo.");
            System.out.println("2. Ir a la tienda");
            System.out.println("3. Consultar tus estadisticas.");
            System.out.println("4. Salir del juego.");
            int opcion = teclado.nextInt();
            //switch del menu principal, contiene la lucha contra un enemigo, las tiendas
            //la consulta de estadisticas, y la salida del juego.
            switch (opcion) {
                case 1:
                    String[] nombreEnemigos = {"Rodrigo el LEGIONARIO", "Guille el Frustrado", "Evelyn la Despiadada", "Javi el Castigador", "Truka Chatarra", "Yuan el Verde", "Luis el Esplendido", "Amador y Pepin", "Lola el hombre", "Alex el Anhiquilador", "Marquitos del estanco"};
                    int indiceAleatorio = random.nextInt(nombreEnemigos.length);
                    String nombreEnemigo = nombreEnemigos[indiceAleatorio];
                    System.out.println(nombreEnemigo + " te desafia");
                    enemigo1.setNombre(nombreEnemigo);
                    enemigo1.calcularFuerzaEnemigo(jugador1);
                    if (jugador1.getAtaque() > enemigo1.getPuntosAtaque()) {
                        System.out.println(enemigo1.getNombre() + " ha sido derrotado");
                        enemigo1.soltarDinero();
                        int sumaDinero = enemigo1.getDinero() + jugador1.getDinero();
                        int sumaGemas = enemigo1.getGemas() + jugador1.getGemas();
                        jugador1.setDinero(sumaDinero);
                        jugador1.setGemas(sumaGemas);
                        System.out.println("tienes " + jugador1.getDinero() + " de oro");
                        System.out.println("tienes " + jugador1.getGemas() + " gema(s)");
                    } else if (jugador1.getAtaque() < enemigo1.getPuntosAtaque()) {

                        int diferencia = enemigo1.getPuntosAtaque() - jugador1.getAtaque();
                        if (jugador1.getEscudo() > 0) {
                            int restarEscudo = jugador1.getEscudo() - diferencia;
                            if (jugador1.getEscudo() <= diferencia) {
                                int restarVida = jugador1.getSalud() + restarEscudo;
                                jugador1.setSalud(restarVida);
                                System.out.println(enemigo1.getNombre() + " te ha derrotado y has perdido " + jugador1.getEscudo() + " puntos de escudo");
                                System.out.println("y " + restarEscudo + " de vida, tu escudo se ha roto");
                                System.out.println("tu salud actual es de " + jugador1.getSalud());
                                jugador1.setEscudo(0);
                                System.out.println("tienes " + jugador1.getEscudo() + " puntos de escudo.");
                                if (jugador1.getSalud() <= 0) {
                                    System.out.println(enemigo1.getNombre() + " te ha matado, mas suerte la proxima vez...");
                                    salir2 = false;
                                }

                            } else {
                                jugador1.setEscudo(restarEscudo);
                                System.out.println(enemigo1.getNombre() + " te ha derrotado y has perdido " + diferencia + " puntos de escudo");
                                System.out.println("tu salud actual es de " + jugador1.getSalud());
                                System.out.println("tienes " + jugador1.getEscudo() + " puntos de escudo.");
                                if (jugador1.getSalud() <= 0) {
                                    System.out.println(enemigo1.getNombre() + " te ha matado, mas suerte la proxima vez...");
                                    salir2 = false;
                                }
                            }
                        } else {
                            int restarSalud = jugador1.getSalud() - diferencia;
                            jugador1.setSalud(restarSalud);
                            System.out.println(enemigo1.getNombre() + " te ha derrotado y has perdido " + diferencia + " puntos de vida");
                            System.out.println("tu salud actual es de " + jugador1.getSalud());
                            if (jugador1.getSalud() <= 0) {
                                System.out.println(enemigo1.getNombre() + " te ha matado, mas suerte la proxima vez...");
                                salir2 = false;

                            }
                        }
                    } else if (jugador1.getAtaque() == enemigo1.getPuntosAtaque()) {
                        System.out.println("el combate esta tan igualado que ambos decidis que es una perdida de tiempo seguir luchando,");
                        System.out.println("asi que decidis daros un abrazo, continuar vuestro camino y enfrentaros de nuevo en otro momento");
                    }
                    break;
                case 2:
                    System.out.println("bienvenido a la tienda de Marcos el vendedor ambulante");

                    int numeroTienda = random.nextInt(3);
                    int precio = 0;
                    while (numeroTienda == 0) {
                        tienda1();
                        int seleccion = teclado.nextInt();
                        if (seleccion == 1) {
                            System.out.println("puntos de escudo:");
                            System.out.println("agrega dos puntos a la estadistica escudo. Cuesta 3 de oro");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 3) {
                                if (comprar == 1) {
                                    int sumarEscudo = jugador1.getEscudo() + 2;
                                    jugador1.setEscudo(sumarEscudo);
                                    System.out.println("comprado con exito");
                                    precio = 3;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 1. 
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto del jugador(objeto 1).
                        if (seleccion == 2) {
                            System.out.println("armadura de Rodrigo:");
                            System.out.println("la armadura de rodrigo el LEGIONARIO,");
                            System.out.println("otorga 4 puntos de vida a quien la posee. Cuesta 5 de oro.");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 5) {
                                if (comprar == 1) {
                                    int sumarSalud = jugador1.getSalud() + 4;
                                    jugador1.setSalud(sumarSalud);
                                    System.out.println("comprado con exito");
                                    precio = 5;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 2.
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto del jugador(objeto 2).
                        if (seleccion == 3) {
                            System.out.println("espada bendecida por Jose");
                            System.out.println("una espada legendaria que fue bendecida por el Gran Jose,");
                            System.out.println("otorga 7 puntos a la estadistica de ataque. Cuesta 10 de oro.");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 10) {
                                if (comprar == 1) {
                                    int sumarAtaque = jugador1.getAtaque() + 7;
                                    jugador1.setAtaque(sumarAtaque);
                                    System.out.println("comprado con exito");
                                    precio = 10;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 3
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto 3
                        if (seleccion == 4) {
                            System.out.println("trinidad jose fain:");
                            System.out.println("una trinidad formada por los 3 objetos sagrados de Jose,");
                            System.out.println("otorga 7 puntos a la estadistica de ataque,");
                            System.out.println("5 puntos a la estadistica de salud y 2 puntos de escudo");
                            System.out.println("Cuesta 7 gemas.");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getGemas() >= 7) {
                                if (comprar == 1) {
                                    int sumarAtaque = jugador1.getAtaque() + 7;
                                    jugador1.setAtaque(sumarAtaque);
                                    int sumarSalud = jugador1.getSalud() + 5;
                                    jugador1.setSalud(sumarSalud);
                                    int sumarEscudo = jugador1.getEscudo() + 2;
                                    jugador1.setEscudo(sumarEscudo);
                                    System.out.println("comprado con exito");
                                    precio = 7;
                                    int restarGemas = jugador1.getGemas() - precio;
                                    jugador1.setGemas(restarGemas);
                                }//if para comprar el objeto 3
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("gemas insuficientes");
                            }//else para que no se pueda comprar el objeto teniendo menos gemas que el precio del objeto.
                        }//if para la seleccion del objeto 3
                        if (seleccion == 5) {
                            numeroTienda = 4;
                        }//if para salir del bucle
                    }//while para la tienda 1.

                    while (numeroTienda == 1) {
                        tienda2();
                        int seleccion = teclado.nextInt();
                        if (seleccion == 1) {
                            System.out.println("puntos de escudo:");
                            System.out.println("agrega dos puntos a la estadistica escudo. Cuesta 3 de oro");
                            System.out.println("1 para comprar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 3) {
                                if (comprar == 1) {
                                    int sumarEscudo = jugador1.getEscudo() + 2;
                                    jugador1.setEscudo(sumarEscudo);
                                    System.out.println("comprado con exito");
                                    precio = 3;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 1. 
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto del jugador(objeto 1).
                        if (seleccion == 2) {
                            System.out.println("casco de Javi el castigador:");
                            System.out.println("casco de Javi el castigador que protegera la cabeza de cualquier ataque,");
                            System.out.println("otorga 3 puntos de vida a quien la posee. Cuesta 4 de oro.");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 4) {
                                if (comprar == 1) {
                                    int sumarSalud = jugador1.getSalud() + 3;
                                    jugador1.setSalud(sumarSalud);
                                    System.out.println("comprado con exito");
                                    precio = 4;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 2.
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto del jugador(objeto 2).
                        if (seleccion == 3) {
                            System.out.println("cuchillo de Evelyn las despiadada");
                            System.out.println("un cuchillo que utilizó Evelyn para torturar a sus victimas,");
                            System.out.println("otorga 4 puntos a la estadistica de ataque. Cuesta 6 de oro.");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 6) {
                                if (comprar == 1) {
                                    int sumarAtaque = jugador1.getAtaque() + 4;
                                    jugador1.setAtaque(sumarAtaque);
                                    System.out.println("comprado con exito");
                                    precio = 6;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 3
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto 3
                        if (seleccion == 4) {
                            System.out.println("doble hacha de los hermanos Amador y Pepin");
                            System.out.println("dos hachas utilizadas por los hermanos Amador y Pepin, aun tienen sangre de sus enemigos");
                            System.out.println("otorga 9 puntos a la estadistica de ataque, Cuesta 5 gemas");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getGemas() >= 5) {
                                if (comprar == 1) {
                                    int sumarAtaque = jugador1.getAtaque() + 9;
                                    jugador1.setAtaque(sumarAtaque);
                                    System.out.println("comprado con exito");
                                    precio = 5;
                                    int restarGemas = jugador1.getGemas() - precio;
                                    jugador1.setGemas(restarGemas);
                                }//if para comprar el objeto 4
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("gemas insuficientes");
                            }//else para que no se pueda comprar el objeto teniendo menos gemas que el precio del objeto.
                        }//if para la seleccion del objeto 4
                        if (seleccion == 5) {
                            numeroTienda = 4;
                        }//if para salir del bucle
                    }//while para la tienda 2.

                    while (numeroTienda == 2) {
                        tienda3();
                        int seleccion = teclado.nextInt();
                        if (seleccion == 1) {
                            System.out.println("puntos de escudo:");
                            System.out.println("agrega dos puntos a la estadistica escudo. Cuesta 3 de oro");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 3) {
                                if (comprar == 1) {
                                    int sumarEscudo = jugador1.getEscudo() + 2;
                                    jugador1.setEscudo(sumarEscudo);
                                    System.out.println("comprado con exito");
                                    precio = 3;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 1. 
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto del jugador(objeto 1).
                        if (seleccion == 2) {
                            System.out.println("Talisman verde de Yuan el verde");
                            System.out.println("Un talisman que proteje de ataques magicos(en verdad solo se supone que da suerte)");
                            System.out.println("otorga 2 puntos de vida y 1 de escudo a quien lo posee. Cuesta 3 de oro.");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 3) {
                                if (comprar == 1) {
                                    int sumarSalud = jugador1.getSalud() + 2;
                                    jugador1.setSalud(sumarSalud);
                                    int sumarEscudo = jugador1.getEscudo() + 1;
                                    jugador1.setEscudo(sumarEscudo);
                                    System.out.println("comprado con exito");
                                    precio = 3;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 2.
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto del jugador(objeto 2).
                        if (seleccion == 3) {
                            System.out.println("Llave inglesa de Truka chtarra:");
                            System.out.println("llave que se ha utilizado en talleres el truka, la saco truka del picaero,");
                            System.out.println("otorga 3 puntos a la estadistica de ataque. Cuesta 4 de oro.");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getDinero() >= 4) {
                                if (comprar == 1) {
                                    int sumarAtaque = jugador1.getAtaque() + 3;
                                    jugador1.setAtaque(sumarAtaque);
                                    System.out.println("comprado con exito");
                                    precio = 4;
                                    int restarDinero = jugador1.getDinero() - precio;
                                    jugador1.setDinero(restarDinero);
                                }//if para comprar el objeto 3
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("oro insuficiente");
                            }//else para que no se pueda comprar el objeto teniendo menos oro que el precio del objeto.
                        }//if para la seleccion del objeto 3
                        if (seleccion == 4) {
                            System.out.println("tico tico de marquitos del estanco");
                            System.out.println("un chicle de Sandia, no es cualquier chicle, si no el del estanco de marquittos,");
                            System.out.println("otorga 10 puntos a la estadistica de salud, Cuesta 4 gemas");
                            System.out.println("1 para compar, 2 para volver.");
                            int comprar = teclado.nextInt();
                            if (jugador1.getGemas() >= 4) {
                                if (comprar == 1) {
                                    int sumarSalud = jugador1.getSalud() + 10;
                                    jugador1.setSalud(sumarSalud);
                                    System.out.println("comprado con exito");
                                    precio = 4;
                                    int restarGemas = jugador1.getGemas() - precio;
                                    jugador1.setGemas(restarGemas);
                                }//if para comprar el objeto 4
                            }//if para comprobar q el usuario tiene dinero suficiente para comprar el objeto.
                            else {
                                System.out.println("gemas insuficientes");
                            }//else para que no se pueda comprar el objeto teniendo menos gemas que el precio del objeto.
                        }//if para la seleccion del objeto 4
                        if (seleccion == 5) {
                            numeroTienda = 4;
                        }//if para salir del bucle
                    }//while para la tienda 3.

                    break;

                case 3:
                    System.out.println(jugador1.toString());
                    break;
                case 4:
                    salir2 = false;
                    break;
            }//cierre switch
        }//cierre while
    }//cierre main
}//cierre class