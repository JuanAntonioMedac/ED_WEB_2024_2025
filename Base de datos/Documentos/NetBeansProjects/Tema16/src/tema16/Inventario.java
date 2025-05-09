package tema16;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AlumnoT
 */
public class Inventario {

    private HashMap<String, Integer> objetosAtaque;
    private HashMap<String, Integer> objetosSalud;
    private HashMap<String, Integer> cantidadObjetos;

    public Inventario() {
        objetosAtaque = new HashMap<>();
        objetosSalud = new HashMap<>();
        cantidadObjetos = new HashMap<>();
    }

    public void objetosAtaque(String nombreObjeto, int puntosAtaque) {
        boolean contieneClave;
        if (contieneClave = objetosAtaque.containsKey(nombreObjeto)) {
            int valor = cantidadObjetos.get(nombreObjeto) + 1;
            cantidadObjetos.put(nombreObjeto, valor);
        } else {
            objetosAtaque.put(nombreObjeto, puntosAtaque);
            cantidadObjetos.put(nombreObjeto, 1);
        }
    }

    public void objetosSalud(String nombreObjeto, int puntosSalud) {
        boolean contieneClave;
        if (contieneClave = objetosSalud.containsKey(nombreObjeto)) {
            int valor = cantidadObjetos.get(nombreObjeto) + 1;
            cantidadObjetos.put(nombreObjeto, valor);
        } else {
            objetosSalud.put(nombreObjeto, puntosSalud);
            cantidadObjetos.put(nombreObjeto, 1);
        }
    }

    public void mostrarInventario() {
        System.out.println("_____ OBJETOS DE ATAQUE ____");
        for (Map.Entry<String, Integer> entry : objetosAtaque.entrySet()) {
            int valor = cantidadObjetos.get(entry.getKey());
            System.out.println("Objeto: " + entry.getKey() + ", Puntos de ataque: " + entry.getValue());
            System.out.println("Cantidad: " + valor);
        }
        System.out.println("____ OBJETOS DE SALUD ____");
        for (Map.Entry<String, Integer> entry : objetosSalud.entrySet()) {
            int valor = cantidadObjetos.get(entry.getKey());
            System.out.println("Objeto: " + entry.getKey() + ", Puntos de salud: " + entry.getValue());
            System.out.println("Cantidad: " + valor);
        }
    }

    public void usarObjeto(String nombreObjeto, Jugador jugador1) {
        boolean contieneClave;
        int valor;
        int suma;
        if (contieneClave = cantidadObjetos.containsKey(nombreObjeto)) {
            if (contieneClave = objetosAtaque.containsKey(nombreObjeto)) {
                valor = objetosAtaque.get(nombreObjeto);
                suma = jugador1.getPuntosAtaque() + valor;
                jugador1.setPuntosAtaque(suma);
                System.out.println("El objeto " + nombreObjeto + " se ha usado,");
                System.out.println("Estadistica otorgada: " + valor + " puntos de ataque");
                valor = cantidadObjetos.get(nombreObjeto) -1;
                cantidadObjetos.put(nombreObjeto, valor);
            } else if (contieneClave = objetosSalud.containsKey(nombreObjeto)) {
                valor = objetosSalud.get(nombreObjeto);
                suma = jugador1.getPuntosSalud() + valor;
                jugador1.setPuntosSalud(suma);
                System.out.println("El objeto " + nombreObjeto + " se ha usado,");
                System.out.println("Estadistica otorgada: " + valor + " puntos de salud");
                valor = cantidadObjetos.get(nombreObjeto) -1;
                cantidadObjetos.put(nombreObjeto, valor);
            }
        }
    }
}
