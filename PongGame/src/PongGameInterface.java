/**
 * PongGameInterface.java: This file contains all the Game
 * function declarations and Game Constants.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 11/30/2023.
 */

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public interface PongGameInterface {

    int WINDOW_WIDTH=800;
    int WINDOW_HEIGHT=600;
    int PADDLE_WIDTH=10;
    int PADDLE_HEIGHT=80;
    int BALL_RADIUS = 10;
    int WINNING_SCORE = 5;
    void movePaddleUp(Slider slider);
    void movePaddleDown(Slider slider);
    void updateScores(Label scoreLabel);
    void showWinnerPopup(String message, Stage primaryStage);
    void showInstructionsPopup();

}
