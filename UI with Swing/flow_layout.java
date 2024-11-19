import javax.swing.*;
import java.awt.*;

public class flow_layout {
    JFrame frame;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;


    flow_layout() {
        frame = new JFrame("flow layout");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");


        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new flow_layout();
    }
}
