package calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * La aplicación consistirá en una calculadora sencilla capaz de realizar
 * las siguientes operaciones:
 * 
 *   1.	Suma y resta de números reales.
 *   2.	Multiplicación y división de números reales.
 *   3.	Raíz cuadrada de números reales. Deberéis identificar un método 
 *      de cálculo aproximado, al no poder utilizar funciones de la 
 *      librería matemática.
 *   4.	Función exponencial con base e. Deberéis identificar un método de 
 *      cálculo aproximado, al no poder utilizar funciones de la librería 
 *      matemática.
 */
public class CalculadoraTest {
    
    @Test
    public void testDividir() {
        // Arrange
        double a[] =        { 1.0, 2.0,   3.0,  4.0, 5.0,   6.0,   7.0,   8.0,    9.0, 10.0 };
        double b[] =        { 2.0, 3.0,   4.0,  5.0, 6.0,   7.0,   8.0,   9.0,   10.0, 11.0 };
        double expected[] = { 0.5, 0.666, 0.75, 0.8, 0.833, 0.857, 0.875, 0.888,  0.9,  0.909 };

        // Act
        double actual[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            actual[i] = Calculadora.dividir(a[i], b[i]);
        }

        // Assert
        assertArrayEquals(expected, actual, 1e-3);
    }

    
    @Test
    public void testMultiplicar() {
        // Arrange
        double a[] =        { 1.0, -12.1,   23.2,   -34.3,   45.4,  -56.5,   67.6,   -78.7,   0.898,   -0.109 };
        double b[] =        { 2.0,   3.1,   -4.2,     5.3,    6.4,   -7.5,    8.6,     9.7,  -1.08,     0.119 };
        double expected[] = { 2.0, -37.51, -97.44, -181.79, 290.56, 423.75, 581.36, -763.39, -0.96984, -0.012971 };
        
        // Act
        double actual[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            actual[i] = Calculadora.multiplicar(a[i], b[i]);
        }

        // Assert
        assertArrayEquals(expected, actual, 1e-3);
    }

    
    @Test
    public void testPotencia() {
        // Arrange
        double base[] = { 1.0, -12.1, 23.2, -34.3, 45.4, -56.5, 67.6,  -88.7, 0.898, -0.109 };
        int exp[] =     {   0,     1,    2,     3,    4,     5,    6,     7,     8,      9 };
        double expected[] = new double[base.length];
        for (int i = 0; i < base.length; i++) {
            expected[i] = (double)Math.pow(base[i], exp[i]);
        }

        // Act
        double actual[] = new double[base.length];
        for (int i = 0; i < base.length; i++) {
            actual[i] = Calculadora.potencia(base[i], exp[i]);
        }

        // Assert
        assertArrayEquals(expected, actual, 1e-3);
    }

    
    @Test
    public void testRaiz() {
        // Arrange
        double x[] = { 1.0, 12.1, 23.2, 34.3, 45.4, 56.5, 67.6, 78.7, 0.898, 0.109 };
        double expected[] = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            expected[i] = Math.sqrt(x[i]);
        }

        // Act
        double actual[] = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            actual[i] = (double)Calculadora.raiz(x[i]);
        }

        // Assert
        assertArrayEquals(expected, actual, 1e-3);
    }

    
    @Test
    public void testRaizNumeroNegativo() {
        // Arrange
        double n = -1;
        IllegalArgumentException expected = new IllegalArgumentException(
                "La raíz de un número negativo no existe");
        
        try {
            // Act
            Calculadora.raiz(n);

            // Assert
            fail("No se ha lanzado la excepción para una raiz de un número negativo");
        } catch (Exception e) {
            assertEquals(expected.getMessage(), e.getMessage());
            assertEquals(expected.getClass(), e.getClass());
        }
    }

    
    @Test
    public void testRestar() {
        // Arrange
        double a[] =         { 1.0, -12.1, 23.2, -34.3, 45.4, -56.5, 67.6, -78.7,  0.898, -0.109 };
        double b[] =         { 2.0,   3.1, -4.2,   5.3,  6.4,  -7.5,  8.6,   9.7,  -1.08,  0.119 };
        double expected[] = { -1.0, -15.2, 27.4, -39.6, 39.0, -49.0, 59.0, -88.4,  1.978, -0.228 };

        // Act
        double actual[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            actual[i] = Calculadora.restar(a[i], b[i]);
        }

        // Assert
        assertArrayEquals(expected, actual, 1e-13);
    }

    
    @Test
    public void testSumar() {
        // Arrange
        double a[] =         { 1.0, -12.1, 23.2, -34.3, 45.4, -56.5, 67.6, -78.7,  0.898, -0.109 };
        double b[] =         { 2.0,   3.1, -4.2,   5.3,  6.4,  -7.5,  8.6,   9.7,  -1.08,  0.119 };
        double expected[] = {  3.0,  -9.0,   19,   -29, 51.8,   -64, 76.2,   -69, -0.182,  0.01 };

        // Act
        double actual[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            actual[i] = Calculadora.sumar(a[i], b[i]);
        }

        // Assert
        assertArrayEquals(expected, actual, 1e-13);
    }

    
    @Test
    public void testExponencial() {
        // Arrange
        double a[] = { 1.0, 2.1, 3.2, 4.3, 5.4, 6.5, -7.6, 8.7, 0.898, -0.109 };
        double expected[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            expected[i] = (double)Math.exp( a[i] );
        }

        // Act
        double actual[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            actual[i] = (double)Calculadora.exponencial( a[i] );
        }

        // Assert
        assertArrayEquals(expected, actual, 1e-3);
    }

}
