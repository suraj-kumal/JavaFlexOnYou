import javax.swing.*;
import java.awt.*;

public class grid_layout {
    JFrame frame;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton button10;
    JButton button11;
    JButton button12;


    grid_layout() {
        frame = new JFrame("grid layout");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button10 = new JButton("10");
        button11 = new JButton("11");
        button12 = new JButton("12");


        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button10);
        frame.add(button11);
        frame.add(button12);


        frame.setLayout(new GridLayout(3, 4));
        frame.setSize(600, 600);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new grid_layout();
    }
}
