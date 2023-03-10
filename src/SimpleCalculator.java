import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator implements ActionListener {

    private JFrame frame;
    private JTextField textField;
    private JButton[] buttons;
    private JPanel buttonPanel;

    private String currentText = "";
    private int currentResult = 0;
    private char currentOperator;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        textField = new JTextField();
        textField.setEditable(false);

        buttons = new JButton[16];
        buttons[0] = new JButton("7");
        buttons[1] = new JButton("8");
        buttons[2] = new JButton("9");
        buttons[3] = new JButton("/");
        buttons[4] = new JButton("4");
        buttons[5] = new JButton("5");
        buttons[6] = new JButton("6");
        buttons[7] = new JButton("*");
        buttons[8] = new JButton("1");
        buttons[9] = new JButton("2");
        buttons[10] = new JButton("3");
        buttons[11] = new JButton("-");
        buttons[12] = new JButton("0");
        buttons[13] = new JButton("C");
        buttons[14] = new JButton("=");
        buttons[15] = new JButton("+");

        // Set all buttons to pink
        for (JButton button : buttons) {
            button.setBackground(Color.BLACK);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            button.setForeground(Color.WHITE);
        }

        buttonPanel = new JPanel(new GridLayout(4, 4));
        for (JButton button : buttons) {
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();
        if (buttonText.matches("[0-9]")) {
            currentText += buttonText;
            textField.setText(currentText);
        } else if (buttonText.matches("[/+*\\-]")) {
            currentOperator = buttonText.charAt(0);
            currentResult = Integer.parseInt(currentText);
            currentText = "";
        } else if (buttonText.equals("C")){
            textField.setText("");
            currentText = "";
            currentResult = 0;
        } else if (buttonText.equals("=")) {
            int secondOperand = Integer.parseInt(currentText);
            switch (currentOperator) {
                case '+':
                    currentResult += secondOperand;
                    break;
                case '-':
                    currentResult -= secondOperand;
                    break;
                case '*':
                    currentResult *= secondOperand;
                    break;
                case '/':
                    currentResult /= secondOperand;
                    break;
            }
            textField.setText(Integer.toString(currentResult));
            currentText = Integer.toString(currentResult);
        }
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
    }

}