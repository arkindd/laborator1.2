package org.example;

import java.util.ArrayList;

public abstract class Person {
    String firstname;
    String lastname;
    String middlename;
    ArrayList<Book> books;



    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getMiddlename() {
        return middlename;
    }
}
