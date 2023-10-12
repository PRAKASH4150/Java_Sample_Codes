/**
 * WordCount.java: This program counts the number of words present in an input
 * file and writes the word count to an output file
 * @author: Sai Surya Prakash Moka
 * @date: 09/28/2023
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class WordCount {

    /**
     *
     * @param inputFilePath-This variable contains the absolute path for input
     *                     file.
     * @param outputFilePath-This variable contains the absolute path for output
     *                     file.
     */
    public void countNumWords(String inputFilePath,String outputFilePath)
    {
        String line;
        String []words;
        int wordCount=0;

        File inputFile=new File(inputFilePath);
        File outputFile=new File(outputFilePath);

        try {
            Scanner scanner=new Scanner(inputFile);
            PrintWriter printWriter=new PrintWriter(outputFile);

            while(scanner.hasNextLine())
            {
                line= scanner.nextLine();
                words=line.split("\\s+");
                wordCount+=words.length;
            }
            System.out.println("Word count:"+wordCount);
            printWriter.println("Word count:"+wordCount);

            scanner.close();
            printWriter.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("Error Opening Input or Output File");
        }
    }


    /**
     * @param args-CLI arguments for main method.
     */
    public static void main(String[] args)
    {
        String inputFilePath="H:/UNH/Fall-2023-Sem/Java/Programs/Week5Lab/resources/input.txt";
        String outputFilePath="H:/UNH/Fall-2023-Sem/Java/Programs/Week5Lab/resources/output.txt";
        WordCount wordCount=new WordCount();
        wordCount.countNumWords(inputFilePath,outputFilePath);
    }
}
