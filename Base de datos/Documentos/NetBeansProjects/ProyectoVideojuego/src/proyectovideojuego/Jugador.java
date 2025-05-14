package proyectovideojuego;
import java.util.Random;
import java.util.Scanner;
/**
 * Clase jugador que permite calcular de forma aleatoria el valor de la variable
 * fuerza
 *
 * @author Alex Beltrán y Lola Ávila
 * @version 1.0
 */
public class Jugador {

    private String name;
    private int salud, escudo, ataque, dinero, gemas;

    /**
     * constructor por defecto
     */
    public Jugador() {
        name = "";
        salud = 20;
        escudo = 0;
        ataque = 0;
        dinero = 2;
        gemas = 0;

    }

    /**
     * constructor por parametro.
     *
     * @param name variable que asigna un nombre al jugador
     */
    public Jugador(String name) {
        this.name = name;
    }

    /**
     * metodo get de la variable name
     *
     * @return devuelve el valor de la variable name
     */
    public String getName() {
        return name;
    }

    /**
     * metodo get de la variable salud
     *
     * @return devuelve el valor de la variable salud
     */
    public int getSalud() {
        return salud;
    }

    /**
     * metodo get de la variable escudo
     *
     * @return devuelve el valor de la variable escudo
     */
    public int getEscudo() {
        return escudo;
    }

    /**
     * metodo get de la variable ataque
     *
     * @return devuelve el valor de la variable ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * metodo get de la variable dinero
     *
     * @return devuelve el valor de la variable dinero
     */
    public int getDinero() {
        return dinero;
    }

    /**
     * metodo get de la variable gemas
     *
     * @return devuelve el valor de la variable gemas
     */
    public int getGemas() {
        return gemas;
    }

    /**
     * metodo set de la variable name
     *
     * @param name nombre del jugador
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * metodo set de la variable salud
     *
     * @param salud puntos de salud del jugador
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * metodo set de la variable escudo
     *
     * @param escudo puntos de escudo del jugador
     */
    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    /**
     * metodo set de la variable ataque
     *
     * @param ataque puntos de ataque del jugador
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * metodo set de la variable dinero
     *
     * @param dinero total obtenido por el jugador
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     * metodo set de la variable gemas
     *
     * @param gemas gemas totales obtenidas por el jugador
     */
    public void setGemas(int gemas) {
        this.gemas = gemas;
    }

    /**
     * metogo toString de la clase jugador
     *
     * @return devuelve el valor de las variables name, salud, escudo, ataque,
     * dinero y gemas
     */
    @Override
    public String toString() {
        return name + ", puntos de salud: " + salud
                + "/puntos de escudo: " + escudo
                + "/puntos de ataque: " + ataque
                + "/" + dinero + " de oro"
                + "/" + gemas + " gema(s)";
    }

    /**
     * metodo personalizado que calcula aleatoriamente el valor de la variable
     * ataque.
     */
    public void calcularFuerzaInicial() {
        Random aleatorio = new Random();
        ataque = aleatorio.nextInt(11);
        System.out.println("tu fuerza inicial es: " + ataque);

    }

    /**
     * metodo personalizado que resta 1 al valor de la variable dinero
     */
    public void restarDinero() {
        dinero--;
    }

}