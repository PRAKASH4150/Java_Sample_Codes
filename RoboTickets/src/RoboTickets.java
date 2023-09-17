import java.util.*;
/**
 * RoboTickets.java:
 * This Program helps to order show tickets to different age groups
 * and calculate the total price that the end user supposed to pay.
 *
 * @author-1 Mr Shokite
 * @author-2 Sai Surya Prakash Moka
 *
 * @date 09/09/2023
 */


public class RoboTickets {
    private final double adult;             // Price of one regular ticket.
    private final double child;             // Child's ticket is half price.
    private final double senior;            // Senior ticket is 80%

    private Scanner sc = new Scanner(System.in);

    /**
     * Initialize Roboticket.com to sell tickets at a fixed base price.
     * Tickets for children are half price, and seniors are 80%.
     *
     * @param price The base ticket price, for an adult.
     */
    public RoboTickets(double price) {
        adult = price;
        child = Math.ceil(100 * (0.5 * price)) / 100; // Round the fraction up.
        senior = Math.ceil(100 * (0.8 * price)) / 100;// Round the fraction up.
    }

    /**
     * Dispense tickets to be paid for by a credit card. Adult, child, and
     * senior tickets may be purchased.
     */
    public void go() {
        double price=0; // If there is no default below, use   price = 0
        int choice=0, quantity=0;
        double totalPrice=0; //Added this variable to display the totalPrice
        String ticketType="";// Added this variable to display the ticket type
        String userName;

        //Modified the welcome message to show the author name
        System.out.println("Please Enter your name:");
        userName=sc.nextLine();
        System.out.println("\n"+userName+", Welcome to Roboticket.com where all shows and" +
                " seats are one low price!");
        while (true) {
            System.out.printf("    1. Adult %.2f\n" +
                    "    2. Child under 12 %.2f\n", adult, child);
            System.out.printf("    3. Senior Citizen %.2f\n", senior);
            System.out.println("    4. Finish & Pay");
            System.out.println("    5. Cancel");
            for (; ; ) {
                /*Added validation code to handle bad menu choices like
                non-numeric input and menu choice out of range */
                try
                {
                    System.out.print("Please select 1, 2, 3, 4 or 5 and " +
                            "press enter: ");
                    choice = sc.nextInt();
                    if (choice > 0 && choice <= 5)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid Menu Option." +
                                " Please try again!!");
                    }
                }
                catch (InputMismatchException inputMismatchException) {
                    sc.nextLine();
                    System.out.println("Numeric Input expected." +
                            " Please try again");
                }
            }
            if(choice==4 || choice==5)
            {
                break;
            }

             /*Added validation code to validate quantity for bad inputs like
                non-numeric input and quantity out of range */

            for (; ; ) {
                try {
                    System.out.print("Please enter the number of tickets" +
                            " you would like: ");
                    quantity = sc.nextInt();    // Should be validated!
                    if (quantity >= 1 & quantity <= 20) {
                        break;
                    } else {
                        System.out.println("Quantity out of Range." +
                                "\nPlease enter values between 1 and 20");
                    }
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Numeric Input expected." +
                            "Please Try again.");
                    sc.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    price = adult;
                    ticketType="Adult";
                    break;
                case 2:
                    price = child;
                    ticketType="Child";
                    break;
                case 3:
                    price = senior;
                    ticketType="Senior";
                    break;
                default:
                    price = 0;
            }
            /* The below 4 lines of code display the qty
            and type of tickets that were ordered
            and calculates the total price up to that point */

            System.out.printf("%d ",quantity);
            System.out.println(ticketType+" Tickets Were ordered.");
            System.out.println("-------------------------------------" +
                    "--------------------------------------");
            totalPrice+=quantity*price;
        }
        if(choice==4){
            System.out.println("-----------------------------------------" +
                    "----------------------------------");
            System.out.printf("Total price: $%.2f",totalPrice);
            if(totalPrice!=0)
            {
                System.out.println("\nPlease swipe your" +
                        " credit/debit card, then take your tickets.");
                System.out.println("\nWe accept Apple Pay™ or Android Pay™ ");
                System.out.println("\n*****Have a great show*****");
            }
            else {
                System.out.println("\nSeems like yo" +
                        "u didn't ordered for any kind of tickets.");
            }
            System.out.println("Program Terminated Successfully");
            System.out.println("--------------------------------------" +
                    "-------------------------------------");
        }
        else if(choice==5)
        {
            System.out.println("Program Terminated Successfully");
        }

    }


        public static void main (String []args){
            RoboTickets rt = new RoboTickets(125.00);
            rt.go();

        }
}
