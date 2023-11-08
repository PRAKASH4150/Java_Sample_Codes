import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ButtonEventHandler implements EventHandler<ActionEvent> {

    private int row;
    private int column;
    private static final int ROWS=6;
    private static final int COLUMNS=7;
    private int [][]board=new int[ROWS][COLUMNS];
    private Button [][]slots=new Button[ROWS][COLUMNS];
    private Button resetButton;
    private Label displayLabel=null;
    private static int currentPlayer=1;
    private int winner;


    ButtonEventHandler(int row,int column,int [][]board,Button [][]slots,Label displayLabel)
    {
        this.row=row;
        this.column=column;
        this.board=board;
        this.displayLabel=displayLabel;
        this.slots=slots;
    }
    ButtonEventHandler(int [][]board,Button[][]slots,Label displayLabel)
    {
        this.board=board;
        this.slots=slots;
        this.displayLabel=displayLabel;
    }
    @Override
    public void handle(ActionEvent event) {
        if (this.board[row][column] == 0) {
            int newRow = findAvailableSlot(column);
            if(newRow!=-1)
            {
                this.board[newRow][column]=currentPlayer;
                this.slots[newRow][column].setStyle(currentPlayer == 1 ?
                        "-fx-background-color: red;-fx-border-color: white; -fx-border-width: 2px;"
                        : "-fx-background-color: black;-fx-border-color: white; -fx-border-width: 2px;");
                currentPlayer = 3 - currentPlayer;
                this.displayLabel.setText("Player-"+ currentPlayer+"'s turn");
                if(currentPlayer==1)
                    this.displayLabel.setTextFill(Color.RED);
                else
                    this.displayLabel.setTextFill(Color.BLACK);
                winner=determineWinner();
                printBoard();
                if(winner==1 || winner==2)
                {
                    this.displayLabel.setText("CONGRATULATIONS!! PLAYER-"+ winner+" WON THE GAME!!!");
                    this.displayLabel.setTextFill(Color.GREEN);
                    disableAllButtons();
                }
                else if(winner==0)
                {

                    this.displayLabel.setText("IT'S A TIE. PLEASE TRY AGAIN!!!");
                    this.displayLabel.setTextFill(Color.GREEN);
                    disableAllButtons();
                }

            }
        }

    }

    public int findAvailableSlot(int column) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == 0) {
                return row;
            }
        }
        return -1;
    }

    public int determineWinner() {
        int nonZeroCount=0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                int player = board[row][col];

                if (player == 0) {
                    continue; // Skip empty slots
                }

                // Check horizontally
                if (col + 3 < COLUMNS) {
                    if (board[row][col + 1] == player &&
                            board[row][col + 2] == player &&
                            board[row][col + 3] == player) {
                        if(player==1)
                        {
                            this.slots[row][col].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 6px;");
                            this.slots[row][col+1].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 6px;");
                            this.slots[row][col+2].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 6px;");
                            this.slots[row][col+3].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 6px;");
                        }
                        else if(player==2)
                        {

                            this.slots[row][col].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 6px;");
                            this.slots[row][col+1].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 6px;");
                            this.slots[row][col+2].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 6px;");
                            this.slots[row][col+3].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 6px;");

                        }
                        return player;
                    }
                }

                // Check vertically
                if (row + 3 < ROWS) {
                    if (board[row + 1][col] == player &&
                            board[row + 2][col] == player &&
                            board[row + 3][col] == player) {
                        if(player==1)
                        {
                            this.slots[row][col].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+1][col].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+2][col].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+3][col].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                        }
                        else if(player==2)
                        {
                            this.slots[row][col].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+1][col].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+2][col].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+3][col].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                        }
                        return player;
                    }
                }

                // Check diagonally (top-left to bottom-right)
                if (row + 3 < ROWS && col + 3 < COLUMNS) {
                    if (board[row + 1][col + 1] == player &&
                            board[row + 2][col + 2] == player &&
                            board[row + 3][col + 3] == player) {
                        if(player==1)
                        {
                            this.slots[row][col].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+1][col+1].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+2][col+2].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+3][col+3].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                        }
                        else if(player==2)
                        {
                            this.slots[row][col].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+1][col+1].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+2][col+2].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+3][col+3].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                        }
                        return player;
                    }
                }

                // Check diagonally (top-right to bottom-left)
                if (row + 3 < ROWS && col - 3 >= 0) {
                    if (board[row + 1][col - 1] == player &&
                            board[row + 2][col - 2] == player &&
                            board[row + 3][col - 3] == player) {
                        if(player==1)
                        {
                            this.slots[row][col].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+1][col-1].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+2][col-2].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+3][col-3].setStyle("-fx-background-color:red;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                        }
                        else if(player==2)
                        {
                            this.slots[row][col].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+1][col-1].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+2][col-2].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                            this.slots[row+3][col-3].setStyle("-fx-background-color:black;" +
                                    "-fx-border-color: blue; -fx-border-width: 10px;");
                        }

                        return player;
                    }
                }
            }
        }

        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLUMNS;j++)
            {
                if(this.board[i][j]!=0)
                {
                    nonZeroCount++;
                }

            }
        }
        if(nonZeroCount==42)
        {
            return 0;
        }
        else {
            return 3;
        }// No winner
    }

    public void printBoard()
    {
        for(int i=0;i<ROWS;i++)
        {
            for(int j=0;j<COLUMNS;j++)
            {
                System.out.print(board[i][j]+" , ");
            }
            System.out.println();
        }
    }

    public void resetGame()
    {
        for (int i=0;i<ROWS;i++)
        {
         for(int j=0;j<COLUMNS;j++)
         {
             if(i==0)
             {
                 slots[i][j].setDisable(false);
             }
             board[i][j]=0;
             slots[i][j].setStyle("");
         }
        }
        currentPlayer=1;
        winner=0;
        displayLabel.setText("Click on any button to start the Game");
        displayLabel.setTextFill(Color.BLACK);
    }

    public void disableAllButtons()
    {
        for(int i=0;i<COLUMNS;i++)
        {
            slots[0][i].setDisable(true);
        }
    }
}
