import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class gridpane extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Adding components to the grid
        gridPane.add(new Button("Button 1"), 0, 0); // Column 0, Row 0
        gridPane.add(new Button("Button 2"), 1, 0); // Column 1, Row 0
        gridPane.add(new Button("Button 3"), 0, 1); // Column 0, Row 1
        gridPane.add(new Button("Button 4"), 1, 1); // Column 1, Row 1

        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setTitle("GridPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
