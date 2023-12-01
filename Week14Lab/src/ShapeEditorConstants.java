/**
 * ShapeEditorConstants.java: This file contains all
 * the Game constants.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 11/30/2023.
 */

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.HashMap;
import java.util.Map;

public interface ShapeEditorConstants {
    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.GREY, Color.PINK,
            Color.MAGENTA, Color.SKYBLUE, Color.BLACK};
    int CIRCLE_RADIUS = 30;
    int RECTANGLE_WIDTH=50;
    int RECTANGLE_HEIGHT=100;
    int ELLIPSE_RADIUSX=75;
    int ELLIPSE_RADIUSY=35;
    Color circleOriginalColor = Color.MAROON;
    Color rectanleOriginalColor=Color.BLUE;
    Color ellipseOriginalColor=Color.GREEN;
    Map<Shape, Integer> clickCountMap = new HashMap<>();
    Map<Shape, Boolean> isShapeDragging = new HashMap<>();
}
