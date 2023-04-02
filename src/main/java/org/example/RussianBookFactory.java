package org.example;

public class RussianBookFactory implements Book_factory {
    private Excel_names provider;


    public RussianBookFactory(Excel_names provider){
        this.provider = provider;

    }
    @Override
    public Fiction createFiction() {

        GenerateBookData generateData = new GenerateRussianBookData(provider);
        return new RussianFiction(generateData);
    }

    @Override
    public Textbook createTextbook() {
        String title = RussianTextbookTitle();
        String author = RussianTextbookAuthor();
        return new RussianTextBook(author, title);
    }

    private String RussianTextbookTitle(){
        return provider.getRussian_courses();
    }

    private String RussianTextbookAuthor(){
        String author;
        String name = provider.getMale_firstname();
        String second_name = provider.getMale_student_lastname();
        author = name + " " + second_name;
        return author;
    }
}
