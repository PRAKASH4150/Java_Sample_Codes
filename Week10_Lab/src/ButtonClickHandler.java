/**
 * ButtonClickHandler.java:
 * This file implements the EventHandler and
 * overrides the handle method. This method
 * will be triggered when any button on the
 * screen is clicked.
 * The buttons and the function are following:
 * Increment: Increments the current value by 1 per click
 * Decrement: Decrements the current value by 1 per click
 * Square: Squares the current value by itself and changes the font color
 * on every mouse click
 * Reset: Resets the current value to 0 and sets the
 * font color of the label to black.
 * @author Sai Surya Prakash Moka
 * @date 11/02/23
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.Random;

public class ButtonClickHandler implements EventHandler<ActionEvent>   {

    private long count=0;
    private Label countLabel=null;
    private final Random random = new Random();



    /**
     * @param count
     * @param countLabel
     */
    ButtonClickHandler(long count,Label countLabel)
    {
        this.count=count;
        this.countLabel=countLabel;
    }
    /**
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {
        final Color[] colors = {
                Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.PURPLE
        };
        Button sourceButton = (Button) event.getSource();
        String buttonText = sourceButton.getText();
        if(buttonText.equalsIgnoreCase("Increment"))
        {
            count++;
            countLabel.setText("Count:"+count);
        } else if (buttonText.equalsIgnoreCase("Decrement")) {
            count--;
            countLabel.setText("Count:"+count);
        }
        else if(buttonText.equalsIgnoreCase("Square"))
        {
            int randomIndex = random.nextInt(colors.length);
            Color randomColor = colors[randomIndex];
            count=count*count;
            countLabel.setText("Square:"+count);
            countLabel.setTextFill(randomColor);
        }
        else if(buttonText.equalsIgnoreCase("Reset"))
        {
            count=0;
            countLabel.setText("Count:"+count);
            countLabel.setTextFill(Color.BLACK);
        }
    }
}
