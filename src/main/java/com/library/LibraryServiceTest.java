package com.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    private LibraryService service;

    @BeforeEach
    void setup() {

        LibraryRepository repository = new LibraryRepository();

        service = new LibraryService(repository);

        Book book = new Book(
                101,
                "Java Programming",
                "James Gosling",
                599.00
        );

        service.addBook(book);
    }

    @Test
    void testAddBook() {

        Book book = new Book(
                102,
                "Spring Boot",
                "Rod Johnson",
                799.00
        );

        assertTrue(service.addBook(book));
    }

    @Test
    void testDuplicateBook() {

        Book book = new Book(
                101,
                "Duplicate Book",
                "Author",
                500.00
        );

        assertFalse(service.addBook(book));
    }

    @Test
    void testFindBook() {

        Book book = service.getBookById(101);

        assertNotNull(book);

        assertEquals("Java Programming", book.getTitle());

    }

    @Test
    void testDeleteBook() {

        assertTrue(service.deleteBook(101));

    }

    @Test
    void testBookCount() {

        assertEquals(1, service.getBookCount());

    }

}
