package by.epam.tr.tasks.two;

import by.epam.tr.tasks.two.models.Author;
import by.epam.tr.tasks.two.models.Book;
import by.epam.tr.tasks.two.models.Cover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BooksDataAccess booksDataAccess = new BooksDataAccess();


        booksDataAccess.addBook(new Book("Title 1", Author.fromStringArray("Author 1", "Author 2"), "Test house 1", (short) 2015, 200, 14.5, Cover.HARD));
        booksDataAccess.addBook(new Book("Title 2", Author.fromStringArray("Author 4", "Author 5"), "Test house 2", (short) 2014, 200, 14.5, Cover.HARD));
        booksDataAccess.addBook(new Book("Title 3", Author.fromStringArray("Author 1", "Author 7"), "Test house 3", (short) 2016, 200, 14.5, Cover.HARD));
        booksDataAccess.addBook(new Book("Title 4", Author.fromStringArray("Author 3", "Author 6"), "Test house 4", (short) 2017, 200, 14.5, Cover.HARD));
        booksDataAccess.addBook(new Book("Title 5", Author.fromStringArray("Author 9", "Author 1"), "Test house 5", (short) 2018, 200, 14.5, Cover.HARD));
        booksDataAccess.addBook(new Book("Title 6", Author.fromStringArray("Author 11", "Author 10"), "Test house 6", (short) 2019, 200, 14.5, Cover.HARD));

        while (true) {
            printMenu();
            int userOption = userOptionInput(scanner);

            switch (userOption) {
                case 1:
                    addBook(scanner, booksDataAccess);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter authors names (if more than 1 enter separated by commas): ");
                    booksDataAccess.getBooksByAuthor(scanner.nextLine().split(",")).forEach(System.out::println);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter publishing house name: ");
                    booksDataAccess.getBooksByPublishingHouse(scanner.nextLine()).forEach(System.out::println);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Enter year: ");
                    booksDataAccess.getBooksFromYear(yearValidation(scanner)).forEach(System.out::println);
                    break;
                case 5:
                    getBooks(booksDataAccess);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please, chose valid options from menu");
                    break;
            }

            System.out.println("\n\n");
        }

    }

    private static void printMenu() {
        System.out.println("============== Menu ==============");
        System.out.println("Press 1 to add Book\n" +
                "Press 2 to get Books by author(s)\n" +
                "Press 3 to get Books by publishing house\n" +
                "Press 4 to get Books from selected year\n" +
                "Press 5 to get all Books\n" +
                "Press 0 to exit");
    }

    private static void addBook(Scanner scanner, BooksDataAccess booksDataAccess) {
        scanner.nextLine();

        Book book = new Book();

        System.out.print("Enter title: ");
        book.setTitle(scanner.nextLine());

        System.out.print("Enter authors (if more than 1 enter separated by commas): ");
        List<String> authorsInput = Arrays.asList(scanner.nextLine().split(","));
        List<Author> authors = new ArrayList<>();
        authorsInput.forEach(s -> authors.add(new Author(s.trim())));
        book.setAuthors(authors);

        System.out.print("Enter publishing house: ");
        book.setPublishingHouse(scanner.nextLine());

        System.out.print("Enter publishing year: ");
        book.setPublishingYear(yearValidation(scanner));

        System.out.print("Enter pages count: ");
        book.setPagesCount(pagesValidation(scanner));

        System.out.print("Enter price: ");
        book.setPrice(priceValidation(scanner));

        System.out.print("Enter cover type (Soft - 1, Hard - 2): ");
        book.setCover(validateCover(scanner));

        booksDataAccess.addBook(book);

        System.out.println("Book successfully added");

    }

    private static Cover validateCover(Scanner scanner) {
        boolean isValid = false;
        Cover cover = null;
        while (!isValid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid cover type. Please try again");
                scanner.nextLine();
            }
            cover = Cover.getByCode(scanner.nextInt());
            if (cover == null) {
                System.out.println("Invalid cover type. Please try again");
            } else {
                isValid = true;
            }
        }
        return cover;
    }

    private static double priceValidation(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
            System.out.println("Invalid price value. Please try again");
        }
        return scanner.nextDouble();
    }

    private static int pagesValidation(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Invalid pages count. Please try again");
        }
        return scanner.nextInt();
    }

    private static short yearValidation(Scanner scanner) {
        while (!scanner.hasNextShort()) {
            scanner.nextLine();
            System.out.println("Invalid year. Please try again");
        }
        return scanner.nextShort();
    }

    private static int userOptionInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Please, choose valid option");
        }
        return scanner.nextInt();
    }

    private static void getBooks(BooksDataAccess booksDataAccess) {
        if (booksDataAccess.getBooks().size() == 0) {
            System.out.println("There is no data to show.");
        } else {
            booksDataAccess.getBooks().forEach(System.out::println);
        }
    }

}
