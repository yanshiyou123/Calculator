import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.util.regex.Pattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField tf;
    private JPanel panel;
    private JButton Add, Equal, Dot, Sub, Mod, Div, C, NAP, Mul,
            Num0, Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8, Num9;
    private JButton[] number = new JButton[10];
    private JButton[] function = new JButton[9];
    private char operator;
    private double number1, number2, result;

    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();

    }

    Calculator() {

        tf = new JTextField();
        tf.setBackground(Color.white);
        tf.setBounds(50, 50, 360, 70);
        tf.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));

        panel = new JPanel();
        panel.setBounds(50, 140, 360, 410);
        panel.setBackground(new Color(202, 206, 217));

        // Button Setting
        funSetting();
        numSetting();

        for (int i = 0; i < 9; i++) {
            function[i].addActionListener(this);
        }
        for (int i = 0; i < 10; i++) {
            number[i].addActionListener(this);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(480, 650);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.add(Equal);
        this.add(Add);
        this.add(Mul);
        this.add(Dot);
        this.add(Sub);
        this.add(Mod);
        this.add(Div);
        this.add(C);
        this.add(NAP);
        for (int i = 0; i < 10; i++) {
            this.add(number[i]);
        }
        this.add(tf);
        this.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton actionSource = (JButton) e.getSource();

        // Number 1-9
        if (actionSource == number[0]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("0");
            } else {
                tf.setText(tf.getText() + "0");
            }
        } else if (actionSource == number[1]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("1");
            } else {
                tf.setText(tf.getText() + "1");
            }
        } else if (actionSource == number[2]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("2");
            } else {
                tf.setText(tf.getText() + "2");
            }
        } else if (actionSource == number[3]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("3");
            } else {
                tf.setText(tf.getText() + "3");
            }
        } else if (actionSource == number[4]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("4");
            } else {
                tf.setText(tf.getText() + "4");
            }
        } else if (actionSource == number[5]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("5");
            } else {
                tf.setText(tf.getText() + "5");
            }
        } else if (actionSource == number[6]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("6");
            } else {
                tf.setText(tf.getText() + "6");
            }
        } else if (actionSource == number[7]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("7");
            } else {
                tf.setText(tf.getText() + "7");
            }
        } else if (actionSource == number[8]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("8");
            } else {
                tf.setText(tf.getText() + "8");
            }
        } else if (actionSource == number[9]) {
            if (Pattern.matches("[0]*", tf.getText())) {
                tf.setText("9");
            } else {
                tf.setText(tf.getText() + "9");
            }
        }

        // Reset
        if (actionSource.equals(C)) {
            tf.setText("");

        }
        // Dot
        if (actionSource.equals(Dot)) {
            if (!tf.getText().contains(".")) {
                tf.setText(tf.getText() + ".");
            } else {
                tf.setText("0.");

            }
        }
        // Negative and Positive
        if (actionSource.equals(NAP)) {
            double temp = Double.parseDouble(tf.getText());
            temp *= -1;
            tf.setText(String.valueOf(temp));

        }
        // Add
        if (actionSource.equals(Add)) {
            number1 = Double.parseDouble(tf.getText());
            operator = '+';
            tf.setText("");
        }
        // Subtraction
        if (actionSource.equals(Sub)) {
            number1 = Double.parseDouble(tf.getText());
            operator = '-';
            tf.setText("");
        }
        // Multiply
        if (actionSource.equals(Mul)) {
            number1 = Double.parseDouble(tf.getText());
            operator = '*';
            tf.setText("");
        }
        // Division
        if (actionSource.equals(Div)) {
            number1 = Double.parseDouble(tf.getText());
            operator = '/';
            tf.setText("");
        }
        // Modulo
        if (actionSource.equals(Mod)) {
            number1 = Double.parseDouble(tf.getText());
            operator = '%';
            tf.setText("");
        }
        // Equal
        if (actionSource.equals(Equal)) {
            number2 = Double.parseDouble(tf.getText());
            switch (operator) {
                case '+':
                    result = number1 + number2;
                    tf.setText(String.valueOf(result));
                    break;
                case '-':
                    result = number1 - number2;
                    tf.setText(String.valueOf(result));
                    break;
                case '*':
                    result = number1 * number2;
                    tf.setText(String.valueOf(result));
                    break;
                case '/':
                    result = number1 / number2;
                    tf.setText(String.valueOf(result));
                    break;
                case '%':
                    result = number1 % number2;
                    tf.setText(String.valueOf(result));
                    break;
            }

        }

    }

    public void funSetting() {
        Add = new JButton("+");
        Mul = new JButton("*");
        Equal = new JButton("=");
        Dot = new JButton(".");
        Sub = new JButton("-");
        Mod = new JButton("%");
        Div = new JButton("/");
        C = new JButton("C");
        NAP = new JButton("+/-");

        Add.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Mul.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Equal.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Dot.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Sub.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Mod.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Div.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        C.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        NAP.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));

        Add.setBackground(new Color(195, 176, 145));
        Mul.setBackground(new Color(195, 176, 145));
        Equal.setBackground(new Color(195, 176, 145));
        Dot.setBackground(new Color(195, 176, 145));
        Sub.setBackground(new Color(195, 176, 145));
        Mod.setBackground(new Color(195, 176, 145));
        Div.setBackground(new Color(195, 176, 145));
        C.setBackground(new Color(195, 176, 145));
        NAP.setBackground(new Color(195, 176, 145));

        Dot.setBounds(240, 470, 70, 70);
        Equal.setBounds(330, 470, 70, 70);
        Add.setBounds(330, 390, 70, 70);
        Mul.setBounds(330, 230, 70, 70);
        Sub.setBounds(330, 310, 70, 70);
        Mod.setBounds(240, 150, 70, 70);
        Div.setBounds(330, 150, 70, 70);
        C.setBounds(60, 150, 70, 70);
        NAP.setBounds(150, 150, 70, 70);

        Dot.setBorder(BorderFactory.createEtchedBorder());
        Equal.setBorder(BorderFactory.createEtchedBorder());
        Add.setBorder(BorderFactory.createEtchedBorder());
        Mul.setBorder(BorderFactory.createEtchedBorder());
        Sub.setBorder(BorderFactory.createEtchedBorder());
        Mod.setBorder(BorderFactory.createEtchedBorder());
        Div.setBorder(BorderFactory.createEtchedBorder());
        C.setBorder(BorderFactory.createEtchedBorder());
        NAP.setBorder(BorderFactory.createEtchedBorder());

        function[0] = C;
        function[1] = NAP;
        function[2] = Mod;
        function[3] = Div;
        function[4] = Mul;
        function[5] = Sub;
        function[6] = Add;
        function[7] = Equal;
        function[8] = Dot;
    }

    public void numSetting() {
        Num0 = new JButton("0");
        Num1 = new JButton("1");
        Num2 = new JButton("2");
        Num3 = new JButton("3");
        Num4 = new JButton("4");
        Num5 = new JButton("5");
        Num6 = new JButton("6");
        Num7 = new JButton("7");
        Num8 = new JButton("8");
        Num9 = new JButton("9");
        Num0.setBounds(60, 470, 160, 70);
        Num1.setBounds(60, 230, 70, 70);
        Num2.setBounds(150, 230, 70, 70);
        Num3.setBounds(240, 230, 70, 70);
        Num4.setBounds(60, 310, 70, 70);
        Num5.setBounds(150, 310, 70, 70);
        Num6.setBounds(240, 310, 70, 70);
        Num7.setBounds(60, 390, 70, 70);
        Num8.setBounds(150, 390, 70, 70);
        Num9.setBounds(240, 390, 70, 70);
        Num0.setBorder(BorderFactory.createEtchedBorder());
        Num1.setBorder(BorderFactory.createEtchedBorder());
        Num2.setBorder(BorderFactory.createEtchedBorder());
        Num3.setBorder(BorderFactory.createEtchedBorder());
        Num4.setBorder(BorderFactory.createEtchedBorder());
        Num5.setBorder(BorderFactory.createEtchedBorder());
        Num6.setBorder(BorderFactory.createEtchedBorder());
        Num7.setBorder(BorderFactory.createEtchedBorder());
        Num8.setBorder(BorderFactory.createEtchedBorder());
        Num9.setBorder(BorderFactory.createEtchedBorder());
        Num0.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num2.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num3.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num4.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num5.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num6.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num7.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num8.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        Num9.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));

        Num0.setBackground(new Color(195, 176, 145));
        Num1.setBackground(new Color(195, 176, 145));
        Num2.setBackground(new Color(195, 176, 145));
        Num3.setBackground(new Color(195, 176, 145));
        Num4.setBackground(new Color(195, 176, 145));
        Num5.setBackground(new Color(195, 176, 145));
        Num6.setBackground(new Color(195, 176, 145));
        Num7.setBackground(new Color(195, 176, 145));
        Num8.setBackground(new Color(195, 176, 145));
        Num9.setBackground(new Color(195, 176, 145));

        number[0] = Num0;
        number[1] = Num1;
        number[2] = Num2;
        number[3] = Num3;
        number[4] = Num4;
        number[5] = Num5;
        number[6] = Num6;
        number[7] = Num7;
        number[8] = Num8;
        number[9] = Num9;
    }

}
