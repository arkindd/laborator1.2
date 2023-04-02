package org.example;

import java.util.Random;

public class GenerateRussianBookData implements GenerateBookData {

    Excel_names provider;
    public GenerateRussianBookData(Excel_names provider) {
        this.provider = provider;
    }
    @Override
    public String createFictionAuthor() {
        String author;
        String name = provider.getMale_firstname();
        String second_name = provider.getFemale_student_lastname();
        author = name + " " + second_name;
        return author;
    }



    @Override
    public String createFictionTitle() {

        String[] KEYWORDS = {"Любовь", "Сердце", "Страсть", "Мечты", "Предназначение", "Секреты", "Мистика", "Магия", "Приключения", "Прощение", "Предательство", "Храбрость", "Надежда", "Судьба", "Принятие", "Шепот", "Тени", "Заклятие", "Размышления", "Отвага"};
        String[] GENRES = {"Роман", "Поэма", "Приключение"};
        Random random = new Random();
        String keyword1 = KEYWORDS[random.nextInt(KEYWORDS.length)];
        String keyword2 = KEYWORDS[random.nextInt(KEYWORDS.length)];
        String genre = GENRES[random.nextInt(GENRES.length)];
        while (keyword2.equals(keyword1)) {
            keyword2 = KEYWORDS[random.nextInt(KEYWORDS.length)];
        }

        String title = keyword1 + " и " + keyword2 + " " + genre;
        return title;
    }



}

