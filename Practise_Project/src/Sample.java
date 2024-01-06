import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sample {
    public static void main(String[]args)
    {
        final String INPUT_FILE_PATH="H:/UNH/Fall-2023-Sem/Java/statement.txt";
        final String OUTPUT_FILE_PATH="H:/UNH/Fall-2023-Sem/Java/output.txt";
        String readLine="";
        int wordCount=0;
        char[] tempArray;
        Scanner sc=null;
        PrintWriter pw=null;
        File inputFile=new File(INPUT_FILE_PATH);
        File outputFile=new File(OUTPUT_FILE_PATH);
        try {
            sc=new Scanner(inputFile);
            pw=new PrintWriter(outputFile);
            while(sc.hasNextLine())
            {
                readLine=sc.nextLine();
                tempArray=readLine.toCharArray();
                wordCount+=tempArray.length;
            }
            pw.println("The Word Count is :"+wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!!!");
        }
        finally {
            sc.close();
            pw.close();
        }
    }
}
