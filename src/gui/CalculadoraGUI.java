package gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import calculadora.Calculadora;

import java.awt.*;

public class CalculadoraGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton btn1 = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    private JButton btn7 = new JButton("7");
    private JButton btn8 = new JButton("8");
    private JButton btn9 = new JButton("9");
    private JButton btn0 = new JButton("0");
    private JButton btnPunto = new JButton(".");
    private JButton btnSuma = new JButton("+");
    private JButton btnResta = new JButton("-");
    private JButton btnMultiplicacion = new JButton("*");
    private JButton btnDivision = new JButton("/");
    private JButton btnIgual = new JButton("=");
    private JButton btnBorrarTodo = new JButton("AC");
    private JButton btnPotencia = new JButton("^");
    private JButton btnRaiz = new JButton("√");
    private JButton btnExponencial = new JButton("e^");
    private JLabel lblDisplay1 = new JLabel("0");
    private JLabel lblDisplay2 = new JLabel("0.0");

    private double num2 = 0;
    private double num1 = 0;

    private JButton activeOper = null;
    private Color defaultBgColor;

    public CalculadoraGUI() {
        setTitle("Calculadora");
        setSize(300, 340);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new java.awt.BorderLayout());
        setContentPane(mainPanel);

        mainPanel.add(getKeyboard(), java.awt.BorderLayout.CENTER);
        mainPanel.add(getDisplay(), java.awt.BorderLayout.NORTH);

        setVisible(true);
    }

    private Component getDisplay() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panel.add(lblDisplay2);
        panel.add(lblDisplay1);

        lblDisplay1.setFont(new Font("Currier New", Font.BOLD, 20));
        lblDisplay2.setFont(new Font("Currier New", Font.BOLD, 15));
        lblDisplay1.setHorizontalAlignment(JLabel.RIGHT);
        lblDisplay2.setHorizontalAlignment(JLabel.RIGHT);

        return panel;
    }

    private JPanel getKeyboard() {
        JPanel keyboard = new JPanel();
        keyboard.setLayout(new java.awt.GridLayout(4, 5, 5, 5));
        keyboard.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        keyboard.add(btn7);
        keyboard.add(btn8);
        keyboard.add(btn9);
        keyboard.add(btnBorrarTodo);
        keyboard.add(btnExponencial);

        keyboard.add(btn4);
        keyboard.add(btn5);
        keyboard.add(btn6);
        keyboard.add(btnMultiplicacion);
        keyboard.add(btnDivision);

        keyboard.add(btn1);
        keyboard.add(btn2);
        keyboard.add(btn3);
        keyboard.add(btnSuma);
        keyboard.add(btnResta);

        keyboard.add(btn0);
        keyboard.add(btnPunto);
        keyboard.add(btnIgual);
        keyboard.add(btnPotencia);
        keyboard.add(btnRaiz);

        defaultBgColor = btn1.getBackground();

        btn0.addActionListener(e -> {numClicked(0);});
        btn1.addActionListener(e -> {numClicked(1);});
        btn2.addActionListener(e -> {numClicked(2);});
        btn3.addActionListener(e -> {numClicked(3);});
        btn4.addActionListener(e -> {numClicked(4);});
        btn5.addActionListener(e -> {numClicked(5);});
        btn6.addActionListener(e -> {numClicked(6);});
        btn7.addActionListener(e -> {numClicked(7);});
        btn8.addActionListener(e -> {numClicked(8);});
        btn9.addActionListener(e -> {numClicked(9);});
        btnPunto.addActionListener(e -> {btnPuntoClicked();});
        btnBorrarTodo.addActionListener(e -> {btnBorrarTodoClicked();});
        btnSuma.addActionListener(e -> {binaryOperClicked((JButton)e.getSource());});
        btnResta.addActionListener(e -> {binaryOperClicked((JButton)e.getSource());});
        btnMultiplicacion.addActionListener(e -> {binaryOperClicked((JButton)e.getSource());});
        btnDivision.addActionListener(e -> {binaryOperClicked((JButton)e.getSource());});
        btnPotencia.addActionListener(e -> {binaryOperClicked((JButton)e.getSource());});
        btnRaiz.addActionListener(e -> {unaryOperClicked((JButton)e.getSource());});
        btnExponencial.addActionListener(e -> {unaryOperClicked((JButton)e.getSource());});
        btnIgual.addActionListener(e -> {btnIgualClicked();});
        
        return keyboard;
    }

    private void unaryOperClicked(JButton btn) {
        activeOper = btn;
        operar();
    }

    private void btnIgualClicked() {
        operar();
    }

    private void binaryOperClicked(JButton btn) {
        operar();
        activeOper = btn;
        activeOper.setBackground(Color.GREEN);
    }

    private void operar() {
        num2 = Double.valueOf(lblDisplay1.getText());
        if (activeOper == null) {
            if (num1 ==0)
                num1 = num2;
        } else if (activeOper.equals(btnSuma)) {
            num1 = Calculadora.sumar(num1, num2);
        } else if (activeOper.equals(btnResta)) {
            num1 = Calculadora.restar(num1, num2);
        } else if (activeOper.equals(btnMultiplicacion)) {
            num1 = Calculadora.multiplicar(num1, num2);
        } else if (activeOper.equals(btnDivision)) {
            num1 = Calculadora.dividir(num1, num2);
        } else if (activeOper.equals(btnPotencia)) {
            num1 = Calculadora.potencia(num1, (int) num2);
        } else if (activeOper.equals(btnExponencial)) {
            num2 = (num2 == 0) ? num1 : num2;
            num1 = Calculadora.exponencial((int) num2);
        } else if (activeOper.equals(btnRaiz)) {
            num2 = (num2 == 0) ? num1 : num2;
            num1 = Calculadora.raiz(num2);
        }
        lblDisplay2.setText(String.valueOf(num1));
        num2 = 0;
        lblDisplay1.setText("0");
        if (activeOper != null) {
            activeOper.setBackground(defaultBgColor);
            activeOper = null;
        }
    }

    private void btnPuntoClicked() {
        if (!lblDisplay1.getText().contains(".")) {
            lblDisplay1.setText(lblDisplay1.getText() + ".");
        }
    }

    private void btnBorrarTodoClicked() {
        if (activeOper != null) {
            activeOper.setBackground(defaultBgColor);
            activeOper = null;
        }
        lblDisplay1.setText("0");
        lblDisplay2.setText("0.0");
        num2 = 0;
        num1 = 0;
    }

    private void numClicked(int i) {
        if (lblDisplay1.getText().equals("0")) {
            lblDisplay1.setText("" + i);
        } else {
            lblDisplay1.setText(lblDisplay1.getText() + i);
        }
    }

}
