package gui;

import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JButton;

import org.junit.Test;

public class CalculadoraGUITest {
    @Test
    public void testHasButtons() {
        // Arrange
        boolean true1 = false, true2 = false, true3 = false, true4 = false, true5 = false, true6 = false;
        boolean true7 = false, true8 = false, true9 = false, true0 = false, truePunto = false;
        boolean trueSuma = false, trueResta = false, trueMultiplicacion = false, trueDivision = false;
        boolean trueIgual = false, truePotencia = false, trueRaiz = false, trueExponencial = false;

        // Act
        CalculadoraGUI gui = new CalculadoraGUI();

        // Assert
        Iterator<Component> iter = getAllComponents(gui).iterator();
        while (iter.hasNext()) {
            Component component = iter.next();
            if (component instanceof JButton) {
                if ("1".equals(((JButton) component).getText())) {
                    true1 = true;
                } else if ("2".equals(((JButton) component).getText())) {
                    true2 = true;
                } else if ("3".equals(((JButton) component).getText())) {
                    true3 = true;
                } else if ("4".equals(((JButton) component).getText())) {
                    true4 = true;
                } else if ("5".equals(((JButton) component).getText())) {
                    true5 = true;
                } else if ("6".equals(((JButton) component).getText())) {
                    true6 = true;
                } else if ("7".equals(((JButton) component).getText())) {
                    true7 = true;
                } else if ("8".equals(((JButton) component).getText())) {
                    true8 = true;
                } else if ("9".equals(((JButton) component).getText())) {
                    true9 = true;
                } else if ("0".equals(((JButton) component).getText())) {
                    true0 = true;
                } else if (".".equals(((JButton) component).getText())) {
                    truePunto = true;
                } else if ("+".equals(((JButton) component).getText())) {
                    trueSuma = true;
                } else if ("-".equals(((JButton) component).getText())) {
                    trueResta = true;
                } else if ("*".equals(((JButton) component).getText())) {
                    trueMultiplicacion = true;
                } else if ("/".equals(((JButton) component).getText())) {
                    trueDivision = true;
                } else if ("=".equals(((JButton) component).getText())) {
                    trueIgual = true;
                } else if ("^".equals(((JButton) component).getText())) {
                    truePotencia = true;
                } else if ("√".equals(((JButton) component).getText())) {
                    trueRaiz = true;
                } else if ("e^".equals(((JButton) component).getText())) {
                    trueExponencial = true;
                }
            }
        }
        assertTrue(true1);
        assertTrue(true2);
        assertTrue(true3);
        assertTrue(true4);
        assertTrue(true5);
        assertTrue(true6);
        assertTrue(true7);
        assertTrue(true8);
        assertTrue(true9);
        assertTrue(true0);
        assertTrue(truePunto);
        assertTrue(trueSuma);
        assertTrue(trueResta);
        assertTrue(trueMultiplicacion);
        assertTrue(trueDivision);
        assertTrue(trueIgual);
        assertTrue(truePotencia);
        assertTrue(trueRaiz);
        assertTrue(trueExponencial);
    }

    /**
     * Recorre todos los componentes de una estructura de componentes y
     * devuelve una lista con todos los componentes encontrados.
     * 
     * @param c contenedor raiz
     * @return lista con todos los componentes encontrados
     */
    private ArrayList<Component> getAllComponents(Container c) {
        ArrayList<Component> components = new ArrayList<Component>();
        Stack<Component> stack = new Stack<Component>();
        stack.push(c);

        while (!stack.isEmpty()) {
            Component component = stack.pop();
            if (component instanceof Container) {
                for (Component child : ((Container) component).getComponents()) {
                    stack.push(child);
                }
            }
            components.add(component);
        }
        return components;
    }
}
