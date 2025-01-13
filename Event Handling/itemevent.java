import javax.swing.*;
import java.awt.event.*;

public class itemevent {
    JFrame frame;
    JLabel label;
    JCheckBox checkBox;
    JComboBox<String> comboBox;
    JTextField textField;

    itemevent() {
        frame = new JFrame("Item event");
        label = new JLabel("Select an option:");
        label.setBounds(20, 20, 200, 20);

        checkBox = new JCheckBox("Enable Combo Box");
        checkBox.setBounds(20, 50, 200, 20);

        comboBox = new JComboBox<>();
        comboBox.setBounds(20, 80, 200, 30);

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) {
                    comboBox.setEnabled(true);
                    label.setText("Select your favorite Waifu:");
                    updateComboBox("Waifu");
                } else {
                    comboBox.setEnabled(false);
                    label.setText("Select an option:");
                    comboBox.removeAllItems();
                }
            }
        });

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (comboBox.getSelectedItem() != null) {
                    textField.setText("You selected: " + comboBox.getSelectedItem());
                }
            }
        });

        textField = new JTextField();
        textField.setBounds(20, 120, 250, 30);
        textField.setEditable(false);

        frame.add(label);
        frame.add(checkBox);
        frame.add(comboBox);
        frame.add(textField);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateComboBox(String category) {
        comboBox.removeAllItems();

        if (category.equals("waifu")) {
            comboBox.addItem("Nezuko Chyaan");
            comboBox.addItem("Alya kujou");
            comboBox.addItem("Masha");
            comboBox.addItem("Mirajane");
            comboBox.addItem("Zero Two");
            comboBox.addItem("Fubuki");
            comboBox.addItem("kurumi");
        }
    }

    public static void main(String[] args) {
        new itemevent();
    }
}
