import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class vbox extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(10); // Spacing between elements
        vbox.getChildren().addAll(
                new Button("Button 1"),
                new Button("Button 2"),
                new Button("Button 3")
        );

        Scene scene = new Scene(vbox, 200, 150);
        primaryStage.setTitle("VBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
