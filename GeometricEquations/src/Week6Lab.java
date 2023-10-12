/**
 * Week6Lab.java: This file is the main file and acts a controller
 * The other two classes are called from this file.
 *
 * @author Sai Surya Prakash Moka
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Week6Lab {
    public static void main(String[] args)
    {
        int choice=0;
        double aVal;
        double bVal;
        double cVal;
        Scanner scanner=new Scanner(System.in);
        LinearEquation linearEquation=null;
        QuadraticEquation quadraticEquation=null;
        System.out.println("****Welcome to Geometric Equatons****");

        while(true)
        {
            try {
                aVal=bVal=cVal=0;
                System.out.println("Please select any of the below choices:");
                System.out.println("1. Find the x-intercept of a linear equation.\n" +
                        "2. Find the x-intercepts of a quadratic equation.\n" +
                        "3. Quit.\nEnter your choice:");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("What is the slope?");
                        bVal=scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("What is the Y-Intercept?");
                        cVal=scanner.nextDouble();
                        scanner.nextLine();
                        linearEquation=new LinearEquation(bVal,cVal);
                        linearEquation.findXIntercept();
                        break;
                    case 2:
                        System.out.println("What is the a term? ");
                        aVal=scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("What is the b term? ");
                        bVal=scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("What is the c term? ");
                        cVal=scanner.nextDouble();
                        scanner.nextLine();
                        quadraticEquation=new QuadraticEquation(aVal,bVal,cVal);
                        quadraticEquation.findXIntercept();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Input!!! Please try again.");
                        break;
                }
            }catch(InputMismatchException inputMismatchException)
            {
                System.out.println("Numeric Input expected!! Please try again");
                scanner.nextLine();
            }
        }

    }
}
