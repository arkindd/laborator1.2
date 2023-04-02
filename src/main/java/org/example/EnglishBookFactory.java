package org.example;
import java.util.Random;

public class EnglishBookFactory implements Book_factory {

    Excel_names provider;

    public EnglishBookFactory(Excel_names course_provider){
        this.provider = course_provider;
    }

    @Override
    public Fiction createFiction() {

        GenerateBookData generateData = new GenerateEnglishBookData(this.provider);
        return new EnglishFiction(generateData);
    }

    @Override
    public Textbook createTextbook() {
        String title = EnglishTextbookTitle();
        String author = EnglishTextbookAuthor();
        String uni = EnglishTextbookUni();
        String level = EnglishTextbookLevel();
        return new EnglishTextBook(author, title, uni, level);
    }

    private String EnglishTextbookTitle(){
        return provider.getEnglish_courses();
    }

    private String EnglishTextbookAuthor(){
        return provider.getEnglish_professors();
    }
    private  String EnglishTextbookUni(){
        return provider.getEnglish_uni();
    }

    private String EnglishTextbookLevel(){
        Random random = new Random();
        int n = random.nextInt(2);
        String level;
        if(n==0){
            level = "bachelor";
        }else {
            level = "masters";
        }
        return level;
    }
}
