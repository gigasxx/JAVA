import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
class CalculatorFrame extends JFrame implements ActionListener {
    private JTextField displayField;
    private double result = 0.0;
    private String lastOperator = "=";
    private boolean isUserTypingNewNumber = true;
    public CalculatorFrame() {
        setTitle("Java Suvam: Basic Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        displayField = new JTextField("0");
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        add(displayField, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("C")) {
            result = 0.0;
            lastOperator = "=";
            isUserTypingNewNumber = true;
            displayField.setText("0");
            return;
        }
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            if (isUserTypingNewNumber) {
                if (command.equals(".") && displayField.getText().contains(".")) return;
                displayField.setText(command);
                isUserTypingNewNumber = false;
            } else {
                if (command.equals(".") && displayField.getText().contains(".")) return;
                displayField.setText(displayField.getText() + command);
            }
        } else {
            calculateCumulative(Double.parseDouble(displayField.getText()));
            lastOperator = command;
            isUserTypingNewNumber = true;
        }
    }
    private void calculateCumulative(double localValue) {
        switch (lastOperator) {
            case "=": result = localValue; break;
            case "+": result += localValue; break;
            case "-": result -= localValue; break;
            case "*": result *= localValue; break;
            case "/": 
                if (localValue != 0) {
                    result /= localValue;
                } else {
                    displayField.setText("Error: Div by 0");
                    result = 0.0;
                    lastOperator = "=";
                    isUserTypingNewNumber = true;
                    return;
                }
                break;
        }   
        if (result == (long) result) {
            displayField.setText(String.valueOf((long) result));
        } else {
            displayField.setText(String.valueOf(result));
        }
    }
}
public class Calculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculatorFrame calc = new CalculatorFrame();
                calc.setVisible(true);
            }
        });
    }
}
