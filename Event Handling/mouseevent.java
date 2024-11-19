import javax.swing.*;
import java.awt.event.*;

public class mouseevent {
    JFrame frame;
    JLabel label;
    JPanel panel;

    mouseevent() {
        frame = new JFrame("Mouse Events Example");
        label = new JLabel("Mouse Events: None");
        label.setBounds(20, 50, 400, 20);

        panel = new JPanel();
        panel.setBounds(20, 80, 350, 300);
        panel.setBackground(java.awt.Color.LIGHT_GRAY);

        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at: X=" + e.getX() + " Y=" + e.getY());
            }

            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed at: X=" + e.getX() + " Y=" + e.getY());
            }

            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released at: X=" + e.getX() + " Y=" + e.getY());
            }

            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered the panel");
            }

            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited the panel");
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                label.setText("Mouse Moved at: X=" + e.getX() + " Y=" + e.getY());
            }

            public void mouseDragged(MouseEvent e) {
                label.setText("Mouse Dragged at: X=" + e.getX() + " Y=" + e.getY());
            }
        });

        frame.add(label);
        frame.add(panel);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new mouseevent();
    }
}
