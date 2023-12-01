/**
 * UserRegistrationHandler.java:
 * This file contains all the methods to be triggered after hitting the submit
 * or the Quit button.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 11/09/2023.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


import java.util.ArrayList;
import java.util.List;

public class UserRegistrationHandler implements EventHandler<ActionEvent> {
    private UserDetails userDetails;
    private static List<UserDetails> userDetailsList =new ArrayList<>();

    /**
     *
     * @param userDetails - Consumes the User details object
     */
    UserRegistrationHandler(UserDetails userDetails)
    {
        this.userDetails=userDetails;
    }


    UserRegistrationHandler()
    {
        super();
    }

    /**
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {
        Button button=(Button) event.getSource();
        if(button.getText().equalsIgnoreCase("Register"))
        {
            userDetailsList.add(this.userDetails);
        }
        else if(button.getText().equalsIgnoreCase("Quit"))
        {
            printHeader();
            printSeparator();

            for (UserDetails userDetails : userDetailsList) {
                printUserData(userDetails);
            }
        }

    }

    /**
     * printHeader(): Will print the header column of the list.
     */
    private static void printHeader() {
        System.out.printf("| %-40s | %-40s | %-20s | %-20s | %-20s | %-20s |%n",
                "Full Name", "Email Address", "Phone Number", "Country", "City", "Prog. Language");
    }

    /**
     * printSeparator(): Prints the line separator.
     */
    private static void printSeparator() {
        System.out.println("|------------------------------------------|" +
                "------------------------------------------|" +
                "----------------------|----------------------|" +
                "----------------------|----------------------|");
    }

    /**
     *
     * @param userDetails Takes in the User details object and prints
     *                    to the screen in a formatted way.
     */

    private static void printUserData(UserDetails userDetails) {
        System.out.printf("| %-40s | %-40s | %-20s | %-20s | %-20s | %-20s |%n",
                userDetails.getFullName(), userDetails.getEmailAddress(),
                userDetails.getPhoneNumber(), userDetails.getCountry(),
                userDetails.getCity(), userDetails.getProgLanguage());
    }
}
