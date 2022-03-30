package by.epam.tr.tasks.two.models;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String surname;

    public Author() {
    }

    public Author(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static List<Author> fromStringArray(String... authors) {
        List<Author> authorsList = new ArrayList<>();
        for (String s : authors) {
            authorsList.add(new Author(s.trim()));
        }
        return authorsList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "surname='" + surname + '\'' +
                '}';
    }
}
