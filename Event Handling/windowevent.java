import javax.swing.*;
import java.awt.event.*;

public class windowevent {
    JFrame frame;
    JLabel label;

    windowevent() {
        frame = new JFrame("Window Events Example");
        label = new JLabel("Window Events Example");
        label.setBounds(20, 50, 300, 20);

        frame.add(label);
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                label.setText("Window Opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                label.setText("Window is Closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                label.setText("Window Closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                label.setText("Window Minimized");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                label.setText("Window Restored");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                label.setText("Window Activated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                label.setText("Window Deactivated");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new windowevent();
    }
}
