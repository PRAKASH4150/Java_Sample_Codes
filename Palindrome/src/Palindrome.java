/**
 * Palindrome.Java: This Program is used to find whether the
 * given string literal is palindrome or not
 * @author Sai Surya Prakash Moka
 * @date 09/21/2023
 */

import java.util.Scanner;

public class Palindrome {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String inputWord;
        Scanner scanner=new Scanner(System.in);
        StringBuilder stringBuilder;

        System.out.println("Please enter a word:");
        inputWord=scanner.nextLine();
        stringBuilder=new StringBuilder(inputWord);
        if(stringBuilder.toString().equalsIgnoreCase(stringBuilder.reverse().toString()))
        {
            System.out.println("\nThis word is a Palindrome.");
        }
        else
        {
            System.out.println("\nThis word is NOT a Palindrome.");
        }
    }
}
