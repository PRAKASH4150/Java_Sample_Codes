import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationExample  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Timeline timeLine=new Timeline(new KeyFrame(Duration.millis(1000),new Tick()));
        timeLine.setCycleCount(5);
        timeLine.play();
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch();
    }

    public class Tick implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("Tick method Invoked");
        }
    }
}
