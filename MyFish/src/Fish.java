/**
 * Fish.java: This file contains the code
 * to draw a Fish developed using Java FX.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10/26/2023
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class Fish extends Application implements FishFeatures {
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

        Label coordinatesLabel = new Label("Mouse Coordinates: (X, Y)");
        Pane pane=new Pane(coordinatesLabel);
        pane.getChildren().add(drawBody());
        pane.getChildren().add(drawTail());
        pane.getChildren().add(drawUpperDorsalFin());
        pane.getChildren().add(drawUpperLaterFin());
        pane.getChildren().add(drawLowerDorsalFin());
        pane.getChildren().add(drawLowerLateralFin());
        pane.getChildren().add(drawMouth());
        pane.getChildren().addAll(drawTeeth());
        pane.getChildren().add(drawEye());
        pane.getChildren().add(drawGills());
        pane.getChildren().add(drawPectoralFin());
        pane.getChildren().addAll(drawBodyMarks());
        pane.getChildren().addAll(drawBubbles());
        pane.setStyle("-fx-background-color: blue;");
        Scene scene=new Scene(pane,1000,1000);
        scene.setOnMouseMoved(event -> {
            double mouseX = event.getSceneX();
            double mouseY = event.getSceneY();
            coordinatesLabel.setText("Mouse Coordinates: (" + mouseX + ", " + mouseY + ")");
        });

        stage.setScene(scene);
        stage.setTitle("MY FISH");
        stage.show();

    }

    /**
     *
     * @return Ellipse instance as a body
     */
    public Ellipse drawBody()
    {
        Ellipse body=new Ellipse(650,500,370,180);
        body.setStroke(Color.BLACK);
        body.setFill(Color.YELLOW);
        body.setStrokeWidth(7.0);
        return body;
    }

    /**
     *
     * @return polygon instance as a Tail.
     */
    public Polygon drawTail(){
        Polygon tail=new Polygon(1022,494,1134,361,1104,491,1145,607);
        tail.setFill(Color.ORANGE);
        tail.setStroke(Color.BLACK);
        tail.setStrokeWidth(7.0);
        return tail;
    }

    /**
     *
     * @return polygon instance as a upper Dorsal fin
     */
    public Polygon drawUpperDorsalFin()
    {
        Polygon upperDorsalFin=new Polygon(472,345,610,180,601,323);
        upperDorsalFin.setFill(Color.GREEN);
        upperDorsalFin.setStroke(Color.BLACK);
        upperDorsalFin.setStrokeWidth(7.0);
        return upperDorsalFin;
    }

    /**
     *
     * @return Polygon as upper lateral fin
     */
    public Polygon drawUpperLaterFin(){
        Polygon upperLateralFin=new Polygon(846,345,966,316,963,407);
        upperLateralFin.setFill(Color.GREEN);
        upperLateralFin.setStroke(Color.BLACK);
        upperLateralFin.setStrokeWidth(7.0);
        return upperLateralFin;
    }

    /**
     *
     * @return polygon instance as a lower dorsal fin
     */
    public Polygon drawLowerDorsalFin()
    {
        Polygon lowerDorsalFin=new Polygon(471,656,589,680,571,811);
        lowerDorsalFin.setFill(Color.GREEN);
        lowerDorsalFin.setStroke(Color.BLACK);
        lowerDorsalFin.setStrokeWidth(7.0);
        return lowerDorsalFin;
    }


    /**
     *
     * @return returns polygon as lower lateral fin
     */
    public Polygon drawLowerLateralFin(){
        Polygon loewerLateralFin=new Polygon(875,645,963,598,981,658);
        loewerLateralFin.setFill(Color.GREEN);
        loewerLateralFin.setStroke(Color.BLACK);
        loewerLateralFin.setStrokeWidth(7.0);
        return loewerLateralFin;
    }

    /**
     *
     * @return polygon instance as a pectoral fin
     */
    public Polygon drawPectoralFin()
    {
        Polygon gills=new Polygon(513,493,603,549,602,429);
        gills.setFill(Color.DARKRED);
        gills.setStroke(Color.BLACK);
        gills.setStrokeWidth(7.0);
        return gills;
    }

    /**
     *
     * @return circle instance as the eye
     */
    public Circle drawEye() {
        Circle eye=new Circle(346,472,8);
        eye.setFill(Color.BLACK);
        eye.setStroke(Color.BLACK);
        eye.setStrokeWidth(3.0);
        return eye;
    }

    /**
     *
     * @return mouth instance as mouth
     */
    public Polygon drawMouth()
    {
        Polygon mouth=new Polygon(288,528,328,532,305,562);
        mouth.setFill(Color.BLACK);
        mouth.setStroke(Color.BLACK);
        mouth.setStrokeWidth(3.0);
        return mouth;
    }

    /**
     *
     * @return List of polygon instances as teeth
     */
    public List<Polygon> drawTeeth()
    {
        List<Polygon> tooth=new ArrayList<>();
        Polygon teeth1=new Polygon(293,526,298,534,303,527);
        teeth1.setFill(Color.WHITE);
        teeth1.setStroke(Color.WHITE);
        Polygon teeth2=new Polygon(309,555,308,542,317,547);
        teeth2.setFill(Color.WHITE);
        teeth2.setStroke(Color.WHITE);
        tooth.add(teeth1);
        tooth.add(teeth2);
        return tooth;
    }

    /**
     *
     * @return Quad curve instance as gills
     */
    public QuadCurve drawGills()
    {
        QuadCurve quadCurve = new QuadCurve(416, 364, 451,501,434,644);
        quadCurve.setStroke(Color.BLACK);
        quadCurve.setFill(Color.RED);
        quadCurve.setStrokeWidth(2);
        return quadCurve;
    }

    /**
     *
     * @return List of circle as body marks instance
     */
    public List<Circle> drawBodyMarks()
    {
        List<Circle> bubbles=new ArrayList<>();
        Circle bubble1=new Circle(457,396,10);
        bubble1.setFill(Color.GRAY);
        bubble1.setStroke(Color.BLACK);
        Circle bubble2=new Circle(556,362,10);
        bubble2.setFill(Color.GRAY);
        bubble2.setStroke(Color.BLACK);
        Circle bubble3=new Circle(667,354,10);
        bubble3.setFill(Color.GRAY);
        bubble3.setStroke(Color.BLACK);
        Circle bubble4=new Circle(767,369,10);
        bubble4.setFill(Color.GRAY);
        bubble4.setStroke(Color.BLACK);
        Circle bubble5=new Circle(892,412,10);
        bubble5.setFill(Color.GRAY);
        bubble5.setStroke(Color.BLACK);
        Circle bubble6=new Circle(980,477,10);
        bubble6.setFill(Color.GRAY);
        bubble6.setStroke(Color.BLACK);
        Circle bubble7=new Circle(856,480,10);
        bubble7.setFill(Color.GRAY);
        bubble7.setStroke(Color.BLACK);
        Circle bubble8=new Circle(740,472,10);
        bubble8.setFill(Color.GRAY);
        bubble8.setStroke(Color.BLACK);
        Circle bubble9=new Circle(628,471,10);
        bubble9.setFill(Color.GRAY);
        bubble9.setStroke(Color.BLACK);
        Circle bubble10=new Circle(467,495,10);
        bubble10.setFill(Color.GRAY);
        bubble10.setStroke(Color.BLACK);
        Circle bubble11=new Circle(466,610,10);
        bubble11.setFill(Color.GRAY);
        bubble11.setStroke(Color.BLACK);
        Circle bubble12=new Circle(569,633,10);
        bubble12.setFill(Color.GRAY);
        bubble12.setStroke(Color.BLACK);
        Circle bubble13=new Circle(702,630,10);
        bubble13.setFill(Color.GRAY);
        bubble13.setStroke(Color.BLACK);
        Circle bubble14=new Circle(852,590,10);
        bubble14.setFill(Color.GRAY);
        bubble14.setStroke(Color.BLACK);
        bubbles.add(bubble1);
        bubbles.add(bubble2);
        bubbles.add(bubble3);
        bubbles.add(bubble4);
        bubbles.add(bubble5);
        bubbles.add(bubble6);
        bubbles.add(bubble7);
        bubbles.add(bubble8);
        bubbles.add(bubble9);
        bubbles.add(bubble10);
        bubbles.add(bubble11);
        bubbles.add(bubble12);
        bubbles.add(bubble13);
        bubbles.add(bubble14);
        return bubbles;
    }

    /**
     *
     * @return list of circle instance as bubbles
     */
    public List<Circle> drawBubbles()
    {
        List<Circle> bubbles=new ArrayList<>();
        Circle bubble1=new Circle(245,510,15);
        bubble1.setFill(Color.WHITE);
        bubble1.setStroke(Color.BLACK);
        bubble1.setStrokeWidth(7.0);
        Circle bubble2=new Circle(222,393,25);
        bubble2.setFill(Color.WHITE);
        bubble2.setStroke(Color.BLACK);
        bubble2.setStrokeWidth(7.0);
        Circle bubble3=new Circle(209,262,35);
        bubble3.setFill(Color.WHITE);
        bubble3.setStroke(Color.BLACK);
        bubble3.setStrokeWidth(7.0);
        bubbles.add(bubble1);
        bubbles.add(bubble2);
        bubbles.add(bubble3);
        return bubbles;
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
