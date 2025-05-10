package tema16;

/**
 *
 * @author AlumnoT
 */
import java.lang.Math;

public class Jugador {

    private String nombre;
    private int puntosSalud, puntosAtaque, dinero;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntosSalud = 20;
        puntosAtaque = 3;
        dinero = 2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void calcularFuerzaInicial() {

        int random = (int) (Math.random() * 10 + 1);
        setPuntosAtaque(random);

    }

    @Override
    public String toString() {
        return "Jugador [puntosSalud=" + puntosSalud + ", puntosAtaque=" + puntosAtaque + ", dinero=" + dinero
                + "]";
    }

}
