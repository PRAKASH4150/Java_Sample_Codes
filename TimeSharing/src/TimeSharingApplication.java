/**
 * TimeSharingApplication.java: This is the main file
 * which contains all the code logic and GUI components
 * for Time Sharing application.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 11/14/2023
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class TimeSharingApplication extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        AtomicReference<String> resort = new AtomicReference<>();
        AtomicInteger selectedPoints = new AtomicInteger();
        AtomicInteger selectedYears =new AtomicInteger();
        TextField pointsTextField = new TextField();
        TextField yearsTextField = new TextField();
        pointsTextField.setPrefWidth(80);
        yearsTextField.setPrefWidth(80);

        final Label upfrontCostLabel=new Label("Upfront Cost: 0");
        upfrontCostLabel.setTextFill(Color.GREEN);
        upfrontCostLabel.setStyle("-fx-font-size:30px;-fx-font-weight:bold");
        upfrontCostLabel.setAlignment(Pos.CENTER);
        upfrontCostLabel.setText("Upfront Cost:$0\nYearly Dues  :$0\nTotal Cost     :$0");


        Label headerLabel =new Label("Welcome to Time Sharing Portal!!!");
        headerLabel.setTextFill(Color.BLUE);
        headerLabel.setStyle("-fx-font-size:40px;-fx-font-weight:bold");

        Label resortLabel =new Label("Select a Resort:");
        resortLabel.setTextFill(Color.BLACK);
        resortLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold");
        resortLabel.setAlignment(Pos.CENTER);


        ComboBox<String> resortListBox = new ComboBox<>();
        ObservableList<String> resorts = FXCollections.observableArrayList("Copper Cay",
                "Pottermore Village", "Ocean Club Villas");
        resortListBox.setItems(resorts);
        resortListBox.setPromptText("Resorts");
        resortListBox.setStyle("-fx-border-color:grey;-fx-background-color:white;-fx-prompt-text-fill:black; -fx-font-size:18px;");
        resortListBox.setPrefWidth(510);
        resortListBox.setPrefHeight(50);
        resortListBox.setOnAction(e -> {
            resort.set(resortListBox.getSelectionModel().getSelectedItem());
            calculateValues(resort,selectedPoints,selectedYears,upfrontCostLabel);
        });

        Label pointsLabel =new Label("Select number of points(100-1000):");
        pointsLabel.setTextFill(Color.BLACK);
        pointsLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold");
        pointsLabel.setAlignment(Pos.CENTER);


        Slider pointsSlider = new Slider(100, 1000, 100);
        pointsSlider.setShowTickMarks(true);
        pointsSlider.setShowTickLabels(true);
        pointsSlider.setMajorTickUnit(100);
        pointsSlider.setMinorTickCount(10);
        pointsSlider.setBlockIncrement(10);
        pointsSlider.setPrefWidth(300);
        pointsSlider.setPrefHeight(30);
        pointsSlider.setStyle("-fx-font-size:18px;-fx-font-color:black;");
        pointsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            selectedPoints.set(newValue.intValue());
            pointsTextField.setText(String.format("%.0f", pointsSlider.getValue()));
            calculateValues(resort,selectedPoints,selectedYears,upfrontCostLabel);
        });



        pointsTextField.setOnAction(e -> {
            try {
                int value = Integer.parseInt(pointsTextField.getText());
                if (value >= 100 && value <= 1000) {
                    pointsSlider.setValue(value);
                } else {
                    pointsTextField.setText(String.valueOf((int) pointsSlider.getValue()));
                }
            } catch (NumberFormatException ex) {
                pointsTextField.setText(String.valueOf((int) pointsSlider.getValue()));
            }
        });


        Label contractLabel =new Label("Select years of contract(10-50):");
        contractLabel.setTextFill(Color.BLACK);
        contractLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold");
        contractLabel.setAlignment(Pos.CENTER);

        Slider yearsSlider = new Slider(10, 50, 5);
        yearsSlider.setShowTickMarks(true);
        yearsSlider.setShowTickLabels(true);
        yearsSlider.setMajorTickUnit(10);
        yearsSlider.setMinorTickCount(1);
        yearsSlider.setBlockIncrement(1);
        yearsSlider.setStyle("-fx-font-size:18px;-fx-font-color:black;");
        yearsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            selectedYears.set(newValue.intValue());
            yearsTextField.setText(String.valueOf(selectedYears.get()));
            calculateValues(resort,selectedPoints,selectedYears,upfrontCostLabel);
        });

        yearsTextField.setOnAction(e -> {
            try {
                int value = Integer.parseInt(yearsTextField.getText());
                if (value >= 10 && value <= 50) {
                    yearsSlider.setValue(value);
                } else {
                    yearsTextField.setText(String.valueOf(yearsSlider.getValue()));
                }
            } catch (NumberFormatException ex) {
                yearsTextField.setText(String.valueOf(( yearsSlider.getValue())));
            }
        });

        Button resetButton = new Button("Reset");
        resetButton.setStyle("-fx-background-color: blue;" +
                "-fx-font-weight: bold;-fx-font-size:20px");
        resetButton.setPrefHeight(TimeSharingConstants.BUTTON_HEIGHT);
        resetButton.setPrefWidth(TimeSharingConstants.BUTTON_WIDTH);
        resetButton.setTextFill(Color.WHITE);
        resetButton.setOnAction(e -> {
            resortListBox.getSelectionModel().clearSelection();
            pointsSlider.setValue(100);
            yearsSlider.setValue(5);
            pointsTextField.setText("");
            yearsTextField.setText("");
            upfrontCostLabel.setText("Upfront Cost:$0\nYearly Dues  :$0\nTotal Cost     :$0");
        });

        HBox pointsPannel=new HBox(2,pointsLabel,pointsTextField);
        HBox yearsPannel = new HBox(2,contractLabel,yearsTextField);
        HBox buttonPannel=new HBox(10,resetButton);
        buttonPannel.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.add(resortLabel, 0, 0);
        gridPane.add(resortListBox, 0, 1);
        gridPane.add(pointsPannel, 0, 2);
        gridPane.add(pointsSlider, 0, 3);
        gridPane.add(yearsPannel, 0, 4);
        gridPane.add(yearsSlider, 0, 5);
        gridPane.add(upfrontCostLabel, 0, 6);
        gridPane.setAlignment(Pos.CENTER);

        VBox formVBox = new VBox(20, headerLabel, gridPane,buttonPannel);
        formVBox.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(formVBox,500,500));
        primaryStage.setTitle("Time Sharing Portal");
        primaryStage.show();
    }

    public void calculateValues(AtomicReference<String> resort,AtomicInteger selectedPoints,
                               AtomicInteger selectedYears,Label upfrontCostLabel)
    {
        double upfrontCost=0;
        double yearlyDues=0;
        double totalCost=0;

        if(resort.get()!=null)
        {
            if(resort.get().equalsIgnoreCase(TimeSharingConstants.COPPER_CAY))
            {
                upfrontCost=TimeSharingConstants.COPPER_CAY_POINT_PRICE*selectedPoints.get();
                yearlyDues=selectedPoints.get()*
                        TimeSharingConstants.COPPER_CAY_YEARLY_DUES_PER_POINT*selectedYears.get();
            }
            else if(resort.get().equalsIgnoreCase(TimeSharingConstants.POTTER_MORE_VILLAGE))
            {
                upfrontCost=TimeSharingConstants.POTTER_MORE_VILLAGE_POINT_PRICE*selectedPoints.get();
                yearlyDues=selectedPoints.get()*
                        TimeSharingConstants.POTTER_MORE_VILLAGE_YEARLY_DUES_PER_POINT*selectedYears.get();
            }
            else if(resort.get().equalsIgnoreCase(TimeSharingConstants.OCEAN_CLUB_VILLAS))
            {
                upfrontCost=TimeSharingConstants.OCEAN_CLUB_VILLAS_POINT_PRICE*selectedPoints.get();
                yearlyDues=selectedPoints.get()*
                        TimeSharingConstants.OCEAN_CLUB_VILLAS_YEARLY_DUES_PER_POINT*selectedYears.get();
            }
            totalCost=upfrontCost+yearlyDues;
            upfrontCostLabel.setText("Upfront Cost:$"+String.format("%.2f",upfrontCost)+
                    "\nYearly Dues  :$"+String.format("%.2f",yearlyDues)+
                    "\nTotal Cost     :$"+String.format("%.2f",totalCost));
        }

    }
    public static void main(String[] args)
    {
        Application.launch();
    }
}
