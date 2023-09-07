/**
 * MilesPerHour.java: This class is used to calculate the speed in mph by taking distance and time as input
 * @author Sai Surya Prakash Moka
 */
import java.util.Scanner;

public class MilesPerHour {
    public static void main(String[] args) {
        //Declaring the variables
        double distance;
        double time;
        double mph;

        Scanner scanner=new Scanner(System.in); //Creating a scanner instance
        System.out.print("How many miles did you travel? ");
        distance=scanner.nextDouble(); //Getting the double input for distance
        System.out.print("How many hours did it take you to travel that distance?");
        time=scanner.nextDouble();//Getting the double input for time
        mph=distance/time; //calculating miles per hour
        System.out.printf("Your speed was %.2f miles per hour",mph); //Printing mph with 2 decimal precision
        scanner.close(); //closing the scanner

    }
}
