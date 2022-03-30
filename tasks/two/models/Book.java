package by.epam.tr.tasks.two.models;

import java.util.List;

public class Book {

    private int id;
    private String title;
    private List<Author> authors;
    private String publishingHouse;
    private short publishingYear;
    private int pagesCount;
    private double price;
    private Cover cover;

    public Book() {
    }

    public Book(String title, List<Author> authors, String publishingHouse, short publishingYear, int pagesCount, double price, Cover cover) {
        this.title = title;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.publishingYear = publishingYear;
        this.pagesCount = pagesCount;
        this.price = price;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public short getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(short publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", publishingYear=" + publishingYear +
                ", pagesCount=" + pagesCount +
                ", price=" + price +
                ", cover=" + cover +
                '}';
    }
}
