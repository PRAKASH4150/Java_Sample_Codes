import java.util.Scanner;

/**
 * Palindrome.java: This Program is used to check
 * if the entered word is a Palindrome or not.
 * @author Sai Surya Prakash Moka
 * @date 12/14/23
 */
public class Palindrome {
    public static void main(String[] args)
    {
        String inputWord; //Used to store the input word
        String reverseWord; //Used to store the reversed string
        String exitChar; //Used for exiting the while loop
        Scanner scanner;
        do {
            scanner=new Scanner(System.in);
            StringBuilder stringBuilder=new StringBuilder();

            System.out.println("Please enter a word");
            inputWord=scanner.nextLine();
            stringBuilder.append(inputWord);
            reverseWord=stringBuilder.reverse().toString();

            if(inputWord.equalsIgnoreCase(reverseWord))
            {
                System.out.println("This word is a palindrome");
            }
            else
            {
                System.out.println("This word is NOT a palindrome");
            }


            System.out.println("Hit E to exit and any other key to continue");
            exitChar=scanner.nextLine();
        }while(!exitChar.equalsIgnoreCase("E"));

        scanner.close();
    }
}
