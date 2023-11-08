/**
 * GraphicalHouse.java. This file contains the
 * graphical representation of a house drawn using
 * Java FX.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10/26/2023
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class GraphicalHouse extends Application {

    /**
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        Pane pane=new Pane();
        pane.getChildren().add(drawBody());
        pane.getChildren().add(drawRoof());
        pane.getChildren().add(drawDoor());
        pane.getChildren().add(drawDoorKnob());
        Scene scene=new Scene(pane,1000,1000);
        stage.setScene(scene);
        stage.setTitle("MY HOUSE");
        stage.show();
    }

    /**
     * @return - Rectangle instance which forms the body
     */
    public Rectangle drawBody()
    {
        Rectangle body=new Rectangle(750,500);
        body.setX(560);
        body.setY(425);
        body.setFill(Color.RED);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(7.0);
        return body;
    }

    /**
     * @return Rectangle instance which forms roof.
     */
    public Rectangle drawRoof()
    {
        Rectangle roof=new Rectangle(1000,75);
        roof.setX(428);
        roof.setY(344);
        roof.setFill(Color.BLACK);
        roof.setStroke(Color.BLACK);
        roof.setStrokeWidth(7.0);
        return roof;
    }

    /**
     * @return -Rectangle instance which forms the door.
     */
    public Rectangle drawDoor()
    {
        Rectangle door=new Rectangle(100,250);
        door.setX(882);
        door.setY(675);
        door.setFill(Color.BLACK);
        door.setStrokeWidth(7.0);
        return door;
    }

    /**
     *
     * @return Circle instance which forms the door knob.
     */
    public Circle drawDoorKnob()
    {
        Circle doorKnob=new Circle(956,802,10);
        doorKnob.setFill(Color.WHITE);
        doorKnob.setStroke(Color.BLACK);
        doorKnob.setStrokeWidth(3.0);
        return doorKnob;
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
