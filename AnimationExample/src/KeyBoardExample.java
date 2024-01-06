import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KeyBoardExample extends Application implements EventHandler<KeyEvent> {

    Label displayLabel=new Label("No Key is Pressed");
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane=new Pane();
        pane.getChildren().add(displayLabel);
        Scene scene=new Scene(pane);
        scene.setOnKeyPressed(this);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Key board event");
        primaryStage.show();
    }

    @Override
    public void handle(KeyEvent event) {

        displayLabel.setText("Key Pressed is "+event.getCode());
        displayLabel.setStyle("-fx-font-size: 50px");
        displayLabel.setTextFill(Color.RED);
    }

    public static void main(String[] args)
    {
        Application.launch();
    }
}
