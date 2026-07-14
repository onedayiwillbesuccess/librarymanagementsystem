package com.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {

    private final List<Book> books = new ArrayList<>();

    /**
     * Add Book
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * View All Books
     */
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Find Book By ID
     */
    public Book findBookById(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }

        }

        return null;
    }

    /**
     * Delete Book By ID
     */
    public boolean deleteBook(int id) {

        Book book = findBookById(id);

        if (book != null) {
            books.remove(book);
            return true;
        }

        return false;
    }

    /**
     * Check Book Exists
     */
    public boolean exists(int id) {
        return findBookById(id) != null;
    }

    /**
     * Total Books
     */
    public int countBooks() {
        return books.size();
    }

}
