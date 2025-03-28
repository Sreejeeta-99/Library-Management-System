package Library_Management_System;

public class Book 
{
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private String availability;

    public Book(String bookID, String title, String author, String genre, String availability) 
    {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        setAvailability(availability);
    }

    public String getBookID() 
    { 
        return bookID; 
    }
    public String getTitle() 
    { 
        return title; 
    }
    public String getAuthor() 
    { 
        return author; 
    }
    public String getGenre() 
    { 
        return genre; 
    }
    public String getAvailability() 
    { 
        return availability; 
    }

    public void setTitle(String title) 
    { 
        if (!title.isEmpty()) 
            this.title = title; 
    }
    public void setAuthor(String author) 
    { 
        if (!author.isEmpty()) 
            this.author = author; 
    }
    public void setGenre(String genre) 
    { 
        this.genre = genre; 
    }

    public void setAvailability(String availability) 
    {
        if (availability.equalsIgnoreCase("Available") || availability.equalsIgnoreCase("Checked Out")) 
            this.availability = availability;
        else 
            this.availability = "Available"; 
        
    }

    @Override
    public String toString() 
    {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Availability: " + availability;
    }
}
