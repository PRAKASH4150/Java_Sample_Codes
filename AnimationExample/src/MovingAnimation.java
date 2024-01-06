import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MovingAnimation extends Application {

    private Circle circle;
    private final int WIDTH=500;
    private final int HEIGHT=500;
    private final int RADIUS=20;
    private int direction=1;
    private double speedFactor = 1.0;
    private int speed=100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        circle =new Circle();
        circle.setCenterX((double)WIDTH/2);
        circle.setCenterY((double)HEIGHT/2);
        circle.setRadius(RADIUS);
        circle.setFill(Color.BLUE);

        Timeline timeLine=new Timeline(new KeyFrame(Duration.millis(speed),new AnimatedEvent()));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        Pane pane=new Pane();
        pane.getChildren().addAll(circle);
        Scene scene=new Scene(pane,WIDTH,HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Moving Animation");
        primaryStage.setResizable(false);
        timeLine.play();
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        Application.launch();
    }

    public class AnimatedEvent implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {
            if(circle.getCenterX()+RADIUS>WIDTH)
            {
                direction=-1;
                speedFactor *= 0.9;
            }
            else if(circle.getCenterX()+RADIUS<=0)
            {
                direction=1;

            }
            circle.setCenterX(circle.getCenterX()+direction);
            ((Timeline) event.getSource()).getKeyFrames().set(0, new KeyFrame(Duration.millis(speed *speedFactor), this));
        }
    }
}
