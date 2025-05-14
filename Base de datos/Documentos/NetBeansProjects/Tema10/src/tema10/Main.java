package tema10;

public class Main {

    public static void main(String[] args) {

        Gato gato = new Gato(2, "negro", "bombay", "negro", "felino", "casa", "trepar");
        Perro perro = new Perro(17, "coco", "yorkshire", "marron", "canino", "casa", "vivir");

        System.out.println(gato);
        System.out.println(perro);

        gato.sonido();
        perro.sonido();
    }

}
