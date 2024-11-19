import javax.swing.*;
import java.awt.*;

public class guicontrol {

    JFrame frame;
    JTextField textField;
    JPasswordField passwordField;
    JTextArea textArea;
    JCheckBox checkBox1, checkBox2;
    JRadioButton radioButton1, radioButton2;
    JComboBox<String> comboBox;
    JSlider slider;
    JButton submitButton;

    guicontrol() {
        frame = new JFrame("GUI Controls");
        frame.setLayout(new GridLayout(9, 1, 1, 10));

        textField = new JTextField();
        frame.add(new JLabel("Enter username:"));
        frame.add(textField);

        passwordField = new JPasswordField();
        frame.add(new JLabel("Enter password:"));
        frame.add(passwordField);

        textArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(new JLabel("Additional Info:"));
        frame.add(scrollPane);

        checkBox1 = new JCheckBox("I agree to terms");
        checkBox2 = new JCheckBox("Subscribe to newsletter");
        frame.add(checkBox1);
        frame.add(checkBox2);

        radioButton1 = new JRadioButton("Option 1");
        radioButton2 = new JRadioButton("Option 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        frame.add(radioButton1);
        frame.add(radioButton2);

        comboBox = new JComboBox<>(new String[]{"Option A", "Option B", "Option C"});
        frame.add(new JLabel("Choose an option:"));
        frame.add(comboBox);

        slider = new JSlider(0, 100, 50);
        frame.add(new JLabel("Adjust the slider:"));
        frame.add(slider);

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        frame.add(submitButton);

        frame.setSize(400, 400);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new guicontrol();
    }
}
