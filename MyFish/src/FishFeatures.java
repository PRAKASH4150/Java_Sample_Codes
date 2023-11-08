import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;

import java.util.List;

public interface FishFeatures {
    public Ellipse drawBody();
    public Polygon drawTail();
    public Polygon drawUpperDorsalFin();
    public Polygon drawUpperLaterFin();
    public Polygon drawLowerDorsalFin();
    public Polygon drawLowerLateralFin();
    public Polygon drawPectoralFin();
    public Circle drawEye();
    public Polygon drawMouth();
    public List<Polygon> drawTeeth();
    public QuadCurve drawGills();
    public List<Circle> drawBodyMarks();
    public List<Circle> drawBubbles();
}
