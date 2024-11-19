import javax.swing.*;
import java.awt.event.*;

public class focusevent {
    JFrame frame;
    JLabel label;
    JTextField textField;
    JButton button;

    focusevent() {
        frame = new JFrame("Focus Events Example");
        label = new JLabel("Focus not yet on Text Field");
        label.setBounds(20, 50, 300, 20);

        textField = new JTextField();
        textField.setBounds(20, 80, 350, 30);

        button = new JButton("Click Me");
        button.setBounds(20, 120, 100, 30);

        // Add FocusListener to JTextField
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                label.setText("Focus gained on Text Field");
            }

            public void focusLost(FocusEvent e) {
                label.setText("Focus lost from Text Field");
            }
        });

        button.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                label.setText("Focus gained on Button");
            }

            public void focusLost(FocusEvent e) {
                label.setText("Focus lost from Button");
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new focusevent();
    }
}
