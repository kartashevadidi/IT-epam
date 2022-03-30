package by.epam.tr.tasks.two;

import by.epam.tr.tasks.two.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksDataAccess {

    private List<Book> books;

    public BooksDataAccess() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(books.size() + 1);
        books.add(book);
    }

    public List<Book> getBooksByAuthor(String... authorName) {
        List<Book> booksByAuthor = new ArrayList<>();
        books.forEach(book -> {
            book.getAuthors().forEach(author -> {
                for (String s : authorName) {
                    if (author.getSurname().equals(s.trim())) {
                        booksByAuthor.add(book);
                    }
                }
            });
        });
        return booksByAuthor;
    }

    public List<Book> getBooksByPublishingHouse(String publishingHouse) {
        List<Book> booksByPublishingHouse = new ArrayList<>();
        books.forEach(book -> {
            if (book.getPublishingHouse().equals(publishingHouse)) {
                booksByPublishingHouse.add(book);
            }
        });
        return booksByPublishingHouse;
    }

    public List<Book> getBooksFromYear(short year) {
        List<Book> booksFromYear = new ArrayList<>();
        books.forEach(book -> {
            if (book.getPublishingYear() >= year) {
                booksFromYear.add(book);
            }
        });
        return booksFromYear;
    }

}
