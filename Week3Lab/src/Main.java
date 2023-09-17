import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

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
            name=scanner.next();
            scanner.nextLine();
            System.out.println("Enter the name of the Sport:");
            sport=scanner.next();
            scanner.nextLine();
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
                }
            }
            System.out.println("Enter the name of the event:");
            event=scanner.next();
            scanner.nextLine();
            olympian=new Olympian(name,sport,numMedals,event);
            olympianList.add(olympian);
        }

        totalNumMedals=Olympian.computeMedals(olympianList);
        System.out.println("The total number of medals won by all the players:"+totalNumMedals);

        System.out.println("-----------------------------------------------------");
        for(Olympian olympianObj:olympianList)
        {
            System.out.println(olympianObj.toString());
            System.out.println("-----------------------------------------------------");
        }
    }
}
