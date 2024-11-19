import javax.swing.*;

public class UIframe {
    JFrame frame;
    JButton button;

    public UIframe() {
        frame = new JFrame();
        button = new JButton("Click");
        frame.setBounds(100, 100, 400, 500);
        button.setBounds(150, 200, 100, 50);
        frame.add(button);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UIframe();
    }
}
