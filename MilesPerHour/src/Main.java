/**
 * Main.java: The main method that calls MilePerHour class to calculate mph
 * @author Sai Surya Prakash Moka
 */

import com.assignments.services.MilesPerHour;
import com.assignments.services.impl.MilesPerHourImpl;

public class Main {
    public static void main(String[] args) {
        double mph;
        MilesPerHour milesPerHour=new MilesPerHourImpl();
        mph=milesPerHour.calculateMilesPerHour();
        System.out.printf("Your speed was %.2f miles per hour",mph);
    }
}