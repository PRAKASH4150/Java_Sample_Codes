/**
 * MilesPerHour.java:
 * This Program is used to calculate the distance
 * travelled in MPH
 * @author Sai Surya Prakash Moka
 * @date 09/21/2023
 */

import java.util.Scanner;

public class MilesPerHour {

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        double distance;
        double time;
        double mph;

        System.out.println("\nHow many miles did you travel?");
        distance=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("How many hours did it take you to travel that distance?");
        time=scanner.nextDouble();
        mph=distance/time;
        System.out.printf("Your speed was %.2f miles per hour",mph);

    }
}
