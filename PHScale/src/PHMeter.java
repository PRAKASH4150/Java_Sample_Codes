/**
 * PHMeter.java: This program is used to select a
 * Ph LEVEL and the program displays the type of
 * chemical and th current Selected PH value
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 12/14/2023
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class PHMeter extends Application {

    private final Label currentPH=new Label();
    private final Label phType=new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {
        int MIN_PH_VAL = 0;
        int MAX_PH_VAL = 10;
        int WINDOW_WIDTH = 400;
        int WINDOW_HEIGHT = 400;

        Label headerLabel=new Label("PH - METER");
        headerLabel.setTextFill(Color.BLUE);
        headerLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 30px");
        Slider phScale=new Slider();
        phScale.setMin(MIN_PH_VAL);
        phScale.setMax(MAX_PH_VAL);
        phScale.setShowTickLabels(true);
        phScale.setShowTickMarks(true);
        phScale.setMajorTickUnit(1);
        phScale.setMaxWidth(WINDOW_WIDTH -100);

        phScale.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int pHValue =(int) newValue.doubleValue();
                currentPH.setText("Level:" + pHValue);
                currentPH.setTextFill(Color.GREEN);
                currentPH.setStyle("-fx-font-size: 25px;-fx-font-weight: bold");
                phType.setTextFill(Color.GREEN);
                phType.setStyle("-fx-font-size: 25px;-fx-font-weight: bold");
                if (pHValue < 7) {
                    phType.setText("Type: Acid");
                } else if (pHValue > 7) {
                    phType.setText("Type: Base");
                } else {
                    phType.setText("Type: Neutral");
                }
            }
        });



        HBox infoBox=new HBox(10,currentPH,phType);
        infoBox.setAlignment(Pos.CENTER);
        VBox vbox=new VBox(10,headerLabel,infoBox,phScale);
        vbox.setAlignment(Pos.CENTER);
        Scene scene=new Scene(vbox, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("PH Measuring Display");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch();
    }


}
