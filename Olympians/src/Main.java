/**
 *  Main.java: This program is used to take the sports records from the user
 *  and compute the total number of medals won by all the players and to
 *  display all the information in a well formatted fashion.
 *
 * @author: Sai Surya Prakash Moka
 * @date: 09/20/2023.
 */

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String myName="Sai Surya Prakash Moka";
        String name;
        String sport;
        String event;
        int numMedals;
        int totalNumMedals;
        int numOfRecords;
        Olympian olympian;
        List<Olympian> olympianList=new ArrayList<Olympian>();

        Scanner scanner=new Scanner(System.in);

        System.out.println("******P3:Olympians "+myName+"******");
        System.out.println("Enter the number of records you want to enter:");
        numOfRecords=scanner.nextInt();
        scanner.nextLine();

        for(int i=1;i<=numOfRecords;i++)
        {
            System.out.println("-----------------------------------------------" +
                    "------------------");
            System.out.println("*****Record"+i+"*****");
            System.out.println("Enter the name of the Player:");
            name=scanner.nextLine();
            System.out.println("Enter the name of the Sport:");
            sport=scanner.nextLine();
            while(true) {
                try {

                    System.out.println("Enter the number of Medals:");
                    numMedals = scanner.nextInt();
                    scanner.nextLine();

                    if (numMedals < 0 || numMedals > 10) {
                        System.out.println("Invalid number of medals. Please try again!!");
                    } else {
                        break;
                    }

                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Numeric Input expected. Please try again!!");
                    scanner.nextLine();
                }
            }
            System.out.println("Enter the name of the event:");
            event=scanner.nextLine();
            olympian=new Olympian(name,sport,numMedals,event);
            olympianList.add(olympian);
            System.out.println("*****Record"+i+" Inserted Successfully*****");
        }

        totalNumMedals=Olympian.computeMedals(olympianList);
        System.out.println("-----------------------------------------------------");
        System.out.println("The total number of medals won by all the players:"+totalNumMedals);

        System.out.println("-----------------------------------------------------");
        System.out.println("\n\n"+String.join("", Collections.
                nCopies(43,
                        String.valueOf("*")))+"PLAYER-RECORDS"+
                String.join("", Collections.
                        nCopies(43,
                                String.valueOf("*"))));
        System.out.println("Player Name                 Sport                       " +
                "No.of.Medals   Event                       ");
        System.out.println( String.join("", Collections.
                nCopies(100,
                        String.valueOf("-"))));
        for(Olympian olympianObj:olympianList)
        {
            System.out.println(olympianObj.getName()+
                    String.join("", Collections.
                            nCopies(28-olympianObj.getName().length(),
                                    String.valueOf(" ")))+olympianObj.getSport()+
                    String.join("", Collections.
                            nCopies(28-olympianObj.getSport().length(),
                                    String.valueOf(" ")))
            +olympianObj.getNumMedals()+
                    String.join("", Collections.
                            nCopies(15,
                                    String.valueOf(" ")))
            +olympianObj.getEvent());

            System.out.println( String.join("", Collections.
                    nCopies(100,
                            String.valueOf("-"))));
        }
    }
}
