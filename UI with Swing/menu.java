import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu {
    JFrame frame;
    JButton button;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu;
    JMenuItem newItem, openItem, saveItem, cutItem, copyItem, pasteItem;
    JCheckBoxMenuItem checkItem;
    JRadioButtonMenuItem radioItem1, radioItem2;
    JToolBar toolBar;
    JPopupMenu popUpMenu;

    public menu() {
        frame = new JFrame("Swing Menu Example");
        button = new JButton("Click Me!");

        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        button.setBounds(200, 200, 150, 50);
        button.setToolTipText("This is a button. Click me!");

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");

        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);

        editMenu = new JMenu("Edit");
        cutItem = new JMenuItem("Cut");
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");

        checkItem = new JCheckBoxMenuItem("Enable Option");
        radioItem1 = new JRadioButtonMenuItem("Option 1");
        radioItem2 = new JRadioButtonMenuItem("Option 2");

        ButtonGroup group = new ButtonGroup();
        group.add(radioItem1);
        group.add(radioItem2);

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.addSeparator();
        editMenu.add(checkItem);
        editMenu.add(radioItem1);
        editMenu.add(radioItem2);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

        toolBar = new JToolBar();
        JButton cutButton = new JButton(new ImageIcon("cut-icon.png"));
        JButton copyButton = new JButton(new ImageIcon("copy-icon.png"));
        toolBar.add(cutButton);
        toolBar.add(copyButton);
        frame.add(toolBar, BorderLayout.NORTH);

        popUpMenu = new JPopupMenu();
        JMenuItem popupItem1 = new JMenuItem("Popup Item 1");
        JMenuItem popupItem2 = new JMenuItem("Popup Item 2");

        popUpMenu.add(popupItem1);
        popUpMenu.add(popupItem2);

        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popUpMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popUpMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        frame.add(button);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new menu();
    }
}
