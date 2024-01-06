import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SimpleAnimationDemo extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.createTimer();
        primaryStage.show();
    }

    private void createTimer()
    {
        Timeline timeline = new Timeline( new KeyFrame( Duration.millis(500), new Tick() ) );

        timeline.setCycleCount( Timeline.INDEFINITE );
        timeline.play();
    }

    public static void main(String[] args)
    {
        Application.launch( args );
    }

    class Tick implements EventHandler<ActionEvent>
    {
        public void handle( ActionEvent e )
        {
            System.out.println("Timer ticked");
        }
    }
}