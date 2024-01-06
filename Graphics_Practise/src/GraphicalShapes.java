import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GraphicalShapes extends Application {
    int count=0;
    Label headerLabel=new Label("Count:"+count);

    @Override
    public void start(Stage primaryStage) throws Exception {




        headerLabel.setTextFill(Color.GREEN);
        headerLabel.setStyle("-fx-font-weight:bold;-fx-font-size:30px");

        Button incButton =new Button("Increment");
        incButton.setOnAction(new ButtonEventHandler(true));
        incButton.setTextFill(Color.WHITE);
        incButton.setPrefWidth(150);
        incButton.setPrefHeight(60);
        incButton.setStyle("-fx-background-color:blue");

        Button decButton =new Button("Decrement");
        decButton.setOnAction(new ButtonEventHandler(false));
        decButton.setTextFill(Color.WHITE);
        decButton.setPrefWidth(150);
        decButton.setPrefHeight(60);
        decButton.setStyle("-fx-background-color:red");

        Slider slider =new Slider();


        HBox buttonHolder=new HBox(20,incButton,decButton);
        buttonHolder.setAlignment(Pos.CENTER);
        VBox mainBox=new VBox(20,headerLabel,buttonHolder);
        mainBox.setAlignment(Pos.CENTER);

        Scene root=new Scene(mainBox);
        primaryStage.setScene(root);
        primaryStage.setTitle("Value Editor");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch();
    }

    public  class ButtonEventHandler implements EventHandler<ActionEvent>
    {
        private final  boolean isIncrement;
        ButtonEventHandler(boolean isIncrement)
        {
            this.isIncrement=isIncrement;
        }
        @Override
        public void handle(ActionEvent event) {
            if(isIncrement)
                count++;
            else
                count--;
            headerLabel.setText("Count:"+count);
        }
    }
}
