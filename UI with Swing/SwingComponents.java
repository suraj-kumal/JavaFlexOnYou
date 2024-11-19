import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.table.*;
import javax.swing.tree.*;

public class SwingComponents {
    JFrame frame;
    JButton button;
    JTable table;
    JTree tree;
    JFileChooser fileChooser;
    JColorChooser colorChooser;
    JInternalFrame internalFrame;

    public SwingComponents() {
        frame = new JFrame("Swing Components");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        button = new JButton("choose a  file");
        button.setBounds(50, 50, 150, 40);
        frame.add(button);

        String[] columns = {"ID", "Name", "Age"};
        Object[][] data = {
                {1, "Suraj", 22},
                {2, "Raden", 18},
                {3, "Nezuko", 14}
        };
        table = new JTable(data, columns);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBounds(50, 120, 300, 150);
        frame.add(tableScroll);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Node 1");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Node 2");
        root.add(node1);
        root.add(node2);
        tree = new JTree(root);
        JScrollPane treeScroll = new JScrollPane(tree);
        treeScroll.setBounds(400, 120, 200, 150);
        frame.add(treeScroll);

        fileChooser = new JFileChooser();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(frame, "Selected file: " + file.getAbsolutePath());
                }
            }
        });

        colorChooser = new JColorChooser();
        JButton colorButton = new JButton("Pick Color");
        colorButton.setBounds(50, 300, 150, 40);
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = colorChooser.showDialog(frame, "Choose a Color", Color.WHITE);
                if (color != null) {
                    frame.getContentPane().setBackground(color);
                }
            }
        });
        frame.add(colorButton);

        internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
        internalFrame.setBounds(200, 250, 300, 200);
        internalFrame.setVisible(true);
        frame.add(internalFrame);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingComponents();
            }
        });
    }
}
