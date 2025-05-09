package calculadora5;

/**
 * Clase de calculadora donde podemos hacer operaciones
 * @author Lola Ávila
 * version 1.0
 */
public class Calculadora5 {

    private double a;
    private double b;

    /**
     * Constructor por defecto
     */
    public Calculadora5() {
        a = 0;
        b = 0;
    }

    /**
     * Constructor por parametros
     * @param a variable para representar el primer numero
     * @param b variable para representar el segundo numero
     */
    public Calculadora5(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Metodo get de la variable a
     * @return devuelve la variable a
     */
    public double getA() {
        return a;
    }

    /**
     * Metodo get de la variable b
     * @return devuelve la variable b
     */
    public double getB() {
        return b;
    }

    /**
     * Metodo set de la variable a
     * @param a variable para representar el primer numero
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Metodo set de la variable b
     * @param b variable para representar el segundo numero
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * Metodo personalizado para realizar sumas
     * @return devuelve el valor de la suma
     */
    public double sumar() {
        return a + b;
    }

    /**
     * Metodo personalizado para realizar restas
     * @return devuelve el valor de la resta
     */
    public double restar() {
        return a - b;
    }

    /**
     * Metodo personalizado para realizar multiplicaciones
     * @return devuelve el valor de la multiplicacion
     */
    public double multiplicar() {
        return a * b;
    }

    /**
     * Metodo personalizado para realizar divisiones
     * @return devuelve el valor de la division
     * @throws ArithmeticException impide hacer la division si el divisor es 0
     */
    public double dividir() throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }
        return a / b;
    }

    /**
     * Metodo personalizado para realizar la raiz cuadrada de un numero
     * @param num 
     * @return devuelve el valor de la operacion
     * @throws IllegalArgumentException impide realizar la raiz cuadrada si el numero es menor que 0
     */
    public double raizCuadrada(double num) throws IllegalArgumentException {
        if (num < 0) {
            throw new ArithmeticException("No se puede hacer la raiz cuadrada de un numero negativo");
        }
        return Math.sqrt(a);
    }

    /**
     * Metodo personalizado para realizar la potencia de un numero
     * @return devuelve el valor de la potencia
     */
    public double potencia() {
        return Math.pow(a, b);
    }

    /**
     * Metodo personalizado para realizar logaritmos
     * @param num
     * @return devuelve el valor del logaritmo
     * @throws IllegalArgumentException impide realizar la operacion si el numero es menor o igual que 0
     */
    public double log(double num) throws IllegalArgumentException {
        if (num <= 0) {
            throw new ArithmeticException("No se puede calcular el logaritmo de un numero menor o igual que 0");
        }
        return Math.log(a);
    }

    /**
     * Metodo personalizado para realizar el factorial de un numero
     * @param num
     * @return devuelve el valor del factorial
     * @throws IllegalArgumentException impide realizar la operacion si el numero es menor que 0
     */
    public double factorial(double num) throws IllegalArgumentException {
        if (num < 0) {
            throw new ArithmeticException("No se puede calcular el factorial de un numero menor que 0");
        }
        long resultado = 1;
        for (int i = 1; i <= num; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }

}//class
