import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int choice=0;
        String absoluteFilePath="";
        TransactionManager transactionManager = new TransactionManager();
        Scanner scannerObj=null;

        System.out.println("\n*****Welcome to Transaction Management System*****");
        scannerObj=new Scanner(System.in);
        while(true)
        {

            try
            {
                System.out.println("-------------------------------------------------");
                System.out.println("Select any of the following choices:");
                System.out.println("1.Read data from a File.\n2.Write data to a file.");
                System.out.println("\nEnter your choice:");

                choice = scannerObj.nextInt();
                scannerObj.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the absolute path of the Input file\n" +
                                "Eg: (C:/Users/windows/textfile.txt):");
                        absoluteFilePath=scannerObj.nextLine();
                        transactionManager.readTransactionsFromFile(absoluteFilePath);
                        break;
                    case 2:
                        System.out.println("Enter the absolute path of the Input file\n" +
                                "Eg: (C:/Users/windows/textfile.txt):");
                        absoluteFilePath=scannerObj.nextLine();
                        transactionManager.writeTransactionsToFile(absoluteFilePath);
                        break;
                    default:
                        System.out.println("Invalid Input!!! Try again.");
                        break;

                }


            }
            catch(InputMismatchException inputMismatchException)
            {
                System.out.println("Numeric Input Expected!!! Please try again");
                scannerObj.nextLine();
            }
        }
    }
}
