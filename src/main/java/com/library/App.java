package com.library;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LibraryRepository repository = new LibraryRepository();
        LibraryService service = new LibraryService(repository);

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Book Count");
            System.out.println("6. Exit");

            System.out.print("\nEnter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Book ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Book Title : ");
                    String title = scanner.nextLine();

                    System.out.print("Author : ");
                    String author = scanner.nextLine();

                    System.out.print("Price : ");
                    double price = scanner.nextDouble();

                    Book book = new Book(id, title, author, price);

                    if (service.addBook(book)) {
                        System.out.println("Book Added Successfully.");
                    } else {
                        System.out.println("Failed to Add Book.");
                    }

                    break;

                case 2:

                    List<Book> books = service.getAllBooks();

                    if (books.isEmpty()) {

                        System.out.println("No Books Available.");

                    } else {

                        for (Book b : books) {
                            System.out.println(b);
                        }

                    }

                    break;

                case 3:

                    System.out.print("Enter Book ID : ");

                    int searchId = scanner.nextInt();

                    Book foundBook = service.getBookById(searchId);

                    if (foundBook != null) {

                        System.out.println(foundBook);

                    } else {

                        System.out.println("Book Not Found.");

                    }

                    break;

                case 4:

                    System.out.print("Enter Book ID : ");

                    int deleteId = scanner.nextInt();

                    if (service.deleteBook(deleteId)) {

                        System.out.println("Book Deleted Successfully.");

                    } else {

                        System.out.println("Book Not Found.");

                    }

                    break;

                case 5:

                    System.out.println("Total Books : " + service.getBookCount());

                    break;

                case 6:

                    System.out.println("Thank You!");

                    scanner.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");

            }

        }

    }

}
