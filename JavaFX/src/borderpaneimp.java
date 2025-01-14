import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class borderpaneimp extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        borderPane.setTop(new Button("Top"));
        borderPane.setLeft(new Button("Left"));
        borderPane.setCenter(new Button("Center"));
        borderPane.setRight(new Button("Right"));
        borderPane.setBottom(new Button("Bottom"));

        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setTitle("BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
