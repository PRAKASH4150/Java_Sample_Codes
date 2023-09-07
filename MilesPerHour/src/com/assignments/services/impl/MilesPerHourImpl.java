/**
 * MilesPerHourImpl.java: Class that contains the actual implementation to calculate mph
 * @author Sai Surya Prakash Moka
 */
package com.assignments.services.impl;

import java.util.Scanner;
import com.assignments.services.MilesPerHour;

public class MilesPerHourImpl implements MilesPerHour {

    @Override
    public double calculateMilesPerHour() {
        double distance;
        double time;
        Scanner scanner=new Scanner(System.in);
        System.out.print("How many miles did you travel? ");
        distance=scanner.nextDouble();
        System.out.print("How many hours did it take you to travel that distance?");
        time=scanner.nextDouble();
        scanner.close();
        return distance/time;
    }
}
