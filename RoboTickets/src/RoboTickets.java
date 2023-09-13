import java.util.*;
/**
 * RoboTickets.java:
 * Seed java file for P2 - RoboTickets
 *
 * @author Mr Shokite
 * @author Sai Surya Prakash Moka
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
        child = Math.ceil(100 * (0.5 * price)) / 100;      // Round the fraction up.
        senior = Math.ceil(100 * (0.8 * price)) / 100;      // Round the fraction up.
    }

    /**
     * Dispense tickets to be paid for by a credit card. Adult, child, and
     * senior tickets may be purchased.
     */
    public void go() {
        double price=0; // If there is no default below, use   price = 0;
        double totalPrice=0;
        int choice=0, quantity=0;
        String ticketType="";

        //Modified the welcome message to show my name
        System.out.println("\nWelcome to Roboticket.com where all shows and seats are one low price!\n" +
                "Recently made code modifications by Sai Surya Prakash Moka");
        while (true) {
            System.out.printf("    1. Adult %.2f\n    2. Child under 12 %.2f\n", adult, child);
            System.out.printf("    3. Senior Citizen %.2f\n", senior);
            System.out.println("    4.Finish & Pay");
            for (; ; ) {
                try
                {
                    System.out.print("Please select 1, 2, 3 or 4 and press enter: ");
                    choice = sc.nextInt();
                    if (choice > 0 && choice <= 4)
                    {
                        break;
                    }
                }
                catch (InputMismatchException inputMismatchException) {
                    String junk = sc.nextLine();   // Discard chars to end of line.
                    System.out.println("Bad menu choice. Please try again");
                }
            }
            if(choice==4)
            {
                break;
            }

            //Created a validation loop to validate qty.
            for (; ; ) {
                try {
                    System.out.print("Please enter the number of tickets you would like: ");
                    quantity = sc.nextInt();    // Should be validated!
                    if (quantity >= 1 & quantity <= 20) {
                        break;
                    } else {
                        System.out.println("Quantity out of Range.\nPlease enter values between 1 and 20");
                    }
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Numeric Input expected.Please Try again.");
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
            System.out.printf("%d ",quantity);
            System.out.println(ticketType+" Tickets Were ordered.");
            System.out.println("---------------------------------------------------------------------------");
            totalPrice+=quantity*price;
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("Total price: $%.2f",totalPrice);
        System.out.println("\nPlease swipe your credit card, then take your tickets.");
        System.out.println("---------------------------------------------------------------------------");
    }

        //    -------------------------------------------------------------------------------------------
        public static void main (String []args){
            RoboTickets rt = new RoboTickets(125.00);
            rt.go();

        }
}
