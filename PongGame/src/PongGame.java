/**
 * PongGame.java: This file contains all
 * the Game logic for the Pong game which
 * includes animations handling events etc.;
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 11/30/2023
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class PongGame extends Application implements PongGameInterface {
    private Rectangle paddle1;
    private Rectangle paddle2;
    private Circle ball;
    private double ballXSpeed = 2;
    private double ballYSpeed = 2;
    private int player1Score = 0;
    private int player2Score = 0;
    private final double increaseSpeed = 1.1;
    private AnimationTimer timer=null;
    private   Label scoreLabel;

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
        scoreLabel= new Label("Player 1: 0 , Player 2: 0");
        scoreLabel.setAlignment(Pos.CENTER);
        scoreLabel.setLayoutX(250);
        scoreLabel.setLayoutY(10);
        scoreLabel.setStyle("-fx-font-size: 30px;-fx-font-weight:bold;");
        scoreLabel.setTextFill(Color.GREEN);

        Button infoButton = new Button("Info");
        infoButton.setAlignment(Pos.CENTER);
        infoButton.setLayoutX(180);
        infoButton.setLayoutY(10);
        infoButton.setStyle("-fx-font-size: 20px;-fx-background-color: blue;-fx-font-weight: bold");
        infoButton.setTextFill(Color.WHITE);


        Pane pane=new Pane(scoreLabel);

        paddle1=new Rectangle(PADDLE_WIDTH,PADDLE_HEIGHT);
        paddle1.setX(10);
        paddle1.setY(288);
        paddle1.setFill(Color.RED);
        paddle2=new Rectangle(PADDLE_WIDTH,PADDLE_HEIGHT);
        paddle2.setX(780);
        paddle2.setY(288);
        paddle2.setFill(Color.BLUE);

        Slider sliderOne = new Slider(0, WINDOW_HEIGHT - PADDLE_HEIGHT, (double) WINDOW_HEIGHT / 2 - (double) PADDLE_HEIGHT / 2);
        Slider sliderTwo = new Slider(0, WINDOW_HEIGHT - PADDLE_HEIGHT, (double) WINDOW_HEIGHT / 2 - (double) PADDLE_HEIGHT / 2);

        sliderOne.setLayoutX(25);
        sliderOne.setLayoutY(10);
        sliderTwo.setLayoutX(635);
        sliderTwo.setLayoutY(10);

        paddle1.yProperty().bind(sliderOne.valueProperty());
        paddle2.yProperty().bind(sliderTwo.valueProperty());

        ball = new Circle((double) WINDOW_WIDTH / 2, (double) WINDOW_HEIGHT / 2, BALL_RADIUS, Color.BLACK);

        pane.getChildren().addAll(paddle1,paddle2, sliderOne, sliderTwo,ball,infoButton);

        Scene scene=new Scene(pane,WINDOW_WIDTH,WINDOW_HEIGHT);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    movePaddleUp(sliderOne);
                    break;
                case S:
                    movePaddleDown(sliderOne);
                    break;
                case UP:
                    movePaddleUp(sliderTwo);
                    break;
                case DOWN:
                    movePaddleDown(sliderTwo);
                    break;
            }
        });

         timer= new AnimationTimer() {
            @Override
            public void handle(long now) {
                ball.setCenterX(ball.getCenterX() + ballXSpeed);
                ball.setCenterY(ball.getCenterY() + ballYSpeed);

                if (ball.getCenterX() <= BALL_RADIUS || ball.getCenterX() >= WINDOW_WIDTH - BALL_RADIUS) {
                    if (ball.getCenterX() <= BALL_RADIUS) {
                        player2Score++;
                    } else {
                        player1Score++;
                    }
                    ballXSpeed *= -1;
                    updateScores(scoreLabel);
                }
                if (ball.getCenterY() <= BALL_RADIUS || ball.getCenterY() >= WINDOW_HEIGHT - BALL_RADIUS) {
                    ballYSpeed *= -1;
                }

                if (ball.getBoundsInParent().intersects(paddle1.getBoundsInParent())
                        || ball.getBoundsInParent().intersects(paddle2.getBoundsInParent())) {
                    ballXSpeed *= -1;
                    ballYSpeed *= -1;
                }


                if (player1Score >= WINNING_SCORE || player2Score >= WINNING_SCORE) {
                    stop();
                    String winner = (player1Score >= WINNING_SCORE) ? "Player 1" : "Player 2";
                    String displayMessage=winner + " wins!";
                    System.out.println(displayMessage);
                    showWinnerPopup(displayMessage,primaryStage);
                }
            }
        };
        timer.start();

        infoButton.setOnMouseClicked(event -> {
            timer.stop();
            showInstructionsPopup();
        });

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Ping Pong Game");
        primaryStage.show();
    }

    /**
     * This function is to adjust the position of the Paddle
     * Upwards.
     * @param slider - Slider Panel
     */
    public void movePaddleUp(Slider slider) {
        double currentValue = slider.getValue();
        if (currentValue > 0) {
            slider.setValue(currentValue - 30);
        }
    }

    /**
     * This function is to adjust the position of the Paddle
     * downwards
     * @param slider - Panel
     */
    public void movePaddleDown(Slider slider) {
        double currentValue = slider.getValue();
        if (currentValue < WINDOW_HEIGHT - PADDLE_HEIGHT) {
            slider.setValue(currentValue + 30);
        }
    }

    /**
     * This function is used to update the score label.
     * @param scoreLabel - Label of the score
     */
    public void updateScores(Label scoreLabel) {
        scoreLabel.setText("Player 1: " + player1Score + "  Player 2: " + player2Score);
    }

    /**
     *
     * @param message
     * @param primaryStage
     */
    public void showWinnerPopup(String message,Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);

        ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(closeButton);

        // Set an action handler to close the primaryStage
        alert.setOnCloseRequest(e -> primaryStage.close());

        alert.show();
        alert.show();
    }


    /**
     * This function is used to
     * display the Game instructions.
     */
    public void showInstructionsPopup() {
        Alert instructions = new Alert(Alert.AlertType.INFORMATION);
        instructions.setTitle("Instructions");
        instructions.setHeaderText("Player Controls");
        instructions.setContentText(
                "Player 1 Controls: W (Up), S (Down) or Left Slider\n" +
                "Player 2 Controls: Up Arrow (Up), Down Arrow (Down) or Right Slider\n\n" +
                "Click OK to resume the game.");

        instructions.setOnHidden(evt -> timer.start()); // Resume game on popup close

        instructions.showAndWait();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
