import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public interface Graphical2DShapes {
    public Line drawLine(double startX, double startY, double endX, double endY, Color color);
    public Rectangle drawRectangle(double startX, double startY, double width, double height, Color color);
    public Circle drawCircle(double centerX, double centerY, double radius, Color color);
    public Ellipse drawEllipse(double centerX, double centerY, double radiusX, double radiusY, Color color);
    public Polygon drawTriangle(double x1, double y1, double x2, double y2, double x3, double y3, Color color);
    public Polygon drawQuadrilateral(double x1,double y1,double x2,double y2,double x3,double y3,
                                     double x4,double y4,Color color);
    public Polygon drawPentagon(double centerX, double centerY, double sideLength,Color color);
    public Arc drawArc(double centerX,double centerY,double radiusX, double radiusY,double startAngle,double length,Color color);
    public Polygon drawHexagon(double centerX, double centerY, double sideLength,Color color);

}
