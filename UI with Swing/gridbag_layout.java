import javax.swing.*;
import java.awt.*;

public class gridbag_layout {
    JFrame frame;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;

    gridbag_layout() {
        frame = new JFrame("gridbag layout");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");

        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL; // Makes the buttons stretch horizontally

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(button1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(button2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(button3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(button4, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(button5, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(button6, gbc);

        frame.setSize(500, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new gridbag_layout();
    }
}
