import javax.swing.*;
import java.awt.*;

public class border_layout {
    JFrame frame;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;

    border_layout() {
        frame = new JFrame("border layout");
        button1 = new JButton("LEFT");
        button2 = new JButton("RIGHT");
        button3 = new JButton("TOP");
        button4 = new JButton("BOTTOM");
        button5 = new JButton("CENTER");


        frame.add(button1, BorderLayout.WEST);
        frame.add(button2, BorderLayout.EAST);
        frame.add(button3, BorderLayout.NORTH);
        frame.add(button4, BorderLayout.SOUTH);
        frame.add(button5, BorderLayout.CENTER);


        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new border_layout();
    }
}
