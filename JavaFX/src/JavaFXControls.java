import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class JavaFXControls extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Label
        Label label = new Label("JavaFX UI Controls Example");

        // TextField
        TextField textField = new TextField();
        textField.setPromptText("Enter your name");

        // Button
        Button button = new Button("Submit");
        button.setOnAction(event -> {
            String name = textField.getText();
            if (!name.isEmpty()) {
                label.setText("Hello, " + name + "!");
            } else {
                label.setText("Please enter your name!");
            }
        });

        // RadioButton
        RadioButton rb1 = new RadioButton("Option 1");
        RadioButton rb2 = new RadioButton("Option 2");
        ToggleGroup toggleGroup = new ToggleGroup();
        rb1.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);

        // CheckBox
        CheckBox checkBox = new CheckBox("I agree to the terms and conditions");

        // Hyperlink
        Hyperlink hyperlink = new Hyperlink("Click here for more information");
        hyperlink.setOnAction(event -> label.setText("You clicked the hyperlink!"));

        // Tooltip
        Tooltip tooltip = new Tooltip("This is a button to submit your name");
        Tooltip.install(button, tooltip);

        // Menu
        Menu menu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        menu.getItems().addAll(openMenuItem, saveMenuItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        // FileChooser
        Button fileChooserButton = new Button("Choose File");
        fileChooserButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                label.setText("Selected file: " + file.getAbsolutePath());
            }
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(
                menuBar,
                label,
                textField,
                button,
                rb1, rb2,
                checkBox,
                hyperlink,
                fileChooserButton
        );

        // Scene and Stage
        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setTitle("JavaFX Controls Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
