package tema16;

/**
 *
 * @author AlumnoT
 */
import java.lang.Math;

public class Enemigo {

    private String nombre;
    private int puntosAtaque;

    public Enemigo(String nombre) {
        this.nombre = nombre;

        puntosAtaque = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public void calcularFuerzaEnemigo() {

        int random = (int) (Math.random() * 10 + 1);
        setPuntosAtaque(random);

    }

    public int soltarDinero() {
        int random;
        return random = (int) (Math.random() * 5 + 1);
    }
}
