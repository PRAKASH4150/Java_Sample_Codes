import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PizzaSelection extends Application {

    private Label infoLabel=null;
    private static String toppings="";
    @Override
    public void start(Stage primaryStage) throws Exception {

        Label mainHeader =new Label("Pizza Selection");
        mainHeader.setTextFill(Color.BLUE);
        mainHeader.setStyle("-fx-font-weight:bold;-fx-font-size: 40px");

        infoLabel=new Label();
        infoLabel.setTextFill(Color.GREEN);
        infoLabel.setStyle("-fx-font-weight:bold;-fx-font-size: 25px");


        Label pizzaSize=new Label("Select the Pizza Size:");
        pizzaSize.setTextFill(Color.BLACK);
        pizzaSize.setStyle("-fx-font-weight:bold;-fx-font-size: 18px");

        ToggleGroup tg=new ToggleGroup();

        RadioButton small=new RadioButton("Small");
        RadioButton medium =new RadioButton("Medium");
        RadioButton large=new RadioButton("Large");
        RadioButton xLarge=new RadioButton("X-Large");

        small.setOnAction(new EventResponse(tg,""));
        small.setToggleGroup(tg);
        medium.setOnAction(new EventResponse(tg,""));
        medium.setToggleGroup(tg);
        large.setOnAction(new EventResponse(tg,""));
        large.setToggleGroup(tg);
        xLarge.setOnAction(new EventResponse(tg,""));
        xLarge.setToggleGroup(tg);

        Label toppings=new Label("Select the Pizza Toppings:");
        toppings.setTextFill(Color.BLACK);
        toppings.setStyle("-fx-font-weight:bold;-fx-font-size: 18px");

        CheckBox pepperoni=new CheckBox("Pepperoni");
        CheckBox ham=new CheckBox("Ham");
        CheckBox mushrooms=new CheckBox("Mushrooms");

        pepperoni.setOnAction(new EventResponse(tg,"Pepperoni"));
        ham.setOnAction(new EventResponse(tg,"Ham"));
        mushrooms.setOnAction(new EventResponse(tg,"Mushrooms"));

        HBox sizeHolder=new HBox(10,small,medium,large,xLarge);
        sizeHolder.setAlignment(Pos.CENTER);

        HBox toppingsHolder=new HBox(10,pepperoni,ham,mushrooms);
        toppingsHolder.setAlignment(Pos.CENTER);

        VBox mainBox=new VBox(10,mainHeader,infoLabel,pizzaSize,sizeHolder,toppings,toppingsHolder);
        mainBox.setAlignment(Pos.CENTER);

        Scene scene=new Scene(mainBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Selection Portal");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
      Application.launch();
    }

    public class EventResponse implements EventHandler<ActionEvent>
    {

        private final ToggleGroup tg;
        private final String topping;

        EventResponse(ToggleGroup tg,String topping)
        {
            this.tg=tg;
            this.topping=topping;
        }
        @Override
        public void handle(ActionEvent event) {
            String size=((ToggleButton)tg.getSelectedToggle()).getText();
            toppings+=this.topping+"+";
            infoLabel.setText(size+":"+toppings);
        }
    }
}
