import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Board{

    private static final int ROWS=6;
    private static final int COLUMNS=7;
    private static final int BUTTON_WIDTH=100;
    private static final int BUTTON_HEIGHT=100;
    private Label displayLabel=null;
    private Button[][] slots=new Button[ROWS][COLUMNS];
    private Button resetButton=null;
    private int [][]board=new int[ROWS][COLUMNS];
    private ButtonEventHandler buttonEventHandler=null;
    private int currentPlayer=1;
    public Scene constructBoard()
    {
        GridPane gridPane=new GridPane();
        VBox mainBox=null;
        Label headerLabel=new Label("Welcome to Connect-4 Game.");
        headerLabel.setStyle("-fx-font-size: 70px;-fx-font-weight:bold");
        headerLabel.setTextFill(Color.BLUE);
        displayLabel =new Label("Click on any button to start the Game");
        displayLabel.setStyle("-fx-font-size:30px;");
        displayLabel.setTextFill(Color.BLACK);
        for(int i=0;i<ROWS;i++)
        {
            for (int j=0;j<COLUMNS;j++)
            {
                slots[i][j]=createButton(i,j);
                gridPane.add( slots[i][j],j,i);
            }
        }
        buttonEventHandler=new ButtonEventHandler(board,slots,displayLabel);
        resetButton=new Button("Reset");
        resetButton.setPrefWidth(200);
        resetButton.setPrefHeight(100);
        resetButton.setStyle("-fx-font-size: 25px;" +
                "-fx-text-fill: black;-fx-font-weight:bold;");
        resetButton.setOnAction(event ->buttonEventHandler.resetGame() );
        gridPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox headerBox=new HBox(20,headerLabel);
        HBox displayBox=new HBox(20,displayLabel);
        HBox boardBox=new HBox(20,gridPane);
        HBox buttonBox=new HBox(20,resetButton);
        headerBox.setAlignment(Pos.CENTER);
        displayBox.setAlignment(Pos.CENTER);
        boardBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        mainBox=new VBox(20,headerBox,displayBox,boardBox,buttonBox);
        mainBox.setAlignment(Pos.CENTER);
        return new Scene(mainBox,500,500);

    }

    public Button createButton(int row,int column)
    {
        Button button=new Button();
        buttonEventHandler=new ButtonEventHandler(row,column,board,slots,displayLabel);
        button.setOnAction(buttonEventHandler);
        button.setPrefWidth(BUTTON_WIDTH);
        button.setPrefHeight(BUTTON_HEIGHT);
        if(row>0)
        {
            button.setDisable(true);
        }
        return button;
    }

}
