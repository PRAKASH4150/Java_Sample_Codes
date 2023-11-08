/**
 * Week10Lab.java:
 * This java file contains logic to develop a GUI application.
 * The stage consists buttons which increments, decrements
 * and squares the number.
 * @author Sai Surya Prakash Moka
 * @date 11/02/23
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Week10Lab extends Application {


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
        long count=0;
        Label countLabel = new Label("Count:"+count);
        countLabel.setStyle("-fx-font-size: 50px;-fx-font-weight:bold");


        ButtonClickHandler buttonClickHandler=new ButtonClickHandler(count,countLabel);

        Button incrementButton=new Button("Increment");
        incrementButton.setOnAction(buttonClickHandler);
        incrementButton.setPrefWidth(200);
        incrementButton.setPrefHeight(100);
        incrementButton.setStyle("-fx-font-size: 25px;-fx-background-color:green;" +
                "-fx-text-fill: white;-fx-font-weight:bold;");


        Button decrementButton=new Button("Decrement");
        decrementButton.setOnAction(buttonClickHandler);
        decrementButton.setPrefWidth(200);
        decrementButton.setPrefHeight(100);
        decrementButton.setStyle("-fx-font-size: 25px;-fx-background-color:red;" +
                "-fx-text-fill: white;-fx-font-weight:bold;");
        decrementButton.setPrefWidth(200);
        decrementButton.setPrefHeight(100);


        Button crazyButton =new Button("Square");
        crazyButton.setOnAction(buttonClickHandler);
        crazyButton.setPrefWidth(200);
        crazyButton.setPrefHeight(100);
        crazyButton.setStyle("-fx-font-size: 25px;-fx-background-color:blue;" +
                "-fx-text-fill: white;-fx-font-weight:bold;");
        crazyButton.setPrefWidth(200);
        crazyButton.setPrefHeight(100);

        Button resetButton=new Button("Reset");
        resetButton.setOnAction(buttonClickHandler);
        resetButton.setPrefWidth(200);
        resetButton.setPrefHeight(100);
        resetButton.setStyle("-fx-font-size: 25px;" +
                "-fx-text-fill: black;-fx-font-weight:bold;");
        resetButton.setPrefWidth(200);
        resetButton.setPrefHeight(100);

        HBox hBox1 = new HBox(20,incrementButton,decrementButton,crazyButton,resetButton);
        HBox hBox2 = new HBox(10,countLabel);
        VBox mainVBox=new VBox(hBox2,hBox1);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        mainVBox.setAlignment(Pos.CENTER);


        Scene scene=new Scene(mainVBox,300,200);
        stage.setScene(scene);
        stage.setTitle("Value Editor");
        stage.show();
    }

    /**
     * The main method launches the application.
     * @param args
     */
    public static void main(String[] args)
    {
        Application.launch();
    }


}
