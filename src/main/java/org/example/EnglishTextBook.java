package org.example;

public class EnglishTextBook extends Book implements Textbook{

    public EnglishTextBook(String author, String title, String uni, String degree_level){
        this.title = title;
        this.author = author;
        this.uni = uni;
        this.degree_level = degree_level;
    }
}
