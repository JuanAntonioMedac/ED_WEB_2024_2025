package proyectovideojuego;

import java.util.Random;

public class Enemigo {

    private String nombre;
    private int puntosAtaque;

    public Enemigo() {
        nombre = "";
        puntosAtaque = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    @Override
    public String toString() {
        return nombre + "tiene " + puntosAtaque + " puntos de ataque";
    }

    public void calcularFuerzaenemigo() {
        Random aleatorio = new Random();
        int puntosFuerza = aleatorio.nextInt(10);
        System.out.println("La fuerza de " + nombre + " es de " + puntosFuerza + " puntos");
    }

    public void soltarDinero() {
        Random aleatorio = new Random();
        int soltarDinero = aleatorio.nextInt(5);
        System.out.println("Has derrotado a " + nombre + ", obtienes " + soltarDinero + " de oro");
    }
}
