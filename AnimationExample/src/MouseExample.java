import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MouseExample extends Application implements EventHandler<MouseEvent> {

    Label textLabel=new Label();
    public static void main(String[] args)
    {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root=new Pane();
        root.getChildren().add(textLabel);
        Scene scene=new Scene(root);
        scene.setOnMouseMoved(this);
        scene.setOnMouseClicked(this);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MouseEvent");
        primaryStage.show();
    }

    @Override
    public void handle(MouseEvent event) {
            double xCordinate=event.getX();
            double yCordinate=event.getY();
            int clickCount=  event.getClickCount();

            textLabel.setText("X:"+xCordinate+",Y:"+yCordinate+":Click Count:"+clickCount);

    }
}
