import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Todo extends JFrame {

    private JTextField taskInputField;
    private final JList<String> taskList;
    private final DefaultListModel<String> listModel;
    private static final Logger LOGGER = Logger.getLogger(Todo.class.getName());

    private static final String URL = "jdbc:mysql://localhost:3306/todo_app";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Custom colors
    private static final Color PRIMARY_COLOR = new Color(70, 130, 180); // Steel blue
    private static final Color BACKGROUND_COLOR = new Color(240, 240, 240);
    private static final Color BUTTON_TEXT_COLOR = new Color(51, 51, 51); // Dark gray for better visibility
    private static final Color BUTTON_HOVER_COLOR = new Color(230, 230, 230); // Light gray for hover
    private static final Color BORDER_COLOR = new Color(200, 200, 200); // Light gray for borders

    public Todo() {
        setTitle("Todo Manager");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(BACKGROUND_COLOR);

        // Create main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Input panel with modern styling
        JPanel inputPanel = createStyledInputPanel();

        // Task list with custom renderer
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        taskList.setFixedCellHeight(40);
        taskList.setCellRenderer(new CustomListCellRenderer());

        // Styled scroll pane
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 1));
        scrollPane.setBackground(Color.WHITE);

        // Action buttons panel
        JPanel actionPanel = createStyledActionPanel();

        // Add components to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(actionPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Load initial tasks
        try {
            loadTasks();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error connecting to the database.", e);
            showErrorDialog("Database Connection Error", "Could not connect to the database. Please check your connection settings.");
        }
    }

    private JPanel createStyledInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBackground(BACKGROUND_COLOR);

        // Styled label
        JLabel taskLabel = new JLabel("New Task:");
        taskLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        taskLabel.setForeground(PRIMARY_COLOR);

        // Styled text field
        taskInputField = new JTextField(20);
        taskInputField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        taskInputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Styled button
        JButton addButton = createStyledButton("Add Task", "plus");

        inputPanel.add(taskLabel, BorderLayout.WEST);
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Add action listener
        addButton.addActionListener(e -> SwingUtilities.invokeLater(this::addTask));

        return inputPanel;
    }

    private JPanel createStyledActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        actionPanel.setBackground(BACKGROUND_COLOR);

        JButton markDoneButton = createStyledButton("Mark Complete", "check");
        JButton deleteButton = createStyledButton("Delete", "trash");

        actionPanel.add(markDoneButton);
        actionPanel.add(deleteButton);

        // Add action listeners
        markDoneButton.addActionListener(e -> SwingUtilities.invokeLater(this::markTaskDone));
        deleteButton.addActionListener(e -> SwingUtilities.invokeLater(this::deleteTask));

        return actionPanel;
    }

    private JButton createStyledButton(String text, String iconName) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR),
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(BUTTON_HOVER_COLOR);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.WHITE);
            }
        });

        return button;
    }

    private void showErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(this,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }

    // Custom ListCellRenderer for better-looking tasks
    private class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Custom styling
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            // Status-based styling
            String text = value.toString();
            if (text.contains("(Done)")) {
                label.setForeground(new Color(0, 128, 0));
            } else {
                label.setForeground(Color.BLACK);
            }

            if (!isSelected) {
                label.setBackground(Color.WHITE);
            }

            return label;
        }
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }

    private void loadTasks() throws SQLException {
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks ORDER BY id ASC");
            listModel.clear();
            while (rs.next()) {
                String task = rs.getString("task");
                String status = rs.getString("status");
                listModel.addElement(task + " (" + status + ")");
            }
        }
    }

    private void addTask() {
        String task = taskInputField.getText().trim();
        if (!task.isEmpty()) {
            try (Connection connection = getConnection();
                 PreparedStatement ps = connection.prepareStatement("INSERT INTO tasks (task, status) VALUES (?, ?)")) {
                ps.setString(1, task);
                ps.setString(2, "Pending");
                ps.executeUpdate();
                loadTasks();
                taskInputField.setText("");
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error adding task.", e);
                showErrorDialog("Error", "Could not add task to database.");
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Please enter a task description.",
                    "Task Required",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void markTaskDone() {
        String selectedTask = taskList.getSelectedValue();
        if (selectedTask != null) {
            String task = selectedTask.split(" \\(")[0];
            try (Connection connection = getConnection();
                 PreparedStatement ps = connection.prepareStatement("UPDATE tasks SET status = ? WHERE task = ?")) {
                ps.setString(1, "Done");
                ps.setString(2, task);
                ps.executeUpdate();
                loadTasks();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error marking task as done.", e);
                showErrorDialog("Error", "Could not update task status.");
            }
        }
    }

    private void deleteTask() {
        String selectedTask = taskList.getSelectedValue();
        if (selectedTask != null) {
            String task = selectedTask.split(" \\(")[0];
            try (Connection connection = getConnection();
                 PreparedStatement ps = connection.prepareStatement("DELETE FROM tasks WHERE task = ?")) {
                ps.setString(1, task);
                ps.executeUpdate();
                loadTasks();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error deleting task.", e);
                showErrorDialog("Error", "Could not delete task from database.");
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not set system look and feel.", e);
        }

        SwingUtilities.invokeLater(() -> {
            Todo app = new Todo();
            app.setVisible(true);
        });
    }
}