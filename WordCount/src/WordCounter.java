/**
 * WordCounter.java: The program is
 * used to count the words present in an input file
 * and display it to the output file
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10/26/2023
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordCounter {
    /**
     *
     * @param filePath - Input file path
     * @return - The number of words present in the file
     */
    public int countNumWords(String filePath)
    {
        String line;
        String []words;
        int wordCount=0;
        Scanner scanner=null;
        try
        {
            scanner=new Scanner(new File(filePath));
            while(scanner.hasNextLine())
            {
                line=scanner.nextLine();
                words=line.split("\\s+");
                wordCount+=words.length;
            }
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Unable to open the file.Check Whether the file" +
                    "exists in the specified path");
            System.exit(0);
        }
        finally {
            scanner.close();
        }
        return wordCount;
    }

    /**
     *
     * @param filePath --Output file path
     * @param numOfWords -- Take the number of words as an argument.
     */
    public void writeOutputToFile(String filePath,int numOfWords)
    {
        PrintWriter printWriter=null;
        try
        {
            printWriter =new PrintWriter(new File(filePath));
            printWriter.println("Word Count:"+numOfWords);
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Unable to create the file.Check Whether the file" +
                    "path exists");
            System.exit(0);
        }
        finally {
            printWriter.close();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        int numWords;
        WordCounter wordCounter=new WordCounter();
        numWords=wordCounter.countNumWords("H://UNH//Fall-2023-Sem//" +
                "Java//Programs//WordCount//resources//input.txt");
        wordCounter.writeOutputToFile("H://UNH//Fall-2023-Sem//Java//" +
                "Programs//WordCount//resources//output.txt",numWords);
        System.out.println("Program Executed Successfully");
    }
}
