/**
 * Board.java: This file acts as the main file and contains
 * all the functionality to layout and setup the board.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 11/08/2023
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Board extends Application{

    private static final int ROWS=6;
    private static final int COLUMNS=7;
    private static final int BUTTON_WIDTH=100;
    private static final int BUTTON_HEIGHT=100;
    private final Button[][] slots=new Button[ROWS][COLUMNS];
    private final int [][]board=new int[ROWS][COLUMNS];
    private Label displayLabel=null;
    private ButtonEventHandler buttonEventHandler=null;
    private Button dummyButton=null;

    /**
     * constructBoard(): This method is used to construct the
     * layout of the board.
     * @return the Scene object.
     */
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

        dummyButton=new Button("Player-1");
        dummyButton.setStyle("-fx-background-color:red;" +
                "-fx-font-size:18px;-fx-font-weight:bold");
        dummyButton.setPrefWidth(BUTTON_WIDTH);
        dummyButton.setPrefHeight(BUTTON_HEIGHT);
        dummyButton.setTextFill(Color.WHITE);
        dummyButton.setDisable(true);

        for(int i=0;i<ROWS;i++)
        {
            for (int j=0;j<COLUMNS;j++)
            {
                slots[i][j]=createButton(i,j);
                gridPane.add( slots[i][j],j,i);
            }
        }
        buttonEventHandler=new ButtonEventHandler(board,slots,displayLabel,dummyButton);
        Button resetButton = new Button("Reset");
        resetButton.setPrefWidth(200);
        resetButton.setPrefHeight(100);
        resetButton.setStyle("-fx-font-size: 25px;" +
                "-fx-text-fill: black;-fx-font-weight:bold;");
        resetButton.setOnAction(event ->buttonEventHandler.resetGame() );
        gridPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox headerBox=new HBox(20,headerLabel);
        HBox displayBox=new HBox(20,displayLabel);
        HBox boardBox=new HBox(20,gridPane);
        HBox buttonBox=new HBox(20, resetButton,dummyButton);
        headerBox.setAlignment(Pos.CENTER);
        displayBox.setAlignment(Pos.CENTER);
        boardBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        mainBox=new VBox(20,headerBox,displayBox,boardBox,buttonBox);
        mainBox.setAlignment(Pos.CENTER);
        return new Scene(mainBox,500,500);

    }

    /**
     * @param row - Accepts the row in the grid
     * @param column - Accepts the column in the grid
     * @return the button instance
     */
    public Button createButton(int row,int column)
    {
        Button button=new Button();
        buttonEventHandler=new ButtonEventHandler(row,column,board,slots,displayLabel,dummyButton);
        button.setOnAction(buttonEventHandler);
        button.setPrefWidth(BUTTON_WIDTH);
        button.setPrefHeight(BUTTON_HEIGHT);
        if(row>0)
        {
            button.setDisable(true);
        }
        return button;
    }


    /**
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Board board=new Board();
        primaryStage.setScene(board.constructBoard());
        primaryStage.setTitle("Connect-4");
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        Application.launch();
    }
}
