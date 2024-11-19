import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class optiondialogs {

    JFrame frame;
    JButton btnMessage, btnConfirm, btnInput;

    optiondialogs() {

        frame = new JFrame("Option Dialogs Example");

        btnMessage = new JButton("Show Message");
        btnMessage.setBounds(50, 30, 200, 40);
        btnMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "This is a simple message.");
            }
        });


        btnConfirm = new JButton("Show Confirm");
        btnConfirm.setBounds(50, 80, 200, 40);
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(frame, "Do you want to continue?");
                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "You clicked Yes");
                } else {
                    JOptionPane.showMessageDialog(frame, "You clicked No");
                }
            }
        });


        btnInput = new JButton("Show Input");
        btnInput.setBounds(50, 130, 200, 40);
        btnInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter your name:");
                JOptionPane.showMessageDialog(frame, "Hello, " + name);
            }
        });


        frame.add(btnInput);
        frame.add(btnConfirm);
        frame.add(btnMessage);

        frame.setSize(325, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new optiondialogs();
    }
}
