/**
 * LibraryCatalog.java
 * This class is developed for the library Management System
 * Consists of functionalities like adding the books
 * to the inventory, displaying all the book information
 * displaying all the books by title
 * and also check in and check out functionalities
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryCatalog {

    private List<Book> booksList=new ArrayList<Book>();

    /**
     * This method is used to add the books in to the arraylist.
     * @param title Title of the book
     * @param author Author of the book
     * @param publicationDate Publication date of the book
     */
    public void addBook(String title,String author,String publicationDate,boolean available )
    {
        String dateFormat = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        try {
            Date date = simpleDateFormat.parse(publicationDate);
            Book book=new Book(title,author,date,available);
            booksList.add(book);
        }  catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }

    }

    /**
     * This method is used to display all the books in the inventory
     */
    public void printAllBooks(){
        if(!booksList.isEmpty())
        {
            for(Book book:booksList)
            {
                System.out.println(book.toString());
                System.out.println("---------------------------------------");
            }
        }
        else
        {
            System.out.println("There are no books to display");
        }

    }

    /**
     * This method is used to print the book titles
     */
    public void printBookTitles(){
        int count=0;
        if(!booksList.isEmpty()) {
            for (Book book : booksList) {
                ++count;
                System.out.println("Book:"+count+" Title:"+book.getTitle());
            }
        }
        else
        {
            System.out.println("There are no books to display");
        }
    }

    /**
     * This method is used to search for a book by its author name
     * @param author Author of the book
     */
    public void printTitlesByAuthor(String author)
    {
        boolean foundBook=false;
        if(!booksList.isEmpty()) {
            for (Book book : booksList) {
                if (book.getAuthor().equalsIgnoreCase(author.trim())) {
                    System.out.println("Title:" + book.getTitle());
                    foundBook=true;
                }
            }
            if(foundBook==false)
            {
                System.out.println("No books found with the specified author name.");
            }
        }
        else {
            System.out.println("There are no books to display");
        }
    }

    /**
     * This method is used to check out a book by passing the title name
     * @param title Title of the book
     */
    public void checkOutBook(String title)
    {
        if(!booksList.isEmpty())
        {
            boolean foundBook=false;
            for(Book book:booksList)
            {
                if(book.getTitle().equalsIgnoreCase(title.trim()))
                {
                    foundBook=true;
                    if(!book.getAvailable())
                    {
                        System.out.println("Sorry this book is not available currently");
                    }
                    else
                    {
                        book.setAvailable(false);
                        System.out.println("Check Out Successful");
                    }
                    break;
                }
            }
            if(foundBook==false)
            {
                System.out.println("No books found with the specified book name.");
            }
        }
        else {
            System.out.println("There are no books to display");
        }
    }

    /**
     * This method is used to check in a book by passing its title
     * @param title Title of the book
     */
    public void checkInBook(String title)
    {
        if(!booksList.isEmpty())
        {
            boolean foundBook=false;
            for(Book book:booksList)
            {
                if(book.getTitle().equalsIgnoreCase(title.trim()))
                {
                    book.setAvailable(true);
                    foundBook=true;
                    System.out.println("Check In Successful");
                    break;
                }
            }
            if(foundBook==false)
            {
                System.out.println("No books found with the specified book name.");
            }
        }
        else {
            System.out.println("There are no books to display");
        }
    }

    public static void main(String[] args){

        int menuChoice;
        String authorName;
        String bookTitle;
        LibraryCatalog libraryCatalog =new LibraryCatalog();
        Scanner scanner=new Scanner(System.in);

        libraryCatalog.addBook("To Kill a Mockingbird","Harper Lee","1960-01-01",true);
        libraryCatalog.addBook("1984","George Orwell","1949-05-07",true);
        libraryCatalog.addBook("The Great Gatsby","F. Scott Fitzgerald","1925-05-18",true);
        libraryCatalog.addBook("The Catcher in the Ryey","J.D. Salinger","1951-08-23",true);
        libraryCatalog.addBook("Harry Potter and the Sorcerer's Stone","J.K. Rowling","1997-05-18",false);


        System.out.println("*****Welcome to Library Management System*****");

        while(true) {
            System.out.println("---------------------------------------");
            System.out.println("1. Display all the Book Details");
            System.out.println("2. Display all the Book Titles");
            System.out.println("3. Display all the Book Titles by author");
            System.out.println("4. Check out a book");
            System.out.println("5. Check in a book");
            System.out.println("Enter your choice:");
            try {
                menuChoice = scanner.nextInt();
                scanner.nextLine();
                if (menuChoice >= 1 && menuChoice <= 5) {
                    switch(menuChoice)
                    {
                        case 1:
                            libraryCatalog.printAllBooks();
                            break;
                        case 2:
                            libraryCatalog.printBookTitles();
                            break;
                        case 3:
                            System.out.println("Enter the author name:");
                            authorName=scanner.nextLine();
                            libraryCatalog.printTitlesByAuthor(authorName);
                            break;
                        case 4:
                            System.out.println("Enter the book title:");
                            bookTitle=scanner.nextLine();
                            libraryCatalog.checkOutBook(bookTitle);
                            break;
                        case 5:
                            System.out.println("Enter the book title:");
                            bookTitle=scanner.nextLine();
                            libraryCatalog.checkInBook(bookTitle);
                            break;
                    }
                } else {
                    System.out.println("Invalid Menu option. Please try again");
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Numeric Input expected!! Try again.");
                scanner.nextLine();
            }
        }
    }
}
