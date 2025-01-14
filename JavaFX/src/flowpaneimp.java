import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class flowpaneimp extends Application {
    @Override
    public void start(Stage primaryStage) {
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.getChildren().addAll(
                new Button("Button 1"),
                new Button("Button 2"),
                new Button("Button 3"),
                new Button("Button 4"),
                new Button("Button 5")
        );

        Scene scene = new Scene(flowPane, 300, 200);
        primaryStage.setTitle("FlowPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
