package calculadora;

/**
 * La aplicación consistirá en una calculadora sencilla capaz de realizar
 * las siguientes operaciones:
 * 
 *   1. Suma y resta de números reales.
 *   2. Multiplicación y división de números reales.
 *   3. Raíz cuadrada de números reales. Deberéis identificar un método
 *      de cálculo aproximado, al no poder utilizar funciones de la
 *      librería matemática.
 *   4. Función exponencial con base e. Deberéis identificar un método de
 *      cálculo aproximado, al no poder utilizar funciones de la librería
 *      matemática.
 * 
 * Para las operaciones 3 y 4 no podrás hacer uso de ninguna librería
 * matemática y deberás utilizar operaciones básicas como la suma, resta,
 * multiplicación y división, empleando para ello las funciones de la
 * propia calculadora implementadas en los pasos anteriores. La precisión
 * alcanzada en los cálculos debe ser superior a 1e-3.
 */

public class Calculadora {

    public static double sumar(double a, double b) {
        return a + b;
    }

    
    public static double restar(double a, double b) {
        return a - b;
    }

    
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    
    public static double dividir(double a, double b) {
        return a / b;
    }

    
    public static double potencia(double base, int exp) {
        double x = 1;
        for (int i = 0; i < exp; i++) {
            x *= base;
        }
        return x;
    }

    /**
     * Método que calcula la raíz cuadrada de un número real mediante el 
     * algoritmo babilónico. Que está basado en el hecho de que la raíz cuadrada 
     * de un número real x es igual al lado de un cuadrado cuya area es igual a x.
     * 
     * @param x radicando
     * @return raíz cuadrada de a
     */
    public static double raiz(double x) {
        if (x < 0)
            throw new IllegalArgumentException(
            "La raíz de un número negativo no existe");
        double a = x;
        double b = 0;
        /* No es necesario calcular el error, iterara hasta que el sistema no
        sea capaz de representar mas decimales. Se puede hacer while(a != b) */
        while (a != b) {
            b = a;
            a = (a + x / a) / 2;
        }
        return a;
    }

    /**
     * Calcula la funcion exponencial mediante la serie de Taylor.
     * 
     * @param x exponente
     * @return exponencial de x (e^x)
     */
    public static double exponencial(double x) {
        double suma = 0, b = 0;
        int n = 1;
        do {
            b = suma;
            suma += potencia(x, n) / factorial(n);
            n++;
        } while (b != suma); // Hasta que no puede representar mas decimales
        return suma + 1;
    }

    private static double factorial(int n) {
        double fact = 1;
        for (int i = 1; i <= n; i++) 
            fact *= i;
        return fact;
    }
    
}
