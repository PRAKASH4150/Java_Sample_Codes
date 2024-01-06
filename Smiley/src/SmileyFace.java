import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * SmileyFace.java: This program is used to draw
 * a smiley face on to the screen.
 * The face will contain two eyes and smile.
 *
 * @author Sai Surya Prakash Moka
 * @date 12/14/2023
 */
public class SmileyFace extends Application {

    private final int WINDOW_WIDTH=400;
    private final int WINDOW_HEIGHT=400;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root=new Pane();
        root.getChildren().addAll(drawFace(),drawEyes().get(0),
                drawEyes().get(1),drawMouth());
        Scene scene=new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Smiley");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Shape drawFace()
    {
        Circle face=new Circle();
        face.setCenterX((double)WINDOW_WIDTH/2);
        face.setCenterY((double)WINDOW_HEIGHT/2);
        face.setRadius(150);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.BLACK);
        face.setStrokeWidth(10);
        return face;
    }

    public List<Shape> drawEyes()
    {
        List<Shape> eyes=new ArrayList<>();
        Circle eye1=new Circle();
        eye1.setCenterX(127);
        eye1.setCenterY(167);
        eye1.setRadius(20);
        eye1.setFill(Color.BLACK);
        eye1.setStrokeWidth(5);

        Circle eye2=new Circle();
        eye2.setCenterX(271);
        eye2.setCenterY(165);
        eye2.setRadius(20);
        eye2.setFill(Color.BLACK);
        eye2.setStrokeWidth(5);
        eyes.add(eye1);
        eyes.add(eye2);
        return eyes;
    }

    public Shape drawMouth(){
        Arc smile = new Arc(198, 260, 75, 50, 0, -180);
        smile.setType(ArcType.OPEN);
        smile.setStroke(Color.BLACK);
        smile.setStrokeWidth(5);
        smile.setFill(Color.TRANSPARENT);
        return smile;

    }

    public static void main(String[] args)
    {
        Application.launch();
    }


}
