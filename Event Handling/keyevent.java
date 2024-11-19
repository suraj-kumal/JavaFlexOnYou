import javax.swing.*;
import java.awt.event.*;

public class keyevent {
    JFrame frame;
    JLabel label;
    JTextArea textArea;

    keyevent() {
        frame = new JFrame("Key Events Example");
        label = new JLabel("Words: 0 Characters: 0");
        label.setBounds(20, 50, 300, 20);
        textArea = new JTextArea();
        textArea.setBounds(20, 80, 350, 300);

        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = textArea.getText();
                String[] words = text.split("\\s");
                label.setText("Words: " + words.length + " Characters: " + text.length());
            }
        });

        frame.add(label);
        frame.add(textArea);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new keyevent();
    }
}
