import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EllipseAnimation extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int ELLIPSE_RADIUS_X = 20;

    Ellipse ellipse;

    double direction = 1;


    @Override
    public void start(Stage primaryStage) {
        ellipse = new Ellipse(ELLIPSE_RADIUS_X, ELLIPSE_RADIUS_X);
        ellipse.setFill(Color.BLUE);

        // Set initial position
        ellipse.setCenterX(ELLIPSE_RADIUS_X);
        ellipse.setCenterY(HEIGHT / 2.0);

        // Create a pane and add the ellipse to it
        Pane pane = new Pane();
        pane.getChildren().add(ellipse);

        // Create a timeline animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1), new TimerHandler())
        );

        // Set the animation to repeat indefinitely
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Create a scene and add the pane to it
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        // Set up the stage
        primaryStage.setTitle("Ellipse Animation");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the animation
        timeline.play();
    }
    public static void main(String[] args) {
        launch(args);
    }

    class TimerHandler implements EventHandler<ActionEvent>
    {
        public void handle( ActionEvent event)
        {
            if( ( ellipse.getCenterX() + ELLIPSE_RADIUS_X + direction ) > WIDTH )
            {
                direction = -1;
                speedFactor *= 0.9;
            }
            else if( ( ellipse.getCenterX() - ELLIPSE_RADIUS_X + direction <= 0 ) )
            {
                direction = 1;
            }

            ellipse.setCenterX( ellipse.getCenterX() + direction );
        }
    }
}
