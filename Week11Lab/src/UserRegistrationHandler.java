import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


import java.util.ArrayList;
import java.util.List;

public class UserRegistrationHandler implements EventHandler<ActionEvent> {
    private UserDetails userDetails;
    private static List<UserDetails> userDetailsList =new ArrayList<>();
    UserRegistrationHandler(UserDetails userDetails)
    {
        this.userDetails=userDetails;
    }

    UserRegistrationHandler()
    {
        super();
    }
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

    private static void printHeader() {
        System.out.printf("| %-40s | %-40s | %-20s | %-20s | %-20s | %-20s |%n",
                "Full Name", "Email Address", "Phone Number", "Country", "City", "Prog. Language");
    }

    private static void printSeparator() {
        System.out.println("|------------------------------------------|" +
                "------------------------------------------|" +
                "----------------------|----------------------|" +
                "----------------------|----------------------|");
    }

    private static void printUserData(UserDetails userDetails) {
        System.out.printf("| %-40s | %-40s | %-20s | %-20s | %-20s | %-20s |%n",
                userDetails.getFullName(), userDetails.getEmailAddress(),
                userDetails.getPhoneNumber(), userDetails.getCountry(),
                userDetails.getCity(), userDetails.getProgLanguage());
    }
}
