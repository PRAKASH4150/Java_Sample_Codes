import javafx.application.Application;
import javafx.stage.Stage;

public class Connect4Game extends Application {
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