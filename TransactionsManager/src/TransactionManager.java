import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
* TransactionManagaer.java: This file is used to read and write to a file
* and process all the transaction data.
*
* @author Sai Surya Prakash Moka
*
* @date 10-05-2023
* */
public class TransactionManager {

    /**
     * readTransactionsFromFile() : This function is
     * used to read data from a file containing
     * the transactions and output on to the
     * console.
     */
    public void readTransactionsFromFile(String absoluteFilePath){
        File inputFile=null;
        Scanner scanner=new Scanner(System.in);
        inputFile= new File(absoluteFilePath);
        try
        {
            scanner=new Scanner(inputFile);
            System.out.println();
            while(scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }
        catch(FileNotFoundException fileNotFoundException)
        {
            System.out.println("\nUnable to locate the Input File.\n" +
                    "Make sure whether file is present.\n" +
                    "Exiting the Program");
            scanner.close();
            System.exit(0);
        }
    }

    /**
     * writeTransactionsToFile() : This function is used to
     * write the tranasction date on to a specified file and
     * output the content.
     */
    public void writeTransactionsToFile(String absoluteFilePath)
    {
        int transactionId;
        int lineCount;
        double amount=0.0;
        String date;
        String line="";
        String []data;
        PrintWriter printWriter =null;
        Scanner filescanner=null;
        Scanner scanner=new Scanner(System.in);

        try {
            while(true) {
                FileWriter fileWriter = new FileWriter(absoluteFilePath, true);
                printWriter=new PrintWriter(fileWriter);
                filescanner = new Scanner(new File(absoluteFilePath));
                lineCount=0;
                while (filescanner.hasNextLine()) {
                    line = filescanner.nextLine();
                    lineCount++;
                }

                if(lineCount >0 )
                {
                    data = line.split("\\,");
                    transactionId = Integer.parseInt(data[0]) + 1;
                }
                else {
                    System.out.println("Transaction ID,Amount,Date");
                    transactionId=1;
                }
                System.out.println("-----------------------------" +
                        "--------------------");
                while (true) {
                    try {
                        System.out.println("Enter the amount:");
                        amount = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException inputMismatchException) {
                        System.out.println("Numeric Input expected!!!" +
                                " Please try again.");
                        scanner.nextLine();
                    }
                }
                if(amount==-1.0)
                {
                    break;
                }
                while(true)
                {
                    System.out.println("Enter the data (YYYY-MM-DD):");
                    date = scanner.nextLine();
                    if(isValidDate(date))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid date format!!!");
                    }
                }

                printWriter.print("\n" + transactionId + "," + amount + "," + date);
                System.out.println("Record Inserted Successfully");
                System.out.println("------------------------" +
                        "-------------------------");
                printWriter.close();
                filescanner.close();
            }
            System.out.println("\n\n\n******UPDATED FILE CONTENT******");
            readTransactionsFromFile(absoluteFilePath);
        } catch (FileNotFoundException fileNotFoundExceptionIOException) {
            System.out.println("Unable to write to the Output File.\n" +
                    "Make sure whether file is present.\n" +
                    "Exiting the Program");

        }
        catch(IOException ioException)
        {
            System.out.println("Unable to write to the Output File.\n"+
                    "Exiting the Program");
            System.exit(0);
        }
        finally {
            filescanner.close();
            printWriter.close();

        }

    }

    /**
     * isValidDate() : This function is used to check whether the entered
     * date as string is valid or not.
     * @param dateStr -Accepts the date which is in String format
     * @return boolean - Returns if the input date is valid or not.
     */
    public static boolean isValidDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }



}
