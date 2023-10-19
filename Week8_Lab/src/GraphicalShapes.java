/**
 * GraphicalShapes.java: This class leverages the use of
 * JavaFX to display basic shapes on the screen.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10-19-2023.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class GraphicalShapes extends Application implements Graphical2DShapes{


    /**
     * @param stage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage stage)
    {
        Pane pane=new Pane();
        pane.getChildren().add(drawLine(0,0,255,255, Color.RED));
        pane.getChildren().add(drawRectangle(170,100,100,30,Color.GREEN));
        pane.getChildren().add(drawCircle(1000,500,200,Color.BLUE));
        pane.getChildren().add(drawEllipse(1500,400,150,200,Color.MAGENTA));
        pane.getChildren().add(drawTriangle(300,50,450,150,300,250,Color.PINK));
        pane.getChildren().add(drawQuadrilateral(600,250,150,300,600,450,700,680,Color.MAROON));
        pane.getChildren().add(drawPentagon(200,750,150,Color.SKYBLUE));
        pane.getChildren().add(drawArc(750, 980, 300, 300, 45, 90,Color.BLACK));
        pane.getChildren().add(drawHexagon(1500,750,150,Color.YELLOW));
        pane.getChildren().add(drawRectangle(650,50,250,250,Color.SKYBLUE));
        Scene scene=new Scene(pane,1000,1000);
        stage.setScene(scene);
        stage.setTitle("2-D Shapes");
        stage.show();
    }

    /**
     *
     * @param startX - Starting X Co-ordinate
     * @param startY - Starting Y Co-ordinate
     * @param endX - Ending X Co-ordinate
     * @param endY - Ending Y Co-ordinate
     * @param color - Color of the line
     * @return Line instance
     */
    @Override
    public Line drawLine(double startX,double startY,double endX,double endY,Color color)
    {
        Line line=new Line(startX,startY,endX,endY);
        line.setStroke(color);
        return line;
    }

    /**
     *
     * @param startX - Starting X Co-ordinate
     * @param startY - Starting Y Co-ordinate
     * @param width - Width of the rectangle
     * @param height - Height of the rectangle
     * @param color - Color to be filled inside the rectangle.
     * @return - Rectangle instance.
     */
    @Override
    public Rectangle drawRectangle(double startX,double startY,double width,double height,Color color)
    {
        Rectangle rectangle=new Rectangle(startX,startY,width,height);
        rectangle.setFill(color);
        return rectangle;
    }

    /**
     *
     * @param centerX - X Co-ordinate of the center
     * @param centerY - Y Co-ordinate of the center
     * @param radius  - Radius of the circle
     * @param color - Color to be filled inside the circle
     * @return Circle instance
     */
    @Override
    public Circle drawCircle(double centerX,double centerY,double radius,Color color)
    {
        Circle circle=new Circle(centerX,centerY,radius);
        circle.setFill(color);
        return circle;
    }

    /**
     *
     * @param centerX - X Co-ordinate of the center
     * @param centerY - Y Co-ordinate of the center
     * @param radiusX - Radius in X direction
     * @param radiusY - Radius in Y direction
     * @param color - Color to be filled inside the ellipse.
     * @return Ellipse instance.
     */
    @Override
    public Ellipse drawEllipse(double centerX,double centerY,double radiusX,double radiusY,Color color)
    {
        Ellipse ellipse=new Ellipse(centerX,centerY,radiusX,radiusY);
        ellipse.setFill(color);
        return ellipse;
    }

    /**
     *
     * @param x1 - X1 Co-ordinate
     * @param y1 - Y1 Co-ordinate
     * @param x2 - X2 Co-ordinate
     * @param y2 - Y2 Co-ordinate
     * @param x3 - X3 Co-ordinate
     * @param y3 - Y3 Co-ordinate
     * @param color - Color to be filled inside the
     * @return Polygon instance.
     */
    @Override
    public Polygon drawTriangle(double x1,double y1,double x2,double y2,double x3,double y3,Color color)
    {
        Polygon polygon=new Polygon();
        polygon.getPoints().addAll(new Double[]{x1,y1,x2,y2,x3,y3});
        polygon.setFill(color);
        return polygon;
    }

    /**
     *
     * @param x1 - X1 Co-ordinate
     * @param y1 - Y1 Co-ordinate
     * @param x2 - X2 Co-ordinate
     * @param y2 - Y2 Co-ordinate
     * @param x3 - X3 Co-ordinate
     * @param y3 - Y3 Co-ordinate
     * @param x4 - X4 Co-ordinate
     * @param y4 - Y4 Co-ordinate
     * @param color - Color to be filled inside the Quadrilateral.
     * @return - Polygon instance
     */
    @Override
    public Polygon drawQuadrilateral(double x1,double y1,double x2,double y2,double x3,double y3,
                                     double x4,double y4,Color color)
    {
        Polygon polygon=new Polygon();
        polygon.getPoints().addAll(new Double[]{x1,y1,x2,y2,x3,y3,x4,y4});
        polygon.setFill(color);
        return polygon;
    }

    /**
     *
     * @param centerX - X Co-ordinate of the center
     * @param centerY - Y Co-ordinate of the center
     * @param sideLength - Length of each side
     * @param color - Color to be filled inside the pentagon
     * @return - Polygon instance.
     */
    @Override
    public Polygon drawPentagon(double centerX, double centerY, double sideLength,Color color) {
        Polygon pentagon = new Polygon();
        for (int i = 0; i < 5; i++) {
            double internalAngle = Math.toRadians(90 + (double) (360 * i) / 5);
            double x = centerX + sideLength * Math.cos(internalAngle);
            double y = centerY - sideLength * Math.sin(internalAngle);
            pentagon.getPoints().addAll(x, y);
        }
        pentagon.setFill(color);
        return pentagon;
    }

    /**
     *
     * @param centerX - X Co-ordinate
     * @param centerY - Y Co-ordinate
     * @param radiusX - Radius X
     * @param radiusY - Radius -Y
     * @param startAngle - Angle to start
     * @param length - Length of the arc
     * @param color - Color to be filled inside the arc.
     * @return Arc instance.
     */
    @Override
    public Arc drawArc(double centerX,double centerY,double radiusX, double radiusY,double startAngle,double length,Color color){
        Arc arc=new Arc(centerX, centerY, radiusX, radiusY, startAngle, length);
        arc.setStroke(color);
        return arc;
    }

    /**
     *
     * @param centerX - X Co-ordinate of the center
     * @param centerY - Y Co-ordinate of the center
     * @param sideLength - Length of each side
     * @param color - Color to be filled inside the Hexagon
     * @return - Polygon instance.
     */
    @Override
    public Polygon drawHexagon(double centerX, double centerY, double sideLength,Color color) {
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++) {
            double internalAngle = Math.toRadians(60 * i); // Calculate angles for the hexagon's vertices
            double x = centerX + sideLength * Math.cos(internalAngle);
            double y = centerY + sideLength * Math.sin(internalAngle);
            hexagon.getPoints().addAll(x, y);
        }
        hexagon.setFill(color);
        return hexagon;
}

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
