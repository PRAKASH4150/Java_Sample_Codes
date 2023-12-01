/**
 * ShapeEditor.java: This file contains all the code
 * logic to edit the shapes and do the necessary
 * action on click and drag events.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 11/30/2023
 */

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import java.util.Map;
import java.util.Random;

public class ShapesEditor extends Application implements ShapeEditorConstants {
    private final Random random = new Random();
    private static int editableCircleRadius=CIRCLE_RADIUS;
    private static int editableRectangleWidth=RECTANGLE_WIDTH;
    private static int editableRectangleHeight=RECTANGLE_HEIGHT;
    private static int editableEllipseRadiusX=ELLIPSE_RADIUSX;
    private static int editableEllipseRadiusY=ELLIPSE_RADIUSY;
    private double dragStartX, dragStartY;


    /**
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);

        scene.setOnMousePressed(event -> {
            dragStartX = event.getSceneX();
            dragStartY = event.getSceneY();
        });

        scene.setOnMouseDragged(event -> {
            double offsetX = event.getSceneX() - dragStartX;
            double offsetY = event.getSceneY() - dragStartY;
            if (Math.abs(offsetX) > 5 || Math.abs(offsetY) > 5) {
                event.consume();
            }
        });

        scene.setOnMouseReleased(event -> {
            if (Math.abs(event.getX() - dragStartX) <= 5 && Math.abs(event.getY() - dragStartY) <= 5) {
                boolean isDragging = false;
                for (Map.Entry<Shape, Boolean> entry : isShapeDragging.entrySet()) {
                    if (entry.getValue()) {
                        isDragging = true;
                        break;
                    }
                }

                if (!isDragging) {
                    Shape clickedShape = null;
                    for (Node shape : root.getChildren()) {
                        if (shape instanceof Shape && shape.contains(event.getX(), event.getY())) {
                            clickedShape = (Shape) shape;
                            break;
                        }
                    }

                    if (clickedShape == null) {
                        Shape shape = getRandomShape(event.getX(), event.getY());
                        root.getChildren().add(shape);
                        clickCountMap.put(shape, 0);
                        addDragListeners(shape);
                    } else {
                        handleClickEvent(clickedShape);
                    }
                }
            }
        });


        primaryStage.setScene(scene);
        primaryStage.setTitle("Shapes Editor");
        primaryStage.show();
    }

    /**
     * getRandomShape(): Generates a random shape between Circle, Ellipse and
     * Rectangle
     * @param x coordinate
     * @param y coordinate
     * @return Shape Object
     */
    public Shape getRandomShape(double x, double y) {
        int choice = random.nextInt(3);
        Shape shape = null;
        switch (choice) {
            case 0:
                shape = new Circle(x, y, CIRCLE_RADIUS);
                shape.setFill(circleOriginalColor);
                break;
            case 1:
                shape = new Rectangle(x, y, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
                shape.setFill(rectanleOriginalColor);
                break;
            case 2:
                shape = new Ellipse(x, y, ELLIPSE_RADIUSX,ELLIPSE_RADIUSY);
                shape.setFill(ellipseOriginalColor);
                break;
        }

        return shape;
    }

    /**
     * handleClickEvent(): The size and color of the shape
     * will be changed upon each mouse click by using this function
     * @param shape accepts the Shape that is being clicked
     */
    public void handleClickEvent(Shape shape) {
        int clickCount = clickCountMap.getOrDefault(shape, 0);

        if (clickCount < 2) {
            Color newColor = getRandomColor();
            shape.setFill(newColor);

            if (shape instanceof Circle) {
                editableCircleRadius+=20;
                ((Circle) shape).setRadius(editableCircleRadius);
            } else if (shape instanceof Rectangle) {
                editableRectangleWidth+=20;
                editableRectangleHeight+=20;
                ((Rectangle) shape).setWidth(editableRectangleWidth);
                ((Rectangle) shape).setHeight(editableRectangleHeight);
            } else if (shape instanceof Ellipse) {
                editableEllipseRadiusX+=20;
                editableEllipseRadiusY+=20;
                ((Ellipse) shape).setRadiusX(editableEllipseRadiusX);
                ((Ellipse) shape).setRadiusY(editableEllipseRadiusY);
            }

            clickCountMap.put(shape, clickCount + 1);
        } else {
            if (shape instanceof Circle) {
                editableCircleRadius=CIRCLE_RADIUS;
                ((Circle) shape).setRadius(CIRCLE_RADIUS);
                shape.setFill(circleOriginalColor);
            } else if (shape instanceof Rectangle) {
                editableRectangleWidth=RECTANGLE_WIDTH;
                editableRectangleHeight=RECTANGLE_HEIGHT;
                ((Rectangle) shape).setWidth(RECTANGLE_WIDTH);
                ((Rectangle) shape).setHeight(RECTANGLE_HEIGHT);
                shape.setFill(rectanleOriginalColor);
            } else if (shape instanceof Ellipse) {
                editableEllipseRadiusX=ELLIPSE_RADIUSX;
                editableEllipseRadiusY=ELLIPSE_RADIUSY;
                ((Ellipse) shape).setRadiusX(ELLIPSE_RADIUSX);
                ((Ellipse) shape).setRadiusY(ELLIPSE_RADIUSY);
                shape.setFill(ellipseOriginalColor);
            }

            clickCountMap.put(shape, 0);
        }
    }

    /**
     * getRandomColor(): Generates a random color
     * @return Color instance
     */
    public Color getRandomColor() {
        int index = random.nextInt(colors.length);
        return colors[index];
    }

    /**
     * addDragListeners(): Used to drag a shape
     * @param shape - Accepts a shape that should be dragged.
     */
    public void addDragListeners(Shape shape) {
        isShapeDragging.put(shape, false);

        shape.setOnMousePressed(event -> {
            isShapeDragging.put(shape, true);
            dragStartX = event.getSceneX() - shape.getTranslateX();
            dragStartY = event.getSceneY() - shape.getTranslateY();
        });

        shape.setOnMouseDragged(event -> {
            if (isShapeDragging.get(shape)) {
                double offsetX = event.getSceneX() - dragStartX;
                double offsetY = event.getSceneY() - dragStartY;
                shape.setTranslateX(offsetX);
                shape.setTranslateY(offsetY);
            }
        });

        shape.setOnMouseReleased(event -> {
            isShapeDragging.put(shape, false);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
