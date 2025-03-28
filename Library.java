package Library_Management_System;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library 
{
    private Map<String, Book> books = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addBook() 
    {
        System.out.print("Enter Book ID: ");
        String bookID = scanner.nextLine();
        if (books.containsKey(bookID)) 
        {
            System.out.println("Error: Book ID already exists.");
            return;
        }

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability (Available/Checked Out): ");
        String availability = scanner.nextLine();

        if (title.isEmpty() || author.isEmpty()) 
        {
            System.out.println("Error: Title and Author cannot be empty.");
            return;
        }

        books.put(bookID, new Book(bookID, title, author, genre, availability));
        System.out.println("Book added successfully!");
    }

    public void viewBooks() 
    {
        if (books.isEmpty()) 
        {
            System.out.println("No books available.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    public void searchBook() 
    {
        System.out.print("Enter Book ID or Title to search: ");
        String query = scanner.nextLine();

        books.values().stream()
                .filter(book -> book.getBookID().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Book not found."));
    }

    public void updateBook() 
    {
        System.out.print("Enter Book ID to update: ");
        String bookID = scanner.nextLine();
        Book book = books.get(bookID);

        if (book == null) 
        {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("Enter new Title (leave blank to keep existing): ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new Author (leave blank to keep existing): ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter new Genre (leave blank to keep existing): ");
        String newGenre = scanner.nextLine();
        System.out.print("Enter new Availability (Available/Checked Out): ");
        String newAvailability = scanner.nextLine();

        if (!newTitle.isEmpty()) 
            book.setTitle(newTitle);
        if (!newAuthor.isEmpty()) 
            book.setAuthor(newAuthor);
        if (!newGenre.isEmpty()) 
            book.setGenre(newGenre);
        if (!newAvailability.isEmpty()) 
            book.setAvailability(newAvailability);

        System.out.println("Book details updated successfully!");
    }

    public void deleteBook() 
    {
        System.out.print("Enter Book ID to delete: ");
        String bookID = scanner.nextLine();

        if (books.remove(bookID) != null) 
            System.out.println("Book deleted successfully.");
        else 
            System.out.println("Book not found.");
        
    }

    public void exitSystem() 
    {
        System.out.println("Exiting the system...");
        scanner.close();
        System.exit(0);
    }

    public void showMenu() 
    {
        while (true) 
        {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) 
            {
                case "1": addBook(); break;
                case "2": viewBooks(); break;
                case "3": searchBook(); break;
                case "4": updateBook(); break;
                case "5": deleteBook(); break;
                case "6": exitSystem(); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
