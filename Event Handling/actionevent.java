import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionevent {
    JFrame frame;
    JButton button;

    actionevent() {
        frame = new JFrame();
        button = new JButton("Click");

        button.setBounds(150, 200, 100, 50);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button was clicked!");
            }
        });
        frame.setSize(400, 500);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new actionevent();
    }
}
