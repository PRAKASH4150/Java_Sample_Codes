/**
 * Book.java:
 * This is a POJO class for Book. Contains the variables,
 * Initializes the variables using the parametrized constructor
 * and consist of getter and setter methods
 * @author Sai Surya Prakash Moka
 * @date 09/14/2023
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {

    private String title;
    private String author;
    private Date publicationDate;
    private boolean available;

    Book(String title,String author,Date publicationDate)
    {
        this.title=title;
        this.author=author;
        this.publicationDate=publicationDate;
        this.available=true;
    }

    Book(String title,String author,Date publicationDate,boolean available)
    {
        this.title=title;
        this.author=author;
        this.publicationDate=publicationDate;
        this.available=available;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }
    public Date getPublicationDate()
    {
        return publicationDate;
    }

    public boolean getAvailable()
    {
        return available;
    }
    public void setAvailable(boolean available)
    {
        this.available=available;
    }


    @Override
    public String toString()
    {
        String dateFormatPattern = "MM/dd/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Title:").append(title).append("\nAuthor:")
                .append(author).append("\nPublication Date:").
                append(dateFormat.format(publicationDate)).append("\nAvailability:")
                .append(available);
        return stringBuilder.toString();

    }

}
