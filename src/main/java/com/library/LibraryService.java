package com.library;

import java.util.List;

public class LibraryService {

    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    /**
     * Add Book
     */
    public boolean addBook(Book book) {

        if (repository.exists(book.getId())) {
            System.out.println("Book ID already exists.");
            return false;
        }

        if (book.getPrice() <= 0) {
            System.out.println("Book price must be greater than zero.");
            return false;
        }

        repository.addBook(book);
        return true;
    }

    /**
     * View All Books
     */
    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    /**
     * Search Book By ID
     */
    public Book getBookById(int id) {
        return repository.findBookById(id);
    }

    /**
     * Delete Book
     */
    public boolean deleteBook(int id) {
        return repository.deleteBook(id);
    }

    /**
     * Total Books
     */
    public int getBookCount() {
        return repository.countBooks();
    }

}
