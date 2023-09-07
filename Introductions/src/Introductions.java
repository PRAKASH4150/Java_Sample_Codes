/**
 * Introductions.java: This program gives about my introduction.
 * @author Sai Surya Prakash Moka
 * @date 09-05-2023
 * @version 1.0
 */
public class Introductions {

    /**
     * Every Java project contains the main method. The main method will be the
     * entry point of the program. The method signature for main is
     * public static void main(string[] args)
     * public: This is an access specifier. Making a method as public will make
     * it accessible to all the members inside and outside the class
     * static: My making a method as static it makes it available to the class and making
     * it as static will make the JVM to invoke main without creating an object
     * void: return type (Returns nothing)
     * main: method name
     * @param args The main() method also accepts some data from the user.
     * It accepts a list of strings, which is called a string array.
     * It is used to hold the command line arguments in the form of string values.
     * In this program the main method contains the instructions to print my Introduction
     */
    public static void main(String[] args)
    {
      String major="M.S in Computer Science";
      int yearOfGrad=2024;
      String quote="Dream is not that you see in sleep,dream is something that " +
              "does not let you sleep.";
      System.out.println("\t\t\t Welcome to Introductions by Sai Surya Prakash Moka\n");
      System.out.println("Major:"+major+"\t\t Year of Graduation:"+yearOfGrad);
      System.out.println("\nQuotes that inspires me:");
      System.out.println(quote);
      System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   -A.P.J.Abdul Kalam");
      System.out.println("\nOne fact about me is,I am a Full Stack Java Web Developer.");
    }
}

/*
Console Output:
Welcome to Introductions by Sai Surya Prakash Moka

Major:M.S in Computer Science		 Year of Graduation:2024

Quotes that inspires me:
Dream is not that you see in sleep,dream is something that does not let you sleep.
															   -A.P.J.Abdul Kalam

One fact about me is,I am a Full Stack Java Web Developer.

Process finished with exit code 0
*/